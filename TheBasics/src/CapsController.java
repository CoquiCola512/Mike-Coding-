import java.util.Random;

import javax.swing.JOptionPane;

public class CapsController {
	public static void main(String[] args) {
		String wORDgIVEN;
		wORDgIVEN = JOptionPane
				.showInputDialog(null, "Plz givh meh 2 words...");
		System.out.println(wORDgIVEN.toUpperCase());
		System.out.println(wORDgIVEN.toLowerCase());
		String fIRSTwORD;
		fIRSTwORD = wORDgIVEN.split(" ")[0];
		String sECONDwORD;
		sECONDwORD = wORDgIVEN.split(" ")[1];
		System.out.println(fIRSTwORD.toLowerCase());
		System.out.println(sECONDwORD.toUpperCase());
		String fIRSTlETTER;
		fIRSTlETTER = wORDgIVEN.substring(0, 1);
		String sECONDlETTER;
		sECONDlETTER = wORDgIVEN.substring(1, 2);
		System.out.println(fIRSTlETTER);
		System.out.println(sECONDlETTER);

		String nEWwORD = ("");
		for (int i = 0; i < wORDgIVEN.length(); i++) {
			Random gen = new Random();
			int num = gen.nextInt(2);
			if (num == 0) {
				nEWwORD += wORDgIVEN.substring(i,i+1).toUpperCase();
			}
			else{
				nEWwORD += wORDgIVEN.substring(i,i+1).toLowerCase();
			}

		}
		System.out.println(nEWwORD);
	}
	
}

