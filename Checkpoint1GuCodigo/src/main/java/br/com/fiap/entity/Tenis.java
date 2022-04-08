package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_TENIS")
@SequenceGenerator(name="tenis", sequenceName="SQ_TB_TENIS",allocationSize = 1)
public class Tenis {

	@Id
	@Column(name="cd_tenis")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tenis")
	private Integer id;
	
	@Column(name="nm_tenis", nullable = false, length = 50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento", nullable = false)
	private Calendar dataLancamento;

	@Column(name="ds_color", nullable = false, length = 30)
	private String colorWay;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_marca", nullable = false, length = 15)
	private MarcaTenis marca;

	@Column(name="ds_estado", nullable = false, length = 15)
	private String estado;

	public Tenis() {}

	public Tenis(String nome, Calendar dataLancamento, String colorWay, MarcaTenis marca, String estado) {
		super();
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.colorWay = colorWay;
		this.marca = marca;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getColorWay() {
		return colorWay;
	}

	public void setColorWay(String colorWay) {
		this.colorWay = colorWay;
	}

	public MarcaTenis getMarca() {
		return marca;
	}

	public void setMarca(MarcaTenis marca) {
		this.marca = marca;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
