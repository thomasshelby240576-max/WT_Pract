import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();

        LinkedList<String> subjectList = new LinkedList<>();
        
        // Accept subject names from the user and add them to the LinkedList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            String subject = scanner.next();
            subjectList.add(subject);
        }

        Collections.sort(subjectList);
        // Display the subject names using Iterator
        System.out.println("\nSubject names:");
        Iterator<String> iterator = subjectList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        scanner.close();
    }
}
