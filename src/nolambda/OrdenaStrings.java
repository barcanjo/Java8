package nolambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
		 * Cria uma instância de ComparadorPorTamanho que implementa
		 * Comparator, responsável por comparar valores
		 */
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		/*
		 *  Método antigo para ordenar uma lista com uma instância de
		 *  Comparator
		 */
		// Collections.sort(palavras, comparador);
		
		/* 
		 * Utiliza o default method de List para aplicar o comparador
		 * e ordenar a lista
		 */
		palavras.sort(comparador);
		
		System.out.println(palavras);
		
		/*
		 * Método anigo para Iterar sobre uma lista 
		 */
		/*for (String p : palavras) {
			System.out.println(p);
		}*/
		
		/*
		 * Cria uma instância de ImprimeNaLinha, que implementa Consumer,
		 * responsável por receber uma String e executar o método accept
		 * a cada Iteração da lista (forEach()).
		 */
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
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
	 * Método executado, neste exemplo, a cada Iteração de uma lista.
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
