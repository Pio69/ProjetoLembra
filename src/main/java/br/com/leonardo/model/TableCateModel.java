package br.com.leonardo.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.leonardo.dao.CategoriaDAO;
import br.com.leonardo.dao.ProdutoDAO;

public class TableCateModel extends AbstractTableModel {

	private CategoriaDAO ctl;
	private List<Categoria> categorias = new ArrayList<>();
	private String[] colunas = { "ID", "Descricao"};
	private final int col_id = 0;
	private final int col_desc = 1;

	// CONSTRUTOR TABELA DE PRODUTOS
	public TableCateModel() {
		// INSTANCIA A CONEXAO COM BANCO DE DADOS
		ctl = new CategoriaDAO();
		categorias = ctl.listar();
	}

	public List<Categoria> getLinhas() {
		return categorias;
	}

	public void setLinhas(List<Categoria> dados) {
		categorias = dados;
	}

	@Override
	public String getColumnName(int column) {
		// Retorna o nome da coluna de acordo com seu indice
		return colunas[column];
	}

	@Override
	public int getColumnCount() {
		// Retorna o total de colunas da tabela
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// Retorna o total de linhas da tabela
		return categorias.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Preencher cada c�lula da tabela com seu valor correspondente

		switch (columnIndex) {
		case col_id:

			return categorias.get(rowIndex).getIdCate();

		case col_desc:
			return categorias.get(rowIndex).getDescCate();
			
		}

		return null;
	}

}
