package catering;

import java.util.ArrayList;

public class ServingCounter {
	private ArrayList<Meal> mealList = null;
	//private ArrayList<Meal> mealList2 = null;
	//private ArrayList<Meal> mealList3 = null;
	/**
	 * Create a Counting Server with empty Meal list
	 */
	public ServingCounter(){
		mealList = new ArrayList<Meal>();
		//mealList2 = new ArrayList<Meal>();
	//	mealList3 = new ArrayList<Meal>();
	}
	/**
	 * Method puts meal to Serving Counter
	 * @param meal put to Serving Counter
	 */
	public synchronized void putMealToCounter(Meal meal){
		mealList.add(meal);
		//mealList2.add(meal2);
		//mealList3.add(meal3);
	}
	/**
	 * Method to get Meal Serving Counter
	 * @return if present a meal, else null
	 */
	public synchronized Meal getMealFromCounter(){
		if (mealList.size() > 0) {
			Meal meal = mealList.get(0);
			//Meal meal2 = mealList2.get(0);
			//Meal meal3 = mealList3.get(0);
			mealList.remove(0);
			return meal;
		}
		return null;
	}

}
