package aplicação;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Produto;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho do arquivo: ");
		String caminho = sc.nextLine();// "C:\\Users\\aliss\\Dropbox\\Programação\\Seção 20 - Exercicio.txt"
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
			lista.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		sc.close();

	}

}
