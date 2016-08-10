package com.apps.ma.ui;

import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.apps.ma.template.MetadataAnalyzer;
import com.apps.ma.multicasting.MulticastingUtility;

public class MetadataAnalyzerUI extends javax.swing.JFrame {

	public int setProcessingTime=0;
	public boolean addChannelFlag = false;
	public boolean deleteChannelFlag = false;
	public boolean updateChannelFlag=false;
	public boolean defaultChannelData=true;	
	public final String addChannel = "ADDCHANNEL";
	public final String deleteChannel = "DELETECHANNEL";
	public final String updateChannelData = "UPDATEDATA";
	
	public JButton updateButton;
	public Object[][] tableRowData;
	public String[] tableColumnHeaders;
	
	public DefaultTableModel createChannelListing;	
	public MulticastingUtility mUtils = new MulticastingUtility();
	public List<Integer> addSelectedRows = new ArrayList<Integer>();
	public MetadataAnalyzerUI() {
		initComponents();
		
	}

@SuppressWarnings("unchecked")

private void initComponents()
{
	jButton5 = new javax.swing.JButton();
	jButton6 = new javax.swing.JButton();
	jButton7 = new javax.swing.JButton();
	jPanel1 = new javax.swing.JPanel();
	jLabel1 = new javax.swing.JLabel();
	jPanel2 = new javax.swing.JPanel();
	jScrollPane2 = new javax.swing.JScrollPane();
	jTable2 = new javax.swing.JTable();
	jPanel5 = new javax.swing.JPanel();
	jLabel4 = new javax.swing.JLabel();
	jButton3 = new javax.swing.JButton();
	jButton4 = new javax.swing.JButton();
	jProgressBar2 = new javax.swing.JProgressBar();
	jPanel6 = new javax.swing.JPanel();
	jLabel3 = new javax.swing.JLabel();
	jPanel4 = new javax.swing.JPanel();
	Slider1 = new javax.swing.JSlider();
	jButton8 = new javax.swing.JButton();
	value_int = new javax.swing.JTextField();
	jLabel6 = new javax.swing.JLabel();
	jPanel8 = new javax.swing.JPanel();
	jLabel5 = new javax.swing.JLabel();
	jTextField1 = new javax.swing.JTextField();
	jButton13 = new javax.swing.JButton();
	jButton14 = new javax.swing.JButton();
	jTabbedPane2 = new javax.swing.JTabbedPane();
	jScrollPane1 = new javax.swing.JScrollPane();
	jTextPane1 = new javax.swing.JTextPane();
	jScrollPane3 = new javax.swing.JScrollPane();
	jTextPane2 = new javax.swing.JTextPane();
	jTextField2 = new javax.swing.JTextField();
	jScrollPane4 = new javax.swing.JScrollPane();
	jTextPane3 = new javax.swing.JTextPane();
	jLabel7 = new javax.swing.JLabel();
	jPanel3 = new javax.swing.JPanel();
	jButton1 = new javax.swing.JButton();
	jButton2 = new javax.swing.JButton();
	updateButton = new javax.swing.JButton();
	jLabel2 = new javax.swing.JLabel();
	jButton5.setText("jButton5");
	jButton6.setText("jButton6");
	jButton7.setText("jButton7");
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	jLabel1.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N	
	jLabel1.setForeground(new java.awt.Color(51, 51, 0));
	jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	jLabel1.setText("META DATA ANALYZER");
	jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration"));
	jPanel2.setFont(new java.awt.Font("Californian FB", 1, 24));
	
		/*
		 * below code creates the Channel listing table.
		 */
	
      	jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	    jTable2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12));
	    tableRowData = new Object[][]{
	            {"Universal-HD", "232.36.124.202", "10.22.122.113", "36202,36203,36204,36205,36206",  new Boolean(false)},
	            {"Fox_News_SD", "232.36.124.203", "10.22.122.113", "36203,36204,36205",  new Boolean(false)},
	            {"Golf_SD", "232.36.124.205", "10.22.122.113", "36205,36206,36207,36208",  new Boolean(false)},
	            {"USA_SD", "232.36.124.206", "10.22.122.113", "36209,36206,36207,36208",  new Boolean(false)},
	            {"HLN_HD", "232.36.124.201", "10.22.122.113", "36201,36202,36203,36204,36205",  new Boolean(false)},
	            {"Venezuela_SD", "232.36.124.64", "10.22.122.127", "3664,3665,3666,3667",  new Boolean(false)},
	            {"ESPN_SD", "232.36.124.65", "10.22.122.127", "3665,3666,3667,3668",  new Boolean(false)},
	            {"Hallmark_SD", "232.36.124.66", "10.22.122.127", "3666,3667,3668,3669",  new Boolean(false)},
	            {"Teen_Nick_SD", "232.36.124.67", "10.22.122.127", "3667,3668,3669,3670",  new Boolean(false)},
	            {"MTV_Jams_SD", "232.36.124.68", "10.22.122.127", "3668,3669,3670,3671",  new Boolean(false)},
	            {"Mun2_SD", "232.36.124.69", "10.22.122.127", "3669,3670,3671,3672",  new Boolean(false)},
	            {"HSN_SD", "232.36.124.70", "10.22.122.127", "3670,3671,3672,3673",  new Boolean(false)},
	            {"CBSESPORTS_SD", "232.36.124.71", "10.22.122.127", "3671,3672,3673,3674",  new Boolean(false)},
	            {"Spike_SD", "232.36.124.72", "10.22.122.127", "3672,3673,3674,3675",  new Boolean(false)},
	            {"CSPAN_SD", "232.36.124.73", "10.22.122.127", "3673,3674,3675,3676",  new Boolean(false)},
	            {"Esquire_SD", "232.36.124.74", "10.22.122.127", "3674,3675,3676,3677",  new Boolean(false)},
	            {"Discovery_SD", "232.36.124.77", "10.22.122.127", "3677,3678,3679,3678",  new Boolean(false)},
	            {"BigBunny1", "239.0.0.1", "239.0.0.1", "1234,1211",  new Boolean(false)},
	            {"BigBunny2", "239.0.0.1", "239.0.0.1", "1234,1233",  new Boolean(false)},
	            {"BigBunny3", "239.0.0.1", "239.0.0.1", "1234,1211",  new Boolean(false)},
	            {"BigBunny4", "239.0.0.1", "239.0.0.1", "1234,1233",  new Boolean(false)},
	            {"BigBunny5", "239.0.0.1", "239.0.0.1", "1234,1211",  new Boolean(false)},
	            {"BigBunny6", "239.0.0.1", "239.0.0.1", "1234,1233",  new Boolean(false)},
	    		            
	        };
	     tableColumnHeaders = new String[]{
	             "Channels", "Multicast IP", "Gateway IP", "Ports", "Action"
	        };
	     
	    createChannelListing = new DefaultTableModel(tableRowData,tableColumnHeaders) {
	            Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	       };
	    jTable2.setModel(createChannelListing);
	    jTable2.setRowSelectionAllowed(true);
	    jTable2.setColumnSelectionAllowed(false);
	    
	    jTable2.getSelectionModel().addListSelectionListener(
                new RowColumnListSelectionListener());
	    jTable2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    
	   

		jTable2.getTableHeader().setReorderingAllowed(false);
		jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            	jTable2AncestorAdded(evt);
            }           
			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
		jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
			
        });	
		
	jScrollPane2.setViewportView(jTable2);
	
	jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	jLabel4.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
	jLabel4.setText("Completion %");
	jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton3.setText("START");
	jButton3.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			jButton3ActionPerformed(evt);
		}
	});
	
	
	jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton4.setText("ABORT");
	javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
	jPanel5.setLayout(jPanel5Layout);
	jPanel5Layout.setHorizontalGroup(
	jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel5Layout.createSequentialGroup()
		.addGap(46, 46, 46)
		.addComponent(jButton3)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
		.addComponent(jButton4)
		.addGap(72, 72, 72))
		.addGroup(jPanel5Layout.createSequentialGroup()
		.addContainerGap()
		.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel5Layout.createSequentialGroup()
		.addComponent(jLabel4)
		.addGap(0, 0, Short.MAX_VALUE))
		.addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		.addContainerGap())
	);
	jPanel5Layout.setVerticalGroup(
	jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel5Layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(jLabel4)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
		.addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addGap(32, 32, 32)
		.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		.addComponent(jButton3)
		.addComponent(jButton4))
		.addGap(19, 19, 19))
	);
	
	/*
	 *   Set duration using slider..
	 */
	
	jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	jLabel3.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
	jLabel3.setForeground(new java.awt.Color(51, 51, 0));
	jLabel3.setText("Set Timer In Minutes");
	jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
	
	Slider1.setMajorTickSpacing(20);
	Slider1.setMaximum(125);
	Slider1.setMinimum(5);
	Slider1.setMinorTickSpacing(5);
	Slider1.setPaintLabels(true);
	Slider1.setPaintTicks(true);
	
	
	
	javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
	jPanel4.setLayout(jPanel4Layout);
	jPanel4Layout.setHorizontalGroup(
		jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel4Layout.createSequentialGroup()
		.addGap(76, 76, 76)
		.addComponent(Slider1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addContainerGap(35, Short.MAX_VALUE))
		);
	jPanel4Layout.setVerticalGroup(
	jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	.addGroup(jPanel4Layout.createSequentialGroup()
	.addComponent(Slider1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
	.addGap(0, 11, Short.MAX_VALUE))
	);
	jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton8.setText("OK");
	jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	jButton8.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		jButton8ActionPerformed(evt);
		}
	});
	
	jLabel6.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
	jLabel6.setText("Duration In Mins");
	value_int.setText("5");
	javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
	jPanel6.setLayout(jPanel6Layout);
	jPanel6Layout.setHorizontalGroup(
		jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup()
		.addComponent(jLabel3)
		.addGap(0, 0, Short.MAX_VALUE))
		.addGroup(jPanel6Layout.createSequentialGroup()
		.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup()
		.addGap(71, 71, 71)
		.addComponent(jLabel6)
		.addGap(32, 32, 32)
		.addComponent(value_int, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addGap(41, 41, 41)
		.addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addGroup(jPanel6Layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	jPanel6Layout.setVerticalGroup(
	jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup()
		.addComponent(jLabel3)
		.addGap(36, 36, 36)
		.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addGap(18, 18, 18)
		.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		.addComponent(jButton8)
		.addComponent(value_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addComponent(jLabel6))
		.addGap(0, 0, Short.MAX_VALUE))
	);
	
	Slider1.addChangeListener(new ChangeListener(){
		@Override
		public void stateChanged(ChangeEvent evt) {
			
			value_int.setText(String.valueOf(Slider1.getValue()));
		}		
	});
	
	
	jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	jLabel5.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
	jLabel5.setText("LOGS");
	jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton13.setText("Browse Path");
	jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton14.setText("OK");
	jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jScrollPane1.setViewportView(jTextPane1);
	jTabbedPane2.addTab("CC Standards", jScrollPane1);
	jScrollPane3.setViewportView(jTextPane2);
	jTabbedPane2.addTab("Maximum Bitrates", jScrollPane3);
	
	jTextField2.addActionListener(new java.awt.event.ActionListener() {
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		jTextField2ActionPerformed(evt);
		}
	});
	
	jTabbedPane2.addTab("Descriptors", jTextField2);
	jScrollPane4.setViewportView(jTextPane3);
	jTabbedPane2.addTab("Available Audio Lang", jScrollPane4);
	jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
	jLabel7.setText("Export HTML Files");
	javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
	jPanel8.setLayout(jPanel8Layout);
	jPanel8Layout.setHorizontalGroup(
	jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addGap(70, 70, 70)
		.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(jButton13)
		.addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addComponent(jLabel7))))
		.addContainerGap(47, Short.MAX_VALUE))
	);
	jPanel8Layout.setVerticalGroup(
	jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addComponent(jLabel5)
		.addGap(18, 18, 18)
		.addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addGap(48, 48, 48)
		.addComponent(jLabel7)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(jButton13)
		.addGroup(jPanel8Layout.createSequentialGroup()
		.addGap(1, 1, 1)
		.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addGap(48, 48, 48)
		.addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addContainerGap(25, Short.MAX_VALUE))
	);
	jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton1.setText("Add Channel");
	jButton1.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		jButton1ActionPerformed(evt);
		}
	});
	jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	jButton2.setText("Delete Channel");
	jButton2.addActionListener(new java.awt.event.ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Selected Rows: "+jTable2.getSelectedRowCount());
			if(jTable2.getSelectedRowCount() >= 1){
				createChannelListing.removeRow(jTable2.getSelectedRow());
			}
		}		
	});
	
	updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	updateButton.setText("Update Data");
	updateButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		jButton1ActionPerformed(evt);
		}
	});
	
	javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	jPanel3.setLayout(jPanel3Layout);
	jPanel3Layout.setHorizontalGroup(
	jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel3Layout.createSequentialGroup()
		.addContainerGap()
		.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		.addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)		
		.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	);
	jPanel3Layout.setVerticalGroup(
	jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel3Layout.createSequentialGroup()
		.addContainerGap(16, Short.MAX_VALUE)
		.addComponent(jButton1)
		.addGap(18, 18, 18)
		.addComponent(updateButton)
		.addGap(18, 18, 18)
		.addComponent(jButton2)
		.addGap(30, 30, 30))
	);
	javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	jPanel2.setLayout(jPanel2Layout);
	jPanel2Layout.setHorizontalGroup(
	jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel2Layout.createSequentialGroup()
		.addContainerGap()
		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
		.addComponent(jScrollPane2)
		.addGap(18, 18, 18)
		.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addContainerGap())
		.addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addGroup(jPanel2Layout.createSequentialGroup()
		.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addGap(18, 18, 18)
		.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	);
	jPanel2Layout.setVerticalGroup(
	jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel2Layout.createSequentialGroup()
		.addContainerGap()
		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
		.addGap(26, 26, 26)
		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addContainerGap(18, Short.MAX_VALUE))
	);
	jLabel2.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
	jLabel2.setForeground(new java.awt.Color(51, 51, 0));
	jLabel2.setText("");
	javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	jPanel1.setLayout(jPanel1Layout);
	jPanel1Layout.setHorizontalGroup(
	jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		.addGroup(jPanel1Layout.createSequentialGroup()
		.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		.addGap(0, 0, Short.MAX_VALUE))
	);
	jPanel1Layout.setVerticalGroup(
	jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup()
		.addContainerGap()
		.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addGroup(jPanel1Layout.createSequentialGroup()
		.addGap(0, 0, Short.MAX_VALUE)
		.addComponent(jLabel2)))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addGap(47, 47, 47))
	);
	jLabel1.getAccessibleContext().setAccessibleDescription("");
	getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
	pack();
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {			
		System.out.println(value_int.getText());
		String tempPT = value_int.getText();
		setProcessingTime = Integer.parseUnsignedInt(tempPT);
		collectChannelDataFromUI(jTable2);		
	}
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt){
		
		mUtils.doRenderMulticastingForAll(setProcessingTime, collectChannelDataFromUI(jTable2));
	}
	
	
	private void value_intActionPerformed(java.awt.event.ActionEvent evt) {
	
	}
	
	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
	
	}
	
	private void jTable2InputMethodTextChanged(InputMethodEvent evt) {
		
		
	}
	
	private void jTable2AncestorAdded(AncestorEvent evt) {
			
			
	}
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

				createChannelListing.addRow(new Object[]{"", "", "", "",  new Boolean(false)});	
    } 
	
	
	
	private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         

		if(jTable2.getSelectedRow() != -1){
			createChannelListing.setValueAt(jTable2.getValueAt(jTable2.getSelectedRow(), 0), jTable2.getSelectedRow(), 0);
			createChannelListing.setValueAt(jTable2.getValueAt(jTable2.getSelectedRow(), 1), jTable2.getSelectedRow(), 1);
			createChannelListing.setValueAt(jTable2.getValueAt(jTable2.getSelectedRow(), 2), jTable2.getSelectedRow(), 2);
			createChannelListing.setValueAt(jTable2.getValueAt(jTable2.getSelectedRow(), 3), jTable2.getSelectedRow(), 3);					
		}
		else
		{
			System.out.println("No rows selected to update the value");
		}		
    } 
	
	public List<MetadataAnalyzer> collectChannelDataFromUI(JTable cTable){
		 String channelName;
		 String broadcastIP;
		 String sourceIP;
		 String ports;
		 int[] rowIndices={};
		 List<MetadataAnalyzer> selectedChannelList;
		
		selectedChannelList = new ArrayList<MetadataAnalyzer>();
		DefaultTableModel dModel = (DefaultTableModel)cTable.getModel();
		if(dModel.getRowCount() > 0){
			//System.out.println("No of Channels: "+addSelectedRows.size());
			if(cTable.getSelectedRowCount() > 0)
			{				
				//int[] selectedRows = cTable.getSelectedRows();
				List<Integer> selectedRows = addSelectedRows;
				for(int i: selectedRows){
					channelName = cTable.getValueAt(i, 0).toString();
					broadcastIP = cTable.getValueAt(i, 1).toString();
					sourceIP = cTable.getValueAt(i, 2).toString();
					ports =  cTable.getValueAt(i, 3).toString();
					System.out.println(channelName+" "+broadcastIP+" "+sourceIP+" "+ports);
					MetadataAnalyzer channelRecord = new MetadataAnalyzer(channelName,broadcastIP,sourceIP,ports);
					selectedChannelList.add(channelRecord);					
				}
				//System.out.println("Selected channel rows count: "+selectedChannelList.size());
			}
			else
			{
				System.out.println("No selected rows from Channel list table.");
				Logger.getLogger("No selected rows from Channel list table.");
			}
		}
		else {
			Logger.getLogger("Empty Channel list table. Will not be able to process empty table");
			
		}
		return selectedChannelList;
	}
	
	public void doInvokeMetadataAnalyzerUI(){
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
					}
			}
		} catch (ClassNotFoundException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	
		java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
			new MetadataAnalyzerUI().setVisible(true);
			}
		});	
		
	}
	
	private class RowColumnListSelectionListener implements ListSelectionListener {
		
        public void valueChanged(ListSelectionEvent listSelEvent) {
            if (jTable2.getRowSelectionAllowed() &&
                    !jTable2.getColumnSelectionAllowed() && !listSelEvent.getValueIsAdjusting())
            {            	
                int[] rows = jTable2.getSelectedRows();
                jTable2.convertRowIndexToModel(jTable2.getSelectedRow());
                System.out.println(Arrays.asList(rows[0]));                
                addSelectedRows.add(rows[0]);
            }            
         }       
    }


public static void main(String args[]) {

try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
					}
			}
		} catch (ClassNotFoundException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(MetadataAnalyzerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

	java.awt.EventQueue.invokeLater(new Runnable() {
		public void run()
		{
			new MetadataAnalyzerUI().setVisible(true);
		}
	  });
	}

private javax.swing.JSlider Slider1;
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton13;
private javax.swing.JButton jButton14;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton5;
private javax.swing.JButton jButton6;
private javax.swing.JButton jButton7;
private javax.swing.JButton jButton8;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPanel jPanel3;
private javax.swing.JPanel jPanel4;
private javax.swing.JPanel jPanel5;
private javax.swing.JPanel jPanel6;
private javax.swing.JPanel jPanel8;
private javax.swing.JProgressBar jProgressBar2;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JScrollPane jScrollPane2;
private javax.swing.JScrollPane jScrollPane3;
private javax.swing.JScrollPane jScrollPane4;
private javax.swing.JTabbedPane jTabbedPane2;
private javax.swing.JTable jTable2;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
private javax.swing.JTextPane jTextPane1;
private javax.swing.JTextPane jTextPane2;
private javax.swing.JTextPane jTextPane3;
private javax.swing.JTextField value_int;
// End of variables declaration
}
