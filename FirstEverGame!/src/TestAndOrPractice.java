
public class TestAndOrPractice {

	int practice;
	
	boolean test;
	
	public static void main(String[] print) {
		TestAndOrPractice core = new TestAndOrPractice();
		int[] listOfnum = {17, 4, 12, 1, 1};
		int[] listOfNum2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int[] listOfNum3 = {-1, 2, 3, -4, 5, 6, 7, 8};
		int[] listOfNum4 = {-1, -2, -3, -4, -5};
		int[] listOfNum5 = {2, 2, 2, 2, 2};
		int[] listOfNum6 = {-2, -2, -2, -2, -2};
		int[] listOfNum7 = {0, 0,0, 0, 0};
		int[] listOfNum8 = {0, 5, 0, 5, 0};
		int[] listOfNum9 = {};
		int[] listOfNum10 = {16};

		//core.printStuff();
		//System.out.println(core.giveNum());	
		System.out.println(core.doubleNum(1.5));
		System.out.println(core.sumArray(listOfnum));
		System.out.println(core.sumArray(listOfNum2));
		System.out.println(core.sumArray(listOfNum3));
		System.out.println(core.sumArray(listOfNum4));
		System.out.println(core.sumArray(listOfNum5));
		System.out.println(core.sumArray(listOfNum6));
		System.out.println(core.sumArray(listOfNum7));
		System.out.println(core.sumArray(listOfNum8));
		System.out.println(core.sumArray(listOfNum9));
		System.out.println(core.sumArray(listOfNum10));
	}
	
	int sumArray(int[] list) {
		
		int sum = 0;
		
		for(int i = 0; i < list.length; i ++) {
			sum = sum + list[i];
		
		}
		
		return sum;
		
	}
	
	private void printStuff() {
	
		practice = 10;
		test = false;
		
		if (practice < 7) {
			test = true;
		}
		
		if(test == true) {
		System.out.println("stuff");	
		
		
		}
		
		else{
			System.out.println("thing");	
		}
		
	}
	
	private int giveNum() {
		return 13;
	}
	
	private double doubleNum(double num){	
		return num * 2;
	}
	
}
