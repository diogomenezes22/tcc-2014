package br.edu.granbery.model;

import java.io.Serializable;

public class Peao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705377933463097580L;
	
		private int id;
		private String descricao;
		private int posicaoAtual;
		private int proximaPosicao;
		private boolean podeAndar;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public int getPosicaoAtual() {
			return posicaoAtual;
		}
		public void setPosicaoAtual(int posicaoAtual) {
			this.posicaoAtual = posicaoAtual;
		}
		public boolean isPodeAndar() {
			return podeAndar;
		}
		public void setPodeAndar(boolean podeAndar) {
			this.podeAndar = podeAndar;
		}
		public int getProximaPosicao() {
			return proximaPosicao;
		}
		public void setProximaPosicao(int proximaPosicao) {
			this.proximaPosicao = proximaPosicao;
		}
}
