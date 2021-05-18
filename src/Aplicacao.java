public class Aplicacao {

	public static void main(String[] args) {

		String arquivoTxt = "C:\\Users\\caioc\\Desktop\\ninja_caiocesar-4-1\\arquivo_de_entrada.txt";
		Operacao op = new Operacao();
		op.lerArquivo(arquivoTxt);

		//System.out.println(op.imprime());
		String saida = "arquivo_de_saida"; // caminho de saida 
		op.gerarResultado(saida);
	}
}
