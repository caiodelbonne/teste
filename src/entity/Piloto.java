package entity;

public class Piloto {



		private String nome;
		private int numeroPiloto;
		private int posicaoChegada;
		private int tempoDaProva;
		private double mediaVelocidade; // sem metodo
		

		public Piloto(String nome, int numeroPiloto, int tempoDaProva ,double mediaVelocidade) {
			this.nome = nome;
			this.numeroPiloto = numeroPiloto;
			this.tempoDaProva = tempoDaProva;
			this.mediaVelocidade = mediaVelocidade ;
		}
		@Override
		public String toString() {
			return "[ Campeão :" + nome.toUpperCase() +" Numero do piloto: " + numeroPiloto + ",Tempo de prova: " + tempoDaProva +" Segundos , velocidade media foi de : " 
					+ mediaVelocidade;
		}


		public Double getMediaVelocidade() {
			return mediaVelocidade;
		}
		public int getTempoDaProva() {
			return tempoDaProva;
		}
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getNumeroPiloto() {
			return numeroPiloto;
		}

		public int getPosicaoChegada() {
			return posicaoChegada;
		}

		public void setPosicaoChegada(int posicaoChegada) {
			this.posicaoChegada = posicaoChegada;
		}

		

		
		public int velocidadeMedia (int quantidadeVoltas , int velocidade) {
		
			int media = ( quantidadeVoltas + velocidade ) / quantidadeVoltas ;
			
			return media;
		}

	}

