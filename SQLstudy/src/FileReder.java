import java.io.*;

;

public class FileReder {

	private String resultStr;

	public String getResult() {

		return resultStr;

	}

	public void readFile(String path) {

		try {
			BufferedReader read = new BufferedReader(new FileReader(path));

			String buf = "";
			while ((buf = read.readLine()) != null) {

				if (buf != null)
					resultStr = resultStr + buf;

			}
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		FileReder read = new FileReder();
		MySqlExecute my = new MySqlExecute();
		MyParser parse = new MyParser(my);

		read.readFile("E:\\work\\ccy1.txt");
		parse.parse(read.getResult());
		my.showData();
	}

}
