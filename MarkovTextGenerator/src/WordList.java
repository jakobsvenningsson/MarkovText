import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Random;
public class WordList {
	HashMap<String,LinkedList<String>> corpus = new HashMap<String,LinkedList<String>>();
	LinkedList<String> words = new LinkedList<String>();


	public WordList(){
		String sentence = "1 And Adam knew * Eve his wife; and she conceived , and bare * Cain, and said ,"
				+ " I have gotten a man from the LORD. 2 And she again bare his brother Abel. And Abel was a"
				+ " keeper of sheep, but Cain was a tiller of the ground. 3 And in process of time it came to pass,"
				+ " that Cain brought of the fruit of the ground an offering unto the LORD. 4 And Abel, he also brought"
				+ " of the firstlings of his flock and of the fat thereof. And the LORD had respect unto Abel and to his "
				+ "offering: 5 But unto Cain and to his offering he had not respect . And Cain was very wroth , and his "
				+ "countenance fell . 6 And the LORD said unto Cain, Why art thou wroth ? and why is thy countenance fallen"
				+ " ? 7 If thou doest well , shalt thou not be accepted? and if thou doest not well , sin lieth at the door."
				+ " And unto thee shall be his desire, and thou shalt rule over him. 8 And Cain talked with Abel his brother: "
				+ "and it came to pass, when they were in the field, that Cain rose up against Abel his brother, and slew him "
				+ ". 9 And the LORD said unto Cain, Where is Abel thy brother? And he said , I know not: Am I my brother's keeper"
				+ " ? 10 And he said , What hast thou done ? the voice of thy brother's blood crieth unto me from the ground. 11"
				+ " And now art thou cursed from the earth, which hath opened her mouth to receive thy brother's blood from thy "
				+ "hand; 12 When thou tillest the ground, it shall not henceforth yield unto thee her strength; a fugitive and a"
				+ " vagabond shalt thou be in the earth. 13 And Cain said unto the LORD, My punishment is greater than I can bear ."
				+ " 14 Behold, thou hast driven me out this day from the face of the earth; and from thy face shall I be hid ; and I "
				+ "shall be a fugitive and a vagabond in the earth; and it shall come to pass , that every one that findeth me shall slay me . "
				+ "15 And the LORD said unto him, Therefore whosoever slayeth Cain, vengeance shall be taken on him sevenfold. And the LORD set "
				+ "a mark upon Cain, lest any finding him should kill him. 16 And Cain went out from the presence of the LORD, and dwelt in the land "
				+ "of Nod, on the east of Eden. 17 And Cain knew his wife; and she conceived , and bare Enoch: and he builded a city, and called the "
				+ "name of the city, after the name of his son, Enoch. 18 And unto Enoch was born Irad: and Irad begat Mehujael: and Mehujael begat Methusael:"
				+ "   A light wind whips at him as he adjusts several valves on a "
              +"large battered moisture vaporator which sticks out of the "
               +"desert floor much like an oil pipe with valves. He is aided "
               +"appears to be barely functioning and moves with jerky motions.  "
               +"A bright sparkle in the morning sky catches Luke's eye and "
               +"he instinctively grabs a pair of electrobinoculars from his "
               +"utility belt. He stands transfixed for a few moments studying "
               +"the heavens, then dashed toward his dented, crudely repaired "
               +"Landspeeder (an auto-like transport that travels a few feet "
               +"above the ground on a magnetic-field). He motions for the "
               +"tiny robot to follow him.";
		StringTokenizer token = new StringTokenizer(sentence," ");
		while(token.hasMoreTokens()){
			words.add(token.nextToken());
		}
	
	}
	
	
	public void createCorpus(){
		for(int i=0;i<words.size()-1;i++){
			if(!corpus.containsKey(words.get(i))){
				corpus.put(words.get(i),new LinkedList<String>());
			}
			
           corpus.get(words.get(i)).add(words.get(i+1));
		}
		//for(String s:words){
		//System.out.println(s + "-" + corpus.get(s));
		//}
	}
	
	public void generate(){
		Random rand = new Random();
		String current = "electrobinoculars";
		for(int k=0;k<10;k++){
		for(int i=0;i<10;i++){
			System.out.print(current+" ");
			String n = current;
			int length= corpus.get(n).size();
			current = corpus.get(n).get(rand.nextInt(length));
		}
		System.out.println("\n");
		}
	}
	
	public static void main(String []args){
		WordList list = new WordList();
		list.createCorpus();
		list.generate();
		
	}

}