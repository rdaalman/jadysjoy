package com.dabis.trimsalon.ui;
import static org.junit.Assert.fail;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.log4j.Logger;
import org.gui.JCalendarCombo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.dabis.trimsalon.beans.Afspraak;
import com.dabis.trimsalon.beans.Boekhouding;
import com.dabis.trimsalon.beans.Klant;
import com.dabis.trimsalon.utils.HibernateUtil;
import com.dabis.trimsalon.utils.QueryTableModel;

public class TrimsalonBoekhoudingFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(TrimsalonOpmerkingenFrame.class);
	private javax.swing.JButton addButton = null;
	private JButton clearButton = null;
	private JButton exitButton = null;
	private JPanel ivjJFrameContentPane = null;
	private JLabel ivjJLabel9 = null;
	private JLabel ivjJLabel1 = null;
	private JLabel ivjJLabel2 = null;
	private JLabel ivjJLabel3 = null;
	private JLabel ivjJLabel4 = null;
	private JLabel ivjJLabel5 = null;
	private JLabel ivjJLabel11 = null;
	private JTextField ivjJTextField = null;
	private JTextField ivjJTextField1 = null;
	private JTextField ivjJTextField2 = null;
	private JTextField ivjJTextField3 = null;
	private JCheckBox jCheckBox = null;
	private JCalendarCombo ivjJCalendarCombo = null;
	private JScrollPane ivjJScrollPane = null;
	private JTable ivjJTable = null;
	private TableColumn ivjTableColumn = null;
	private TableColumn ivjTableColumn2 = null;
	private JTabbedPane ivjJTabbedPane = null;
	private JComboBox jComboBox = null;
	public Boolean sortAscending = new Boolean(true);
	public String sortBy = "!id";  //  @jve:decl-index=0:
	private JButton removeButton = null;
	
	public TrimsalonBoekhoudingFrame() {
		super();
		initialize();
	}

	private void initialize() {
		setName("mainFrame");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(931, 539);
		this.setTitle("Boekhouding");
		this.setContentPane(getJFrameContentPane());
		fillIvjJTable(sortBy, sortAscending);
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return JPanel
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			getJFrameContentPane().add(getJLabel1(), getJLabel1().getName());
			getJFrameContentPane().add(getJTextField1(),
					getJTextField1().getName());
			getJFrameContentPane().add(getJLabel11(), getJLabel11().getName());
			ivjJFrameContentPane.add(getIvjJTabbedPane(), getIvjJTabbedPane()
					.getName()); // JVE Generated
			ivjJFrameContentPane.add(getJLabel2(), null);
			ivjJFrameContentPane.add(getJLabel3(), null);
			ivjJFrameContentPane.add(getJTextField1(), null);
			ivjJFrameContentPane.add(getJTextField2(), null);
			ivjJFrameContentPane.add(getJTextField3(), null);
			ivjJFrameContentPane.add(getAddButton(), null);
			ivjJFrameContentPane.add(getClearButton(), null);
			ivjJFrameContentPane.add(getExitButton(), null);
			ivjJFrameContentPane.add(getJLabel9(), null);
			ivjJFrameContentPane.add(getJTextField(), null);
			ivjJFrameContentPane.add(getRemoveButton(), null);
			ivjJFrameContentPane.add(getJLabel4(), null);
			ivjJFrameContentPane.add(getJCalendarCombo(), null);
			ivjJFrameContentPane.add(getJLabel5(), null);
		}
		return ivjJFrameContentPane;
	}
	
	/**
	 * Return the addButton property value.
	 * @return JButton
	 */
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText("Opslaan");
			addButton.setBounds(new Rectangle(450, 450, 100, 25));
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					Boekhouding c = new Boekhouding();
					// If id is empty then its a new boekhouding
					long id = Long.parseLong(getJTextField().getText());
					if(id == -1) {
						// New boekhouding
						Afspraak af1 = new Afspraak();	
						
						try {
							Add(af1);
						} catch (HibernateException e) {
							// Afspraak is mandatory, so an error should appear.
							if(! e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Hond.klant") ) {
								fail("Could not add Hond:"+e.getMessage());
							}
						}
						// Retrieve it again
						af1 = (Afspraak) GetAll("from Afspraak").get(0);
						af1.setHond(getJComboBox1().getSelectedItem()+"");
						
						c.setPrijsExbtw(Double.valueOf(getJTextField3().getText()));
						c.setBtw(Double.valueOf(getJTextField1().getText()));
						c.setBetaalt(getJCheckBox().isSelected());
						
						//Calendar statement
						Calendar datum = Calendar.getInstance();
						datum.setTime(getJCalendarCombo().getDate().getTime());
						c.setBoekingsdatum(datum); //calendar gegevens
										        
						Session session = HibernateUtil.getCurrentSession();
				        session.beginTransaction();
				        session.save(c);
				        session.getTransaction().commit();
				        getJTextField().setText(c.getId()+"");
					} else {
						// Boekhouding is modified
						Session session = HibernateUtil.getCurrentSession();
				        session.beginTransaction();
						c = (Boekhouding) session.createQuery("from Boekhouding where id="+id).list().get(0);
				        session.getTransaction().commit();
				    	Afspraak af1 = new Afspraak();
						
						try {
							Add(af1);
						} catch (HibernateException e) {
							// Afspraak is mandatory, so an error should appear.
							if(! e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Hond.klant") ) {
								fail("Could not add Hond:"+e.getMessage());
							}
						}
						// Retrieve it again
						af1 = (Afspraak) GetAll("from Afspraak").get(0);
						af1.setAfspraak(getJComboBox1().getSelectedItem()+""); //Objecten in combobox
				    	
						c.setPrijsExbtw(Double.valueOf(getJTextField3().getText()));
						c.setBtw(Double.valueOf(getJTextField1().getText()));
						c.setBetaalt(getJCheckBox().isSelected());
						c.setBoekingsdatum(getJCalendarCombo().getDate());
						
						session = HibernateUtil.getCurrentSession();
				        session.beginTransaction();
				        session.update(c);
				        session.getTransaction().commit();
					}
					fillIvjJTable(sortBy, sortAscending);
				}
			});
		}
		return addButton;
	}
	
	/**
	 * This method initializes clearButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton();
			clearButton.setBounds(new Rectangle(665, 450, 110, 25));
			clearButton.setText("Leeg maken");
			clearButton.setName("clearButton");
			clearButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearInvoer();
					//Return the focus to the typing area.
					ivjJTextField1.requestFocusInWindow();
					
				}
			});
		}
		return clearButton;
	}
	
	/**
	 * This method initializes exitButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExitButton() {
		if (exitButton == null) {
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(780, 450, 100, 25));
			exitButton.setText("Stoppen");
			exitButton.setName("exitButton");
			exitButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitButton;
	}
	
	private void clearInvoer() {
		getJTextField().setText("-1");
		getJTextField1().setText(null);
		getJTextField2().setText(null);
		getJTextField3().setText(null);
	}

	/**
	 * Return the JLabels property value.
	 * @return JLabel
	 */
	private JLabel getJLabel9() {
		if (ivjJLabel9 == null) {
			ivjJLabel9 = new JLabel();
			ivjJLabel9.setName("JLabel9");
			ivjJLabel9.setBounds(457, 80, 134, 15);
			ivjJLabel9.setText("Id");
		}
		return ivjJLabel9;
	}
	
	private JLabel getJLabel1() {
		if (ivjJLabel1 == null) {
			ivjJLabel1 = new JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Boekingsdatum");
			ivjJLabel1.setBounds(457, 110, 134, 15);
		}
		return ivjJLabel1;
	}
	
	private JLabel getJLabel2() {
		if (ivjJLabel2 == null) {
			ivjJLabel2 = new JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setBounds(new Rectangle(457, 140, 134, 15));
			ivjJLabel2.setText("Afspraak");
		}
		return ivjJLabel2;
	}
	
	private JLabel getJLabel3() {
		if (ivjJLabel3 == null) {
			ivjJLabel3 = new JLabel();
			ivjJLabel3.setName("JLabel3");
			ivjJLabel3.setBounds(new Rectangle(457, 170, 134, 15));
			ivjJLabel3.setText("Prijs ex btw");
		}
		return ivjJLabel3;
	}
	
	private JLabel getJLabel4() {
		if (ivjJLabel4 == null) {
			ivjJLabel4 = new JLabel();
			ivjJLabel4.setName("JLabel4");
			ivjJLabel4.setBounds(new Rectangle(457, 200, 134, 15));
			ivjJLabel4.setText("Btw");
		}
		return ivjJLabel4;
	}
	
	private JLabel getJLabel5() {
		if (ivjJLabel5 == null) {
			ivjJLabel5 = new JLabel();
			ivjJLabel5.setName("JLabel5");
			ivjJLabel5.setBounds(new Rectangle(457, 230, 134, 15));
			ivjJLabel5.setText("Betaald");
		}
		return ivjJLabel5;
	}
	
	/**
	 * Return the JLabel11 property value.
	 * @return JLabel
	 */
	private JLabel getJLabel11() {
		if (ivjJLabel11 == null) {
			ivjJLabel11 = new JLabel();
			ivjJLabel11.setName("JLabel11");
			ivjJLabel11.setText("Boekhouding informatie");
			ivjJLabel11.setBounds(457, 39, 442, 34);
		}
		return ivjJLabel11;
	}

	/**
	 * Return the JTextFields property value.
	 * @return JTextField
	 */
	private JTextField getJTextField() {
		if (ivjJTextField == null) {
			ivjJTextField = new JTextField();
			ivjJTextField.setName("JTextField");
			ivjJTextField.setEnabled(false);
			ivjJTextField.setBounds(new Rectangle(600, 80, 300, 20));
			ivjJTextField.setText("-1");
		}
		return ivjJTextField;
	}
	
	private JTextField getJTextField1() {
		if (ivjJTextField1 == null) {
			ivjJTextField1 = new JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setBounds(new Rectangle(600, 200, 300, 20));
		}
		return ivjJTextField1;
	}
	
	private JTextField getJTextField2() {
		if (ivjJTextField2 == null) {
			ivjJTextField2 = new JTextField();
			ivjJTextField2.setName("JTextField2");
			ivjJTextField2.setBounds(new Rectangle(600, 140, 300, 20));
		}
		return ivjJTextField2;
	}
	
	private JComboBox getJComboBox1() {
		if (jComboBox == null) {
			Afspraak af1 = new Afspraak();
			af1 = (Afspraak) GetAll("from Afspraak").get(0);
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(600, 140, 300, 20));
			jComboBox.addItem("Selecteer Afspraak...");
			jComboBox.addItem(af1.getDatum());
		}		
				
		return jComboBox;
	}
	
	private JTextField getJTextField3() {
		if (ivjJTextField3 == null) {
			ivjJTextField3 = new JTextField();
			ivjJTextField3.setName("JTextField3");
			ivjJTextField3.setBounds(new Rectangle(600, 170, 300, 20));
		}
		return ivjJTextField3;
	}
	
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(598, 347, 21, 21));
		}
		return jCheckBox;
	}
	
	private JCalendarCombo getJCalendarCombo() {
		if (ivjJCalendarCombo == null) {
			ivjJCalendarCombo = new JCalendarCombo();
			ivjJCalendarCombo.setName("JCalendarCombo");
			ivjJCalendarCombo.setBounds(new Rectangle(600, 110, 300, 20));
		}
		return ivjJCalendarCombo;
	}
	
	private class TableSelectionListener implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent e) {
	        //Ignore extra messages.
	        if (e.getValueIsAdjusting()) return;

	        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
	        if (lsm.isSelectionEmpty()) {
	            //no rows are selected
	        } else {
	            int selectedRow = lsm.getMinSelectionIndex();
	            //selectedRow is selected
	            String id = (String) ((QueryTableModel)getIvjJTable().getModel()).getRow(selectedRow)[0];
				Session session = HibernateUtil.getCurrentSession();
		        session.beginTransaction();
				Boekhouding c = (Boekhouding) session.createQuery("from Boekhouding where id="+id).list().get(0);
		        session.getTransaction().commit();
		        getJTextField().setText(c.getId()+"");
		        getJTextField1().setText(c.getAfspraak()+"");
		        getJTextField2().setText(c.getPrijsExbtw()+"");
		        getJTextField3().setText(c.getBtw()+"");
		        getJCheckBox().setSelected(c.isBetaalt());		        
		        getJCalendarCombo().setDate(c.getBoekingsdatum());
	        }
	    }
	}
	
	private class TableSorter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            TableColumnModel columnModel = getIvjJTable().getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 
            int column = getIvjJTable().convertColumnIndexToModel(viewColumn); 
            if(e.getClickCount() == 1 && column != -1) {
                sortAscending = new Boolean(!sortAscending.booleanValue());
				String v = ((QueryTableModel)getIvjJTable().getModel()).getVarNames()[column];
                sortBy = v.substring(0, 1).toLowerCase()+v.substring(1);
                fillIvjJTable(sortBy, sortAscending);
                clearInvoer();
            }
         }
	}

	/**
	 * This method initializes hondenScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getIvjJScrollPane() {
		if (ivjJScrollPane == null) {
			ivjJScrollPane = new JScrollPane();
			ivjJScrollPane.setViewportView(getIvjJTable());
		}
		return ivjJScrollPane;
	}

	/**
	 * This method initializes hondenTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getIvjJTable() {
		if (ivjJTable == null) {
			ivjJTable = new JTable();
			ivjJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			ivjJTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			ivjJTable.setShowGrid(true);
// Ask to be notified of selection changes.
			ivjJTable.getSelectionModel().addListSelectionListener(new TableSelectionListener());
// Make column header click result in sorting ascending (shift-click is descending)
			ivjJTable.setColumnSelectionAllowed(false);
	        TableSorter listSorter = new TableSorter();
			JTableHeader th = ivjJTable.getTableHeader();
	        th.addMouseListener(listSorter); 
		}
		return ivjJTable;
	}
	
	@SuppressWarnings("unchecked")
	private void fillIvjJTable(String sortBy, Boolean ascending) {
		Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Boekhouding.class);
        if(ascending) c.addOrder(Order.asc(sortBy));
        else c.addOrder(Order.desc(sortBy));
		List<Boekhouding> list = c.list();
		log.debug("List Boekhouding size="+list.size());
        session.getTransaction().commit();
        String[] cols = {"!Id","Boekingsdatum","Afspraak","PrijsExBtw","Btw","Betaalt"};
        QueryTableModel m = new QueryTableModel(cols, list);
        getIvjJTable().setModel(m);
        
	}
	
	/**
	 * This method initializes ivjTableColumn
	 * 
	 * @return table.TableColumn
	 */
	@SuppressWarnings("unused")
	private TableColumn getIvjTableColumn() {
		if (ivjTableColumn == null) {
			ivjTableColumn = new TableColumn(); // Explicit Instance
			ivjTableColumn.setHeaderValue("Task");
			ivjTableColumn.setPreferredWidth(40); // JVE Generated
			ivjTableColumn.setResizable(false); // JVE Generated
			ivjTableColumn.setModelIndex(0); // JVE Generated
		}
		return ivjTableColumn;
	}

	/**
	 * This method initializes ivjTableColumn2
	 * 
	 * @return table.TableColumn
	 */
	@SuppressWarnings("unused")
	private TableColumn getIvjTableColumn2() {
		if (ivjTableColumn2 == null) {
			ivjTableColumn2 = new TableColumn(); // Explicit Instance
			ivjTableColumn2.setHeaderValue("Time Added");
			ivjTableColumn2.setPreferredWidth(90); // JVE Generated
			ivjTableColumn2.setModelIndex(1); // JVE Generated
		}
		return ivjTableColumn2;
	}

	/**
	 * This method initializes ivjJTabbedPane
	 * 
	 * @return JTabbedPane
	 */
	private JTabbedPane getIvjJTabbedPane() {
		if (ivjJTabbedPane == null) {
			ivjJTabbedPane = new JTabbedPane(); // Explicit Instance
			ivjJTabbedPane.addTab("Boekhouding", null, getIvjJScrollPane(), null); // JVE Generated
			ivjJTabbedPane.setBounds(7, 28, 428, 476); // JVE Generated
		}
		return ivjJTabbedPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRemoveButton() {
		if (removeButton == null) {
			removeButton = new JButton();
			removeButton.setText("Verwijderen");
			removeButton.setBounds(new Rectangle(555, 450, 105, 26));
			removeButton.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					// If id is -1 then its a new boekhouding
					long id = Long.parseLong(getJTextField().getText());
					if(id != -1) {
						Session session = HibernateUtil.getCurrentSession();
				        session.beginTransaction();
						Boekhouding c = (Boekhouding) session.createQuery("from Boekhouding where id="+id).list().get(0);
				        session.getTransaction().commit();
						session = HibernateUtil.getCurrentSession();
				        session.beginTransaction();
				        session.delete(c);
				        session.getTransaction().commit();
					}
					clearInvoer();
					fillIvjJTable(sortBy, sortAscending);
				}
			});
		}
		return removeButton;
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> GetAll(String query) throws HibernateException {
		List<T> list = null;
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
			list = (List<T>) session.createQuery(query).list();
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
		return list;
	}

	//====================================================================================
	//Supporting methods
	//
	private void Add(Object object) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.save(object);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}

}  //  @jve:decl-index=0:visual-constraint="-15,6"

