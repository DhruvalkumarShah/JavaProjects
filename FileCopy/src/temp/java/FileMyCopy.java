package temp.java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileMyCopy {
	public static void main(String args[]) {
		if(args.length>=2) {
			System.out.println("File copying started.");
			try {
				BufferedReader myReader=new BufferedReader(new FileReader(args[0]));
				BufferedWriter myWriter=new BufferedWriter(new FileWriter(args[1]));
				//Creating an object of the String as line so as to read the myReader file line by line.
				String line;
				//Iterating through the file.
				while((line=myReader.readLine())!=null) {
					//Writing the file line by line.
					myWriter.write(line);
				}
				myReader.close();
				myWriter.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("File copying cannot take place.");
		}
	}
}
