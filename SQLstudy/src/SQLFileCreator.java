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
		newFile = new File(path);

		try {

			fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
					path, true)), true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String path;
	private PrintWriter fileWriter;
	private File newFile;
	private int Id;

	public void createFile() {

		try {
			
			newFile.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addCountry(String data) {

		if (newFile.length() == 0) {

			fileWriter.println("INSERT INTO currency values");
			fileWriter.print("(" + Id + "," + "'" + data + "'");

		} else {

			Id++;
			fileWriter.print("," + "(" + Id + "," + "'" + data + "'");

		}

	}

	public void addCode(String data) {

		fileWriter.println("," + "'" + data + "'" + ")");

	}

	public void MyClose() {

		fileWriter.close();
	}

}
