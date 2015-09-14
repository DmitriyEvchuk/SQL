public class MyParser {

	public MyParser(SQLFileCreator ex) {
		execut = ex;
	}

	SQLFileCreator execut;

	public void parse(String forParse) {

		String control = "";
		String data = "";
		Boolean tegNameBegin = false;
		int counterTd = 0;

		for (int i = 0; i < forParse.length(); i++) {

			char buf = forParse.charAt(i);

			if (buf == '<') {
				tegNameBegin = true;
				control = "";

			}

			if (tegNameBegin) {

				control = control + buf;

			}

			if (control.equals("<td>")) {

				if (buf != '>')
					data = data + buf;
			}

			if (buf == '>') {
				tegNameBegin = false;
			}

			if (control.equals("</td>")) {
				counterTd++;

				if (counterTd == 1)
					execut.addCountry(data);

				if (counterTd == 4) {
					execut.addCode(data);

					counterTd = 0;
				}
				control = "";
				data = "";

			}

		}// for

	}

}
