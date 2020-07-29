package br.com.leonardo.controller;

import java.math.BigDecimal;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.leonardo.dao.ProdutoDAO;
import br.com.leonardo.model.Categoria;
import br.com.leonardo.model.Produto;

public class ProdutoController {

	public void cadastrarProduto(JTextField descProd, JTextField precoProd, JSpinner qtd, JComboBox categoria) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto prod = new Produto();
		
		prod.setDescProd(descProd.getText());
		prod.setPrecoProd(new BigDecimal(precoProd.getText()));
		prod.setQtdProd(Integer.parseInt(qtd.getValue().toString()));
		prod.setIdCateProd(((Categoria) (categoria.getSelectedItem())).getIdCate());
		
		produtoDAO.inserir(prod);
	}
	
	public void editarProduto(Integer idProd,JTextField descProd, JTextField precoProd, JSpinner qtd, JComboBox categoria) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto prod = new Produto();
		
		prod.setIdProd(idProd);
		prod.setDescProd(descProd.getText());
		prod.setPrecoProd(new BigDecimal(precoProd.getText()));
		prod.setQtdProd(Integer.parseInt(qtd.getValue().toString()));
		prod.setIdCateProd(((Categoria) (categoria.getSelectedItem())).getIdCate());
		
		produtoDAO.editar(prod, idProd);
	}
	
	public void deletarProduto(Integer idProd) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.deletar(idProd);
	}
	
}
