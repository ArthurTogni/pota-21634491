import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ListaPessoas {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*-------------------------------------------------------------------------------------------------------------------------*/
		/*
		André Santos Benedicto - 21446132
		Arthur Togni Silva - 21634491
		Guilherme Aragão Spósito - 21464152
		*/
		/*-------------------------------------------------------------------------------------------------------------------------*/

		Scanner sc1 = new Scanner(System.in);

		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<String> sexo = new ArrayList<String>();
		ArrayList<String> endereco = new ArrayList<String>();
		ArrayList<String> cidade = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> telefone = new ArrayList<String>();
		ArrayList<String> idade = new ArrayList<String>();

//		while (true) {
		try (Stream<String> data = Files.lines(
				Path.of("C:\\Users\\Arthur\\Desktop\\repository\\pota-21634491\\ARQUIVO-AQUI\\arquivoDados.csv"))) {

//				Scanner sc = new Scanner(System.in);
//
//				System.out.println("Escreva o nome a ser pesquisado ou 'exit' para sair: ");
//
//				String pesquisa = sc.nextLine();

			data.forEach(lines -> {

				String[] arrayData = lines.split(",");

				nome.add(semAcento(arrayData[0]));
				sexo.add(semAcento(arrayData[1]));
				endereco.add(semAcento(arrayData[2]));
				cidade.add(semAcento(arrayData[3]));
				email.add(semAcento(arrayData[4]));
				telefone.add(semAcento(arrayData[5]));
				idade.add(semAcento(arrayData[6]));
			});

		} catch (Exception ex) {
			System.out.println("Erro na aplicacao");
		}

		while (true) {

			Scanner sc = new Scanner(System.in);

			System.out.println("Escreva o nome a ser pesquisado ou 'exit' para sair: ");
			System.out.println();

			String pesquisa = sc.nextLine();

			int index = nome.indexOf(semAcento(pesquisa));
			

			if (semAcento(pesquisa).equals("exit")) {
				System.out.println("**********************************");
				System.out.println("SAINDO DA APLICACAO");
				System.out.println("**********************************");
				break;

			} else if (index == -1) {

				System.out.println("---------------- PESSOA NAO ENCONTRADA ----------------");
				System.out.println();

			} else if (index >= 0) {

				System.out.println("Nome: " + nome.get(index));
				System.out.println("Sexo: " + sexo.get(index));
				System.out.println("Endereco: " + endereco.get(index));
				System.out.println("Cidade: " + cidade.get(index));
				System.out.println("Email: " + email.get(index));
				System.out.println("Telefone: " + telefone.get(index));
				System.out.println("Idade: " + idade.get(index));
				
				System.out.println();
			} else {

				System.out.println("**************************************");
				System.out.println("erro na aplicacao");
				System.out.println("**************************************");
			}

		}

	}

	public static String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

}
