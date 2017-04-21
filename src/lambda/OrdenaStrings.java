package lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Utiliza o Lambda do Java 8 para redução do código, tornando-o
 * menos verboso.
 * O Lambda é utilizado em situações onde Interfaces Funcionais
 * são necessárias em um método, como Compartator e Consumer, e se pode
 * adotar Classes Anônimas (como invocar um new em Consumer).
 * Uma Interface Funcional tem apenas um método abstrato e além dele,
 * outros métodos default.
 * 
 * @author Bruno Arcanjo
 *
 */
public class OrdenaStrings {

	public static void main(String[] args) {
		/*
		 *  Constrói uma lista de String
		 */
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");
		
		/*
		 * Método antigo para ordenar uma lista com uma instância de
		 * Comparator
		 */
		// Collections.sort(palavras, comparador);
		
		/*
		 * Método 1 para ordenação de uma List.
		 *  
		 * Utiliza o default method de List para aplicar o comparador
		 * e ordenar a lista.
		 * Repare que já é passado ao método sort um construtor da
		 * Interface Comparator, com Generics do tipo String, e a
		 * definição do método compare para aplicar o critério de
		 * ordenação da lista.
		*/
		/*palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});*/
		

		/*
		 * Método 2 para ordenação de uma List.
		 * 
		 * Utiliza o recurso Lambda do Java 8 para omitir o uso de uma classe
		 * anônima Comparator e definir o uso de duas variáveis s1 e s2,
		 * ambas do tipo String para fazer a comparação dos valores.
		 * A flecha "->" serve para indicar a execução que será realizada,
		 * neste caso a execução do método que retorna o resultado da comparação.
		*/
		/*
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		System.out.println(palavras);*/
		
		/*
		 * Método 3 para ordenação de uma List.
		 * 
		 * Utiliza o recurso Lambda do Java 8 para omitir o uso de uma classe
		 * anônima Comparator e definir o uso de duas variáveis s1 e s2,
		 * ambas do tipo String para fazer a comparação dos valores.
		 * Neste caso, como Comparator só precisa de um parâmetro (do tipo String)
		 * não se faz necessário o uso dos parênteses conforme o exemplo anterior,
		 * e nem a declaração do tipo como String, já que as variáveis s1 e s2
		 * são desse tipo.
		 * 
		 * A flecha "->" serve para indicar a execução que será realizada,
		 * neste a comparação das Strings s1 e s2. E como apenas um bloco será
		 * executado, não se faz necessário adicionar as chaves entre ele, tornando
		 * o código ainda mais reduzido. 
		 * Foi utulizado o método comparte da classe Integer para fazer a comparação
		 * de s1 e s2, da mesma forma que foi realizado utilizando a classe Comparator. 
		*/
		/*palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));*/
		
		/*
		 * Método 4 para ordenação de uma List.
		 * 
		 * Utiliza o recurso Lambda e Mehotd Reference do Java 8 para ordernar uma List.
		 * É criada uma Function (do pacote java.util.function) que recebe um objeto
		 * do tipo String e retorna um objeto do tipo Integer.
		 * É possível que a função receba um Lambda que define um objeto s e defina
		 * que o método Abstrato da classe Comparator (compare) compare o length
		 * desse objeto (s.length()). Mas também é possível reduzir esse trecho do
		 * código utilizando o recurso Method Reference do Java 8, utilizando
		 * String::length para indicar que será utilizado uma String e dela a propriedade
		 * length para fazer a compartação. Como todos os itens da List são Strings então
		 * de cada String é utilizado o length para fazer a comparação de cada uma.
		 * 
		 * Com o uso do método comparing da classe Comparator é possível passar como
		 * parâmetro a função criada (via Lambda ou Method Referente) ou um próprio
		 * Lambda ou Method Reference(que nesse caso retornam a Interface Funcional
		 * Comparator, utilizada para fazer a comparação da List).
		 *  
		 */
		/*Function<String, Integer> funcao = s -> s.length();
		Function<String, Integer> funcao2 = String::length;
		Comparator<String> comparator = Comparator.comparing(funcao);
		palavras.sort(comparator);
		
		
		palavras.sort(Comparator.comparing(s -> s.length()));*/
		palavras.sort(Comparator.comparing(String::length));
		
		/*
		 * Método anigo para Iterar sobre uma lista 
		 */
		/*for (String p : palavras) {
			System.out.println(p);
		}*/
		
		/*
		 * Método 1 para Iteração e exibição dos valores de uma List.
		 * 
		 * Cria uma instância de ImprimeNaLinha, que implementa Consumer,
		 * responsável por receber uma String e executar o método accept
		 * a cada Iteração da lista (forEach()).
		 */
		/*Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);*/
		
		/*
		 * Método 2 para Iteração e exibição dos valores de uma List.
		 * 
		 * Cria uma classe Anônica Consumer, responsável por receber uma String
		 * e executar o método accept a cada Iteração da lista (forEach()).
		 */
		/*Consumer<String> consumidor = new Consumer<String>() {

		@Override
		public void accept(String s) {
			System.out.println(s);
		}
		
		}; 
		palavras.forEach(consumidor);*/
		
		/*
		 * Método 3 para Iteração e exibição dos valores de uma List.
		 * 
		 * Cria uma classe Anônica Consumer, responsável por receber uma String
		 * e executar o método accept a cada Iteração da lista (forEach())
		 * diretamente no método forEach da List.
		*/
		
		/*palavras.forEach(new Consumer<String>() {
	
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		*/
		
		/*
		 * Método 4 para Iteração e exibição dos valores de uma List.
		 * 
		 * Utiliza o recurso Lambda do Java 8 para omitir o uso de uma classe
		 * anônima Consumer e definir o uso de uma variável s do tipo String
		 * para exibir os valores na tela.
		 * A flecha "->" serve para indicar a execução que será realizada,
		 * neste caso um sysout. 
		*/
		/*palavras.forEach((String s) -> {
			System.out.println(s);
		});*/
		
		/*
		 * Método 5 para Iteração e exibição dos valores de uma List.
		 * 
		 * Utiliza o recurso Lambda do Java 8 para omitir o uso de uma classe
		 * anônima Consumer.
		 * Neste caso, como Consumer só precisa de um parâmetro (do tipo String)
		 * não se faz necessário o uso dos parênteses conforme o exemplo anterior,
		 * e nem a declaração do tipo como String, já que a variável s é desse tipo.
		 * 
		 * A flecha "->" serve para indicar a execução que será realizada,
		 * neste caso um sysout. E como apenas um bloco será executado, não se faz
		 * necessário adicionar as chaves entre ele, tornando o código ainda mais
		 * reduzido. 
		*/
		/*palavras.forEach(s -> System.out.println(s));*/
		
		/*
		 * Método 5 para Iteração e exibição dos valores de uma List.
		 * 
		 * Utiliza o recurso Lambda do Java 8 para omitir o uso de uma classe
		 * anônima Consumer.
		 * Neste caso, como Consumer só precisa de um parâmetro (do tipo String)
		 * não se faz necessário o uso dos parênteses conforme o exemplo anterior,
		 * e nem a declaração do tipo como String, já que a variável s é desse tipo.
		 * 
		 * Utilizando o recurso Lambda e Mehotd Reference do Java 8, é definido
		 * que a classe System.out executará o método println para imprimir no console
		 * o conteúdo de cada item da lista, chamando o método toString de cada um,
		 * ou seja, neste caso de serem String, o próprio valor do objeto.
		 *  
		 */
		palavras.forEach(System.out::println);
	}
}

/**
 * Implementação de Consumer recebendo em seu Generics a classe String.
 * 
 * @author Bruno Arcanjo
 *
 */
class ImprimeNaLinha implements Consumer<String> {
	
	/**
	 * Método executado, neste exemplo, a cada Iteração de uma List.
	 * Com esta definição, a cada Iteração o valor de s (o valor da
	 * lista) é exibido no console.
	 */
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

/**
 * Implementação de Comparator recebendo em seu Generics a classe String.
 * Utiliza Strings para comparar seus valores e definir a ordenação da
 * lista.
 * 
 * @author Bruno Arcanjo
 *
 */
class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}
