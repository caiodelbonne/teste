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
import java.util.Scanner;

import entity.Piloto;

public class Program { // posicao de chegada

	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("pt-BR"));
		List<Piloto> list = new ArrayList<Piloto>();
		String arquivoTxt = "C:\\Users\\caioc\\Desktop\\ninja_caiocesar-4-1\\ARQUIVO_ENTRADA.csv";

		try {
			BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivoTxt));
			leitorArquivo.readLine();
			String line = leitorArquivo.readLine();

			while ((line = leitorArquivo.readLine()) != null) {
				leitorArquivo.readLine();
				String[] str_Array = line.split(";");
				String hora = str_Array[0].trim();
				String nomeEId = str_Array[1].trim();
				int numeroVoltas = Integer.parseInt(str_Array[2].trim());
				String tempoDeVolta = str_Array[3].trim();
				// Double tempo = Double.parseDouble(tempoDeVolta)/60;
				Double velocidadeMedia = Double.parseDouble(str_Array[4].trim()); // era String
				Piloto pi = new Piloto(hora, nomeEId, numeroVoltas, tempoDeVolta, velocidadeMedia);
				list.add(pi);
			}
			for (Piloto p : list) {

				System.out.println(p);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}