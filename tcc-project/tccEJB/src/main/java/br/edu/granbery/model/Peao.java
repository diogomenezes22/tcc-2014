package br.edu.granbery.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="PEAO")
public class Peao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705377933463097580L;
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID")
		private int id;
		
		@Column(name="DESCRICAO")
		private String descricao;
		
		@Column(name="POSICAOATUAL")
		private int posicaoAtual;
		
		@Column(name="PROXIMAPOSICAO")
		private int proximaPosicao;
		
		@Column(name="PODEANDAR")
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
