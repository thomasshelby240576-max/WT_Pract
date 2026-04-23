import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = sc.nextLine();
        Scanner file = new Scanner(new File(filename));

        while (file.hasNextLine()) {
            String line = file.nextLine();
            String reversedLine = new StringBuilder(line).reverse().toString();
            String upperCaseLine = reversedLine.toUpperCase();
            System.out.println(upperCaseLine);
        }
        file.close();
    }
}
