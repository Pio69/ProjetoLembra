package br.com.leonardo.model;

import java.math.BigDecimal;

public class Produto {

	private int idProd;
	private String descProd;
	private BigDecimal precoProd;
	private int qtdProd;
	private int idCateProd;

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public BigDecimal getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(BigDecimal precoProd) {
		this.precoProd = precoProd;
	}

	public int getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}

	public int getIdCateProd() {
		return idCateProd;
	}

	public void setIdCateProd(int idCateProd) {
		this.idCateProd = idCateProd;
	}

}
