package br.com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.leonardo.connection.DataBase;
import br.com.leonardo.model.Categoria;
import br.com.leonardo.model.Produto;

public class CategoriaDAO {

	private Connection con;	

	public CategoriaDAO( ) {
		con = DataBase.getInstance().getConnection();
	}

	// METEDO CRIADO PARA INSERIR PRODUTOS NA TABELA PRODUTO NO BD
	public boolean inserir(Categoria cat) {

		boolean valida = false;
		
		try {

			String sql = "INSERT INTO categoria (descCategoria) VALUES (?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cat.getDescCate());

			ps.executeUpdate();
			
			valida = true;

			JOptionPane.showMessageDialog(null, "Categoria Cadastrada com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar os dados!");
			valida = false;
		}
		
		return valida;
	}	
	
	public boolean editar(Categoria cat) {

		boolean valida = false;
		
		try {

			String sql = "Update categoria set descCategoria = ? where idCategoria = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cat.getDescCate());
			ps.setInt(2, cat.getIdCate());

			ps.executeUpdate();
			
			valida = true;

			JOptionPane.showMessageDialog(null, "Categoria Cadastrada com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar os dados!");
			valida = false;
		}
		
		return valida;
	}
	
	public Categoria lista(int idCat) {

		Categoria categoria = null;
		
		try {
			String sql = "SELECT * FROM categoria where idCategoria = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, idCat);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				categoria = new Categoria();

				categoria.setIdCate(idCat);
				categoria.setDescCate(rs.getString("descCategoria"));

				
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao listar categorias cadastradas!");
		}
		
		return categoria;
		
	}
	
	public List<Categoria> listar() {

		List<Categoria> categorias = new ArrayList<>();

		try {
			String sql = "SELECT * FROM categoria";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria();

				categoria.setIdCate(rs.getInt("idCategoria"));
				categoria.setDescCate(rs.getString("descCategoria"));
				
				categorias.add(categoria);
				
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao listar categorias cadastrados!");
		}
		
		return categorias;
		
	}
	
	public void deletar(int idCate) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from categoria where idCategoria = ?");
			
			ps.setInt(1, idCate);
			
			System.out.println(ps.toString());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao deletar categoria cadastrada!");
			e.printStackTrace();
		}
		
	}
	
}
