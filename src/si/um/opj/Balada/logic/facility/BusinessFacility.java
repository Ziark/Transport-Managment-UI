package si.um.opj.Balada.logic.facility;

import si.um.opj.Balada.logic.transport.Location;
import si.um.opj.Balada.logic.transport.Vehicle;

/**
 * Class Business Facility with all it's information
 * @author Marc Isidre Balada Fibla
 */
public abstract class BusinessFacility implements Transportable{

	private String name;
	private Location location;
	
	public BusinessFacility() {}
	
	public BusinessFacility(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "BusinessFacility [name=" + name + ", location=" + location + ", getName()=" + getName()
				+ ", getLocation()=" + getLocation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}

