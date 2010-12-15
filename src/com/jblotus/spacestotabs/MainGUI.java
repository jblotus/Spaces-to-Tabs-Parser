package com.jblotus.spacestotabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		frame.setTitle("SpacesToTabsParser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add in the menu
		JMenuBar menuBar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		final JMenuItem open = new JMenuItem("Open");	
		

		
		filemenu.add(open);
		menuBar.add(filemenu);
		//add the menu bar
		frame.add(BorderLayout.NORTH, menuBar);
		
		//two panels to diff results
		JTextArea originalFile = new JTextArea("original");
		JTextArea newFile = new JTextArea("new");
		frame.add(BorderLayout.CENTER, originalFile);
		frame.add(BorderLayout.EAST, newFile);
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
			    
				int returnVal = fc.showOpenDialog(open);
				 if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            System.out.println(file.getName());
			            
			            //now we need to parse the file
			            FileParser fp = new FileParser();
			            StringBuffer newFileContent = FileParser.parse(file);
			            System.out.println(newFileContent);
			        } else {
			        	System.out.println("error");
			        }
			}
		});		
		frame.setVisible(true);
	}

}
