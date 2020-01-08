
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 1;
		while(number  < 100 ){
			if (number % 3 == 0 && number  %5 !=0) { 
				System.out.println("Fizz");
			}
			if (number % 5 == 0 && number %3 !=0){
				System.out.println("Buzz");
			}
			if (number % 3 == 0 && number % 5 ==0){ 
				System.out.println("Fizzbuzz");
			}
			if (number %  3 != 0 && number %5  != 0) {
				System.out.println(number);
			}
			 number++;

	}
	
	}
}
