package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Piloto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dataHora;
	private String nomePiloto;
	private int numeroDeVoltas;
	private Double tempoDeVolta;
	private Double velocidadeMedia;
	private List<Piloto> piloto = new LinkedList<Piloto>(); // test

	Piloto() {
	}

	public Piloto(String dataHora, String nomePiloto, int numeroDeVoltas, Double tempoDeVolta, Double velocidadeMedia) {

		this.dataHora = dataHora;
		this.nomePiloto = nomePiloto;
		this.numeroDeVoltas = numeroDeVoltas;
		this.tempoDeVolta = tempoDeVolta;
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public String toString() {
		return 	" Piloto = " + nomePiloto + 
				", Voltas = " + numeroDeVoltas + 
				" , tempo Da Volta = " +  tempoDeVolta
				+ " , velocidadeMedia = " + velocidadeMedia 
				+ " Horario da prova  " + dataHora;
		
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public int getNumeroDeVoltas() {
		return numeroDeVoltas;
	}

	public void setNumeroDeVoltas(int numeroDeVoltas) {
		this.numeroDeVoltas = numeroDeVoltas;
	}

	public Double getTempoDeVolta() {
		return tempoDeVolta;
	}

	public void setTempoDeVolta(Double tempoDeVolta) {
		this.tempoDeVolta = tempoDeVolta;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

}
