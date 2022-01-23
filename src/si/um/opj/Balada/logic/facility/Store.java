package si.um.opj.Balada.logic.facility;

import si.um.opj.Balada.logic.transport.Location;
import si.um.opj.Balada.logic.transport.Vehicle;

/**
 * Class Store with all it's information
 * @author Marc Isidre Balada Fibla
 *
 */
public class Store extends BusinessFacility implements Transportable{
	
	private String name;
	private Location location;
	
	/**
	 * Default and public constructor of Store class
	 */
	public Store() {
		super();
	}
	
	/**
	 * Second and public constructor of Store class
	 * @param name name of the store
	 * @param location location of the store
	 */
	public Store(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Store [name=" + name + ", " + location + "]";
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * acceptVehicle in the Store class unloads all the food items from the vehicle
	 */
	public void acceptVehicle(Vehicle vehicle) {
		vehicle.unloadFoodItems();
	}
	
}

