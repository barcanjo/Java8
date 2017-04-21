# Java8
Projeto com alguns recursos da API 8 do Java.

É possível ver o uso de:
- **Classes anônimas**
- **Interfaces Funcionais**
- **default method** em Interfaces
- **Lambda**
- **Method Reference**
- **Stream**
- **LocalDate**
- **LocalTime**
- **LocalDateTime**
- **DateTimeFormatter**

## Classes anônimas
Pode-se utilizar uma classe anônima ao invés de utilizar a implementação de uma Interface Funcional. Veja o exemplo abaixo onde é construída uma instância da Interface `Comparator` dentro do método *sort* da `java.util.List palavas`:

```
List<String> palavras = new ArrayList<String>();
palavras.add("JavaScript");
palavras.add("Java");
palavras.add("C");
palavras.add("Asp");
palavras.sort(new Comparator<String>() {
  @Override
  public int compare(String s1, String s2) {
    if (s1.length() < s2.length())
      return -1;
    if (s1.length() > s2.length())
      return 1;
    return 0;
  }
});
```
*A Interface `Comparator` é um exemplo de Interface Funcional, com um método abstrato *compare* e os demais como default.*

## Lambda
Exemplo de ordenação de uma `java.util.List` com Lambda, utilizando a classe `java.lang.Integer` para comparação do tamanho das Strings:
```
palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
```
Exemplo de ordenação de uma `java.util.List` com Lambda, utilizando o *comparing* da Interface `Comparator` para comparação do tamanho das Strings:
```
palavras.sort(Comparator.comparing(s -> s.length()));
```
## Method Reference
Exemplo de ordenação de uma `java.util.List` com Method Reference, utilizando o *comparing* da Interface `Comparator` para comparação do tamanho das Strings através do método length:
```
palavras.sort(Comparator.comparing(String::length));
```
Exemplo de Iteração sobre uma `java.util.List` e exibição dos seus valores no console, utilizando o Method Reference: 
```
palavras.forEach(System.out::println);
```
## Stream
Permite converter `uma java.util.List` em um Streama fim de realizar operações mais avançadas nos elementos da lista.
```
List<Curso> cursos = new ArrayList<Curso>();
cursos.add(new Curso("Python", 45));
cursos.add(new Curso("JavaScript", 150));
cursos.add(new Curso("Java 8", 113));
cursos.add(new Curso("C", 55));

...

class Curso {
	
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
	}
}

```
Utilizando o Method Reference, retorna e imprime no console os cursos com quantidade de alunos maior que 100:
```
cursos.stream()
  .filter(c -> c.getAlunos() > 100)
  .forEach(c -> System.out.println(c.getNome()));
```

Imprime no console um Stream de Integer com a quantidade de alunos nos cursos com mais de 100 alunos:
```
cursos.stream()
  .filter(c -> c.getAlunos() > 100)
  .map(Curso::getAlunos)
  .forEach(System.out::println);
```

Imprime no console a soma de toda a quantidade de alunos nos cursos com mais de 100 alunos:
```
int sum = cursos.stream()
  .filter(c -> c.getAlunos() >= 100)
  .mapToInt(Curso::getAlunos)
  .sum();
  System.out.println(sum);
```

Imprime no console o número de cursos com a quantidade de alunos maior que 100:
```
System.out.println(cursos.stream().filter(c -> c.getAlunos() > 150).count());
```
