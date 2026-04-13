import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of friends (N): ");
        int N = sc.nextInt();
        
        // Create a HashSet to store the names
        HashSet<String> names = new HashSet<>();
        
        // Read N names from the user
        for (int i = 0; i < N; i++) {
            System.out.print("Enter name of friend " + (i + 1) + ": ");
            String name = sc.next();
            names.add(name);
        }
        
        // Convert HashSet to ArrayList for sorting
        ArrayList<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        
        // Display the sorted names
        System.out.println("\nFriends in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }
        
        sc.close();
    }
}
