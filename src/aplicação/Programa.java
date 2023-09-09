package aplicação;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entidade.Produto;
import entidade.ProdutoSoma;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho do arquivo: ");
		String caminho = sc.nextLine();// C:/Users/aliss/Dropbox/Programação/Seção 20 - Exercicio.txt
		System.out.print("Digite o salario: R$ ");
		Double salario = sc.nextDouble();
		System.out.println();

		try (BufferedReader buffer = new BufferedReader(new FileReader(caminho))) {

			List<Produto> lista = new ArrayList<>();

			String linha = buffer.readLine();
			while (linha != null) {
				String[] pasta = linha.split(",");
				lista.add(new Produto(pasta[0], pasta[1], Double.parseDouble(pasta[2])));
				linha = buffer.readLine();
			}
			System.out.println("Email de pessoas cujo salário é superior a R$" + salario);

			Comparator<String> comparador = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			List<String> listaEmail = lista.stream()
					.filter(p -> p.getSalario() > salario)
					.map(p -> p.getEmail())
					.sorted(comparador).collect(Collectors.toList());
			listaEmail.forEach(System.out::println);

			ProdutoSoma ps = new ProdutoSoma();

			double soma = ps.soma(lista, p -> p.getNome().charAt(0) == 'M');
			System.out.print("Soma do salário das pessoas cujo nome começa com 'M': R$" + String.format("%.2f", soma));

			// lista.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		sc.close();

	}

}
