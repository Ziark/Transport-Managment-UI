package si.um.opj.Balada.logic.transport;

import si.um.opj.Balada.logic.facility.Store;
import si.um.opj.Balada.logic.facility.Warehouse;

/**
 * Class Route with all it's information
 * @author Marc Isidre Balada Fibla
 */
public class Route {

	private Store store;
	private Warehouse warehouse;
	private int distance;
	
	/**
	 * Public and default constructor of Route Class
	 */
	public Route() {}
	
	/**
	 * Second and public contructor of Route class
	 * @param store store which is in this route
	 * @param warehouse warehouse of the store which is in this route
	 * @param distance distance of the route in km
	 */
	public Route(Store store, Warehouse warehouse, int distance) {
		this.store=store;
		this.warehouse=warehouse;
		this.distance=distance;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String toString() {
		return "Route [store=" + store + ", warehouse=" + warehouse + ", distance=" + distance + "]";
	}
	
}
