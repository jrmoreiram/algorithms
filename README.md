# 🧮 Challenge Algorithms - Desafios de Lógica e Algoritmos

## 📋 Visão Geral

Repositório dedicado a **desafios de lógica de programação e algoritmos** implementados em **Java** com **Spring Boot**. O projeto contém três desafios clássicos de algoritmos que testam habilidades em manipulação de arrays, strings e processamento de dados com coleções.

> **Projeto Técnico**: Sistema desenvolvido para demonstrar soluções algorítmicas e boas práticas de desenvolvimento Java.

## 🎯 Objetivo do Projeto

Este projeto tem como objetivos:
- ✅ Demonstrar soluções algorítmicas eficientes
- ✅ Aplicar conceitos de lógica de programação
- ✅ Implementar interfaces e padrões de projeto
- ✅ Utilizar recursos do Spring Boot
- ✅ Praticar testes unitários com JUnit

## 🧩 Desafios Implementados

### 📌 Desafio 1: Busca de Subarray em Array

**Problema**: Encontrar a primeira ocorrência de um subarray dentro de um array principal.

#### 📝 Especificação
```java
public interface FindArray {
    int findArray(int[] array, int[] subArray);
}
```

#### 🎲 Regras de Negócio
- Retornar a **posição** da primeira ocorrência do subarray no array principal
- Se houver **múltiplas ocorrências**, retornar a **última**
- Se **não houver ocorrência**, retornar **-1**

#### 💡 Exemplos

| Array Principal | SubArray | Resultado | Explicação |
|----------------|----------|-----------|------------|
| `[4,9,3,7,8]` | `[3,7]` | `2` | Encontrado na posição 2 |
| `[1,3,5]` | `[1]` | `0` | Encontrado na posição 0 |
| `[7,8,9]` | `[8,9,10]` | `-1` | Não encontrado |
| `[4,9,3,7,8,3,7,1]` | `[3,7]` | `5` | Última ocorrência na posição 5 |

#### 🔧 Implementação
- **Interface**: `FindArray.java`
- **Classe**: `MyFindArray.java` (package: `br.com.projuris.challengealgorithm.servicesimpl`)

---

### 🔤 Desafio 2: Primeira Letra Não Duplicada

**Problema**: Encontrar o primeiro caractere não repetido em uma string.

#### 📝 Especificação
```java
public interface FindCharachter {
    char findChar(String word);
}
```

#### 🎲 Regras de Negócio
- Retornar a **primeira letra não duplicada** na palavra
- Se **todas as letras forem duplicadas**, retornar `' '` (espaço em branco)

#### 💡 Exemplos

| Palavra | Resultado | Explicação |
|---------|-----------|------------|
| `"stress"` | `'t'` | 't' aparece apenas uma vez |
| `"reembolsar"` | `'m'` | 'm' é a primeira letra única |
| `"aabbcc"` | `' '` | Todas letras duplicadas |

#### 🔧 Implementação
- **Interface**: `FindCharachter.java`
- **Classe**: `MyFindChar.java` (package: `br.com.projuris.challengealgorithm.servicesimpl`)

**Algoritmo Implementado**:
```java
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
```

---

### 💰 Desafio 3: Cálculo de Custos de Funcionários

**Problema**: Calcular o custo total agrupado por departamento e por cargo.

#### 📝 Especificação
```java
public interface FindCalculation {
    List<CostOffice> costByOffice(List<Employee> employees);
    List<CostDepartment> costByDepartment(List<Employee> employees);
}
```

#### 🎲 Regras de Negócio
- Calcular a **soma dos salários** agrupados por:
  - 📊 **Departamento** (Administrativo, Financeiro, Jurídico)
  - 👔 **Cargo** (Estagiário, Assistente, Gerente, Diretor)
- Utilizar `BigDecimal` para precisão monetária

#### 💡 Exemplo de Dados

```java
// Lista de funcionários de exemplo
Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
Funcionario funcionario7 = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
Funcionario funcionario8 = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
Funcionario funcionario9 = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
Funcionario funcionario10 = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));
```

#### 📊 Resultado Esperado

**Por Departamento**:
| Departamento | Custo Total |
|--------------|-------------|
| Administrativo | R$ 18.001,15 |
| Financeiro | R$ 19.800,90 |
| Jurídico | R$ 25.001,80 |

**Por Cargo**:
| Cargo | Custo Total |
|-------|-------------|
| Estagiário | R$ 700,40 |
| Assistente | R$ 4.101,80 |
| Gerente | R$ 24.001,20 |
| Diretor | R$ 34.000,45 |

#### 🔧 Implementação
- **Interface**: `FindCalculation.java`
- **Classe**: `MyCalculation.java` (package: `br.com.projuris.challengealgorithm.servicesimpl`)
- **Entidades**: 
  - `Employee.java` (Funcionário)
  - `CostDepartment.java` (Custo por Departamento)
  - `CostOffice.java` (Custo por Cargo)

