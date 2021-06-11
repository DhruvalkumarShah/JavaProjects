package temp.java;
import java.io.File;
import java.io.IOException;
public class ListOfFile {
	public static void main(String args[]) throws IOException {
		File directoryPath=new File("D:");
		int file=0,directory=0;
		File[] contents=directoryPath.listFiles();
		for(int i=0;i<contents.length;i++) {
			if(contents[i].isFile()) file++;
			else directory++;
		}
		System.out.println("The number of files are : "+file);
		System.out.println("The number of Directorys are : "+directory);
	}
}
