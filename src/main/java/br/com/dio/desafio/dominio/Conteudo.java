package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    /**
     * Valor padrão de XP para conteúdos
     */
    public static final double XP_PADRAO = 10.0; // Made public for direct access, avoiding method calls

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
