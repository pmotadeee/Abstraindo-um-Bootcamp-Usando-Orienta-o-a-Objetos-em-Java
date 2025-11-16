package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Dev {
    private String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>(16); // Initial capacity for better performance
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>(16);
    private final AtomicReference<Double> cachedXp = new AtomicReference<>(-1.0); // Cache for XP calculation

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        if (this.conteudosInscritos.isEmpty()) {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
            return;
        }
        // Get first element without stream for better performance
        Conteudo conteudo = this.conteudosInscritos.iterator().next();
        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
        this.cachedXp.set(-1.0); // Invalidate cache
    }

    public double calcularTotalXp() {
        // Return cached value if available
        double xp = cachedXp.get();
        if (xp >= 0) {
            return xp;
        }
        
        // Calculate and cache the result
        xp = 0.0;
        for (Conteudo c : conteudosConcluidos) {
            xp += c.calcularXp();
        }
        cachedXp.set(xp);
        return xp;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos.clear();
        if (conteudosInscritos != null) {
            this.conteudosInscritos.addAll(conteudosInscritos);
        }
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos.clear();
        if (conteudosConcluidos != null) {
            this.conteudosConcluidos.addAll(conteudosConcluidos);
        }
        this.cachedXp.set(-1.0); // Invalidate cache when contents change
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome); // Only compare by name for better performance and to avoid circular references
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome); // Consistent with equals()
    }
}
