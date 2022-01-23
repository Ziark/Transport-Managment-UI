package si.um.opj.Balada.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;

import si.um.opj.Balada.logic.FoodItem;
import si.um.opj.Balada.logic.facility.Warehouse;

public class IndependentClassListenerAFIW implements ActionListener {

	private JList<FoodItem> fi;
	private JList<Warehouse> wh;
	private ArrayList<FoodItem> fiList;
	private ArrayList<Warehouse> whList;
	
	public IndependentClassListenerAFIW(JList<FoodItem> fi, JList<Warehouse> wh, ArrayList<FoodItem> fiList,
			ArrayList<Warehouse> whList) {
		this.fi = fi;
		this.wh = wh;
		this.fiList = fiList;
		this.whList = whList;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(fi.getSelectedIndex()>=0 && wh.getSelectedIndex()>= 0) {
			FoodItem auxFI = fiList.get(fi.getSelectedIndex());
			Warehouse auxW = whList.get(wh.getSelectedIndex());
			auxW.addItem(auxFI);
		}
	}

}
