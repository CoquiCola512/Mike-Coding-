import java.util.Random;

import javax.swing.JOptionPane;


public class LoTtErY2 {
public static void main(String[] args) {
	String numberz = "";
	Random gen = new Random();
	for(int i = 0;i<5;i++){
		int num = gen.nextInt(100);
		numberz += num+" ";
	}	
	System.out.println("YoUr LoTtErY nUmBeRz R: "+numberz);
	
}
}
