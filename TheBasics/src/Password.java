import javax.swing.JOptionPane;


public class Password {
public static void main(String[] args) {
	String secret;
	secret=JOptionPane.showInputDialog(null, "telh meh yo secretsssssssss");
	String password;
	password="TestingTesting123";
	String guess;
	guess=JOptionPane.showInputDialog(null, "Psssst...what's the password?");
    if (guess.equals(password)){
		JOptionPane.showMessageDialog(null, secret);
		
    	
    }
    else{
		JOptionPane.showMessageDialog(null,"SCRAM LOSER!!!!!");

    }
}
}
