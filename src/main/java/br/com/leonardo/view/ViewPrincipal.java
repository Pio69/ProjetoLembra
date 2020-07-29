package br.com.leonardo.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 85, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(10, 527, 65, 23);
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(82, 0, 502, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Produto");
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBounds(173, 57, 135, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewTableProd frame = new ViewTableProd();
				frame.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.setBackground(Color.WHITE);
		btnCategoria.setBounds(173, 11, 135, 35);
		btnCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTableCate frame = new ViewTableCate();
				frame.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnCategoria);
	}
}
