package si.um.opj.Balada.logic.facility;

import java.time.LocalDate;
import java.util.Arrays;

import si.um.opj.Balada.logic.FoodItem;
import si.um.opj.Balada.logic.exception.CapacityExceededException;
import si.um.opj.Balada.logic.exception.FoodItemTypeException;
import si.um.opj.Balada.logic.exception.VolumeExceededException;
import si.um.opj.Balada.logic.transport.Location;
import si.um.opj.Balada.logic.transport.Truck;
import si.um.opj.Balada.logic.transport.Van;
import si.um.opj.Balada.logic.transport.Vehicle;

/**
 * Class Warehouse with all it's information plus some methods for using arrays
 * @author Marc Isidre Balada Fibla
 *
 */
public class Warehouse extends BusinessFacility implements Transportable {

	private String name;
	private Location location;
	private FoodItem[] foodItemsArray;
	private int num;
	
	/**
	 * Default and private constructor of the Warehouse class
	 */
	@SuppressWarnings("unused")
	private Warehouse() {
		super();
	}
	
	/**
	 * Second and public constructor of the Warehouse class
	 * @param name name of the warehouse, where is
	 * @param location location of the warehouse
	 */
	public Warehouse(String name, Location location) {
		this.name = name;
		this.location = location;
	}
	
	/**
	 * Third and public constructor of the Warehouse class
	 * @param name name of the warehouse
	 * @param location location of the warehouse, where is
	 * @param capacity capacity of the warehouse, number of items that can contain
	 */
	public Warehouse(String name, Location location, int capacity) {
		this(name,location);
		this.foodItemsArray = new FoodItem[capacity];
		num=0;
	}

	public FoodItem[] getFoodItemsArray() {
		return foodItemsArray;
	}
	
	public int getFoodItemsArrayLength() {
		return foodItemsArray.length;
	}

	public void setFoodItemsArray(FoodItem[] foodItemsArray) {
		this.foodItemsArray = foodItemsArray;
		num = foodItemsArray.length;
	}

	public String toString() {
		return "Warehouse [name=" + name + ", " + location + ", NumItems: "+num+
				", foodItemsArray="+ Arrays.toString(foodItemsArray) + "]";
	}

	/**
	 * Adds a foodItem to the array of items, checking before if item exists
	 * @param foodItem foodItem we want to add to the array
	 */
	public void addItem(FoodItem foodItem) {
		if ((num < foodItemsArray.length)
				&&(!this.foodItemExists(foodItem.getLabel()))
						&& (stillValid(foodItem))) {
			foodItemsArray[num] = foodItem;
			num++;
		}else {
			if (this.stillValid(foodItem)) {
				if (num >= foodItemsArray.length) System.out.println("Not possible: Array full");
				else System.out.println("Not possible: this food item already exists");
			}else System.out.println("Not possible: food item isn't already valid");
		}
	}
	
	/**
	 * Removes the given foodItem from the array of foodItems.
	 * @param foodItem foodItem we want to remove from the array
	 */
	public void removeItem(FoodItem foodItem) {
		int pos=this.foodItemPosition(foodItem);
		if (pos!=-1) {
			for (int i=pos; i<num-1; i++) {
				foodItemsArray[i]=foodItemsArray[i+1];
			}
			foodItemsArray[num-1]=null;
			num--;
		}
	}
	
	/**
	 * @return number of foodItems in the array of foodItemsArray
	 */
	public int returnTheNumberOfFoodItems() {
		return num;
	}
	
	/**
	 * @param label label which is a String that identifies a FoodItem
	 * @return true if the foodItem with the specified label exists in the array, false if not
	 */
	public boolean foodItemExists(String label) {
		int i=0;
		boolean sameItem = false;
		while ((i<num)&&(!sameItem)) {
			if(foodItemsArray[i].getLabel().equals(label)) {
				sameItem=true;
			}
			else i++;
		}
		if(sameItem) return true;
		else return false;
	}
	
	/**
	 * @param foodItem foodItem which is the foodItem we want the position of
	 * @return the position in the array of the foodItem specified in label,-1 if doesn't exist
	 */
	public int foodItemPosition (FoodItem foodItem) {
		int i=0;
		boolean end = false;
		while ((i<num)&&(!end)) {
			if(foodItemsArray[i].getLabel().equals(foodItem.getLabel())) end=true;
			else i++;
		}
		if(end) return i;
		else return -1;
	}
	
	/**
	 * stillValid method checks if a method is valid. One method is valid if today's date it's higher or equal to the items expiration date.
	 * @param foodItem foodItem you need to check if is still valid
	 * @return True or False if the item is valid or not
	 */
	private boolean stillValid(FoodItem foodItem) {
		LocalDate today = LocalDate.now();
		today = today.plusDays(3);
		LocalDate expDate = foodItem.getExpirationDate();
		return expDate.isAfter(today);
	}

	/**
	 * Loads a van with the food items of the warehouse
	 * @throws VolumeExceededException 
	 * @throws CapacityExceededException 
	 */
	public void acceptVehicle(Vehicle vehicle)  throws CapacityExceededException, VolumeExceededException, FoodItemTypeException  {
		boolean isException = false;
		if (vehicle instanceof Truck) {
			if (vehicle.getFreeSpace() < num) {
				isException=true;
				throw new CapacityExceededException(); 
			}
			if (isException)vehicle.unloadFoodItems();
			else vehicle.loadFoodItem(foodItemsArray);
			if(vehicle.getTakenSpace() > 100) throw new VolumeExceededException();
				
		}else {
			if (vehicle.getFreeSpace() < num) throw new CapacityExceededException(); 
			if (!(sameType((Van)vehicle))) {
				isException=true;
				throw new FoodItemTypeException(); 
			}
			if (!isException) {
				vehicle.loadFoodItem(foodItemsArray);
				if(vehicle.getTakenSpace() > 100) throw new VolumeExceededException();
			}
		}
	}
	
	/**
	 * Checks if the vehicle food item type is the same than all the warehouse food item types
	 * @param van vehicle which cargo food items type will be checked
	 * @return true if it's same type, false if not
	 */
	public boolean sameType(Van van) {
		int i=0;
		boolean sameType=true;
		while ((i<num)&&(sameType)){
			if(!foodItemsArray[i].getType().equals(van.getType())) sameType = false;
			else i++;
		}
		return sameType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
