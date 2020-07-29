package br.com.leonardo.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.leonardo.dao.CategoriaDAO;
import br.com.leonardo.dao.ProdutoDAO;

public class TableProdModel extends AbstractTableModel {

	private ProdutoDAO ctl;
	private CategoriaDAO ctlCategoria = new CategoriaDAO();
	private List<Produto> produtos = new ArrayList<>();
	private String[] colunas = { "ID", "Descricao", "Preco", "Quantidade", "Categoria" };
	private final int col_id = 0;
	private final int col_desc = 1;
	private final int col_preco = 2;
	private final int col_qtd = 3;
	private final int col_categoria = 4;

	// CONSTRUTOR TABELA DE PRODUTOS
	public TableProdModel() {
		// INSTANCIA A CONEXAO COM BANCO DE DADOS
		ctl = new ProdutoDAO();
		produtos = ctl.listar();
	}

	public List<Produto> getLinhas() {
		return produtos;
	}

	public void setLinhas(List<Produto> dados) {
		produtos = dados;
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
		return produtos.size();
	} 

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Preencher cada c�lula da tabela com seu valor correspondente

		switch (columnIndex) {
		case col_id:

			return produtos.get(rowIndex).getIdProd();

		case col_desc:
			return produtos.get(rowIndex).getDescProd();

		case col_preco:

			return produtos.get(rowIndex).getPrecoProd();

		case col_qtd:

			return produtos.get(rowIndex).getQtdProd();
		
		case col_categoria:
			return ctlCategoria.lista(produtos.get(rowIndex).getIdCateProd()).getDescCate();
		}

		return null;
	}

}
