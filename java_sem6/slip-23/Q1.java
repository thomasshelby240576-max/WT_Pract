import java.util.Scanner;

public class Q1 implements Runnable {
    private String input;

    public Q1(String input) {
        this.input = input;
    }
    @Override
    public void run() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isVowel(ch)) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Q1 vowel = new Q1(input);
        Thread thread = new Thread(vowel);
        thread.start();

        sc.close();
    }
}
