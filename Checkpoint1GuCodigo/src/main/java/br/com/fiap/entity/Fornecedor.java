package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_FORNECEDOR")
@SequenceGenerator(name="fornecedor", sequenceName="SQ_TB_FORNECEDOR",allocationSize = 1)
public class Fornecedor {
	
		@Id
		@Column(name="cd_fornecedor")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor")
		private Integer codigo;
		
		@Column(name="nm_fornecedor", nullable = false, length = 50)
		private String nomeFornecedor;
		
		@Column(name="ds_cpf", nullable = false)
		private int cpf;
		
		@Column(name="ds_local",nullable = false, length = 50)
		private String local;
		
		public Fornecedor() {}

		public Fornecedor(Integer codigo, String nomeFornecedor, int cpf, String local) {
			super();
			this.codigo = codigo;
			this.nomeFornecedor = nomeFornecedor;
			this.cpf = cpf;
			this.local = local;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getNomeFornecedor() {
			return nomeFornecedor;
		}

		public void setNomeFornecedor(String nomeFornecedor) {
			this.nomeFornecedor = nomeFornecedor;
		}

		public int getCpf() {
			return cpf;
		}

		public void setCpf(int cpf) {
			this.cpf = cpf;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}
		
		
		
}
