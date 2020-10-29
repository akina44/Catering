package catering;



public class Main {
	public final static int NUMBEROFGUEST = 10;
	private final int SIMULATIONDURATION = 12000; // Milliseconds
	public ServingCounter servingCounter = null;
	
	public Main() {
		servingCounter = new ServingCounter();
		
		Fill fill1 =new Fill("First tray", servingCounter);
		Thread fill1Thread = new Thread(fill1);
		
		Fill fill2 =new Fill("Second tray", servingCounter);
		Thread fill2Thread = new Thread(fill2);
		
		Fill fill3 =new Fill("Third tray", servingCounter);
		Thread fill3Thread = new Thread(fill3);
		
		waiter waiter1 = new waiter(" Waiter ", servingCounter );
		Thread waiter1Thread = new Thread(waiter1);
		
		fill1Thread.start();
		fill2Thread.start();
		fill3Thread.start();
		waiter1Thread.start();
		
		try {
			Thread.sleep(SIMULATIONDURATION);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		fill1.stop();
		fill2.stop();
		fill3.stop();
		waiter1.stop();
	}
	public static void main(String[] args) {
		Main catering = new Main();
	}

}
