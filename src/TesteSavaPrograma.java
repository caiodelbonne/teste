import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TesteSavaPrograma {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("arquivo_de_entrada.txt"));
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(";");

			String hora = linhaScanner.next();
			String nomeEId = linhaScanner.next();
		//	int numeroVoltas = linhaScanner.nextInt();
			String tempoDeVolta = linhaScanner.next();
			//double velocidadeMedia = linhaScanner.nextDouble();

			//String valorFormatado = String.format
				System.out.format(new Locale("pt", "BR"), "%s - %s - %d, %d  %2.3f %n", hora, nomeEId,
					 tempoDeVolta);

			linhaScanner.close();
		}
		
	}

}

/*
 * 
 * 
 * String numero = "3:31.315"; String[] x = numero.split(":"); Double
 * primeiroNumero = Double.parseDouble(x[0]); System.out.println("1 numero = " +
 * (primeiroNumero));
 * 
 * double segundoNumero = Double.parseDouble(x[1]);
 * System.out.println("segundo numero " + segundoNumero); double tempo =
 * primeiroNumero + segundoNumero ;
 * System.out.println("a soma precisa ser igual o numero que esta na String ");
 * System.out.println(tempo);
 * 
 */