public class Q1 extends Thread { 
    char c; 
    public void run() { 
        for(c = 'A'; c<='Z';c++) { 
            System.out.println(""+c); 
            try { 
                Thread.sleep(2000); 
            } catch(Exception e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
    public static void main(String args[]) { 
        Q1 t = new Q1(); 
        t.start(); 
    } 
}