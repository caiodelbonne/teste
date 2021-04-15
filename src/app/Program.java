package app;
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
import java.util.Scanner;

import entity.Piloto;

public class Program { // posicao de chegada

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// lista de piloto
		System.out.println("Quantidade de pilotos ?");

		int N = sc.nextInt();

		System.out.println("Quantidade de pilotos que ira participar da corrida: " + N);
		List<Piloto> list = new ArrayList<Piloto>();

		for (int i = 0; i < N; i++) {
			System.out.println("Entre com Nome Piloto : " + i);
			String name = sc.next();
			System.out.println("Numero de Identificação do Piloto");
			int numeroPiloto = sc.nextInt();
			// vetor de voltas
			System.out.println("Voltas Completas. . . ");

			int quantidadeDeVoltas = sc.nextInt();
			if (quantidadeDeVoltas > 4) {
				System.out.println("Quantidade de voltas maxima 4");
				throw new ArithmeticException(
						"quantidade de voltas nao pode ser maior que 4 \n" + "repita novamente! ");

			}
			// aqui começa a nedia velocidade , velocidade em vetor

			int voltas[] = new int[quantidadeDeVoltas];
			int somaTempo = 0;
			int velocidadeDaVolta;
			int vm[] = new int[quantidadeDeVoltas];
			double somavelocidade = 0;
			for (int volta  =0 ; volta < quantidadeDeVoltas; volta++) {
				System.out.println("Volta de numero : " + volta);
				System.out.println("velocidade Maxima da volta " + volta);
				vm[volta] = sc.nextInt();
				somavelocidade += vm[volta];
				System.out.println("Tempo da volta em segundos : ");
				int tempoDaVolta = sc.nextInt();
				somaTempo += tempoDaVolta;
			}
			double mediaVelocidade = (somavelocidade / quantidadeDeVoltas);
			System.out.println("Tempo total : " + somaTempo + " velocidade media " + mediaVelocidade +" Km");

			Piloto x = new Piloto(name, numeroPiloto, somaTempo, mediaVelocidade);
			list.add(x);
		}

		list.sort(Comparator.comparing(Piloto::getTempoDaProva));
		// lista de ordenação por tempo

		for (Piloto piloto : list) {

			System.out.println("Nome do piloto: " + piloto.getNome() + 
					" Numero do piloto : " + piloto.getNumeroPiloto()
					+ " tempo de corrida : " + piloto.getTempoDaProva() + 
					" Velocidade media foi de: " + piloto.getMediaVelocidade());
		}

		System.out.println(list.get(0));
	}
}