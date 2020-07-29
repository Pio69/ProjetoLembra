package br.com.leonardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.leonardo.controller.CategoriaController;
import br.com.leonardo.dao.CategoriaDAO;
import br.com.leonardo.model.Categoria;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ViewCate extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;

	public ViewCate(Integer idCate) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(342, 11, 104, 20);
		contentPane.add(lblNewLabel);
		
		txtDesc = new JTextField();
		txtDesc.setBorder(new LineBorder(Color.BLACK));
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDesc.setBounds(10, 65, 380, 30);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 34, 120, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnPrinci = new JButton("...");
		btnPrinci.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPrinci.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPrinci.setBackground(Color.WHITE);
		btnPrinci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idCate != null) {
					CategoriaController categoriaController = new CategoriaController();
					categoriaController.editarCategoria(idCate, txtDesc);
				}else {
					CategoriaController categoriaController = new CategoriaController();
					categoriaController.cadastrarCategoria(txtDesc);
				}				
				
				ViewTableCate frame = new ViewTableCate();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPrinci.setBounds(649, 415, 125, 35);
		contentPane.add(btnPrinci);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewTableCate frame = new ViewTableCate();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(514, 415, 125, 35);
		contentPane.add(btnVoltar);
		
		if(idCate != null) {
			btnPrinci.setText("Editar");
			
			CategoriaDAO cateDAO = new CategoriaDAO();
			Categoria categoria = cateDAO.lista(idCate);
			
			txtDesc.setText(categoria.getDescCate());
			
		}else {
			btnPrinci.setText("Cadastrar");
		}
		
	}
}
