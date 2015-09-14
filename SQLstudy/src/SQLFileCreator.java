import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class SQLFileCreator {

	SQLFileCreator(String path) {

		this.path = path;

		try {
			
			fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
					path, true)), true);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String path;
	PrintWriter fileWriter;
	int Id;

	public void addCountry(String data) {

		File newFile = new File(path);

		try {
			newFile.delete();
			newFile.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (newFile.length() == 0){
			fileWriter.println("INSERT INTO currency values");
			fileWriter.print("("+Id+","+"'"+data+"'");
			//Id++;
		}
		else{
			Id++;
			fileWriter.print(","+"("+Id+","+"'"+data+"'");
			
		}

		
		
	}
	
	public void addCode(String data) {
		
		fileWriter.println(","+"'"+data+"'"+")");
		
		}
	
	public void MyClose(){
		
		fileWriter.close();
	}
	
	
	
	
	

}
