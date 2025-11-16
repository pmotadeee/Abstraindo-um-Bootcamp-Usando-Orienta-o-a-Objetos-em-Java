package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public Curso() {
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return new StringBuilder("Curso{")
                .append("titulo='").append(getTitulo()).append('\'')
                .append(", descricao='").append(getDescricao()).append('\'')
                .append(", cargaHoraria=").append(cargaHoraria)
                .append('}')
                .toString();
    }
}
