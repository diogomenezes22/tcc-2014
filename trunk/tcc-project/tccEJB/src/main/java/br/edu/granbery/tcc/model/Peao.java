package br.edu.granbery.tcc.model;

import java.io.Serializable;

import javax.persistence.*;

import br.edu.granbery.tcc.util.SampleEntity;

@Entity
@Table(name="TB_PEAO" )
public class Peao implements Serializable, SampleEntity{
	
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID_PEAO")
		private Long id;
		
		@Column(name="DE_DESCRICAO")
		private String descricao;
		
		@Column(name="DE_COR")
		private String cor;
		
		@Column(name="POSICAO_ATUAL")
		private Integer posicaoAtual;
		
		@Transient
		private int proximaPosicao;
		
		@Transient
		private boolean podeAndar;
		
		@OneToOne
		@JoinColumn(name = "ID_JOGADOR", referencedColumnName = "ID_JOGADOR")
		private Jogador jogador;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public Integer getPosicaoAtual() {
			return posicaoAtual;
		}
		public void setPosicaoAtual(Integer posicaoAtual) {
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
		public Jogador getJogador() {
			return jogador;
		}
		public void setJogador(Jogador jogador) {
			this.jogador = jogador;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Peao other = (Peao) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
}
