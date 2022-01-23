package si.um.opj.Balada.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import si.um.opj.Balada.logic.transport.Truck;
import si.um.opj.Balada.logic.transport.Vehicle;

public class IndependentClassListenerVH implements ActionListener{

	private JList<Vehicle> vhList;
	private ArrayList<Vehicle> listV;
	
	public IndependentClassListenerVH(JList<Vehicle> vhList, ArrayList<Vehicle> listV) {
		this.vhList = vhList;
		this.listV = listV;
	}

	public void actionPerformed(ActionEvent e) {
		DefaultListModel<Vehicle> model_2 = (DefaultListModel<Vehicle>) vhList.getModel();
		if(vhList.getSelectedIndex()>=0) {
			listV.remove(vhList.getSelectedIndex());
			model_2.remove(vhList.getSelectedIndex());
		}
	}

}
