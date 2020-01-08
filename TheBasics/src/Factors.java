import javax.swing.JOptionPane;


public class Factors {
public static void main(String[] args) {
	String input ;
	input = JOptionPane.showInputDialog(null,"please pick a whole number and tell me the number you pick." );
	int num = Integer.parseInt(input);
	String factors = "";
	for (int i=1; i<=num/2; i++){
		if(num%i==0){
			factors += i+" , ";
		}
	}
	int length = factors.length();
	factors = factors.substring(0, length-2);
	JOptionPane.showMessageDialog(null, "her r ur factuuuuuuuuuuuurs:\n " +factors);

}
}
