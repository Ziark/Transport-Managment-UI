package si.um.opj.Balada.logic.exception;

public class CapacityExceededException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CapacityExceededException() {
		super("Vehicle is already full of items");
	}
}
