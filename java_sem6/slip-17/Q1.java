import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet; 
 
public class Q1 { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the number of integers: "); 
        int n = sc.nextInt(); 
        Set<Integer> set = new TreeSet<>(); 
        for (int i = 1; i <= n; i++) { 
            System.out.print("Enter integer #" + i + ": "); 
            int num = sc.nextInt();
            set.add(num);
        } 
        System.out.println("The integers in sorted order are: "); 
        for (int num : set) { 
            System.out.print(num + " "); 
        } 
        sc.close();
    } 
} 
