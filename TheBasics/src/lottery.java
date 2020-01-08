import javax.swing.JOptionPane;


public class lottery {
public static void main(String[] args) {
	String numberz = "";
	for(int i = 0;i<5;i++){
		String input;

		input=JOptionPane.showInputDialog(null, "2 digity digety numberz plz");
		numberz += input+" ";
	}	
	System.out.println("YoUr LoTtErY nUmBeRz R: "+numberz);
	
}
}
