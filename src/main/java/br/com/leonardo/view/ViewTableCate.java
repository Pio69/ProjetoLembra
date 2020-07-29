package br.com.leonardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.leonardo.controller.CategoriaController;
import br.com.leonardo.controller.ProdutoController;
import br.com.leonardo.controller.ViewTableProdController;
import br.com.leonardo.model.TableCateModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ViewTableCate extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JButton btnDeletar;
	private JButton btnEditar;
	private JButton btnCadastrar;

	public ViewTableCate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 764, 482);
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
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		TableCateModel tableCateModel = new TableCateModel();
		table.setModel(tableCateModel);
		
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
		
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPrincipal frame = new ViewPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(264, 521, 120, 35);
		contentPane.add(btnVoltar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					CategoriaController cateController = new CategoriaController();
					cateController.deletarCategoria(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));;
					TableCateModel tableCateModel = new TableCateModel();
					table.setModel(tableCateModel);
				}
			}
		});
		btnDeletar.setBounds(394, 521, 120, 35);
		contentPane.add(btnDeletar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					ViewCate frame = new ViewCate(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnEditar.setBounds(524, 521, 120, 35);
		contentPane.add(btnEditar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCate frame = new ViewCate(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(654, 521, 120, 35);
		contentPane.add(btnCadastrar);
		
		ViewTableProdController.bloqueiaBotoes(btnEditar, btnDeletar, true);
	}
}
