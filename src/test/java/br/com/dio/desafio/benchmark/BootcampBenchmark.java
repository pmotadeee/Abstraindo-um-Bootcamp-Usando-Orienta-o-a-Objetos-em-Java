package br.com.dio.desafio.benchmark;

import br.com.dio.desafio.dominio.*;
import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class BootcampBenchmark {
    
    private Bootcamp bootcamp;
    private Dev dev;
    private static final int NUM_CURSOS = 1000;
    private static final int NUM_DEVS = 100;
    
    @Setup
    public void setup() {
        // Create a bootcamp with many courses
        bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Performance Test");
        bootcamp.setDescricao("Performance testing bootcamp");
        
        for (int i = 0; i < NUM_CURSOS; i++) {
            Curso curso = new Curso();
            curso.setTitulo("Curso " + i);
            curso.setDescricao("Descrição " + i);
            curso.setCargaHoraria((i % 10) + 1); // 1-10 hours
            bootcamp.getConteudos().add(curso);
        }
        
        // Register many devs
        for (int i = 0; i < NUM_DEVS; i++) {
            Dev d = new Dev();
            d.setNome("Dev " + i);
            d.inscreverBootcamp(bootcamp);
        }
        
        // Create a test dev
        dev = new Dev();
        dev.setNome("Test Dev");
        dev.inscreverBootcamp(bootcamp);
    }
    
    @Benchmark
    public void testProgredir() {
        // Simulate progress through courses
        while (!dev.getConteudosInscritos().isEmpty()) {
            dev.progredir();
        }
    }
    
    @Benchmark
    public double testCalcularXp() {
        // Calculate XP for all completed content
        return dev.calcularTotalXp();
    }
    
    @Benchmark
    public void testInscricaoBootcamp() {
        // Test bootcamp enrollment
        Dev newDev = new Dev();
        newDev.setNome("New Dev");
        newDev.inscreverBootcamp(bootcamp);
    }
    
    @Benchmark
    public void testEqualsHashCode() {
        // Test equals and hashCode performance
        Dev dev1 = new Dev();
        dev1.setNome("Test");
        Dev dev2 = new Dev();
        dev2.setNome("Test");
        
        boolean isEqual = dev1.equals(dev2);
        int hash1 = dev1.hashCode();
        int hash2 = dev2.hashCode();
    }
}
