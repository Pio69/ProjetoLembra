package br.com.leonardo.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.com.leonardo.dao.CategoriaDAO;

public class ComboBoxCategoriaModel extends AbstractListModel implements ComboBoxModel {

	private List<Categoria> categorias = new ArrayList<>();
	private Categoria categoria;
	private CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public ComboBoxCategoriaModel() {
		this.categorias = categoriaDAO.listar(); 
	}

	@Override
	public Object getElementAt(int index) {
		//Retorna o elemento do index que retorna a lista (Linha Selecionada)
		return this.categorias.get(index);
	}

	@Override
	public int getSize() {
		//Retorna a quantia de elementos no comboBox
		return this.categorias.size();
	}

	@Override
	public Object getSelectedItem() {
		//Retorna o item selecionado
		if(categorias.isEmpty()) {
			return null;
		} else {
			return this.categoria;
		}
	}

	@Override
	public void setSelectedItem(Object comboBox) {
		//Informa o item selecionado
		if (comboBox instanceof Categoria) {
			this.categoria = (Categoria) comboBox;
		}
		
		//Atualiza o comboBox
		fireContentsChanged(this.categorias, 0, this.categorias.size());
	}

}
