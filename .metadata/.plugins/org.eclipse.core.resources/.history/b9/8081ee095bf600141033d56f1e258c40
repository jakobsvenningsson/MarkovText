import java.awt.*; 
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import java.io.*;

public class TextFileManager {
	private JFrame frame;
	private File textFile;
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
	public TextFileManager(){
		setUpGUI();
	}
	
	
	private void setUpGUI(){
		frame = new JFrame("filemanager");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel toolBar = new JPanel();
		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){openFile();}
			
		});
		JButton saveButton = new JButton("Save");

		JLabel test = new JLabel("HEJ");
		contentPane.add(test,BorderLayout.NORTH);
		
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

	private void openFile(){
		//FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        //"JPG & GIF Images", "txt", "gif");
		   // fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == fileChooser.APPROVE_OPTION){
			textFile = fileChooser.getSelectedFile();
		
		}
		
		
		
			
		}
	
	public void readFile(){
		try{
			BufferedReader input = new BufferedReader(new FileReader(textFile));
			String s = input.readLine();
			System.out.println(s);
			input.close();
		}
		catch(FileNotFoundException e){System.out.println("File not found");
		}
		catch(IOException e){System.out.println("Something went wrong");
		}
	}
	
	
	
	public static void main(String args[]){
		TextFileManager test = new TextFileManager();
		System.out.println("HEJ");
	}
}


