import java.util.ArrayList;

public class ArrayListPractice {
	
	
	
	public static void main(String[] print) {
	
		ArrayListPractice noMoStatic = new ArrayListPractice();
		noMoStatic.doingThingz();
		
	}
	
	public void doingThingz() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(16);
		list.add(5);
		list.add(12);
		list.add(17);
		list.add(2004);
		list.add(13);
		list.add(2);
	
		
		System.out.println(list.get(2));
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		
		System.out.println("----------");
		
		list.remove(3); 
		
		System.out.println(list.get(2));
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		
		System.out.println("----------");
		
		int sumzItUp = 0;
		for(int i = 0; i < list.size(); i++) {
			sumzItUp = sumzItUp + list.get(i);
			
		}
		
		System.out.println(sumzItUp);
		System.out.println(sumzItUp++);
		System.out.println(++sumzItUp);
		System.out.println(sumzItUp);

		
	}
}
