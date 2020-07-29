package br.com.leonardo.controller;

import java.math.BigDecimal;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.com.leonardo.dao.CategoriaDAO;
import br.com.leonardo.model.Categoria;

public class CategoriaController {

	public void cadastrarCategoria(JTextField descCate) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria cate = new Categoria();
		
		cate.setDescCate(descCate.getText());
		
		categoriaDAO.inserir(cate);
	}
	
	public void editarCategoria(Integer idCate,JTextField descCate) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria cate = new Categoria();
		
		cate.setIdCate(idCate);
		cate.setDescCate(descCate.getText());
		
		categoriaDAO.editar(cate);
	}
	
	public void deletarCategoria(Integer idCate) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.deletar(idCate);
	}
	
}
