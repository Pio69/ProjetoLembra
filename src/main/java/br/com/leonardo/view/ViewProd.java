package br.com.leonardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.leonardo.controller.ProdutoController;
import br.com.leonardo.dao.CategoriaDAO;
import br.com.leonardo.dao.ProdutoDAO;
import br.com.leonardo.model.Categoria;
import br.com.leonardo.model.ComboBoxCategoriaModel;
import br.com.leonardo.model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewProd extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtPreco;
	private JComboBox cmbCategoria;
	
	private ComboBoxCategoriaModel comboBoxCategoriaModel;

	public ViewProd(Integer idProd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produto");
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
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPreco.setBounds(10, 106, 120, 20);
		contentPane.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBorder(new LineBorder(Color.BLACK));
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPreco.setColumns(10);
		txtPreco.setBounds(10, 137, 200, 30);
		contentPane.add(txtPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQuantidade.setBounds(10, 178, 120, 20);
		contentPane.add(lblQuantidade);
		
		JSpinner spnQtd = new JSpinner();
		spnQtd.setBorder(new LineBorder(new Color(0, 0, 0)));
		spnQtd.setFont(new Font("Arial", Font.PLAIN, 14));
		spnQtd.setBounds(10, 209, 70, 30);
		contentPane.add(spnQtd);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategoria.setBounds(10, 250, 120, 20);
		contentPane.add(lblCategoria);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCategoria.setBorder(new LineBorder(Color.BLACK));
		cmbCategoria.setBackground(Color.WHITE);
		
		comboBoxCategoriaModel = new ComboBoxCategoriaModel();
		cmbCategoria.setModel(comboBoxCategoriaModel);
		
		cmbCategoria.setBounds(10, 281, 200, 30);
		contentPane.add(cmbCategoria);
		
		JButton btnPrinci = new JButton("...");
		btnPrinci.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPrinci.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPrinci.setBackground(Color.WHITE);
		btnPrinci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idProd != null) {
					ProdutoController produtoController = new ProdutoController();
					produtoController.editarProduto(idProd ,txtDesc, txtPreco, spnQtd, cmbCategoria);
				}else {
					ProdutoController produtoController = new ProdutoController();
					produtoController.cadastrarProduto(txtDesc, txtPreco, spnQtd, cmbCategoria);
				}				
				
				ViewTableProd frame = new ViewTableProd();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPrinci.setBounds(639, 414, 135, 35);
		contentPane.add(btnPrinci);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewTableProd frame = new ViewTableProd();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(494, 415, 135, 35);
		contentPane.add(btnVoltar);
		
		if(idProd != null) {
			btnPrinci.setText("Editar");
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto prod = new Produto();
			
			prod = produtoDAO.lista(idProd);
			
			System.out.println(idProd);
			
			txtDesc.setText(prod.getDescProd());
			txtPreco.setText("" + prod.getPrecoProd());
			spnQtd.setValue(prod.getQtdProd());
			
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			Categoria categoria = new Categoria(); 
			
			comboBoxCategoriaModel = new ComboBoxCategoriaModel();
			comboBoxCategoriaModel.setSelectedItem(categoria);
			
			cmbCategoria.setModel(comboBoxCategoriaModel);
			
		}else {
			btnPrinci.setText("Cadastrar");
		}
		
	}
}
