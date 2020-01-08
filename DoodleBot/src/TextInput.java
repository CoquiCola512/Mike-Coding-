import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TextInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = JOptionPane
				.showInputDialog("Hello, please say something to start this program...");

		writeToFile(input);

	}

	static void writeToFile(String txt) {

		FileWriter fW;
		try {
			fW = new FileWriter("src/InputTxt.txt");
			fW.write(txt);
			fW.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