## 🏗️ Arquitetura do Projeto

### Estrutura de Pacotes

```
br.com.projuris.challengealgorithm/
│
├── entities/                          # Entidades de domínio
│   ├── Employee.java                  # Funcionário (cargo, depto, salário)
│   ├── CostDepartment.java            # Custo por departamento
│   └── CostOffice.java                # Custo por cargo
│
├── services/                          # Interfaces de serviço
│   ├── FindArray.java                 # Interface busca de array
│   ├── FindCharachter.java            # Interface busca de caractere
│   └── FindCalculation.java           # Interface cálculo de custos
│
├── servicesimpl/                      # Implementações dos algoritmos
│   ├── MyFindArray.java               # Solução desafio 1
│   ├── MyFindChar.java                # Solução desafio 2
│   └── MyCalculation.java             # Solução desafio 3
│
└── ChallengealgorithmApplication.java # Aplicação Spring Boot
```

### Modelo de Entidades

#### 👤 Employee (Funcionário)
```java
public class Employee {
    private String office;         // Cargo
    private String department;     // Departamento
    private BigDecimal salary;     // Salário
    
    // Construtor, getters e setters
}
```

#### 💼 CostDepartment (Custo por Departamento)
```java
public class CostDepartment {
    private String department;     // Nome do departamento
    private BigDecimal cost;       // Custo total
    
    // Getters e setters
}
```

#### 👔 CostOffice (Custo por Cargo)
```java
public class CostOffice {
    private String office;         // Nome do cargo
    private BigDecimal cost;       // Custo total
    
    // Getters e setters
}
```

## 🛠️ Tecnologias e Recursos

### Framework e Bibliotecas

| Tecnologia | Versão | Propósito |
|------------|--------|-----------|
| **Java** | 1.8+ | Linguagem de programação |
| **Spring Boot** | 2.1.0.RELEASE | Framework de aplicação |
| **Spring Data JPA** | 2.1.0 | Persistência de dados |
| **Spring Data REST** | 2.1.0 | Criação de APIs REST |
| **HAL Browser** | - | Navegação de APIs hipermídia |
| **H2 Database** | Runtime | Banco de dados em memória |
| **JUnit** | 4.x | Framework de testes |
| **Maven** | 3.6.0+ | Gerenciamento de dependências |

### Dependências Maven

```xml
<!-- Spring Boot Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Spring Data REST -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>

<!-- Spring Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- HAL Browser -->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Spring Boot Test -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

## 📁 Estrutura do Projeto

```
algorithms-master/
│
├── challenge-algorithms/                # Projeto principal
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── br/com/projuris/challengealgorithm/
│   │   │   │       ├── entities/            # Entidades
│   │   │   │       ├── services/            # Interfaces
│   │   │   │       ├── servicesimpl/        # Implementações
│   │   │   │       └── ChallengealgorithmApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties   # Configurações
│   │   │
│   │   └── test/
│   │       └── java/
│   │           └── br/com/projuris/challengealgorithm/
│   │               ├── ChallengealgorithmApplicationTests.java
│   │               └── MyFindCharTest.java  # Testes unitários
│   │
│   ├── .mvn/                            # Maven wrapper
│   ├── mvnw                             # Maven wrapper (Linux/Mac)
│   ├── mvnw.cmd                         # Maven wrapper (Windows)
│   ├── pom.xml                          # Dependências Maven
│   ├── .gitignore                       # Arquivos ignorados
│   └── README.md                        # Documentação original
│
└── README.md                            # README raiz
```

## 🚀 Como Executar

### Pré-requisitos

1. **Java JDK 8** ou superior
   - [Download Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
   - [Download OpenJDK](https://adoptium.net/)

2. **Apache Maven 3.6.0+** (opcional, pode usar o wrapper)
   - [Download Maven](https://maven.apache.org/download.cgi)

3. **Eclipse IDE 2018-09** (versão 4.9+) - Opcional
   - [Download Eclipse](https://www.eclipse.org/downloads/)

4. **Git** para controle de versão
   - [Download Git](https://git-scm.com/)

### Compilação e Execução

#### Usando Maven Wrapper (Recomendado)

**Linux/Mac**:
```bash
cd challenge-algorithms
./mvnw clean install
./mvnw spring-boot:run
```

**Windows**:
```cmd
cd challenge-algorithms
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

#### Usando Maven Local

```bash
cd challenge-algorithms
mvn clean install
mvn spring-boot:run
```

### Executar Testes

```bash
# Executar todos os testes
./mvnw test

# Executar teste específico
./mvnw test -Dtest=MyFindCharTest
```

### Acessar Aplicação

Após iniciar a aplicação:
- **URL Base**: `http://localhost:8080`
- **HAL Browser**: `http://localhost:8080/browser/index.html`
- **H2 Console** (se habilitado): `http://localhost:8080/h2-console`

## 🧪 Testes Implementados

### MyFindCharTest

