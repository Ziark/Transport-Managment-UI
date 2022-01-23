package si.um.opj.Balada.logic.transport;

import si.um.opj.Balada.logic.FoodItemType;

/**
 * Class Van with all it's information
 * @author Marc Isidre Balada Fibla
 */
public class Van extends Vehicle {
	
	
	private FoodItemType type;
		
	public Van() {
		super();
	}
		
	public Van(int registrationNumber, double averageSpeed) {
		super(registrationNumber, averageSpeed);
	}
		
	/**
	 * 3rd and parametrized constructor of Van subclass
	 * @param registrationNumber registration Number that identifies the vehicle (Van)
	 * @param volume volume of the vehicle (Van) in m^3
	 * @param maxWeight maximum Weight of the vehicle
	 * @param averageSpeed average Speed of the vehicle
	 * @param dim capability of the array of FoodItems
	 * @param type type of FoodItem, can be fresh or frozen
	 */
	public Van(int registrationNumber, double volume, int maxWeight, double averageSpeed, int dim, FoodItemType type) {
		super(registrationNumber, volume, maxWeight, averageSpeed, dim);
		this.type = type;
	}
		
	public String toString() {
		return "Van [type=" + type + "], "+super.toString();
	}

	public double getVehiclesMaxVolume() {
		return super.getVolume();
	}

	public FoodItemType getType() {
		return type;
	}

	public void setType(FoodItemType type) {
		this.type = type;
	}

}
