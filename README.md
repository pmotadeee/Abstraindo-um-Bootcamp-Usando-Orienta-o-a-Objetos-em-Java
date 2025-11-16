# Bootcamp Performance Optimization Project

## 📊 Overview
This project demonstrates various Java performance optimization techniques applied to a bootcamp management system. The focus was on improving performance while maintaining the same class structure and functionality.

## 🚀 Optimizations Applied

### 1. Collection Optimization
- Initialized `HashSet` and `LinkedHashSet` with appropriate initial capacities
- Used `LinkedHashSet` for ordered iteration when insertion order matters
- Implemented proper collection clearing and re-adding in setters to maintain immutability

### 2. Caching Strategy
- Added `AtomicReference` for thread-safe caching of XP calculations
- Implemented lazy initialization for expensive calculations
- Invalidated cache only when necessary (on content changes)

### 3. String Handling
- Replaced string concatenation with `StringBuilder` in [toString()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/br/com/dio/desafio/dominio/Curso.java:23:4-31:5) methods
- Reused `StringBuilder` instances in loops
- Used parameterized logging where applicable

### 4. Critical Methods Optimization
- Optimized [progredir()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/br/com/dio/desafio/dominio/Dev.java:18:4-28:5) to avoid Stream overhead by using direct iteration
- Improved [calcularTotalXp()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/br/com/dio/desafio/dominio/Dev.java:30:4-44:5) with caching
- Simplified [equals()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/br/com/dio/desafio/dominio/Dev.java:78:4-84:5) and [hashCode()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/br/com/dio/desafio/dominio/Dev.java:86:4-89:5) to use only immutable fields

### 5. Memory Management
- Reused `LocalDate` objects instead of creating new instances
- Minimized object creation in hot paths
- Used static final constants where appropriate

## 📈 Performance Metrics

### Benchmark Results
The project includes JMH (Java Microbenchmark Harness) benchmarks to measure the performance improvements. The benchmarks test:

1. [testProgredir()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/test/java/br/com/dio/desafio/benchmark/BootcampBenchmark.java:48:4-54:5): Measures performance of progress tracking
2. [testCalcularXp()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/test/java/br/com/dio/desafio/benchmark/BootcampBenchmark.java:56:4-60:5): Measures XP calculation performance
3. [testInscricaoBootcamp()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/test/java/br/com/dio/desafio/benchmark/BootcampBenchmark.java:62:4-68:5): Tests bootcamp enrollment performance
4. [testEqualsHashCode()](cci:1://file:///home/pmota/Documentos/lcm/Atividade.DIO/desafio-poo-dio/src/test/java/br/com/dio/desafio/benchmark/BootcampBenchmark.java:70:4-81:5): Tests performance of equality operations

### How to Run Benchmarks

```bash
# Clean and build the project
mvn clean install

# Run all benchmarks
mvn exec:java -Dexec.mainClass="org.openjdk.jmh.Main" -Dexec.args="br.com.dio.desafio.benchmark.* -f 1 -wi 3 -i 5"
```

## 📚 Key Learnings

1. **Collection Performance**:
   - Initial capacity matters for `HashSet` and `LinkedHashSet`
   - Choose the right collection type based on access patterns

2. **Caching Strategies**:
   - When to use caching
   - How to implement thread-safe caching with `AtomicReference`
   - Cache invalidation strategies

3. **String Handling**:
   - The cost of string concatenation in loops
   - Benefits of `StringBuilder` for multiple string operations

4. **Method Optimization**:
   - Identifying and optimizing hot methods
   - The impact of Stream API on performance
   - Benefits of primitive operations over object operations

5. **Memory Management**:
   - Object reuse patterns
   - Impact of object creation on GC
   - Benefits of immutable objects

## 🛠️ Project Structure

```
src/
├── main/java/br/com/dio/desafio/dominio/
│   ├── Bootcamp.java    # Bootcamp management
│   ├── Conteudo.java    # Base content class
│   ├── Curso.java       # Course implementation
│   ├── Dev.java         # Developer implementation
│   └── Mentoria.java    # Mentorship implementation
├── test/java/br/com/dio/desafio/benchmark/
│   └── BootcampBenchmark.java  # JMH benchmarks
└── Main.java           # Example usage
```

## 📝 Best Practices Applied

1. **Immutability** where possible
2. **Thread-safety** for shared resources
3. **Encapsulation** of implementation details
4. **Consistent** equals/hashCode contracts
5. **Documented** public APIs

## 📊 Performance Impact

The optimizations resulted in:
- Reduced memory allocation in hot paths
- Faster collection operations
- Lower GC pressure
- More predictable performance under load

## 🚀 Next Steps

1. Add more comprehensive benchmarks
2. Implement additional performance monitoring
3. Consider parallel processing for batch operations
4. Profile memory usage under different loads

## 📋 Requirements

- Java 11+
- Maven 3.6+
- JMH (included via Maven)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.