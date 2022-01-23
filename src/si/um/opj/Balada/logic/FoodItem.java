package si.um.opj.Balada.logic;

import java.time.LocalDate;

/**
 * Class FoodItem with all it's information
 * @author Marc Isidre Balada Fibla
 *
 */
public class FoodItem {

	private FoodItemType type;
	private double weight;
	private String label;
	private double volume;
	private LocalDate expirationDate;
	
	/**
	 * Default and public constructor of the FoodItem class
	 */
	public FoodItem() {
		super();
	}
	
	public FoodItemType getType() {
		return type;
	}

	public void setType(FoodItemType type) {
		this.type = type;
	}

	/**
	 * Second and public constructor of the FoodItem class
	 * @param label label with you can identify the FoodItem
	 */
	public FoodItem(String label) {
		this.label = label;
	}
	
	/**
	 * Second and public constructor of the FoodItem class
	 * @param weight weight of the FoodItem
	 * @param label label with you can identify the FoodItem
	 * @param volume volume of the FoodItem
	 * @param expirationDate expirationDate of the FoodItem
	 */
	public FoodItem(double weight, String label, double volume, LocalDate expirationDate, FoodItemType type) {
		this(label);
		this.weight = weight;
		this.volume = volume;
		this.expirationDate = expirationDate;
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String toString() {
		return "FoodItem [type=" + type + ", weight=" + weight + ", label=" + label + ", volume=" + volume
				+ ", expirationDate=" + expirationDate + "]";
	}
	
}

