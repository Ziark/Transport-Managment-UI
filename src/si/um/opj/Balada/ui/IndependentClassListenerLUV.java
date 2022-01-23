package si.um.opj.Balada.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import si.um.opj.Balada.logic.exception.CapacityExceededException;
import si.um.opj.Balada.logic.exception.FoodItemTypeException;
import si.um.opj.Balada.logic.exception.VolumeExceededException;
import si.um.opj.Balada.logic.facility.BusinessFacility;
import si.um.opj.Balada.logic.facility.Warehouse;
import si.um.opj.Balada.logic.transport.Vehicle;



public class IndependentClassListenerLUV implements ActionListener{

	private JList<BusinessFacility> bf;
	private JList<Vehicle> vh;
	

	public IndependentClassListenerLUV(JList<BusinessFacility> bf, JList<Vehicle> vh) {
		this.bf = bf;
		this.vh = vh;
	}

	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame(); 
		frame.setBounds(500, 500, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		if(bf.getSelectedIndex()>=0 && vh.getSelectedIndex()>=0) {
			try {
				bf.getSelectedValue().acceptVehicle(vh.getSelectedValue());
				
				if(bf.getSelectedValue() instanceof Warehouse) {
					JOptionPane.showMessageDialog(frame,"Items have been loaded to the Vehicle");
				}else {
					JOptionPane.showMessageDialog(frame,"Items have been unloaded to the Store");
				}
			} catch (CapacityExceededException | VolumeExceededException | FoodItemTypeException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
