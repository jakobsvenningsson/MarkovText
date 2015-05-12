
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class TextFileManager {
private static String end = ".txt";
public static ArrayList<String> readFile(File textFile,ArrayList<String> wordlist){
		try{
			BufferedReader input = new BufferedReader(new FileReader(textFile));
			String line;
			while((line = input.readLine())!= null){
				StringTokenizer token = new StringTokenizer(line," ");
				while(token.hasMoreTokens()){
					wordlist.add(token.nextToken());
				}
			}
			input.close();
			return wordlist;
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
			return null;
		}
		catch(IOException e){
			System.out.println("Something went wrong");
			return null;
		}
	}

public static String saveFile(String path, String text){
	String isTextFile = path.substring(path.length()-4, path.length());
	if(isTextFile.equals(end)){
		try{
			BufferedWriter output = new BufferedWriter(new FileWriter(path));
			output.write(text);
			output.close();
			}
		catch(IOException e){
			System.out.println("ERROR");
		}
	}
	else{
		System.out.println("not a txt file");
	}
	return text;
	}
	
}


