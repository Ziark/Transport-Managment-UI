package si.um.opj.Balada.logic.facility;

import si.um.opj.Balada.logic.exception.CapacityExceededException;
import si.um.opj.Balada.logic.exception.FoodItemTypeException;
import si.um.opj.Balada.logic.exception.VolumeExceededException;
import si.um.opj.Balada.logic.transport.Vehicle;

interface Transportable {
	
	public void acceptVehicle(Vehicle vehicle) throws CapacityExceededException, VolumeExceededException, FoodItemTypeException;

}
