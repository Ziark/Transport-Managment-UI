package si.um.opj.Balada.logic.exception;

public class FoodItemTypeException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public FoodItemTypeException() {
		super("The type of the food item doesn't match with this Vans type");
	}
}
