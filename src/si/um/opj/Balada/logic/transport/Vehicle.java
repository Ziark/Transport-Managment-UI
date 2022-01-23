package si.um.opj.Balada.logic.transport;

import java.util.Arrays;

import si.um.opj.Balada.logic.FoodItem;
import si.um.opj.Balada.logic.exception.VolumeExceededException;

/**
 * Class Vehicle with all it's information
 * @author Marc Isidre Balada Fibla
 * @version 2
 */
public abstract class Vehicle {

	private int registrationNumber;
	private double volume;
	private int maxWeight;
	private double averageSpeed;
	private FoodItem[] cargo;
	private int num;
	
	/**
	 * Public and default constructor of Vehicle class
	 */
	public Vehicle() {}
	
	/**
	 * Second and public constructor of Vehicle class
	 * @param registrationNumber registrationNumber of the vehicle
	 * @param averageSpeed averageSpeed vehicle have
	 */
	public Vehicle (int registrationNumber, double averageSpeed) throws IllegalArgumentException {
		this.registrationNumber=registrationNumber;
		if (averageSpeed < 0) throw new IllegalArgumentException();
		else this.averageSpeed=averageSpeed;
	}
	
	/**
	 * Third and public constructor of Vehicle class
	 * @param registrationNumber registration Number that identifies the vehicle
	 * @param volume volume of the vehicle in m^3
	 * @param maxWeight maximum Weight of the vehicle
	 * @param averageSpeed average Speed of the vehicle
	 * @param dim capability of the array of FoodItems
	 */
	public Vehicle(int registrationNumber, double volume, int maxWeight, double averageSpeed, int dim) throws IllegalArgumentException {
		this(registrationNumber, averageSpeed);
		if (volume < 0) throw new IllegalArgumentException();
		else this.volume = volume;
		if (maxWeight < 0) throw new IllegalArgumentException();
		else this.maxWeight = maxWeight;
		this.cargo = new FoodItem[dim];
		num=0;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	
	public int getNum() {
		return num;
	}
	
	/**
	 * @return the number of free positions in the array 
	 */
	public int getFreeSpace() {
		return (cargo.length-num);
	}

	/**
	 * Normal getter of cargo but with null pointer exception checked for number of items = 0
	 * @return if num==0 return null, else return cargo
	 */
	public FoodItem[] getCargo() {
		if (num == 0) {
			FoodItem[] cargoAux = cargo.clone();
			FoodItem fiAux = new FoodItem();
			for (int i=0; i<cargoAux.length; i++) cargoAux[i]=fiAux;
			return cargoAux;
		}
		else return cargo;
	}

	public void setCargo(FoodItem[] cargo) {
		this.cargo = cargo;
	}

	public String toString() {
		return "Vehicle [regNumber=" + registrationNumber + ", volume=" + volume + ", maxWeight=" + maxWeight
				+ ", avSpeed=" + averageSpeed +  ", NumItems=" + num + ", cargo=" + Arrays.toString(cargo) +"]";
	}

	/**
	 * Calculate the travel time with the distance and the speed
	 * @param rte route for getting the distance
	 * @return time in days of the travel rounded up
	 */
	double calculateTravelTime(Route rte) {
		double time;
		time = rte.getDistance() / this.getAverageSpeed();
		return Math.ceil(time/24);
	}
	
	/**
	 * Loads a foodItem onto a vehicle
	 * @param foodItem foodItem which is load onto the vehicle
	 */
	public void loadFoodItem(FoodItem foodItem) throws VolumeExceededException{
		if (num < cargo.length) {
				cargo[num] = foodItem;
				num++;
		}else throw new VolumeExceededException();
	}
	
	/**
	 * Unloads foodItems from a vehicle
	 */
	public void unloadFoodItems() {
		while (num>0) {
			cargo[num-1]=null;
			num--;
		}
	}
	
	/**
	 * @return % of the volume taken up by loaded foodItems in a vehicle
	 */
	public double getTakenSpace() {
		double volAux = 0;
		try {
			for (int i=0; i<num; i++) {
				volAux += cargo[i].getVolume();
			}
		}catch (NullPointerException e){
			//when you haven't all the cargo full (some null items)
			e.printStackTrace();
		}
		if ((getVehiclesMaxVolume())==0) return 0;
		else return (volAux*100)/(getVehiclesMaxVolume());
	}
	
	/**
	 * @return max volume of the vehicle
	 */
	public abstract double getVehiclesMaxVolume();
	
	/**
	 * Loads the vehicle with the food items of param
	 * @param fooditems fooditems array wich will be loaded on to a vehicle
	 */
	public void loadFoodItem(FoodItem[] fooditems){
		int i=0;
		if (this instanceof Van) {
			while((num<cargo.length)&&(i<fooditems.length)){
				cargo[num] = fooditems[i];
				num++;	
				i++;
			}
		}else {
			cargo = fooditems;
			num = fooditems.length;
		}
	}
	

	
}

