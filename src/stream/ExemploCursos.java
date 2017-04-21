package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utiliza os recursos stream() da API do Java 8.
 * 
 * @author Bruno Arcanjo
 *
 */
public class ExemploCursos {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		/*
		 * Usa o toString de Curso para imprimir os dados via
		 * Method Reference.
		 */
		/*cursos.forEach(System.out::println);*/
		

		/*
		 * Usa a propriedade nome de Curso, via lambda, para imprimir os dados.
		 */
		/*cursos.forEach(c -> System.out.println(c.getNome()));*/
		
		/*
		 * Usa o stream() para retorna um Stream da lista de Curso.
		 * Com o Stream é utilizado o método filter para que com o Lambda
		 * sejam retornados apenas os cursos que tenha alunos com iguais ou
		 * maiores que 100.
		 * Como filter também retorna um Stream, é invocado um forEach para
		 * imprimir o nome do Curso no console, via Lambda.
		 */
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("--- Imprime os cursos com numero de alunos maiores ou iguais a 100 ---");
		System.out.println("--- Imprimme o numero de alunos nos cursos com numero de aluno maiores ou iguais a 100 ---");
		/*
		 * Usa o stream() para retorna um Stream da lista de Curso.
		 * Com o Stream é utilizado o método filter para que com o Lambda
		 * sejam retornados apenas os cursos que tenha alunos com iguais ou
		 * maiores que 100.
		 * Como filter também retorna um Stream, é invocado um map para
		 * retornar um Stream de Integer com o número de alunos em cada curso
		 * retornado no método filter.
		 * Como map também retorna um Stream é invocado um forEach para
		 * imprimir no console o número de alunos dos curso retornados,
		 * via Method Reference.
		 */
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.map(Curso::getAlunos)
			.forEach(System.out::println);
		
		
		/*
		 * Usa o stream() para retorna um Stream da lista de Curso.
		 * Com o Stream é utilizado o método filter para que com o Lambda
		 * sejam retornados apenas os cursos que tenha alunos com iguais ou
		 * maiores que 100.
		 * Como filter também retorna um Stream, é invocado um mapToInt para
		 * retornar um IntStream com o número de alunos em cada curso
		 * retornado no método filter. A classe IntStream permite utilizar
		 * métodos voltados para a classe Integer, como sum, average, min e max.
		 * 
		 * Veja também mapToDouble().
		 * 
		 * Como map também retorna um IntStream é invocado um sum para
		 * somar cada número de alunos dos curso retornados.
		 */
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();
		
		System.out.println("--- Imprimme o total de alunos nos cursos com numero de aluno maiores ou iguais a 100 ---");
		System.out.println(sum);
		
		/*
		 * Imprime no console o número de elementos encontrados no Stream.
		 */
		System.out.println("--- Número total de cursos ---");
		System.out.println(cursos.stream().count());
		
		/*
		 * Utilizando o filter retorna todos os cursos com quantidade de alunos
		 * maior que 150, e com uso do count imprime o número de elementos
		 * retornados pelo filter.
		 */
		System.out.println("--- Número total de cursos com número de alunos maior que 150---");
		System.out.println(cursos.stream().filter(c -> c.getAlunos() > 150).count());
		
		/*
		 * Retorna o primeiro elemento do Stream através do findFirst.
		 * Para que seja retornada a instância de Curso e não da Interface
		 * Optional, usa-se o get.
		 */
		System.out.println("--- Primeiro elemento do Stream ---");
		System.out.println(cursos.stream().findFirst().get());
		
		/*
		 * Utilizando o filter retorna um Stream com apenas os 2 primeiros
		 * elementos, e através do forEach e Method Reference imprime
		 * o valor dos elementos, chamando o método toString da classe Curso.
		 */
		cursos.stream().limit(2).forEach(System.out::println);
		
		/*
		 * Filtra por um curso que tenha o número de alunos maior que 100 e
		 * retorne qualquer um deles.
		 * Se estiver presente um elemento, então via Lambda, imprima no console
		 * o seu nome.
		 */
		System.out.println("--- Imprimindo qualquer Curso com numero de alunos maior que 100 se estiver presente");
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.findAny()
			.ifPresent(c -> System.out.print(c.getNome()));
		
		/*
		 * Filtra por cursos com quantidade de alunos maior que 100.
		 * Utilizando o método collect, passa por parâmetro o método toList()
		 * de Collectors para converter o Stream em um List.
		 * No fim, a List é retornada para um objeto do tipo List.
		 */
		List<Curso> listCursos = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.collect(Collectors.toList());
		System.out.println("--- Imprimindo a List de Curso com numero de alunos maior que 100");
		listCursos.stream().forEach(System.out::println);
		
		/*
		 * Filtra por cursos com quantidade de alunos maior que 100.
		 * Utilizando o método collect, passa por parâmetro o método toMap()
		 * de Collectors para converter o Stream em um Map.
		 * Neste caso é necessário definir a chave e valor do Map, e por isso
		 * como parâmetro de toMap() são passadas duas Functions em Lambda
		 * para indicar que o nome do Curso é a chave e alunos é o valor.
		 * Utilizando o Lambda, chamada o forEach do Map, passando por parâmetro
		 * duas Functions com a chave e valor do mapa para imprimir seus valores
		 * no console.
		 */
		System.out.println("--- Imprimindo o Map de Curso com numero de alunos maior que 100");
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
			.forEach((nome, alunos)-> System.out.println(nome + " tem " + alunos + " aluno(s)"));;
	}
}

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
