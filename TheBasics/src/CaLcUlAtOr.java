import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CaLcUlAtOr implements ActionListener {
	JLabel display = new JLabel();
	JButton clear = new JButton("Clear");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton zero = new JButton("0");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton multiply = new JButton("x");
	JButton divide = new JButton("/");
	JButton dot = new JButton(".");
	JButton equals = new JButton("=");
	boolean cleanSlate = true;
	boolean hasDot = false;
	double[] nums;

	public static void main(String[] args) {
		CaLcUlAtOr CaL = new CaLcUlAtOr();
		CaL.setup();
	}

	void setup() {

		Dimension Bsize = new Dimension(80, 60);

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 600);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setPreferredSize(new Dimension(500, 600));

		JPanel dizplay = new JPanel();
		panel.add(dizplay);
		dizplay.setPreferredSize(new Dimension(480, 180));

		JPanel numberz = new JPanel();
		panel.add(numberz);
		numberz.setPreferredSize(new Dimension(300, 300));

		JPanel mathz = new JPanel();
		panel.add(mathz);
		mathz.setPreferredSize(new Dimension(130, 300));

		display.setPreferredSize(new Dimension(480, 50));
		display.setText(" 0.0");
		Font font = new Font("Copperplate Gothic Bold", Font.BOLD, 50);
		display.setFont(font);
		dizplay.add(display);
		clear.setPreferredSize(new Dimension(400, 70));
		clear.setFont(font);
		dizplay.add(clear);
		clear.addActionListener(this);
		one.setPreferredSize(Bsize);
		one.setFont(font);
		numberz.add(one);
		one.addActionListener(this);
		two.setPreferredSize(Bsize);
		two.setFont(font);
		numberz.add(two);
		two.addActionListener(this);
		three.setPreferredSize(Bsize);
		three.setFont(font);
		numberz.add(three);
		three.addActionListener(this);
		four.setPreferredSize(Bsize);
		four.setFont(font);
		numberz.add(four);
		four.addActionListener(this);
		five.setPreferredSize(Bsize);
		five.setFont(font);
		numberz.add(five);
		five.addActionListener(this);
		six.setPreferredSize(Bsize);
		six.setFont(font);
		numberz.add(six);
		six.addActionListener(this);
		seven.setPreferredSize(Bsize);
		seven.setFont(font);
		numberz.add(seven);
		seven.addActionListener(this);
		eight.setPreferredSize(Bsize);
		eight.setFont(font);
		numberz.add(eight);
		eight.addActionListener(this);
		nine.setPreferredSize(Bsize);
		nine.setFont(font);
		numberz.add(nine);
		nine.addActionListener(this);
		zero.setPreferredSize(Bsize);
		zero.setFont(font);
		numberz.add(zero);
		zero.addActionListener(this);
		plus.setPreferredSize(Bsize);
		plus.setFont(font);
		mathz.add(plus);
		plus.addActionListener(this);
		minus.setPreferredSize(Bsize);
		minus.setFont(font);
		mathz.add(minus);
		minus.addActionListener(this);
		multiply.setPreferredSize(Bsize);
		multiply.setFont(font);
		mathz.add(multiply);
		multiply.addActionListener(this);
		divide.setPreferredSize(Bsize);
		divide.setFont(font);
		mathz.add(divide);
		divide.addActionListener(this);
		dot.setPreferredSize(Bsize);
		dot.setFont(font);
		numberz.add(dot);
		dot.addActionListener(this);
		equals.setPreferredSize(Bsize);
		equals.setFont(font);
		numberz.add(equals);
		equals.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();

		if (cleanSlate == true) {
			display.setText("");
			cleanSlate = false;
		}

		if (pressed == clear) {
			display.setText("0.0");
			System.out.println("...");
			cleanSlate = true;
			hasDot = false;

		}
		if (pressed == one) {
			display.setText(display.getText() + "1");

			System.out.println("1");
		}
		if (pressed == two) {
			display.setText(display.getText() + "2");
		}
		if (pressed == three) {
			display.setText(display.getText() + "3");
		}
		if (pressed == four) {
			display.setText(display.getText() + "4");
		}
		if (pressed == five) {
			display.setText(display.getText() + "5");
		}
		if (pressed == six) {
			display.setText(display.getText() + "6");
		}
		if (pressed == seven) {
			display.setText(display.getText() + "7");
		}
		if (pressed == eight) {
			display.setText(display.getText() + "8");
		}
		if (pressed == nine) {
			display.setText(display.getText() + "9");
		}
		if (pressed == zero) {
			display.setText(display.getText() + "0");
		}
		if (pressed == plus) {
			checkOperator();

			display.setText(display.getText() + "+");
		}
		if (pressed == minus) {
			checkOperator();

			display.setText(display.getText() + "-");
		}
		if (pressed == multiply) {
			checkOperator();

			display.setText(display.getText() + "x");
		}
		if (pressed == divide) {
			checkOperator();
			display.setText(display.getText() + "/");
		}

		if (pressed == equals) {
		display.setText("11+11-11x11/11");
			String inputs = display.getText();
			System.out.println(inputs);
			String[] inpt = inputs.split("[+-/x]");
			System.out.println(inpt.length);
			nums = new double[inpt.length];
			for (int i = 0; i < inpt.length; i++) {
				System.out.println(inpt[i]);
				nums[i] = Double.parseDouble(inpt[i]);
			}
			double outpt = 0;
			for (int i = 0; i < nums.length; i++) {
				outpt += nums[i];
			}
			display.setText(outpt + "");
		}

		if (pressed == dot && hasDot == false) {

			if (cleanSlate == true) {
				display.setText(display.getText() + "0");

			}
			display.setText(display.getText() + ".");
			hasDot = true;
		}
	}

	
	
	void checkOperator() {
		String dispTxt = display.getText();
		char last = dispTxt.charAt(dispTxt.length() - 1);
		dispTxt = dispTxt.substring(0, dispTxt.length() - 1);
		if (last == '+' || last == '-' || last == 'x' || last == '/') {
			display.setText(dispTxt);
			// Remove last letter

		}

	}
}
