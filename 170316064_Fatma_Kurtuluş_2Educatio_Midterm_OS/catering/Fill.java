package catering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fill implements Runnable{
	
	private final int FILLINGTIME = 1000;
	private ServingCounter servingCounter = null;
	private String name = null;
	private Random rand = new Random();
	private List<String> mealList = Arrays.asList("Cake", "Borek", "Drink"); 
	private volatile boolean stopFilling = false;
	
	public Fill (String name, ServingCounter servingCounter){
		this.name = name;
		this.servingCounter = servingCounter;
	}
	
	public void run(){
		System.out.println(name + " starts working");
		while (stopFilling == false){
			fillMeal();
			if (stopFilling == true){
				System.out.println(name + " stops working");
			}	
		}
	}
	private void fillMeal() {
		int guestNumber = chooseGuest();
		System.out.println( name + " filling meal");
		try {
			Thread.sleep(FILLINGTIME);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		Meal meal = new Meal(mealList.get(rand.nextInt(mealList.size())), guestNumber);
		System.out.println(name + " finished filling and serve to guest. " + meal.toString());
		servingCounter.putMealToCounter(meal);
		System.out.println(name + " serve to guest. " + meal.toString());
		
		
	}
	public void stop (){
		this.stopFilling = true;
	}

	private int chooseGuest() {
		int guestNumber = rand.nextInt(Main.NUMBEROFGUEST)+1;
		return guestNumber;
	}

}
