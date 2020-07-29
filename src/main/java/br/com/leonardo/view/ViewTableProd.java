package br.com.leonardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.leonardo.controller.ProdutoController;
import br.com.leonardo.controller.ViewTableProdController;
import br.com.leonardo.model.TableProdModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ViewTableProd extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JButton btnDeletar;
	private JButton btnEditar;
	private JButton btnCadastrar;

	public ViewTableProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow() != -1) {
					ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, false);					
				}else {
					ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, true);
				}
			}
		});
		scrollPane.setBounds(10, 11, 764, 482);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, false);					
				}else {
					ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, true);
				}
			}
		});
		
		TableProdModel tableProdModel = new TableProdModel();
		table.setModel(tableProdModel);
		
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPrincipal frame = new ViewPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoltar.setBounds(264, 514, 120, 35);
		contentPane.add(btnVoltar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					ProdutoController prodController = new ProdutoController();
					 prodController.deletarProduto(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
				}
			}
		});
		btnDeletar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeletar.setBounds(394, 515, 120, 35);
		contentPane.add(btnDeletar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					ViewProd frame = new ViewProd(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnEditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEditar.setBounds(524, 515, 120, 35);
		contentPane.add(btnEditar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProd frame = new ViewProd(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCadastrar.setBounds(654, 515, 120, 35);
		contentPane.add(btnCadastrar);
		
		ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, true);
	}
}
