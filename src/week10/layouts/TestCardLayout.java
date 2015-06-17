/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestCardLayout.java
 * 2015年6月17日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package week10.layouts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 实现功能： 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015年6月17日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
 *
 */
public class TestCardLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCardLayout frame = new TestCardLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCardLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		CardLayout clo = new CardLayout(20, 20);
		
		JButton btnNewButton_2 = new JButton("New button3");
		contentPane.add(btnNewButton_2, "name_538535706976120");
		
		JButton btnNewButton_1 = new JButton("New button2");
//		clo.addLayoutComponent(btnNewButton_1, "name_537151261025808");
		contentPane.add(btnNewButton_1, "name_537151261025808");
		
		JButton btnNewButton = new JButton("New button1");
		contentPane.add(btnNewButton, "name_537145652230355");
		
		contentPane.setLayout(clo);
		MouseAdapter madAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clo.next(contentPane);
			}
		};
		
		btnNewButton_2.addMouseListener(madAdapter);
		btnNewButton_1.addMouseListener(madAdapter);
		btnNewButton.addMouseListener(madAdapter);
//		clo.next(contentPane);
	}

}