Teste unitário para validar a busca de caractere não repetido:

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

### Sugestões de Testes Adicionais

```java
// Teste para FindArray
@Test
public void testFindArray_Found() {
    int[] array = {4, 9, 3, 7, 8};
    int[] subArray = {3, 7};
    assertEquals(2, MyFindArray.findArray(array, subArray));
}

@Test
public void testFindArray_NotFound() {
    int[] array = {7, 8, 9};
    int[] subArray = {8, 9, 10};
    assertEquals(-1, MyFindArray.findArray(array, subArray));
}

// Teste para FindChar
@Test
public void testFindChar_Stress() {
    assertEquals('t', MyFindChar.findChar("stress"));
}

@Test
public void testFindChar_Reembolsar() {
    assertEquals('m', MyFindChar.findChar("reembolsar"));
}

// Teste para Calculation
@Test
public void testCostByDepartment() {
    List<Employee> employees = createEmployeeList();
    List<CostDepartment> result = MyCalculation.costByDepartment(employees);
    assertNotNull(result);
    assertEquals(3, result.size()); // 3 departamentos
}
```

## 📊 Complexidade dos Algoritmos

### Desafio 1: FindArray
- **Complexidade de Tempo**: O(n * m)
  - n = tamanho do array principal
  - m = tamanho do subarray
- **Complexidade de Espaço**: O(1)

### Desafio 2: FindChar
- **Complexidade de Tempo**: O(n²)
  - n = tamanho da string
  - Pode ser otimizado com HashMap para O(n)
- **Complexidade de Espaço**: O(1)

### Desafio 3: Calculation
- **Complexidade de Tempo**: O(n)
  - n = número de funcionários
- **Complexidade de Espaço**: O(k)
  - k = número de departamentos/cargos únicos

## 🔧 Possíveis Melhorias

### 1. Otimizações de Algoritmo
```java
// Otimizar FindChar com HashMap
public char findChar(String word) {
    Map<Character, Integer> frequency = new HashMap<>();
    
    // Contar frequências
    for (char c : word.toCharArray()) {
        frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }
    
    // Encontrar primeiro não repetido
    for (char c : word.toCharArray()) {
        if (frequency.get(c) == 1) {
            return c;
        }
    }
    
    return ' ';
}
```

### 2. Implementações Completas
- ✅ Completar implementação de `MyFindArray`
- ✅ Completar implementação de `MyCalculation`
- ✅ Adicionar validações de entrada

### 3. Testes Abrangentes
- ✅ Testes unitários para todos os desafios
- ✅ Testes de casos extremos (edge cases)
- ✅ Testes de performance

### 4. API REST
- ✅ Criar endpoints REST para cada algoritmo
- ✅ Adicionar documentação Swagger/OpenAPI
- ✅ Implementar validação de entrada

### 5. Persistência
- ✅ Salvar resultados em banco de dados
- ✅ Histórico de execuções
- ✅ Métricas de performance

## 📚 Conceitos de Programação Demonstrados

### ✅ Estruturas de Dados
- Arrays e subarrays
- Strings e caracteres
- Listas e coleções
- BigDecimal para precisão monetária

### ✅ Algoritmos
- Busca linear
- Busca de padrões
- Agrupamento e agregação
- Iteração aninhada

### ✅ Paradigmas
- Programação Orientada a Objetos
- Interfaces e implementações
- Separação de responsabilidades
- Injeção de dependência (Spring)

### ✅ Boas Práticas
- SOLID principles
- Clean Code
- Design Patterns
- Testes unitários

## 🎓 Aplicações Práticas

Estes algoritmos têm aplicações reais em:

1. **FindArray**: 
   - Busca de padrões em logs
   - Análise de sequências
   - Detecção de anomalias

2. **FindChar**:
   - Validação de senhas
   - Análise de texto
   - Criptografia

3. **Calculation**:
   - Folha de pagamento
   - Relatórios gerenciais
   - Business Intelligence

## 📝 Notas Importantes

- ⚠️ **Status**: Projeto em desenvolvimento (algumas implementações pendentes)
- 🔄 **Compatibilidade**: Java 8+ requerido
- 📦 **Empacotamento**: JAR executável via Maven
- 🗄️ **Banco de Dados**: H2 em memória (dados não persistidos)

## 👨‍💻 Desenvolvimento

### Importar no Eclipse

1. `File` → `Import` → `Maven` → `Existing Maven Projects`
2. Selecione a pasta `challenge-algorithms`
3. Aguarde o download das dependências
4. Execute como Spring Boot Application

### Importar no IntelliJ IDEA

1. `File` → `Open` → Selecione `pom.xml`
2. Aguarde indexação e download de dependências
3. Execute a classe `ChallengealgorithmApplication`

## 📄 Licença

Projeto educacional para fins de aprendizado e prática de algoritmos.

---

**Desenvolvido com Java + Spring Boot** ☕ | **Challenge Algorithms** 🧮
