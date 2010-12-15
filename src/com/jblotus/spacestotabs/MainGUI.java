package com.jblotus.spacestotabs;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainGUI extends JPanel {	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create gui with file menu
		buildGUI();
	}

	private static void buildGUI() {
		//load frame
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		
		//add in the menu
		JMenuBar menuBar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");	
		
		filemenu.add(open);
		menuBar.add(filemenu);
		//add the menu bar
		frame.add(BorderLayout.NORTH, menuBar);
		frame.setVisible(true);
	}

}
