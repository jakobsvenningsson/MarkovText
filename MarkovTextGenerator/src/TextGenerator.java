import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;

public class TextGenerator {
	private JFrame frame;
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
    
	public TextGenerator(){
		setUpGUI();
	}
	
	private void openFile(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files only", "txt");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == fileChooser.APPROVE_OPTION){
			File currentFile = fileChooser.getSelectedFile();
			String string = TextFileManager.readFile(currentFile);
			System.out.println(string);
		}

	
	
	}
	
	
	private void setUpGUI(){
		frame = new JFrame("textgenerator");
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel toolBar = new JPanel();
		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){openFile();}
			
		});
		JButton saveButton = new JButton("Save");

		
		toolBar.add(importButton);
		toolBar.add(saveButton);
		contentPane.add(toolBar,BorderLayout.WEST);
		
		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);
		JMenu fileMenu = new JMenu("file");
		menu.add(fileMenu);
		
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String args[]){
		new TextGenerator();
	}

}
