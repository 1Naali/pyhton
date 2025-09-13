package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	
	public Window() {
		initialize();
	}
	
	private void initialize() {	
				
		frame = new JFrame();
		frame.setTitle("Aplicativo Organizador");
		frame.getContentPane().setBackground(new Color(62,58,75));
		frame.setSize(
				(int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (), //pega a largura do monitor
	            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight () //pega a altura do monitor
	            );
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();		
		
		button = createButton();
		
		panel.add(button);
		
		
		
		
		
		
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

	private JButton createButton() {
		
		JButton button = new JButton("Print");
		button.setFocusable(false);
		
		button.setMnemonic(KeyEvent.VK_P);
		
		button.setMargin(new Insets(0,0,0,0));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		
		return button;
	}

}
