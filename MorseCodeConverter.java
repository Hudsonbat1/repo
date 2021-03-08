import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	
	public static String printTree() {
		
		String str = "";
		ArrayList<String> list = new ArrayList<>();
		list = tree.toArrayList();
		
		for(String i : list) {
			str += i + " ";
		}
		
		return str;
	}
	
	public static String convertToEnglish(String code) {
		String str = "";
		int index = 0;
		String [] code2 = code.split(" "); 
		
		while(index < code2.length) {
			str += tree.fetch(code2[index]);
			index++;
		}
		
		return str;
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String [] str = null;
		int index = 0;
		Scanner scan = new Scanner(codeFile);
		
		while(scan.hasNext()) {
			str = scan.nextLine().split(" ");
		}
		
		String str2 = "";
		
		while(index < str.length) {
			str2 += tree.fetch(str[index]);
			index++;
		}
		
		scan.close();
		
		return str2;
	}

}
