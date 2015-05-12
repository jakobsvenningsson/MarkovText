import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import java.util.ArrayList;

public class TextGenerator {
	private JFrame frame;
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
    private JTextArea textArea;
    private ArrayList<String> wordlist = new ArrayList<String>();
	public TextGenerator(){
		setUpGUI();
	}
	
	private void openFile(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files only", "txt");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == fileChooser.APPROVE_OPTION){
			File currentFile = fileChooser.getSelectedFile();
			wordlist = TextFileManager.readFile(currentFile,wordlist);
			for(String s:wordlist){
				textArea.append(s + " ");
			}
			}
		}
	
	private void saveFile(){
		int returnVal = fileChooser.showSaveDialog(null);
		if(returnVal == fileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			String text = textArea.getText();
			System.out.println(text);
			String returnstrung = TextFileManager.saveFile(path, text);
		}
	}
	
	private void setUpGUI(){
		frame = new JFrame("textgenerator");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		textArea = new JTextArea("textarea");
		textArea.setColumns(20);
		textArea.setRows(10);
		textArea.setLineWrap(true);

		contentPane.add(textArea,BorderLayout.CENTER);
		
		
		JPanel toolBar = new JPanel();
		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){openFile();}
			
		});
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){saveFile();}
		});

		
		toolBar.add(importButton);
		toolBar.add(saveButton);
		contentPane.add(toolBar,BorderLayout.SOUTH);
		
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
