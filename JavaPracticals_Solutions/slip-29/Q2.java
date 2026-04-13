import java.util.LinkedList;

public class Q2 {
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> List = new LinkedList<>();

        // Add elements at the end of the list
        List.add("Apple");
        List.add("Banana");
        List.add("Orange");
        List.add("Cherry");

        System.out.println("\nInitial LinkedList: \n" + List);

        List.addFirst("Pear");
        System.out.println("\nAdd element at first position: \n" + List);
    
        List.removeLast();
        System.out.println("\nDeleting the Last element: \n" + List);

        System.out.println("\nDisplay the size of Linked List: \n" +  List.size());
    }
}
