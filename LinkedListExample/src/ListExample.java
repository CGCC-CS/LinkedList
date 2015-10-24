import lists.LinkedList;

public class ListExample {

	public static void main(String[] args) {
	//	System.out.print("Hello, World, Chandler, Gilbert");

		LinkedList<String> myList = new LinkedList<String>();
		
		myList.addToFront("Gilbert");
		myList.addToFront("Chandler");
		myList.addToFront("World");
		myList.addToFront("Hello");
		
		System.out.println("Size = " + myList.size());
		System.out.println("First = " + myList.first());
		System.out.println("Last = " + myList.last());
		System.out.println(myList);
		System.out.println("Iterator test:");
		for (String s: myList) {
			System.out.print (s + ", ");
		}
		System.out.println();
		if (myList.isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			System.out.println("List is not empty");
		}
		
		System.out.println("\nRemove some stuff:");
		String front = myList.removeFirst();
		String rear = myList.removeLast();
		System.out.println("Size = " + myList.size());
		System.out.println("Old front: " + front);
		System.out.println("Old rear: " + rear);
		System.out.println("First = " + myList.first());
		System.out.println("Last = " + myList.last());
		System.out.println(myList);
		
		System.out.println("\nRemove the rest:");
		rear = myList.removeLast();
		front = myList.removeFirst();
		System.out.println("Size = " + myList.size());
		System.out.println("Old front: " + front);
		System.out.println("Old rear: " + rear);
		System.out.println(myList);
		if (myList.isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			System.out.println("List is not empty");
		}
		
		System.out.println("\nFinishing up:");
		myList.addToRear("end");
		myList.addToFront("The");
		System.out.println(myList);
	}

}
