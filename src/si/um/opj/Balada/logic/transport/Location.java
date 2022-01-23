package si.um.opj.Balada.logic.transport;

/**
 * Class Location with all it's information
 * @author Marc Isidre Balada Fibla
 *
 */
public class Location {
	
	private String city;
	private String country;
	
	/**
	 * Default and public constructor of Location class
	 */
	public Location() {}
	
	/**
	 * Second and public constructor of Location class
	 * @param city city this location refers to
	 * @param country country this location refers to
	 */
	public Location(String city, String country) {
		this.city=city;
		this.country=country;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "Location [city=" + city + ", country=" + country + "]";
	}


}
