import Lists.LinkedList;



public class ListExample {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addToFront("Hello");
		list.addToFront("World");
		list.addToRear("Chandler");
		list.addToRear("Gilbert");
		
		System.out.print("head -> ");
		for (String s : list) {
			System.out.print(s + " -> ");
		}
		System.out.println("tail");
		
		list.removeFirst();
		list.removeLast();
		
		System.out.print("head -> ");
		for (String s : list) {
			System.out.print(s + " -> ");
		}
		System.out.println("tail");
	}

}
