package br.com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.leonardo.connection.DataBase;
import br.com.leonardo.model.Produto;

public class ProdutoDAO {

	private Connection con;	

	public ProdutoDAO( ) {
		con = DataBase.getInstance().getConnection();
	}

	// METEDO CRIADO PARA INSERIR PRODUTOS NA TABELA PRODUTO NO BD
	public boolean inserir(Produto prod) {

		boolean valida = false;
		
		try {

			String sql = "INSERT INTO produto (descProd, precoProd, qtdProd, Categoria_idCategoria) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, prod.getDescProd());
			ps.setBigDecimal(2, prod.getPrecoProd());
			ps.setInt(3, prod.getQtdProd());
			ps.setInt(4, prod.getIdCateProd());

			ps.executeUpdate();
			
			valida = true;

			JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar os dados!");
			valida = false;
		}
		
		return valida;
	}	
	
	public boolean editar(Produto prod, int idProd) {

		boolean valida = false;
		
		try {

			String sql = "Update produto set descProd = ?, precoProd = ?, qtdProd = ?, Categoria_idCategoria = ? where idProd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, prod.getDescProd());
			ps.setBigDecimal(2, prod.getPrecoProd());
			ps.setInt(3, prod.getQtdProd());
			ps.setInt(4, prod.getIdCateProd());
			ps.setInt(4, idProd);

			ps.executeUpdate();
			
			valida = true;

			JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao editar os dados!");
			valida = false;
		}
		
		return valida;
	}
	
	public Produto lista(int idProd) {

		Produto produto = null;
		
		try {
			String sql = "SELECT * FROM produto where idProd = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idProd);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				produto = new Produto();
				
				produto.setIdProd(rs.getInt("idProd"));
				produto.setDescProd(rs.getString("descProd"));
				produto.setPrecoProd(rs.getBigDecimal("precoProd"));
				produto.setQtdProd(rs.getInt("qtdProd"));
				produto.setIdCateProd(rs.getInt("Categoria_idCategoria"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao listar produto cadastrado!");
		}
		
		return produto;
		
	}
	
	public List<Produto> listar() {

		List<Produto> prod = new ArrayList<>();

		try {
			String sql = "SELECT * FROM produto";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();
				
				produto.setIdProd(rs.getInt("idProd"));
				produto.setDescProd(rs.getString("descProd"));
				produto.setPrecoProd(rs.getBigDecimal("precoProd"));
				produto.setQtdProd(rs.getInt("qtdProd"));
				produto.setIdCateProd(rs.getInt("Categoria_idCategoria"));

				prod.add(produto);
				
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao listar produtos cadastrados!");
		}
		
		return prod;
		
	}
	
	public void deletar(int idProd) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from produto where idProd = ?");
			
			ps.setInt(1, idProd);
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao deletar produto cadastrado!");
		}
		
	}
	
	
}
