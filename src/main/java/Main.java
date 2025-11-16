import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        // Reuse LocalDate.now() to ensure consistency
        LocalDate hoje = LocalDate.now();
        
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(hoje);

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        // Use StringBuilder for multiple concatenations
        StringBuilder sb = new StringBuilder();
        sb.append("Conteúdos Inscritos Camila:").append(devCamila.getConteudosInscritos())
          .append("\nConteúdos Concluídos Camila:").append(devCamila.getConteudosConcluidos())
          .append("\nXP:").append(devCamila.calcularTotalXp());
        System.out.println(sb.toString());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        // Reuse StringBuilder for better performance
        sb.setLength(0);
        sb.append("Conteúdos Inscritos João:").append(devJoao.getConteudosInscritos())
          .append("\nConteúdos Concluídos João:").append(devJoao.getConteudosConcluidos())
          .append("\nXP:").append(devJoao.calcularTotalXp());
        System.out.println(sb.toString());

    }

}
