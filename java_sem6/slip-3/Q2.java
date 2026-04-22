import java.util.Collections;
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

        // Delete the first element of the list
        List.removeFirst();

        System.out.println("\nLinkedList after deleting the first element: \n" + List);

        // Reverse the contents of the list
        Collections.reverse(List);

        System.out.println("\nContents of the list in reverse order: \n" + List);
    }
}
