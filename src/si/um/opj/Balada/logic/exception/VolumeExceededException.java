package si.um.opj.Balada.logic.exception;

public class VolumeExceededException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public VolumeExceededException() {
		super("Maximum volume level reached");
	}
	
}
