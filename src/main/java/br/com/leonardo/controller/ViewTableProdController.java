package br.com.leonardo.controller;

import javax.swing.JButton;

public class ViewTableProdController {

	public static void bloqueiaBotoes(JButton b1, JButton b2, boolean bloqueia) {
		if(bloqueia) {			
			if(b1 != null) b1.setEnabled(!bloqueia);
			if(b2 != null) b2.setEnabled(!bloqueia);
		}else {
			if(b1 != null) b1.setEnabled(!bloqueia);
			if(b2 != null) b2.setEnabled(!bloqueia);
		}
	}
	
}
