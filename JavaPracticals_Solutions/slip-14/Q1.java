import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to be searched: ");
        String searchString = scanner.nextLine();
        scanner.close();

        File[] files = new File(".").listFiles();

        // Iterate through each file in the current directory
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                // Start a new thread for each file search
                Thread thread = new Thread(() -> searchInFile(file, searchString));
                thread.start();
            }
        }
    }

    private static void searchInFile(File file, String searchString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    // Print filename and line number where the string is found
                    System.out.println("Found '" + searchString + "' in file: " + file.getName() + " at line: " + lineNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
        }
    }
}
