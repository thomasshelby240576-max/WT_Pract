import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of student: ");
        int n = sc.nextInt();

        LinkedList<String> studentList = new LinkedList<>();
        
        // Accept subject names from the user and add them to the LinkedList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            String student = sc.next();
            studentList.add(student);
        }
        Collections.sort(studentList);
        // Display the subject names using Iterator
        System.out.println("\nStudent names:");
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        sc.close();
    }
}
