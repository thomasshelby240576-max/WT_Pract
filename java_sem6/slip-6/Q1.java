import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> numbers = new TreeSet<>();
        
        // Accept 'n' integers from the user
        System.out.print("Enter the number of integers: ");
        int n = sc.nextInt();
        System.out.println("Enter the integers:");

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            numbers.add(num);
        }
        
        // Display integers in sorted order
        System.out.println("Integers in sorted order:");
        for (int num : numbers) {
            System.out.println(num);
        }
        
        // Search for a particular element
        System.out.print("Enter the element to search: ");
        int search = sc.nextInt();
        
        if (numbers.contains(search)) {
            System.out.println(search + " is present in the collection.");
        } else {
            System.out.println(search + " is not present in the collection.");
        }
        
        sc.close();
    }
}
