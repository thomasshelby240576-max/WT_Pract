public class Q1 extends Thread {
	String str;
	int n;
	
	Q1(String str, int n) {
		this.str = str;
		this.n = n;
	}
	
	public void run() {
		try {
			for(int i = 0; i < n; i++){
				System.out.println(getName()+"+"+ str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Q1 t1 = new Q1("COVID19",10);
		Q1 t2 = new Q1("LOCKDOWN2020",20);
		Q1 t3 = new Q1("VACCINATED2021",30);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
