public class SuperLoop {

	public static void main(String[] args) {
		System.out.println("First Loop");
		for (int i = 0; i < 101; i++) {
			System.out.println(i);
		}
		System.out.println("Second Loop");
		for (int i = 101; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("Third Loop");
		for (int i = 0; i < 101; i = i + 2) {
			System.out.println(i);
		}
		System.out.println("Fourth Loop");
		for (int i = 1; i < 101; i = i + 2) {
			System.out.println(i);
		}
		System.out.println("Fifth Loop");
		for (int i = 100; i < 201; i = i + 5) {
			System.out.println(i);
		}
		System.out.println("Sixth Loop");
		for (int i = 0; i < 10; i = i + 1) {
			for (int pi = 0; pi < 3; pi = pi + 1) {
				System.out.println(i + " " + pi);
			}
		}
		System.out.println("Seventh Loop");
		for (int i = 0; i < 91; i = i + 10) {
			for (int pi = 1; pi < 11; pi = pi + 1) {
				System.out.print(i + pi + " ");
			}
			System.out.println();
		}

		System.out.println("eighth Loop");
		for (int i = 1; i < 6; i = i + 1) {
			System.out.print(i);
			for (int pi = 1; pi < i + 1; pi = pi + 1) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println("ninth Loop");
		for (int i = 5; i > 0; i = i + -1) {
			System.out.print(i);
			for (int pi = 1; pi < i + 1; pi = pi + 1) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		String x = "";
		while (x.length()< 26 ) {
			System.out.println(x);
			x += " OwO ";
		}
		for (String line = ""; line.length() < 26; line += " OwO "){
			System.out.println(line);
		}
	}
}
