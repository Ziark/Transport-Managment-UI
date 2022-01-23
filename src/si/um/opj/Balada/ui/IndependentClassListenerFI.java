package si.um.opj.Balada.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import si.um.opj.Balada.logic.FoodItem;


public class IndependentClassListenerFI implements ActionListener{

	private JList<FoodItem> fooditemList;
	private ArrayList<FoodItem> listFI;
	
	public IndependentClassListenerFI(JList<FoodItem> fooditemList, ArrayList<FoodItem> listFI) {
		this.fooditemList = fooditemList;
		this.listFI = listFI;
	}

	public void actionPerformed(ActionEvent e) {
		DefaultListModel<FoodItem> model = (DefaultListModel<FoodItem>) fooditemList.getModel();
		if(fooditemList.getSelectedIndex()>=0) {
			listFI.remove(fooditemList.getSelectedIndex());
			model.remove(fooditemList.getSelectedIndex());
		}
	
	}

}