package si.um.opj.Balada.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import si.um.opj.Balada.logic.FoodItem;
import si.um.opj.Balada.logic.FoodItemType;
import si.um.opj.Balada.logic.facility.BusinessFacility;
import si.um.opj.Balada.logic.facility.Store;
import si.um.opj.Balada.logic.facility.Warehouse;
import si.um.opj.Balada.logic.transport.Location;
import si.um.opj.Balada.logic.transport.Truck;
import si.um.opj.Balada.logic.transport.Van;
import si.um.opj.Balada.logic.transport.Vehicle;

public class UserInterface{
	
	private JFrame frmDemoApp;
	private JTextField tf_lblFI;
	private JTextField tf_wgtFI;
	private JTextField tf_volFI;
	private JTextField tf_nameBF;
	private JTextField tf_capBF;
	private JTextField tf_regnV;
	private JTextField tf_avspV;
	private JTextField tf_volV;
	private JTextField tf_mxwV;
	private JTextField tf_ntrV;
	private JTextField tf_capV;
	private JButton btn_addFI;
	private JButton btn_delFI;
	private JButton btn_edtFI;
	private JButton btn_delBF;
	private JButton btn_edtBF;
	private JButton btn_delV;
	private JButton btn_edtV;
	private JList typeFIList;
	private JList typeVanList;
	private JList expDateList;
	private JList fiList;
	private JList locListBF;
	private JList list_typeBF;
	private JList bf;
	private JList aux_bfList;
	private JList aux_bfList2;
	private JList vh;
	private JList list_typeV;
	private JList aux_list_typeV;
	private JList aux_fiList;
	
	final private DefaultListModel<FoodItem> model_FI = new DefaultListModel<FoodItem>();
	final private DefaultListModel<Warehouse> model_WH = new DefaultListModel<Warehouse>(); 
	final private DefaultListModel<BusinessFacility> modelBF = new DefaultListModel<BusinessFacility>();
	final private DefaultListModel<Vehicle> modelVH = new DefaultListModel<Vehicle>();
	
	private ArrayList<FoodItem> fooditems = new ArrayList<FoodItem>();
	private ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
	private ArrayList<BusinessFacility> bfList = new ArrayList<BusinessFacility>();
	private ArrayList<Vehicle> vhList = new ArrayList<Vehicle>();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmDemoApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserInterface() {
		initialize();
	}
	
