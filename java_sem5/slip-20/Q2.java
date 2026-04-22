import java.util.Scanner;

import operation.Maximum; 
class Q2 { 
    public static void main (String args[]) { 
 
        int n1,n2; 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter first no="); 
        n1 = sc.nextInt(); 
        System.out.println("Enter second no="); 
        n2 = sc.nextInt(); 
        
        Maximum ob1 = new Maximum(n1,n2); 
        
        ob1.add(); 
        ob1.sub(); 
        ob1.max(); 
    } 
}