# 🧮 Challenge Algorithm - Sistema de Desafios Algorítmicos

![Java](https://img.shields.io/badge/Java-8+-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.1.0-brightgreen?style=flat-square&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.6.0+-blue?style=flat-square&logo=apache-maven)
![License](https://img.shields.io/badge/License-Educational-yellow?style=flat-square)

## 📋 Visão Geral

Sistema desenvolvido em **Java 8** com **Spring Boot** para resolver três desafios clássicos de **lógica de programação e algoritmos**. O projeto demonstra boas práticas de desenvolvimento, arquitetura em camadas, uso de interfaces e testes unitários.

> **Projeto Técnico**: Implementação de soluções algorítmicas utilizando padrões de design e recursos enterprise do Spring Framework.

---

## 🎯 Objetivos do Projeto

- ✅ **Demonstrar soluções algorítmicas** para problemas comuns
- ✅ **Aplicar design patterns** (Strategy, Interface Segregation)
- ✅ **Utilizar Spring Boot** como framework enterprise
- ✅ **Praticar testes unitários** com JUnit e Spring Test
- ✅ **Seguir princípios SOLID** na organização do código
- ✅ **Desenvolver APIs REST** prontas para integração

---

## 🧩 Desafios Algorítmicos

### 📌 **Desafio 1: Busca de Subarray em Array**

> Encontrar a **última ocorrência** de um subarray dentro de um array principal.

#### 🎯 Objetivo
Implementar um algoritmo que localiza a posição de um subarray dentro de um array, retornando a última ocorrência encontrada.

#### 📝 Interface
```java
package br.com.projuris.challengealgorithm.services;

public interface FindArray {
    int findArray(int[] array, int[] subArray);
}
```

#### 🔍 Regras de Negócio
| Regra | Descrição |
|-------|-----------|
| **Busca Sequencial** | Percorrer o array principal buscando o subarray |
| **Última Ocorrência** | Se houver múltiplas ocorrências, retornar a última |
| **Retorno Posicional** | Retornar o índice da primeira posição do subarray |
| **Não Encontrado** | Retornar `-1` quando não houver correspondência |

#### 💡 Casos de Teste

| Array Principal | SubArray | Resultado | Justificativa |
|----------------|----------|-----------|---------------|
| `[4,9,3,7,8]` | `[3,7]` | `2` | Sequência encontrada a partir do índice 2 |
| `[1,3,5]` | `[1]` | `0` | Elemento único encontrado no início |
| `[7,8,9]` | `[8,9,10]` | `-1` | Subarray não existe no array principal |
| `[4,9,3,7,8,3,7,1]` | `[3,7]` | `5` | Segunda ocorrência (última) no índice 5 |

#### 🏗️ Implementação
- **Package**: `br.com.projuris.challengealgorithm.servicesimpl`
- **Classe**: `MyFindArray.java`
- **Status**: ⚠️ Aguardando implementação

#### 📊 Complexidade Esperada
- **Tempo**: O(n × m) - onde n = tamanho do array, m = tamanho do subarray
- **Espaço**: O(1) - algoritmo in-place

---

### 🔤 **Desafio 2: Primeira Letra Não Duplicada**

> Identificar o **primeiro caractere único** (não repetido) em uma string.

#### 🎯 Objetivo
Analisar uma string e retornar o primeiro caractere que aparece apenas uma vez.

#### 📝 Interface
```java
package br.com.projuris.challengealgorithm.services;

import org.springframework.stereotype.Service;

@Service
public interface FindCharachter {
    char findChar(String word);
}
```

#### 🔍 Regras de Negócio
| Regra | Descrição |
|-------|-----------|
| **Primeira Única** | Retornar a primeira letra que não se repete |
| **Ordem de Aparição** | Considerar a ordem original da string |
| **Sem Ocorrências** | Retornar `' '` (espaço) se todas letras forem duplicadas |
| **Case Sensitive** | Diferenciar maiúsculas de minúsculas |

#### 💡 Casos de Teste

| Entrada | Resultado | Explicação |
|---------|-----------|------------|
| `"stress"` | `'t'` | 't' aparece apenas uma vez (posição 1) |
| `"reembolsar"` | `'m'` | 'm' é a primeira letra única |
| `"aabbcc"` | `' '` | Todas as letras estão duplicadas |
| `"algorithm"` | `'a'` | 'a' aparece apenas uma vez no início |

#### 🏗️ Implementação Atual
```java
package br.com.projuris.challengealgorithm.servicesimpl;

public class MyFindChar {
    public static char findChar(String word) {
        char character;
        for (int i = 0; i < word.length(); i++) {
            character = word.charAt(i);
            for (int j = i + 1; j < word.length(); j++) {
                if (character != word.charAt(j)) {
                    return character;
                }
            }
        }
        return ' ';
    }
}
```

#### 📊 Análise de Complexidade
- **Tempo Atual**: O(n²) - devido ao loop aninhado
- **Espaço Atual**: O(1) - sem estruturas auxiliares
- **Otimização Possível**: O(n) usando HashMap para contar frequências

#### ⚠️ Observação sobre a Implementação
A implementação atual possui uma **lógica incorreta**. O algoritmo retorna o primeiro caractere diferente do próximo, não o primeiro caractere único. 

**Sugestão de Correção**:
```java
public static char findChar(String word) {
    Map<Character, Integer> frequency = new HashMap<>();
    
    // Primeira passada: contar frequências
    for (char c : word.toCharArray()) {
        frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }
    
    // Segunda passada: encontrar primeira com frequência 1
    for (char c : word.toCharArray()) {
        if (frequency.get(c) == 1) {
            return c;
        }
    }
    
    return ' ';
}
```

---

### 💰 **Desafio 3: Cálculo de Custos por Departamento e Cargo**

> Calcular **totalizações** de salários agrupados por departamento e por cargo.

#### 🎯 Objetivo
Processar uma lista de funcionários e calcular o custo total (soma dos salários) agrupado por:
- 🏢 **Departamento** (Administrativo, Financeiro, Jurídico)
- 👔 **Cargo** (Estagiário, Assistente, Gerente, Diretor)

#### 📝 Interface
```java
package br.com.projuris.challengealgorithm.services;

public interface FindCalculation {
    List<CostOffice> costByOffice(List<Employee> employees);
    List<CostDepartment> costByDepartment(List<Employee> employees);
}
```

#### 🏗️ Modelo de Dados

##### 👤 **Employee** (Funcionário)
```java
public class Employee {
    private String office;         // Cargo
    private String department;     // Departamento
    private BigDecimal salary;     // Salário
    
    public Employee(String office, String department, BigDecimal salary) {
        this.office = office;
        this.department = department;
        this.salary = salary;
    }
    // getters e setters
}
```

##### 💼 **CostDepartment** (Custo por Departamento)
```java
public class CostDepartment {
    private String department;     // Nome do departamento
    private BigDecimal cost;       // Custo total do departamento
    
    // getters e setters
}
```

##### 👔 **CostOffice** (Custo por Cargo)
```java
public class CostOffice {
    private String office;         // Nome do cargo
    private BigDecimal cost;       // Custo total do cargo
    
    // getters e setters
}
```

#### 💡 Exemplo de Dataset

```java
List<Employee> employees = Arrays.asList(
    new Employee("Assistente", "Administrativo", new BigDecimal("1000.00")),
    new Employee("Gerente", "Administrativo", new BigDecimal("7000.70")),
    new Employee("Diretor", "Administrativo", new BigDecimal("10000.45")),
    new Employee("Assistente", "Financeiro", new BigDecimal("1300.90")),
    new Employee("Gerente", "Financeiro", new BigDecimal("7500.00")),
    new Employee("Diretor", "Financeiro", new BigDecimal("11000.00")),
    new Employee("Estagiário", "Jurídico", new BigDecimal("700.40")),
    new Employee("Assistente", "Jurídico", new BigDecimal("1800.90")),
    new Employee("Gerente", "Jurídico", new BigDecimal("9500.50")),
    new Employee("Diretor", "Jurídico", new BigDecimal("13000.00"))
);
```

#### 📊 Resultado Esperado

**Custo por Departamento**:
| Departamento | Funcionários | Custo Total |
|--------------|-------------|-------------|
| Administrativo | 3 | R$ 18.001,15 |
| Financeiro | 3 | R$ 19.800,90 |
| Jurídico | 4 | R$ 25.001,80 |
| **TOTAL** | **10** | **R$ 62.803,85** |

**Custo por Cargo**:
| Cargo | Funcionários | Custo Total |
|-------|-------------|-------------|
| Estagiário | 1 | R$ 700,40 |
| Assistente | 3 | R$ 4.101,80 |
| Gerente | 3 | R$ 24.001,20 |
| Diretor | 3 | R$ 34.000,45 |
| **TOTAL** | **10** | **R$ 62.803,85** |

#### 🏗️ Implementação
- **Package**: `br.com.projuris.challengealgorithm.servicesimpl`
- **Classe**: `MyCalculation.java`
- **Status**: ⚠️ Aguardando implementação

#### 📊 Complexidade Esperada
- **Tempo**: O(n) - uma passagem pela lista
- **Espaço**: O(k) - onde k = número de departamentos/cargos únicos

#### 💡 Sugestão de Implementação
```java
public List<CostDepartment> costByDepartment(List<Employee> employees) {
    Map<String, BigDecimal> costs = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.reducing(
                BigDecimal.ZERO,
                Employee::getSalary,
                BigDecimal::add
            )
        ));
    
    return costs.entrySet().stream()
        .map(entry -> {
            CostDepartment cd = new CostDepartment();
            cd.setDepartment(entry.getKey());
            cd.setCost(entry.getValue());
            return cd;
        })
        .collect(Collectors.toList());
}
```

---

## 🏗️ Arquitetura do Projeto

### 📦 Estrutura de Pacotes

```
br.com.projuris.challengealgorithm/
│
├── 📱 ChallengealgorithmApplication.java    # Main class (Spring Boot)
│
├── 📊 entities/                             # Camada de Entidades
│   ├── Employee.java                        # Funcionário
│   ├── CostDepartment.java                  # DTO custo por departamento
│   └── CostOffice.java                      # DTO custo por cargo
│
├── 🔌 services/                             # Camada de Interfaces
│   ├── FindArray.java                       # Interface busca de array
│   ├── FindCharachter.java                  # Interface busca de char
│   └── FindCalculation.java                 # Interface cálculos
│
└── ⚙️ servicesimpl/                         # Camada de Implementação
    ├── MyFindArray.java                     # Implementação desafio 1
    ├── MyFindChar.java                      # Implementação desafio 2
    └── MyCalculation.java                   # Implementação desafio 3
```

### 🎨 Padrões de Design Aplicados

#### 1. **Strategy Pattern**
Cada desafio possui uma interface que define o contrato, permitindo múltiplas implementações.

```java
FindArray ────► MyFindArray
FindCharachter ────► MyFindChar
FindCalculation ────► MyCalculation
```

#### 2. **DTO Pattern** (Data Transfer Object)
Uso de objetos específicos para transferência de dados calculados:
- `CostDepartment` - Encapsula custos por departamento
- `CostOffice` - Encapsula custos por cargo

#### 3. **Separation of Concerns**
- **entities**: Modelos de domínio
- **services**: Contratos (interfaces)
- **servicesimpl**: Lógica de negócio

---

## 🛠️ Stack Tecnológico

### ☕ Core Technologies

| Tecnologia | Versão | Propósito |
|------------|--------|-----------|
| **Java** | 8+ | Linguagem de programação |
| **Spring Boot** | 2.1.0.RELEASE | Framework de aplicação enterprise |
| **Maven** | 3.6.0+ | Gerenciamento de dependências e build |

### 📚 Frameworks e Bibliotecas

| Dependência | Versão | Uso no Projeto |
|-------------|--------|----------------|
| `spring-boot-starter-data-jpa` | 2.1.0 | Persistência e ORM (preparado para uso futuro) |
| `spring-boot-starter-data-rest` | 2.1.0 | Criação automática de APIs REST |
| `spring-boot-starter-web` | 2.1.0 | Desenvolvimento web e REST controllers |
| `spring-data-rest-hal-browser` | 2.1.0 | Navegador de APIs hipermídia HAL |
| `h2` | Runtime | Banco de dados em memória |
| `spring-boot-starter-test` | 2.1.0 | Framework de testes (JUnit, Mockito, etc) |

### 🔧 Ferramentas de Desenvolvimento

- **Maven Wrapper** (`mvnw`) - Build sem instalação do Maven
- **Spring Boot DevTools** - Hot reload (se habilitado)
- **JUnit 4** - Testes unitários
- **Spring Test** - Testes de integração

---

## 📁 Estrutura Completa do Projeto

```
challenge-algorithms/
│
├── 📄 pom.xml                               # Configuração Maven
├── 📄 mvnw / mvnw.cmd                       # Maven Wrapper
├── 📄 README.md                             # Documentação original
├── 📄 .gitignore                            # Arquivos ignorados
│
├── 📂 .mvn/
│   └── wrapper/                             # Maven Wrapper config
│
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   │   └── br/com/projuris/challengealgorithm/
│   │   │       ├── ChallengealgorithmApplication.java
│   │   │       │
│   │   │       ├── 📂 entities/             # 3 classes
│   │   │       │   ├── Employee.java
│   │   │       │   ├── CostDepartment.java
│   │   │       │   └── CostOffice.java
│   │   │       │
│   │   │       ├── 📂 services/             # 3 interfaces
│   │   │       │   ├── FindArray.java
│   │   │       │   ├── FindCharachter.java
│   │   │       │   └── FindCalculation.java
│   │   │       │
│   │   │       └── 📂 servicesimpl/         # 3 implementações
│   │   │           ├── MyFindArray.java     # ⚠️ Vazia
│   │   │           ├── MyFindChar.java      # ✅ Implementada
│   │   │           └── MyCalculation.java   # ⚠️ Vazia
│   │   │
│   │   └── 📂 resources/
│   │       └── application.properties       # Configurações
│   │
│   └── 📂 test/
│       └── 📂 java/
│           └── br/com/projuris/challengealgorithm/
│               ├── ChallengealgorithmApplicationTests.java
│               └── MyFindCharTest.java      # Teste unitário
│
└── 📂 target/                               # Build artifacts (gerado)
```

### 📊 Métricas do Projeto

- **Total de arquivos Java**: 12
- **Total de linhas de código**: ~183 linhas
- **Tamanho do projeto**: ~84 KB
- **Cobertura de testes**: Parcial (apenas FindChar)
- **Status de implementação**: 33% (1 de 3 desafios completos)

---

## 🚀 Guia de Instalação e Execução

### 📋 Pré-requisitos

#### Obrigatórios
- ✅ **Java JDK 8** ou superior
  - [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
  - [OpenJDK](https://adoptium.net/)
  - [Amazon Corretto](https://aws.amazon.com/corretto/)

#### Opcionais
- 📦 **Maven 3.6.0+** (ou use o wrapper incluído)
- 🖥️ **IDE recomendada**:
  - [Eclipse IDE 2018-09+](https://www.eclipse.org/downloads/)
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
  - [VS Code](https://code.visualstudio.com/) com extensões Java

### ⚙️ Configuração Inicial

#### 1. Verificar instalação do Java
```bash
java -version
# Deve exibir: java version "1.8.0_xxx" ou superior
```

#### 2. Clonar/Baixar o projeto
```bash
cd /caminho/desejado
# Extrair o ZIP ou clonar repositório
```

### 🔨 Compilação e Build

#### Usando Maven Wrapper (Recomendado)

**Linux / macOS**:
```bash
cd challenge-algorithms
./mvnw clean install
```

**Windows**:
```cmd
cd challenge-algorithms
mvnw.cmd clean install
```

#### Usando Maven Local
```bash
cd challenge-algorithms
mvn clean install
```

**Saída esperada**:
```
[INFO] BUILD SUCCESS
[INFO] Total time: 15.234 s
```

### ▶️ Executar a Aplicação

#### Método 1: Maven Wrapper
```bash
./mvnw spring-boot:run
```

#### Método 2: JAR executável
```bash
./mvnw clean package
java -jar target/challengealgorithm-0.0.1-SNAPSHOT.jar
```

#### Método 3: IDE
1. Importar o projeto como **Maven Project**
2. Executar a classe `ChallengealgorithmApplication.java`
3. Run as **Spring Boot App**

**Aplicação iniciada**:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.0.RELEASE)

[...] Started ChallengealgorithmApplication in 3.245 seconds
```

### 🌐 Acessar a Aplicação

Após iniciar, os seguintes endpoints estarão disponíveis:

| Endpoint | URL | Descrição |
|----------|-----|-----------|
| **Base URL** | `http://localhost:8080` | Raiz da aplicação |
| **HAL Browser** | `http://localhost:8080/browser/index.html` | Interface de navegação da API |
| **Actuator** | `http://localhost:8080/actuator` | Métricas e saúde (se habilitado) |

---

## 🧪 Testes e Qualidade

### 📊 Testes Implementados

#### 1. **ChallengealgorithmApplicationTests**
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengealgorithmApplicationTests {
    @Test
    public void contextLoads() {
        // Verifica se o contexto Spring carrega corretamente
    }
}
```
**Objetivo**: Validar que a aplicação Spring Boot inicializa sem erros.

#### 2. **MyFindCharTest**
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyFindCharTest {
    @Test
    public void test() {
        MyFindChar.findChar("teste");
    }
}
```
**Status**: ⚠️ Teste básico sem assertions

### ▶️ Executar Testes

```bash
# Todos os testes
./mvnw test

# Teste específico
./mvnw test -Dtest=MyFindCharTest

# Com relatório de cobertura
./mvnw clean test jacoco:report
```

### 📝 Sugestões de Testes Adicionais

#### Para FindChar
```java
@Test
public void testFindChar_Stress_ReturnsT() {
    assertEquals('t', MyFindChar.findChar("stress"));
}

@Test
public void testFindChar_Reembolsar_ReturnsM() {
    assertEquals('m', MyFindChar.findChar("reembolsar"));
}

@Test
public void testFindChar_AllDuplicated_ReturnsSpace() {
    assertEquals(' ', MyFindChar.findChar("aabbcc"));
}

@Test
public void testFindChar_EmptyString_ReturnsSpace() {
    assertEquals(' ', MyFindChar.findChar(""));
}
```

#### Para FindArray
```java
@Test
public void testFindArray_FoundAtBeginning() {
    int[] array = {1, 3, 5};
    int[] subArray = {1};
    assertEquals(0, MyFindArray.findArray(array, subArray));
}

@Test
public void testFindArray_LastOccurrence() {
    int[] array = {4, 9, 3, 7, 8, 3, 7, 1};
    int[] subArray = {3, 7};
    assertEquals(5, MyFindArray.findArray(array, subArray));
}

@Test
public void testFindArray_NotFound() {
    int[] array = {7, 8, 9};
    int[] subArray = {8, 9, 10};
    assertEquals(-1, MyFindArray.findArray(array, subArray));
}
```

#### Para Calculation
```java
@Test
public void testCostByDepartment_CorrectSum() {
    List<Employee> employees = createSampleEmployees();
    List<CostDepartment> result = MyCalculation.costByDepartment(employees);
    
    assertNotNull(result);
    assertEquals(3, result.size());
    
    CostDepartment admin = result.stream()
        .filter(cd -> "Administrativo".equals(cd.getDepartment()))
        .findFirst()
        .orElse(null);
    
    assertNotNull(admin);
    assertEquals(new BigDecimal("18001.15"), admin.getCost());
}
```

---

## 🔧 Melhorias e Evoluções Sugeridas

### 🎯 Curto Prazo (Implementações Pendentes)

#### 1. Completar MyFindArray
```java
public int findArray(int[] array, int[] subArray) {
    int lastOccurrence = -1;
    
    for (int i = 0; i <= array.length - subArray.length; i++) {
        boolean found = true;
        for (int j = 0; j < subArray.length; j++) {
            if (array[i + j] != subArray[j]) {
                found = false;
                break;
            }
        }
        if (found) {
            lastOccurrence = i;
        }
    }
    
    return lastOccurrence;
}
```

#### 2. Completar MyCalculation
- Implementar `costByDepartment()`
- Implementar `costByOffice()`
- Usar Streams API do Java 8

#### 3. Corrigir MyFindChar
- Aplicar algoritmo correto (conforme sugestão anterior)
- Adicionar testes completos

### 📈 Médio Prazo (Funcionalidades)

#### 1. **Criar Controllers REST**
```java
@RestController
@RequestMapping("/api/algorithms")
public class AlgorithmController {
    
    @Autowired
    private FindArray findArray;
    
    @PostMapping("/find-array")
    public ResponseEntity<Integer> findArray(@RequestBody ArrayRequest request) {
        int result = findArray.findArray(request.getArray(), request.getSubArray());
        return ResponseEntity.ok(result);
    }
}
```

#### 2. **Documentação com Swagger**
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```

#### 3. **Validação de Entrada**
```java
@NotNull(message = "Array cannot be null")
@Size(min = 1, message = "Array must have at least one element")
private int[] array;
```

### 🚀 Longo Prazo (Arquitetura)

#### 1. **Métricas e Monitoramento**
- Spring Boot Actuator completo
- Micrometer para métricas
- Grafana + Prometheus

#### 2. **Performance**
- Benchmark com JMH
- Otimização de algoritmos
- Cache com Redis

#### 3. **Persistência**
- Salvar histórico de execuções
- Armazenar datasets de teste
- Auditoria de operações

#### 4. **Containerização**
```dockerfile
FROM openjdk:8-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

---

## 📚 Conceitos de Programação Demonstrados

### ✅ **Estruturas de Dados**
- Arrays unidimensionais
- Strings e caracteres
- Listas genéricas (`List<T>`)
- Maps para agrupamento
- BigDecimal para precisão monetária

### ✅ **Algoritmos**
- **Busca Linear**: Percorrer arrays sequencialmente
- **Pattern Matching**: Encontrar padrões em sequências
- **Agregação**: Somar valores agrupados
- **Iteração**: Loops simples e aninhados

### ✅ **Paradigmas**
- **OOP**: Encapsulamento, herança, polimorfismo
- **Programação Funcional**: Streams, lambdas (Java 8+)
- **Design by Contract**: Interfaces definem contratos

### ✅ **Princípios SOLID**
- **S**ingle Responsibility: Cada classe tem uma responsabilidade
- **O**pen/Closed: Aberto para extensão via interfaces
- **L**iskov Substitution: Implementações são intercambiáveis
- **I**nterface Segregation: Interfaces pequenas e focadas
- **D**ependency Inversion: Dependência de abstrações

---

## 🎓 Casos de Uso Reais

### 1. **FindArray - Busca de Padrões**
- 🔍 **Análise de Logs**: Encontrar sequências de eventos
- 🧬 **Bioinformática**: Buscar padrões em DNA
- 📊 **Séries Temporais**: Detectar tendências recorrentes
- 🎵 **Análise de Áudio**: Identificar padrões sonoros

### 2. **FindChar - Análise de Texto**
- 🔐 **Validação de Senhas**: Verificar caracteres únicos
- 📝 **Processamento de Linguagem Natural**: Análise léxica
- 🎮 **Jogos de Palavras**: Implementar lógica de puzzles
- 📧 **Detecção de Spam**: Análise de padrões textuais

### 3. **Calculation - Relatórios Gerenciais**
- 💼 **Folha de Pagamento**: Totalização por departamento
- 📊 **Business Intelligence**: Dashboards gerenciais
- 💰 **Gestão de Custos**: Análise de despesas
- 📈 **Orçamento Empresarial**: Previsões financeiras

---

## 📊 Análise de Complexidade

### Complexidade de Tempo

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | Otimização Possível |
|-----------|-------------|------------|-----------|---------------------|
| **FindArray** | O(1) | O(n×m) | O(n×m) | KMP: O(n+m) |
| **FindChar (atual)** | O(1) | O(n²) | O(n²) | HashMap: O(n) |
| **Calculation** | O(n) | O(n) | O(n) | - |

### Complexidade de Espaço

| Algoritmo | Espaço Auxiliar | Observações |
|-----------|-----------------|-------------|
| **FindArray** | O(1) | In-place, sem estruturas extras |
| **FindChar (atual)** | O(1) | Pode usar O(n) para otimizar |
| **Calculation** | O(k) | k = número de grupos únicos |

---

## 🐛 Problemas Conhecidos e Limitações

### ⚠️ Bugs Identificados

#### 1. **MyFindChar - Lógica Incorreta**
**Problema**: Retorna primeiro caractere diferente do próximo, não primeiro único.

**Exemplo**:
```java
MyFindChar.findChar("aab"); // Retorna 'a' (incorreto)
// Deveria retornar 'b' (primeiro único)
```

**Solução**: Reescrever usando HashMap para contar frequências.

#### 2. **FindArray e Calculation - Não Implementados**
**Status**: Classes vazias aguardando implementação.

### 📌 Limitações

- ❌ Sem validação de entrada (null, arrays vazios)
- ❌ Sem tratamento de exceções
- ❌ Sem logging estruturado
- ❌ Sem documentação Javadoc
- ❌ Testes com baixa cobertura

---

## 📖 Documentação Adicional

### 🔗 Links Úteis

#### Spring Framework
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/html/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Spring REST Docs](https://spring.io/projects/spring-restdocs)

#### Java
- [Java 8 API](https://docs.oracle.com/javase/8/docs/api/)
- [Effective Java (Joshua Bloch)](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)
- [Clean Code (Robert Martin)](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)

#### Algoritmos
- [Introduction to Algorithms (CLRS)](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
- [LeetCode](https://leetcode.com/) - Prática de algoritmos
- [HackerRank](https://www.hackerrank.com/) - Desafios de programação

---

## 👨‍💻 Desenvolvimento e Contribuição

### 🔀 Importar no Eclipse

1. `File` → `Import...`
2. `Maven` → `Existing Maven Projects`
3. Selecione a pasta `challenge-algorithms`
4. Clique em `Finish`
5. Aguarde o download de dependências
6. Run as `Spring Boot App`

### 🔀 Importar no IntelliJ IDEA

1. `File` → `Open...`
2. Selecione o arquivo `pom.xml`
3. Escolha `Open as Project`
4. Aguarde indexação
5. Run `ChallengealgorithmApplication`

### 📝 Convenções de Código

- **Nomenclatura**: camelCase para métodos, PascalCase para classes
- **Indentação**: 4 espaços (sem tabs)
- **Encoding**: UTF-8
- **Line Ending**: LF (Unix-style)

---

## 📝 Notas Importantes

### ⚠️ Avisos
- 🔴 **Projeto Educacional**: Não usar em produção sem melhorias
- 🟡 **Implementação Parcial**: Apenas 1 de 3 desafios completos
- 🟠 **Bug Conhecido**: MyFindChar possui lógica incorreta

### ✅ Pontos Fortes
- ✔️ Boa separação de responsabilidades
- ✔️ Uso de interfaces (design flexível)
- ✔️ Spring Boot configurado corretamente
- ✔️ Maven Wrapper incluído

### 📦 Informações Técnicas
- **Versão**: 0.0.1-SNAPSHOT
- **GroupId**: br.com.projuris
- **ArtifactId**: challengealgorithm
- **Empacotamento**: JAR
- **Java Version**: 1.8
- **Encoding**: UTF-8

---

## 📄 Licença

Projeto educacional desenvolvido para fins de aprendizado e prática de algoritmos.

---

## 🤝 Suporte e Contato

Para dúvidas sobre implementação ou sugestões de melhorias, consulte:
- 📧 Documentação do Spring Boot
- 💬 Stack Overflow (tag: spring-boot)
- 📚 Comunidade Java Brasil

---

**Desenvolvido com Java + Spring Boot** ☕ | **Challenge Algorithm** 🧮  
*Versão 0.0.1-SNAPSHOT* | *Abril 2026*