	private void initialize() {
		
		frmDemoApp = new JFrame();
		frmDemoApp.setTitle("Transport Management User Interface");
		frmDemoApp.setBounds(500, 200, 1000, 650);
		frmDemoApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDemoApp.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmDemoApp.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("Start", null, panel, null);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel labelIntro = new JLabel("Welcome to Transport Management UI!");
		labelIntro.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_LabelIntro = new GridBagConstraints();
		gbc_LabelIntro.insets = new Insets(0, 0, 10, 0);
		gbc_LabelIntro.gridx = 2;
		gbc_LabelIntro.gridy = 0;
		panel.add(labelIntro, gbc_LabelIntro);
		
		JLabel labelIntro2 = new JLabel("Change TAB to start");
		labelIntro2.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_LabelIntro2 = new GridBagConstraints();
		gbc_LabelIntro2.insets = new Insets(5, 0, 0, 0);
		gbc_LabelIntro2.gridx = 2;
		gbc_LabelIntro2.gridy = 1;
		panel.add(labelIntro2, gbc_LabelIntro2);
		
		/* *****************************************************************************
		 * ********************* FOOD ITEMS TAB ****************************************
		 * *****************************************************************************/
		
		JPanel panel_TFI = new JPanel();
		panel_TFI.setBorder(new LineBorder(Color.GREEN.darker()));
		tabbedPane.addTab("Food Items", null, panel_TFI, null);
		
		GridBagLayout gbl_panel_TFI = new GridBagLayout();
		gbl_panel_TFI.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TFI.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TFI.columnWeights = new double[]{0.0, 0.0, 0.25, 0.0, 0.25, 0.0, Double.MIN_VALUE};
		gbl_panel_TFI.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
		panel_TFI.setLayout(gbl_panel_TFI);
		
		JLabel lbl_addFI = new JLabel("Add a Food Item");
		lbl_addFI.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_addFI = new GridBagConstraints();
		gbc_addFI.gridwidth = 4;
		gbc_addFI.insets = new Insets(10, 0, 15, 0);
		gbc_addFI.gridx = 1;
		gbc_addFI.gridy = 0;
		panel_TFI.add(lbl_addFI, gbc_addFI);
		
		JLabel lbl_lblFI = new JLabel("Add Label: ");
		GridBagConstraints gbc_lblFI = new GridBagConstraints();
		gbc_lblFI.anchor = GridBagConstraints.EAST;
		gbc_lblFI.insets = new Insets(0, 10, 10, 5);
		gbc_lblFI.gridx = 1;
		gbc_lblFI.gridy = 2;
		panel_TFI.add(lbl_lblFI, gbc_lblFI);
		
		tf_lblFI = new JTextField();
		GridBagConstraints gbc_tf_lblFI = new GridBagConstraints();
		gbc_tf_lblFI.insets = new Insets(0, 10, 10, 15);
		gbc_tf_lblFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lblFI.gridwidth = 4;
		gbc_tf_lblFI.gridx = 2;
		gbc_tf_lblFI.gridy = 2;
		panel_TFI.add(tf_lblFI, gbc_tf_lblFI);
				
		JLabel lbl_wgtFI = new JLabel("Add Weight: ");
		GridBagConstraints gbc_lbl_wgtFI = new GridBagConstraints();
		gbc_lbl_wgtFI.anchor = GridBagConstraints.EAST;
		gbc_lbl_wgtFI.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_wgtFI.gridx = 1;
		gbc_lbl_wgtFI.gridy = 3;
		panel_TFI.add(lbl_wgtFI, gbc_lbl_wgtFI);
			
		tf_wgtFI = new JTextField();
		GridBagConstraints gbc_tf_wgtFI = new GridBagConstraints();
		gbc_tf_wgtFI.insets = new Insets(0, 10, 10, 5);
		gbc_tf_wgtFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_wgtFI.gridx = 2;
		gbc_tf_wgtFI.gridy = 3;
		panel_TFI.add(tf_wgtFI, gbc_tf_wgtFI);	
		
		JLabel lbl_volFI = new JLabel("Add Volume: ");
		GridBagConstraints gbc_lbl_volFI = new GridBagConstraints();
		gbc_lbl_volFI.anchor = GridBagConstraints.EAST;
		gbc_lbl_volFI.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_volFI.gridx = 3;
		gbc_lbl_volFI.gridy = 3;
		panel_TFI.add(lbl_volFI, gbc_lbl_volFI);
		
		tf_volFI = new JTextField();
		GridBagConstraints gbc_tf_volFI = new GridBagConstraints();
		gbc_tf_volFI.insets = new Insets(0, 0, 10, 15);
		gbc_tf_volFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_volFI.gridx = 4;
		gbc_tf_volFI.gridy = 3;
		panel_TFI.add(tf_volFI, gbc_tf_volFI);	
		
		JLabel lbl_expdateFI = new JLabel("Expiration Date: ");
		GridBagConstraints gbc_lbl_expdateFI = new GridBagConstraints();
		gbc_lbl_expdateFI.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_expdateFI.anchor = GridBagConstraints.EAST;
		gbc_lbl_expdateFI.gridx = 1;
		gbc_lbl_expdateFI.gridy = 4;
		panel_TFI.add(lbl_expdateFI, gbc_lbl_expdateFI);
		
		LocalDate today = LocalDate.now();
		DefaultListModel<LocalDate> expDateModel = new DefaultListModel<LocalDate>();
		expDateModel.addElement(today);
		expDateModel.addElement(today.plusMonths(3));
		expDateModel.addElement(today.plusDays(6));
		expDateModel.addElement(today.minusDays(2));
		expDateList = new JList<LocalDate>();
		DefaultListCellRenderer rendererDateFI = (DefaultListCellRenderer) expDateList.getCellRenderer();
		rendererDateFI.setHorizontalAlignment(JLabel.CENTER);
		expDateList.setModel(expDateModel);
		
		GridBagConstraints gbc_expdateFI = new GridBagConstraints();
		gbc_expdateFI.insets = new Insets(0, 10, 10, 5);
		gbc_expdateFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_expdateFI.gridx = 2;
		gbc_expdateFI.gridy = 4;
		panel_TFI.add(expDateList, gbc_expdateFI);
		
		JLabel lbl_typeFI = new JLabel("Food Item Type: ");
		GridBagConstraints gbc_lbl_typeFI = new GridBagConstraints();
		gbc_lbl_typeFI.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_typeFI.anchor = GridBagConstraints.EAST;
		gbc_lbl_typeFI.gridx = 3;
		gbc_lbl_typeFI.gridy = 4;
		panel_TFI.add(lbl_typeFI, gbc_lbl_typeFI);
		
		DefaultListModel<FoodItemType> typeFIModel = new DefaultListModel<FoodItemType>();
		typeFIModel.addElement(FoodItemType.FRESH);
		typeFIModel.addElement(FoodItemType.FROZEN);
		typeFIList = new JList<FoodItemType>();
		DefaultListCellRenderer rendererTypeFI = (DefaultListCellRenderer) typeFIList.getCellRenderer();
		rendererTypeFI.setHorizontalAlignment(JLabel.CENTER);
		typeFIList.setModel(typeFIModel);
		
		GridBagConstraints gbc_typeFI = new GridBagConstraints();
		gbc_typeFI.insets = new Insets(0, 0, 10, 15);
		gbc_typeFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeFI.gridx = 4;
		gbc_typeFI.gridy = 4;
		panel_TFI.add(typeFIList, gbc_typeFI);
		
		btn_addFI = new JButton("ADD FOOD ITEM TO LIST");
		GridBagConstraints gbc_btn_addFI = new GridBagConstraints();
		gbc_btn_addFI.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_addFI.insets = new Insets(0, 10, 10, 15);
		gbc_btn_addFI.gridwidth = 4;
		gbc_btn_addFI.gridx = 2;
		gbc_btn_addFI.gridy = 5;
		panel_TFI.add(btn_addFI, gbc_btn_addFI);
		btn_addFI.addActionListener(new AddFoodItem());	
		
		fiList = new JList<FoodItem>();
		GridBagConstraints gbc_fiList = new GridBagConstraints();
		gbc_fiList.fill = GridBagConstraints.BOTH;
		gbc_fiList.insets = new Insets(0, 10, 10, 15);
		gbc_fiList.gridwidth = 4;
		gbc_fiList.gridheight = 4;
		gbc_fiList.gridx = 2;
		gbc_fiList.gridy = 6;
		fiList.setBorder(new LineBorder(Color.GREEN.darker()));
		fiList.setModel(model_FI);
		panel_TFI.add(fiList, gbc_fiList);
		
		aux_fiList = new JList();
		aux_fiList.setModel(model_FI);
		
		btn_delFI = new JButton("DELETE");
		GridBagConstraints gbc_btn_delFI = new GridBagConstraints();
		gbc_btn_delFI.fill = GridBagConstraints.BOTH;
		gbc_btn_delFI.insets = new Insets(0, 10, 10, 5);
		gbc_btn_delFI.gridheight = 2;
		gbc_btn_delFI.gridx = 1;
		gbc_btn_delFI.gridy = 6;
		panel_TFI.add(btn_delFI, gbc_btn_delFI);
		btn_delFI.addActionListener(new IndependentClassListenerFI(fiList, fooditems));
		
		btn_edtFI = new JButton("EDIT");
		GridBagConstraints gbc_btn_edtFI = new GridBagConstraints();
		gbc_btn_edtFI.fill = GridBagConstraints.BOTH;
		gbc_btn_edtFI.insets = new Insets(0, 10, 10, 5);
		gbc_btn_edtFI.gridheight = 2;
		gbc_btn_edtFI.gridx = 1;
		gbc_btn_edtFI.gridy = 8;
		panel_TFI.add(btn_edtFI, gbc_btn_edtFI);
		btn_edtFI.addActionListener(new EditFoodItem());
		
		/* *****************************************************************************
		 * ******************* Business Facility TAB ***********************************
		 * *****************************************************************************/
		
		JPanel panel_TBF = new JPanel();
		panel_TBF.setBorder(new LineBorder(Color.RED.darker()));
		tabbedPane.addTab("Business Facilities", null, panel_TBF, null);
		
		GridBagLayout gbl_panel_TBF = new GridBagLayout();
		gbl_panel_TBF.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TBF.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TBF.columnWeights = new double[]{0.0, 0.0, 0.2, 0.0, 0.2, 0.0, Double.MIN_VALUE};
		gbl_panel_TBF.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		panel_TBF.setLayout(gbl_panel_TBF);
		
		JLabel lbl_TBF = new JLabel("Add a Business Facility");
		lbl_TBF.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_TBF = new GridBagConstraints();
		gbc_lbl_TBF.gridwidth = 4;
		gbc_lbl_TBF.insets = new Insets(10, 0, 15, 0);
		gbc_lbl_TBF.gridx = 1;
		gbc_lbl_TBF.gridy = 0;
		panel_TBF.add(lbl_TBF, gbc_lbl_TBF);
		
		JLabel lbl_nameBF = new JLabel("Add Name: ");
		GridBagConstraints gbc_lbl_nameBF = new GridBagConstraints();
		gbc_lbl_nameBF.anchor = GridBagConstraints.EAST;
		gbc_lbl_nameBF.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_nameBF.gridx = 1;
		gbc_lbl_nameBF.gridy = 2;
		panel_TBF.add(lbl_nameBF, gbc_lbl_nameBF);
		
		tf_nameBF = new JTextField();
		GridBagConstraints gbc_tf_nameBF = new GridBagConstraints();
		gbc_tf_nameBF.insets = new Insets(0, 10, 10, 15);
		gbc_tf_nameBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nameBF.gridwidth = 4;
		gbc_tf_nameBF.gridx = 2;
		gbc_tf_nameBF.gridy = 2;
		panel_TBF.add(tf_nameBF, gbc_tf_nameBF);
		
		JLabel lbl_ltnBF = new JLabel("Add Location: ");
		GridBagConstraints gbc_lbl_ltnBF = new GridBagConstraints();
		gbc_lbl_ltnBF.anchor = GridBagConstraints.EAST;
		gbc_lbl_ltnBF.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_ltnBF.gridx = 1;
		gbc_lbl_ltnBF.gridy = 3;
		panel_TBF.add(lbl_ltnBF, gbc_lbl_ltnBF);
		
		DefaultListModel model_locBF = new DefaultListModel();
		Location locBF = new Location("Tarragona", "Catalonia");
		Location locBF2 = new Location("Toulouse", "France");
		Location locBF3 = new Location("Frankfurt", "Germany");
		Location locBF4 = new Location("Maribor", "Slovenia");
		model_locBF.addElement(locBF);
		model_locBF.addElement(locBF2);
		model_locBF.addElement(locBF3);
		model_locBF.addElement(locBF4);
		locListBF = new JList();
		DefaultListCellRenderer renderer_locBF = (DefaultListCellRenderer) locListBF.getCellRenderer();
		renderer_locBF.setHorizontalAlignment(JLabel.CENTER);
		locListBF.setModel(model_locBF);
		
		GridBagConstraints gbc_lst_ltnBF = new GridBagConstraints();
		gbc_lst_ltnBF.anchor = GridBagConstraints.EAST;
		gbc_lst_ltnBF.insets = new Insets(0, 10, 10, 5);
		gbc_lst_ltnBF.fill = GridBagConstraints.BOTH;
		gbc_lst_ltnBF.gridx = 2;
		gbc_lst_ltnBF.gridy = 3;
		panel_TBF.add(locListBF, gbc_lst_ltnBF);
		
		JLabel lbl_selBF = new JLabel("Select Business Facility: ");
		GridBagConstraints gbc_lbl_selBF = new GridBagConstraints();
		gbc_lbl_selBF.anchor = GridBagConstraints.EAST;
		gbc_lbl_selBF.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_selBF.gridx = 3;
		gbc_lbl_selBF.gridy = 3;
		panel_TBF.add(lbl_selBF, gbc_lbl_selBF);
		
		aux_bfList = new JList();
		aux_bfList.setModel(model_WH);
		aux_bfList2 = new JList();
		aux_bfList2.setModel(modelBF);
		
		DefaultListModel auxModel = new DefaultListModel();
		auxModel.addElement("Warehouse");
		auxModel.addElement("Store");
		list_typeBF = new JList();
		list_typeBF.setModel(auxModel);
		DefaultListCellRenderer renderer_typBF = (DefaultListCellRenderer) list_typeBF.getCellRenderer();
		renderer_typBF.setHorizontalAlignment(JLabel.CENTER);
		
		GridBagConstraints gbc_list_typeBF = new GridBagConstraints();
		gbc_list_typeBF.anchor = GridBagConstraints.EAST;
		gbc_list_typeBF.insets = new Insets(0, 10, 10, 15);
		gbc_list_typeBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_list_typeBF.gridx = 4;
		gbc_list_typeBF.gridy = 3;
		panel_TBF.add(list_typeBF, gbc_list_typeBF);	
		
		JLabel lbl_capBF = new JLabel("Capacity: ");
		lbl_capBF.setVisible(false);
		GridBagConstraints gbc_lbl_capBF = new GridBagConstraints();
		gbc_lbl_capBF.anchor = GridBagConstraints.EAST;
		gbc_lbl_capBF.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_capBF.gridx = 1;
		gbc_lbl_capBF.gridy = 4;
		panel_TBF.add(lbl_capBF, gbc_lbl_capBF);
		
		tf_capBF = new JTextField();
		tf_capBF.setVisible(false);
		GridBagConstraints gbc_tf_capBF = new GridBagConstraints();
		gbc_tf_capBF.insets = new Insets(0, 10, 10, 15);
		gbc_tf_capBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_capBF.gridwidth = 4;
		gbc_tf_capBF.gridx = 2;
		gbc_tf_capBF.gridy = 4;
		panel_TBF.add(tf_capBF, gbc_tf_capBF);	
		
		list_typeBF.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_typeBF.getSelectedValue() == "Warehouse") {
					lbl_capBF.setVisible(true);
					tf_capBF.setVisible(true);
				}else {
					lbl_capBF.setVisible(false);
					tf_capBF.setVisible(false);
				}
			}
		});
		
		bf = new JList();
		bf.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(bf.getSelectedValue() instanceof Warehouse) list_typeBF.setSelectedIndex(0);
				else list_typeBF.setSelectedIndex(1);
			}	
		});
		
		JButton btn_addBF = new JButton("ADD BUSINESS FACILITY TO LIST");
		GridBagConstraints gbc_btn_addBF = new GridBagConstraints();
		gbc_btn_addBF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_addBF.gridwidth = 4;
		gbc_btn_addBF.insets = new Insets(0, 10, 10, 15);
		gbc_btn_addBF.gridx = 2;
		gbc_btn_addBF.gridy = 5;
		panel_TBF.add(btn_addBF, gbc_btn_addBF);
		
		btn_addBF.addActionListener(new AddBusinessFacility());
		
		GridBagConstraints gbc_bf = new GridBagConstraints();
		gbc_bf.fill = GridBagConstraints.BOTH;
		gbc_bf.insets = new Insets(0, 10, 10, 15);
		gbc_bf.gridwidth = 3;
		gbc_bf.gridheight = 4;
		gbc_bf.gridx = 2;
		gbc_bf.gridy = 6;
		bf.setBorder(new LineBorder(Color.RED.darker()));
		bf.setModel(modelBF);
		panel_TBF.add(bf, gbc_bf);
		
		btn_delBF = new JButton("DELETE");
		GridBagConstraints gbc_btn_delBF = new GridBagConstraints();
		gbc_btn_delBF.fill = GridBagConstraints.BOTH;
		gbc_btn_delBF.insets = new Insets(0, 10, 10, 5);
		gbc_btn_delBF.gridheight = 2;
		gbc_btn_delBF.gridx = 1;
		gbc_btn_delBF.gridy = 6;
		panel_TBF.add(btn_delBF, gbc_btn_delBF);
		
		btn_delBF.addActionListener(new IndependentClassListenerBF(bf, bfList));
		
		btn_edtBF = new JButton("EDIT");
		GridBagConstraints gbc_btn_edtBF = new GridBagConstraints();
		gbc_btn_edtBF.fill = GridBagConstraints.BOTH;
		gbc_btn_edtBF.insets = new Insets(0, 10, 10, 5);
		gbc_btn_edtBF.gridheight = 2;
		gbc_btn_edtBF.gridx = 1;
		gbc_btn_edtBF.gridy = 8;
		panel_TBF.add(btn_edtBF, gbc_btn_edtBF);
		
		btn_edtBF.addActionListener(new EditBusinessFacility());
		
		
		/* *****************************************************************************
		 * ************************ Vehicle TAB ****************************************
		 * *****************************************************************************/
		
		list_typeV = new JList();
		list_typeV.setModel(modelVH);
		vh = new JList();
		vh.setModel(modelVH);
		
		JPanel panel_TV = new JPanel();
		panel_TV.setBorder(new LineBorder(Color.BLUE));
		tabbedPane.addTab("Vehicle", null, panel_TV, null);
		
		GridBagLayout gbl_panel_TV = new GridBagLayout();
		gbl_panel_TV.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TV.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_TV.columnWeights = new double[]{0.0, 0.0, 0.25, 0.0, 0.25, 0.0, Double.MIN_VALUE};
		gbl_panel_TV.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		panel_TV.setLayout(gbl_panel_TV);
				
		JLabel lbl_addV = new JLabel("Add a Vehicle");
		lbl_addV.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_addV = new GridBagConstraints();
		gbc_lbl_addV.gridwidth = 4;
		gbc_lbl_addV.insets = new Insets(10, 0, 15, 0);
		gbc_lbl_addV.gridx = 1;
		gbc_lbl_addV.gridy = 0;
		panel_TV.add(lbl_addV, gbc_lbl_addV);
		
		JLabel lbl_regnV = new JLabel("Add Regist Num: ");
		GridBagConstraints gbc_lbl_regnV = new GridBagConstraints();
		gbc_lbl_regnV.anchor = GridBagConstraints.EAST;
		gbc_lbl_regnV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_regnV.gridx = 1;
		gbc_lbl_regnV.gridy = 1;
		panel_TV.add(lbl_regnV, gbc_lbl_regnV);
		
		tf_regnV = new JTextField();
		GridBagConstraints gbc_tf_rgnV = new GridBagConstraints();
		gbc_tf_rgnV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_rgnV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_rgnV.gridwidth = 4;
		gbc_tf_rgnV.gridx = 2;
		gbc_tf_rgnV.gridy = 1;
		panel_TV.add(tf_regnV, gbc_tf_rgnV);
		
		JLabel lbl_avspV = new JLabel("Add Average Speed: ");
		GridBagConstraints gbc_lbl_avspV = new GridBagConstraints();
		gbc_lbl_avspV.anchor = GridBagConstraints.EAST;
		gbc_lbl_avspV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_avspV.gridx = 1;
		gbc_lbl_avspV.gridy = 2;
		panel_TV.add(lbl_avspV, gbc_lbl_avspV);
		
		tf_avspV = new JTextField();
		GridBagConstraints gbc_tf_avspV = new GridBagConstraints();
		gbc_tf_avspV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_avspV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_avspV.gridx = 2;
		gbc_tf_avspV.gridy = 2;
		panel_TV.add(tf_avspV, gbc_tf_avspV);
		
		JLabel lbl_volV = new JLabel("Add Volume: ");
		GridBagConstraints gbc_lbl_volV = new GridBagConstraints();
		gbc_lbl_volV.anchor = GridBagConstraints.EAST;
		gbc_lbl_volV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_volV.gridx = 3;
		gbc_lbl_volV.gridy = 2;
		panel_TV.add(lbl_volV, gbc_lbl_volV);
		
		tf_volV = new JTextField();
		GridBagConstraints gbc_tf_volV = new GridBagConstraints();
		gbc_tf_volV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_volV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_volV.gridx = 4;
		gbc_tf_volV.gridy = 2;
		panel_TV.add(tf_volV, gbc_tf_volV);
		
		JLabel lbl_mxwV = new JLabel("Add Max Weight: ");
		GridBagConstraints gbc_lbl_mxwV = new GridBagConstraints();
		gbc_lbl_mxwV.anchor = GridBagConstraints.EAST;
		gbc_lbl_mxwV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_mxwV.gridx = 1;
		gbc_lbl_mxwV.gridy = 3;
		panel_TV.add(lbl_mxwV, gbc_lbl_mxwV);
		
		tf_mxwV = new JTextField();
		GridBagConstraints gbc_tf_mxwV = new GridBagConstraints();
		gbc_tf_mxwV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_mxwV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_mxwV.gridx = 2;
		gbc_tf_mxwV.gridy = 3;
		panel_TV.add(tf_mxwV, gbc_tf_mxwV);
		
		JLabel lbl_capV = new JLabel("Capacity: ");
		GridBagConstraints gbc_lbl_capV = new GridBagConstraints();
		gbc_lbl_capV.anchor = GridBagConstraints.EAST;
		gbc_lbl_capV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_capV.gridx = 3;
		gbc_lbl_capV.gridy = 3;
		panel_TV.add(lbl_capV, gbc_lbl_capV);
		
		tf_capV = new JTextField();
		GridBagConstraints gbc_tf_capV = new GridBagConstraints();
		gbc_tf_capV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_capV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_capV.gridwidth = 4;
		gbc_tf_capV.gridx = 4;
		gbc_tf_capV.gridy = 3;
		panel_TV.add(tf_capV, gbc_tf_capV);	
		
		JLabel lbl_typV = new JLabel("Vehicle Type: ");
		GridBagConstraints gbc_lbl_typV = new GridBagConstraints();
		gbc_lbl_typV.anchor = GridBagConstraints.EAST;
		gbc_lbl_typV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_typV.gridx = 1;
		gbc_lbl_typV.gridy = 4;
		panel_TV.add(lbl_typV, gbc_lbl_typV);
		
		DefaultListModel aux_modelV = new DefaultListModel();
		aux_modelV.addElement("Truck");
		aux_modelV.addElement("Van");
		aux_list_typeV = new JList();
		aux_list_typeV.setModel(aux_modelV);
		DefaultListCellRenderer renderer_typV = (DefaultListCellRenderer) aux_list_typeV.getCellRenderer();
		renderer_typV.setHorizontalAlignment(JLabel.CENTER);
		aux_list_typeV.setModel(aux_modelV);
		
		GridBagConstraints gbc_list_typeV = new GridBagConstraints();
		gbc_list_typeV.anchor = GridBagConstraints.EAST;
		gbc_list_typeV.insets = new Insets(0, 10, 10, 15);
		gbc_list_typeV.fill = GridBagConstraints.HORIZONTAL;
		gbc_list_typeV.gridx = 2;
		gbc_list_typeV.gridy = 4;
		panel_TV.add(aux_list_typeV, gbc_list_typeV);
	
		JLabel lbl_ntrV = new JLabel("Trailers num: ");
		lbl_ntrV.setVisible(false);
		GridBagConstraints gbc_lbl_ntrV = new GridBagConstraints();
		gbc_lbl_ntrV.anchor = GridBagConstraints.EAST;
		gbc_lbl_ntrV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_ntrV.gridx = 3;
		gbc_lbl_ntrV.gridy = 4;
		panel_TV.add(lbl_ntrV, gbc_lbl_ntrV);
		
		tf_ntrV = new JTextField();
		tf_ntrV.setVisible(false);
		GridBagConstraints gbc_tf_ntrV = new GridBagConstraints();
		gbc_tf_ntrV.insets = new Insets(0, 10, 10, 15);
		gbc_tf_ntrV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ntrV.gridwidth = 4;
		gbc_tf_ntrV.gridx = 4;
		gbc_tf_ntrV.gridy = 4;
		panel_TV.add(tf_ntrV, gbc_tf_ntrV);
		
		aux_list_typeV.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (aux_list_typeV.getSelectedValue() == "Truck") {
					lbl_ntrV.setVisible(true);
					tf_ntrV.setVisible(true);
				}else {
					lbl_ntrV.setVisible(false);
					tf_ntrV.setVisible(false);
				}
			}
		});
		
		JLabel lbl_tvnV = new JLabel("Cargo type: ");
		lbl_tvnV.setVisible(false);
		GridBagConstraints gbc_lbl_tvnV = new GridBagConstraints();
		gbc_lbl_tvnV.anchor = GridBagConstraints.EAST;
		gbc_lbl_tvnV.insets = new Insets(0, 10, 10, 5);
		gbc_lbl_tvnV.gridx = 3;
		gbc_lbl_tvnV.gridy = 4;
		panel_TV.add(lbl_tvnV, gbc_lbl_tvnV);
				
		DefaultListModel typeVanModel = new DefaultListModel();
		typeVanModel.addElement(FoodItemType.FRESH);
		typeVanModel.addElement(FoodItemType.FROZEN);
		typeVanList = new JList();
		typeVanList.setVisible(false);
		DefaultListCellRenderer rendererTypeVan = (DefaultListCellRenderer) typeVanList.getCellRenderer();
		rendererTypeVan.setHorizontalAlignment(JLabel.CENTER);
		typeVanList.setModel(typeVanModel);
		
		GridBagConstraints gbc_typeVan = new GridBagConstraints();
		gbc_typeVan.insets = new Insets(0, 10, 10, 15);
		gbc_typeVan.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeVan.gridx = 4;
		gbc_typeVan.gridy = 4;
		panel_TV.add(typeVanList, gbc_typeVan);
		
		aux_list_typeV.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (aux_list_typeV.getSelectedValue() == "Van") {
					lbl_tvnV.setVisible(true);
					typeVanList.setVisible(true);
				}else {
					lbl_tvnV.setVisible(false);
					typeVanList.setVisible(false);
				}
			}
		});
		
		vh.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(vh.getSelectedValue() instanceof Truck) aux_list_typeV.setSelectedIndex(0); 
				else aux_list_typeV.setSelectedIndex(1); 
			}
		});
		
		JButton btn_addV = new JButton("ADD VEHICLE TO LIST");
		GridBagConstraints gbc_btn_addV = new GridBagConstraints();
		gbc_btn_addV.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_addV.gridwidth = 4;
		gbc_btn_addV.insets = new Insets(0, 10, 10, 15);
		gbc_btn_addV.gridx = 2;
		gbc_btn_addV.gridy = 5;
		panel_TV.add(btn_addV, gbc_btn_addV);
		
		btn_addV.addActionListener(new AddVehicle());

		GridBagConstraints gbc_vh = new GridBagConstraints();
		gbc_vh.fill = GridBagConstraints.BOTH;
		gbc_vh.insets = new Insets(0, 10, 10, 15);
		gbc_vh.gridwidth = 3;
		gbc_vh.gridheight = 4;
		gbc_vh.gridx = 2;
		gbc_vh.gridy = 6;
		vh.setBorder(new LineBorder(Color.BLUE));
		vh.setModel(modelVH);
		panel_TV.add(vh, gbc_vh);
		
		btn_delV = new JButton("DELETE");
		GridBagConstraints gbc_btn_delV = new GridBagConstraints();
		gbc_btn_delV.fill = GridBagConstraints.BOTH;
		gbc_btn_delV.insets = new Insets(0, 10, 10, 5);
		gbc_btn_delV.gridheight = 2;
		gbc_btn_delV.gridx = 1;
		gbc_btn_delV.gridy = 6;
		panel_TV.add(btn_delV, gbc_btn_delV);
		
		btn_delV.addActionListener(new IndependentClassListenerVH(vh, vhList));
		
		btn_edtV = new JButton("EDIT");
		GridBagConstraints gbc_btn_edtV = new GridBagConstraints();
		gbc_btn_edtV.fill = GridBagConstraints.BOTH;
		gbc_btn_edtV.insets = new Insets(0, 10, 10, 5);
		gbc_btn_edtV.gridheight = 2;
		gbc_btn_edtV.gridx = 1;
		gbc_btn_edtV.gridy = 8;
		panel_TV.add(btn_edtV, gbc_btn_edtV);
		
		btn_edtV.addActionListener(new EditVehicle());
		
		/* *****************************************************************************
		 * ************************ ADD ITEMS TO WAREHOUSE TAB *************************
		 * *****************************************************************************/
		JPanel panel_AFIW = new JPanel();
		panel_AFIW.setBorder(new LineBorder(Color.YELLOW.darker()));
		tabbedPane.addTab("Add FI to Warehouse", null, panel_AFIW, null);
		
		GridBagLayout gbl_panel_AFIW = new GridBagLayout();
		gbl_panel_AFIW.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_AFIW.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_AFIW.columnWeights = new double[]{0.0, 0.0, 0.2, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_AFIW.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_AFIW.setLayout(gbl_panel_AFIW);
				
		JLabel lbl_AFIW = new JLabel("Add Food Items to Warehouse");
		lbl_AFIW.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_AFIW = new GridBagConstraints();
		gbc_lbl_AFIW.gridwidth = 4;
		gbc_lbl_AFIW.insets = new Insets(10, 0, 15, 0);
		gbc_lbl_AFIW.gridx = 1;
		gbc_lbl_AFIW.gridy = 0;
		panel_AFIW.add(lbl_AFIW, gbc_lbl_AFIW);
		
		GridBagConstraints gbc_w = new GridBagConstraints();
		gbc_w.fill = GridBagConstraints.BOTH;
		gbc_w.insets = new Insets(15, 10, 10, 15);
		gbc_w.gridwidth = 4;
		gbc_w.gridheight = 3;
		gbc_w.gridx = 2;
		gbc_w.gridy = 1;
		aux_bfList.setBorder(new LineBorder(Color.YELLOW.darker()));
		panel_AFIW.add(aux_bfList, gbc_w);
		
		JButton btn_AFIW = new JButton("ADD FOOD ITEM TO WAREHOUSE");
		GridBagConstraints gbc_btn_AFIW  = new GridBagConstraints();
		gbc_btn_AFIW.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_AFIW.gridwidth = 4;
		gbc_btn_AFIW .insets = new Insets(0, 10, 10, 15);
		gbc_btn_AFIW .gridx = 1;
		gbc_btn_AFIW .gridy = 5;
		panel_AFIW .add(btn_AFIW , gbc_btn_AFIW );
		
		GridBagConstraints gbc_food = new GridBagConstraints();
		gbc_food.fill = GridBagConstraints.BOTH;
		gbc_food.insets = new Insets(0, 10, 10, 15);
		gbc_food.gridwidth = 4;
		gbc_food.gridheight = 3;
		gbc_food.gridx = 2;
		gbc_food.gridy = 6;
		aux_fiList.setBorder(new LineBorder(Color.YELLOW.darker()));
		panel_AFIW.add(aux_fiList, gbc_food);
		
		btn_AFIW.addActionListener(new IndependentClassListenerAFIW(aux_fiList, aux_bfList, fooditems, warehouses));
		
		/* *****************************************************************************
		 * ************************ LOAD/UNLOAD VEHICLES TAB ***************************
		 * *****************************************************************************/
		JPanel panel_LUV = new JPanel();
		panel_LUV.setBorder(new LineBorder(Color.PINK.darker()));
		tabbedPane.addTab("Load/Unload Vehicles", null, panel_LUV, null);
		
		GridBagLayout gbl_panel_LUV = new GridBagLayout();
		gbl_panel_LUV.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_LUV.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_LUV.columnWeights = new double[]{0.0, 0.0, 0.2, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_LUV.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 ,0.0, 0.0,Double.MIN_VALUE};
		panel_LUV.setLayout(gbl_panel_LUV);
				
		JLabel lbl_LUV = new JLabel("Load/Unload Vehicles");
		lbl_LUV.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_LUV = new GridBagConstraints();
		gbc_lbl_LUV.gridwidth = 4;
		gbc_lbl_LUV.insets = new Insets(10, 0, 15, 0);
		gbc_lbl_LUV.gridx = 1;
		gbc_lbl_LUV.gridy = 0;
		panel_LUV.add(lbl_LUV, gbc_lbl_LUV);
		
		GridBagConstraints gbc_aux_bf  = new GridBagConstraints();
		gbc_aux_bf.fill = GridBagConstraints.HORIZONTAL;
		gbc_aux_bf.gridwidth = 4;
		gbc_aux_bf.insets = new Insets(10, 10, 10, 15);
		gbc_aux_bf.gridx = 2;
		gbc_aux_bf.gridy = 1;
		panel_LUV.add(aux_bfList2 , gbc_aux_bf );
		
		JButton btn_LUV = new JButton("LOAD(W)/UNLOAD(S) VEHICLES");
		GridBagConstraints gbc_btn_LUV  = new GridBagConstraints();
		gbc_btn_LUV.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_LUV.gridwidth = 4;
		gbc_btn_LUV .insets = new Insets(10, 10, 10, 15);
		gbc_btn_LUV .gridx = 1;
		gbc_btn_LUV .gridy = 5;
		panel_LUV.add(btn_LUV , gbc_btn_LUV );
		
		GridBagConstraints gbc_aux_tv  = new GridBagConstraints();
		gbc_aux_tv .fill = GridBagConstraints.HORIZONTAL;
		gbc_aux_tv .gridwidth = 4;
		gbc_aux_tv .insets = new Insets(10, 10, 10, 15);
		gbc_aux_tv .gridx = 2;
		gbc_aux_tv .gridy = 6;
		panel_LUV.add(list_typeV , gbc_aux_tv );
		
		btn_LUV.addActionListener(new IndependentClassListenerLUV(aux_bfList2, list_typeV));
	}

	/* *****************************************************************************
	 * ************************ ACTION LISTENERS ***********************************
	 * *****************************************************************************/
	
	class AddFoodItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				
			if(tf_lblFI.getText()!="" && tf_wgtFI.getText()!="" && tf_volFI.getText()!="" &&
					expDateList.getSelectedIndex()>=0 && typeFIList.getSelectedIndex()>=0) {
				
				String aux_tf_lblFI = tf_lblFI.getText();
				double aux_tf_wgtFI = Double.parseDouble(tf_wgtFI.getText());
				double aux_tf_volFI = Double.parseDouble(tf_volFI.getText());
				LocalDate aux_expDate = (LocalDate)expDateList.getSelectedValue();
				FoodItemType aux_typeFI = (FoodItemType)typeFIList.getSelectedValue();
				FoodItem new_FI = new FoodItem(aux_tf_wgtFI, aux_tf_lblFI, aux_tf_volFI, aux_expDate, aux_typeFI);
				model_FI.addElement(new_FI);
				fooditems.add(new_FI);
			}
			typeFIList.setSelectedIndex(-1);
			expDateList.setSelectedIndex(-1);
			tf_lblFI.setText("");
			tf_wgtFI.setText("");
			tf_volFI.setText("");
		}
	}
	
	class EditFoodItem implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(fiList.getSelectedIndex()>=0) {
				int i = fiList.getSelectedIndex();
				FoodItem auxFI = fooditems.get(i);
				auxFI.setLabel(tf_lblFI.getText());
				auxFI.setWeight(Double.parseDouble(tf_wgtFI.getText()));
				auxFI.setVolume(Double.parseDouble(tf_volFI.getText()));
				auxFI.setExpirationDate((LocalDate)expDateList.getSelectedValue());
				auxFI.setType((FoodItemType)typeFIList.getSelectedValue());
				model_FI.set(i, auxFI);
			}
			typeFIList.setSelectedIndex(-1);
			expDateList.setSelectedIndex(-1);
			tf_lblFI.setText("");
			tf_wgtFI.setText("");
			tf_volFI.setText("");
		}
	}
	
	class AddBusinessFacility implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(tf_nameBF.getText()!="" && list_typeBF.getSelectedIndex()>=0 && 
					locListBF.getSelectedIndex()>=0) {
				String aux_nameBF = tf_nameBF.getText();
				Location aux_locBF = (Location)locListBF.getSelectedValue();
				if(list_typeBF.getSelectedIndex()==0 && tf_capBF.getText()!="") {
					int aux_capBF = Integer.parseInt(tf_capBF.getText());
					Warehouse aux_warBF = new Warehouse(aux_nameBF, aux_locBF, aux_capBF);
					model_WH.addElement(aux_warBF);
					warehouses.add(aux_warBF);
					bfList.add(aux_warBF);
					modelBF.addElement(aux_warBF);
				}else {
					if(list_typeBF.getSelectedIndex()==1) {
						Store aux_strBF = new Store(aux_nameBF, aux_locBF);
						bfList.add(aux_strBF);
						modelBF.addElement(aux_strBF);
					}
				}
			}
			list_typeBF.setSelectedIndex(-1);
			tf_nameBF.setText("");
			locListBF.setSelectedIndex(-1);
			tf_capBF.setText("");
		}
	}
	
	class EditBusinessFacility implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(bf.getSelectedIndex()>=0) {	
				int i = bf.getSelectedIndex();
				BusinessFacility auxBF = bfList.get(i);
				auxBF.setName(tf_nameBF.getText());
				Location auxLoc = (Location)locListBF.getSelectedValue();
				System.out.println(auxLoc);
				auxBF.setLocation(auxLoc);
				if(auxBF instanceof Warehouse) {
					((Warehouse)auxBF).setFoodItemsArray(new FoodItem[Integer.parseInt(tf_capBF.getText())]);
				}
				modelBF.set(i, auxBF);
			}
			list_typeBF.setSelectedIndex(-1);
			tf_nameBF.setText("");
			locListBF.setSelectedIndex(-1);
			tf_capBF.setText("");
		}
	}
	
	class AddVehicle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(tf_regnV.getText()!="" && tf_avspV.getText()!="" &&
					tf_volV.getText()!="" && tf_mxwV.getText()!="" &&
					tf_capV.getText()!="") {
				int auxRegNum = Integer.parseInt(tf_regnV.getText());
				double auxVol = Double.parseDouble(tf_volV.getText());
				int auxMxW = Integer.parseInt(tf_mxwV.getText());
				double auxAvS = Double.parseDouble(tf_avspV.getText());
				int auxCapV = Integer.parseInt(tf_capV.getText());
				if(aux_list_typeV.getSelectedValue() == "Truck" && tf_ntrV.getText()!="") {
					int auxNTr = Integer.parseInt(tf_ntrV.getText());
					Truck auxTruck = new Truck(auxRegNum, auxVol, auxMxW, auxAvS, auxCapV, auxNTr);
					modelVH.addElement(auxTruck);
					vhList.add(auxTruck);
				}else {
					if(aux_list_typeV.getSelectedValue() == "Van" && typeVanList.getSelectedIndex()>=0) {
						FoodItemType aux_typeVan = (FoodItemType)typeVanList.getSelectedValue();
						Van auxVan = new Van(auxRegNum, auxVol, auxMxW, auxAvS, auxCapV, aux_typeVan);
						modelVH.addElement(auxVan);
						vhList.add(auxVan);
					}
				}
			}
			tf_regnV.setText("");
			tf_volV.setText("");
			tf_mxwV.setText("");
			tf_avspV.setText("");
			tf_capV.setText("");
			tf_ntrV.setText("");
			aux_list_typeV.setSelectedIndex(-1);
		}
	}
	
	class EditVehicle implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(vh.getSelectedIndex()>=0) {
				int i = vh.getSelectedIndex();
				Vehicle auxV = vhList.get(i);
				auxV.setRegistrationNumber(Integer.parseInt(tf_regnV.getText()));
				auxV.setAverageSpeed(Double.parseDouble(tf_avspV.getText()));
				auxV.setMaxWeight(Integer.parseInt(tf_mxwV.getText()));
				auxV.setVolume(Double.parseDouble(tf_volV.getText()));
				auxV.setCargo(new FoodItem[Integer.parseInt(tf_capV.getText())]);
				if(auxV instanceof Truck) {
					((Truck)auxV).setNumberOfTrailers(Integer.parseInt(tf_ntrV.getText()));
				}else {
					((Van)auxV).setType((FoodItemType)typeVanList.getSelectedValue());
				}
				modelVH.set(i, auxV);
			}
			tf_regnV.setText("");
			tf_volV.setText("");
			tf_mxwV.setText("");
			tf_avspV.setText("");
			tf_capV.setText("");
			tf_ntrV.setText("");
			aux_list_typeV.setSelectedIndex(-1);
		}
	}
	
}
