import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Operacao {

	private String hora;
	private int codPiloto;
	private String nomePiloto;
	private int numeroVoltas;
	private String tempoVolta;
	private float velocidadeMedia;

	private List<Piloto> listaPiloto;
	private double resultado[][]; // matriz

	Operacao() {
		listaPiloto = new ArrayList<Piloto>();
		resultado = new double[10][2];
	}

	public void lerArquivo(String txt) {
		FileReader fr = null;
		BufferedReader leitorArquivo = null;

		try {
			fr = new FileReader(txt); // arquivo fisico
			leitorArquivo = new BufferedReader(fr);
			String linha = leitorArquivo.readLine();

			linha = leitorArquivo.readLine();
			while (linha != null) {
				linha = linha.trim().replaceAll("\\s+", " "); // tabulação - .S space + um ou mais espaço
				// System.out.println(linha);
				String str_Array[] = linha.split(" ");
				hora = str_Array[0];
				codPiloto = Integer.parseInt(str_Array[1]);
				nomePiloto = str_Array[3];
				numeroVoltas = Integer.parseInt(str_Array[4]);
				// tempoVolta = Float.parseFloat(str_Array[5].replace(",", ".") );
				tempoVolta = str_Array[5].replace(",", ".");
				velocidadeMedia = Float.parseFloat(str_Array[6].replace(",", "."));

				gerenciarCorrida(hora, codPiloto, nomePiloto, numeroVoltas, tempoVolta, velocidadeMedia);

				linha = leitorArquivo.readLine();

			}
			for (int i = 0; i < listaPiloto.size(); i++) {

				listaPiloto.get(i).gerarTempoTotal();
			}
			/*
			 * Collections.sort(list, Comparator.comparing(Piloto::getTempoDeVolta)); for
			 * (Piloto p : list) {
			 * 
			 * System.out.println(p); // System.out.println(""); }
			 */
			leitorArquivo.close();
			fr.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void gerenciarCorrida(String hora2, int codPiloto2, String nomePiloto2, int numeroVoltas2,
			String tempoVolta2, float velocidadeMedia2) {
		if (listaPiloto.size() > 0) {
			int posicaoEncontrada = buscarCodigo(codPiloto2);
			if (posicaoEncontrada == -1) {
				Piloto p = new Piloto(hora2, codPiloto2, nomePiloto2, numeroVoltas2, tempoVolta2, velocidadeMedia2);
				listaPiloto.add(p);
			} else {
				listaPiloto.get(posicaoEncontrada).incluirDados(hora2, numeroVoltas2, tempoVolta2, velocidadeMedia2);
			}

		} else {
			Piloto p = new Piloto(hora2, codPiloto2, nomePiloto2, numeroVoltas2, tempoVolta2, velocidadeMedia2);
			listaPiloto.add(p);
		}

	}

	private int buscarCodigo(int codPiloto2) {
		for (int i = 0; i < listaPiloto.size(); i++) {
			if (listaPiloto.get(i).getCodPiloto() == codPiloto2) {
				return i;
			}
		}
		return -1;
	}

	public String imprime() {
		String retorno = "\n";
		for (int i = 0; i < listaPiloto.size(); i++) {
			retorno = retorno + listaPiloto.get(i).toString();
		}
		return retorno;
	}

	public void gerarResultado(String nomeArquivo) {
		for (int i = 0; i < listaPiloto.size(); i++) {
			resultado[i][0] = listaPiloto.get(i).getCodPiloto();
			resultado[i][1] = listaPiloto.get(i).getTotalMS();
		}

		double auxiliarColuna0, auxiliarColuna1;
		for (int i = 0; i < listaPiloto.size(); i++) {
			for (int j = 0; j < listaPiloto.size() - 1; j++) {
				if (resultado[i][1] < resultado[j][1]) {
					auxiliarColuna0 = resultado[i][0];
					auxiliarColuna1 = resultado[i][1];

					resultado[i][0] = resultado[j][0];
					resultado[i][1] = resultado[j][1];

					resultado[j][0] = auxiliarColuna0;
					resultado[j][1] = auxiliarColuna1;
				}
			}
		}

		File f = new File("src\\" + nomeArquivo + ".txt"); /// caminho
		FileWriter fw = null; // dados da ram -> buuff
		PrintWriter pw = null; // buff hd

		try {
			fw = new FileWriter(f);
			pw = new PrintWriter(fw);
			
			pw.print("posição de chegada;codigo Piloto;nome Piloto;Qtde Voltas Completadas;Tempo Total de Prova\n");
			
			for(int i = 0; i<listaPiloto.size() ; i++ ) {
				int c = buscarCodigo((int) resultado[i][0] );
				
				pw.print((i+1) + ";" );
				
				pw.print(listaPiloto.get(c).getCodPiloto() + ";");
				pw.print(listaPiloto.get(c).getNomePiloto() + ";");
				pw.print(listaPiloto.get(c).getQtdTotalDeVoltas() + ";");
				pw.print(listaPiloto.get(c).getTempoTotalDasVoltas() + "\n");
				
			}
			
			
			pw.close();
			fw.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
