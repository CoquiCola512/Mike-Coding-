
public class Variables {
	int dogs = 0;
	static int fish = 12;
	public static void main(String[] args) {
		Variables v = new Variables();
		v.printName();
		String msg = "Wreaths Across America";
		System.out.println(msg);
		int cats = 2;
		System.out.println("I have " + cats + " cats");
		int five = v.givesFive();
		System.out.println(five);
		System.out.println(five + cats);
		System.out.println(v.dogs);
		v.addThree();
		System.out.println(v.dogs);
		System.out.println("fishy fishes");
		System.out.println(fish);
		timesFishByTwo();
		System.out.println(fish);
	}
	public void printName() {
		System.out.println("Vesper");
	}
	
	public int givesFive() {
		return 5;
	}
	
	public void addThree() {
		dogs = dogs + 3;
	}
	
	public static void timesFishByTwo() {
		fish = fish * 2;
	}
	
}

