package app;

import java.io.BufferedReader;
import java.io.FileReader;
// dev caio cesar del bonne
import java.io.IOException;
/*
 * Caio Cesar Del bonne
 * data 26-03
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import entity.Piloto;

public class Program { // posicao de chegada

	public static void main(String[] args) throws Exception {
		Locale br = new Locale("pt", "BR");
		List<Piloto> list = new ArrayList<Piloto>();
		String arquivoTxt = "C:\\Users\\caioc\\Desktop\\ninja_caiocesar-4-1\\ARQUIVO_ENTRADA.csv";

		try {
			BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivoTxt));
			String linha = leitorArquivo.readLine();
			// while (linha != null && !linha.isEmpty()) {
			while ((linha = leitorArquivo.readLine()) != null) {
				leitorArquivo.readLine();
				String[] str_Array = linha.split(";");

				String hora = str_Array[0].trim();
				String nomeEId = str_Array[1].trim();
				int numeroVoltas = Integer.parseInt(str_Array[2].trim());
				String tempoDeVolta = (str_Array[3].trim());
				// ate aqui ok

				String numero = tempoDeVolta;
				String[] x = numero.split(":");
				double primeiroNumero = Double.parseDouble(x[0]);
				// System.out.println("1 numero = " + (primeiroNumero));
				double segundoNumero = Double.parseDouble(x[1]);
//				System.out.println("segundo numero " + segundoNumero);
				double tempo = (primeiroNumero + segundoNumero);

				// aqui esta certo
				double velocidadeMedia = Double.parseDouble(str_Array[4].trim()); // era String

				// String valorFormat = String.format("%s %s %d %d %f" ,hora ,nomeEId
				// ,numeroVoltas ,tempo , velocidadeMedia);

				// ordenar pelo menor valor de volta , depois de ter somado todas as voltas 
				// juntar os objetos e comparar se os nomes são iguais, se for adicionar todos a um só			

				Piloto pi = new Piloto(hora, nomeEId, numeroVoltas, tempo, velocidadeMedia);
				
//				if (nomeEId == nomeEId) {
//					nomeEId +=nomeEId;
//					numeroVoltas += numeroVoltas;
//					
//				}
				list.add(pi);

				linha = leitorArquivo.readLine();

			}
			Collections.sort(list, Comparator.comparing(Piloto::getTempoDeVolta));
			for (Piloto p : list) {

				System.out.println(p);
				// System.out.println("");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}