package br.com.leonardo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataBase {

	private static DataBase db;
	private Connection con;
	
	
	//CRIA E EXECUTA A CONEXAO COM O BANCO E PASSA COMO PARAMETRO O LOGIN E A SENHA DO USUARIO
	//QUE ESTA LOGANDO NO SISTEMA PARA ASSIM TER UM MELHOR CONTROLE DE PERMISSAO NO BD
	private DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/lembra?user=root&useSSL=false&password=");

		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao conectar-se","Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//INSTANCIA A CONEXAO DO BD
	public static DataBase getInstance() {

		if (db == null) {
			db = new DataBase();
		}

		return db;
	}

	public Connection getConnection() {
		return con;
	}
	
}
