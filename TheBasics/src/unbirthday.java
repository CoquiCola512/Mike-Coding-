import javax.swing.JOptionPane;


public class unbirthday {
	public static void main(String[] args) {
		String input;
		input=JOptionPane.showInputDialog(null, "When's your birthday?");
	    if (input.equals("3/20")){
			JOptionPane.showMessageDialog(null, "Happy Birthday!!!! (owo)");

		} 
	    else{
			JOptionPane.showMessageDialog(null, "Have a very merry Unbirthday!!!! (owo)");

		}
	}

}
