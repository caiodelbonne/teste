
public class Piloto {

	private int tamanho = 10;
	private int posicao = 0;

	private int codPiloto;
	private String nomePiloto;

	private String horas[];//
	private int voltas[];//
	private String tempoDasVoltas[];

	private float velocidadesMedia[];

	private String tempoTotalVoltas;
	private double totalMS;

	public Piloto(String hora, int codPiloto, String nomePiloto, int numeroVoltas, String tempoVolta,
			float velocidadeMedia) {

		horas = new String[tamanho];
		voltas = new int[tamanho];
		tempoDasVoltas = new String[tamanho];
		velocidadesMedia = new float[tamanho];

		horas[posicao] = hora;

		this.codPiloto = codPiloto;
		this.nomePiloto = nomePiloto;

		voltas[posicao] = numeroVoltas;
		tempoDasVoltas[posicao] = tempoVolta;
		velocidadesMedia[posicao] = velocidadeMedia;
		this.posicao = this.posicao + 1;
	}

	public int getQtdTotalDeVoltas() {

		return posicao;
	}

	public int getCodPiloto() {
		return codPiloto;
	}

	public String getNomePiloto() {

		return nomePiloto;
	}

	public String getTempoTotalDasVoltas() {

		return tempoTotalVoltas;
	}

	public double getTotalMS() {

		return totalMS;
	}

	public void incluirDados(String hora, int numeroVoltas, String tempoVolta, float velocidadeMedia) {
		horas[posicao] = hora;
		voltas[posicao] = numeroVoltas;
		tempoDasVoltas[posicao] = tempoVolta;
		velocidadesMedia[posicao] = velocidadeMedia;
		this.posicao = this.posicao + 1;
	}

	@Override
	public String toString() {
		String retorno = "\n";
		retorno = retorno + "codigo do piloto: " + codPiloto + "\n";
		retorno = retorno + "nome: " + nomePiloto + "\n";
		for (int i = 0; i < posicao; i++) {
			retorno = retorno + "hora " + horas[i] + " volta de numero " + voltas[i] + " tempo " + tempoDasVoltas[i]
					+ " velocidade Media" + velocidadesMedia[i] + "\n";

		}
		return retorno;
	}

	public void gerarTempoTotal() {
		int minuto = 0;
		int segundos = 0;
		int milSegundos = 0;

		String tempo;
		String auxiliar[];
		for (int i = 0; i < posicao; i++) {
			tempo = tempoDasVoltas[i];
			tempo = tempo.replace(".", ":");
			auxiliar = tempo.split(":");
			minuto = minuto + Integer.parseInt(auxiliar[0]);
			segundos = segundos + Integer.parseInt(auxiliar[1]);
			milSegundos = milSegundos + Integer.parseInt(auxiliar[2]);
		}

		int s = (milSegundos / 1000) % 60;
		segundos = segundos + s;
		milSegundos = milSegundos - (s * 1000);

		tempoTotalVoltas = Integer.toString(minuto) + ":" + Integer.toString(segundos) + ":"
				+ Integer.toString(milSegundos);

		totalMS = ((minuto * 60000) + (segundos * 1000) + milSegundos);

	}

}
