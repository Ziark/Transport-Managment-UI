package si.um.opj.Balada.logic.transport;

/**
 * Class Truck with all it's information
 * @author Marc Isidre Balada Fibla
 */
public class Truck extends Vehicle{
	
	private int numberOfTrailers;
	
	/**
	 * Default constructor of Truck class
	 */
	public Truck() {
		super();
	}
	
	/**
	 * 2nd and public contructor of Truck class
	 * @param registrationNumber registrationNumber of the Truck
	 * @param averageSpeed averageSpeed registered by the Truck
	 */
	public Truck (int registrationNumber, double averageSpeed) {
		super(registrationNumber, averageSpeed);
	}
	
	/**
	 * 3rd and public constructor of Truck class
	 * @param registrationNumber registrationNumber that identifies the vehicle (truck)
	 * @param volume volume of the vehicle (truck) in m^3
	 * @param maxWeight maximum Weight of the vehicle (truck)
	 * @param averageSpeed average Speed of the vehicle (truck)
	 * @param dim capability of the array of FoodItems (cargo)
	 */
	public Truck(int registrationNumber, double volume, int maxWeight, double averageSpeed, int dim) {
		super(registrationNumber, volume, maxWeight, averageSpeed, dim);
	}
	
	/**
	 * 4th and parametrized constructor for Truck subclass
	 * @param registrationNumber registration Number that identifies the vehicle (truck)
	 * @param volume volume of the vehicle (truck) in m^3
	 * @param maxWeight maximum Weight of the vehicle (truck)
	 * @param averageSpeed average Speed of the vehicle (truck)
	 * @param dim capability of the array of FoodItems (cargo)
	 */
	public Truck(int registrationNumber, double volume, int maxWeight, double averageSpeed, int dim, int numberOfTrailers) {
		super(registrationNumber, volume, maxWeight, averageSpeed, dim);
		this.numberOfTrailers=numberOfTrailers;
	}

	public int getNumberOfTrailers() {
		return numberOfTrailers;
	}

	public void setNumberOfTrailers(int numberOfTrailers) {
		this.numberOfTrailers = numberOfTrailers;
	}
	
	/**
	 * @return volume multiplied with the number of trailers
	 */
	public double getVehiclesMaxVolume(){
		return (super.getVolume()*numberOfTrailers);
	}

	@Override
	public String toString() {
		return "Truck [numberOfTrailers=" + numberOfTrailers + "], "+super.toString();
	}	
}
