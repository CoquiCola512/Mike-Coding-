import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.JOptionPane;

public class ChangeMachine {
	public static void main(String[] args) {
		Random gen = new Random();
		double cost = gen.nextDouble() * 30;
		NumberFormat fm = new DecimalFormat("#0.00");
		String cash;
		cash = JOptionPane.showInputDialog(null,
				"your total is $" + fm.format(cost)
						+ " how much cash do you have?");
		double cgiven = Double.parseDouble(cash);
		double change = cgiven - cost;
		JOptionPane.showMessageDialog(null,
				"your change is $" + fm.format(change));
		JOptionPane.showMessageDialog(null, "have a nice day! :)");

	}
}
