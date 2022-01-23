package si.um.opj.Balada.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import si.um.opj.Balada.logic.facility.BusinessFacility;

public class IndependentClassListenerBF implements ActionListener{

	private JList<BusinessFacility> bfList;
	private ArrayList<BusinessFacility> listBF;

	
	public IndependentClassListenerBF(JList<BusinessFacility> bfList, ArrayList<BusinessFacility> listBF) {
		this.bfList = bfList;
		this.listBF = listBF;
	}

	public void actionPerformed(ActionEvent e) {
		DefaultListModel<BusinessFacility> modelBF = (DefaultListModel<BusinessFacility>) bfList.getModel();
		if(bfList.getSelectedIndex()>=0) {
			listBF.remove(bfList.getSelectedIndex());
			modelBF.remove(bfList.getSelectedIndex());
		}
	
	}
}

