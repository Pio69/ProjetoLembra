package br.com.leonardo.model;

public class Categoria {

	private int idCate;
	private String descCate;

	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}

	public String getDescCate() {
		return descCate;
	}

	public void setDescCate(String descCate) {
		this.descCate = descCate;
	}

	@Override
	public String toString() {
		return idCate + " - " + descCate;
	}

	
	
}
