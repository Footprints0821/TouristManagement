import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = -8026416994513756565L;

	public Font displayFont = new Font("Times New Roman", Font.PLAIN, 30);
	//Set the feature of characteristics including the type and size 
	public String adminPassword = "1234";
	//Default password is 1234
	public TrainDatabase trainDatabase = new TrainDatabase();

	public JPanel currentPanel = null;

	public LoginSelection loginSelection = new LoginSelection();
	public EnterPassword enterPassword = new EnterPassword();
	public TableGUI trainGUI = new TableGUI(trainDatabase.trainTable);
	public TableGUI driverGUI = new TableGUI(trainDatabase.driverTable);
	public TableGUI routeGUI = new TableGUI(trainDatabase.routeTable);
	public TableGUI journeyGUI = new TableGUI(trainDatabase.jouneryTable);
	public DisplayTableGUI displayJourneyGUI = new DisplayTableGUI(trainDatabase.jouneryTable, trainDatabase.routeTable);
	public CheckStateGUI checkStateGUI = new CheckStateGUI();
	public RemoteControlGUI remoteControlGUI = new RemoteControlGUI();
	public SyncGUI syncGUI = new SyncGUI();
	public SyncTrainGUI syncTrainGUI = new SyncTrainGUI();
	public SyncStationGUI syncStationGUI = new SyncStationGUI();
	public GUISelection pGUISelection = new GUISelection();

	public MainFrame() {
	//Constructor of the MainFrame
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UIManager.put("Label.font", displayFont);
		UIManager.put("Button.font", displayFont);
		UIManager.put("TextField.font", displayFont);

		setToLoginSelection();	//Lead to first interface
		
		this.setVisible(true);
	}

	public void setToLoginSelection() {
	//User selection interface
		this.setSize(1000, 300);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.loginSelection;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login Selection");
	}

	public void setToEnterPassword() {
	//Let user enter password
		this.setSize(700, 150);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.enterPassword;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Please Enter Your Password");
	}

	public void setToGUISelection() {
	//Main management interface
		this.setSize(800, 200);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.pGUISelection;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GUI Selection");
	}

	public void setToTrainGUI() {
	//Set to manage train GUI
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.trainGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Train");
	}

	public void setToDriverGUI() {
	//Set to manage driver GUI
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.driverGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Driver");
	}

	public void setToRouteGUI() {
	//Set to manage route GUI
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.routeGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Route");
	}

	public void setToJourneyGUI() {
	//Set to manage journey GUI
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.journeyGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Journey");
	}

	public void setToDisplayJourneyGUI() {
	//Set to display time table GUI
		this.setSize(1300, 800);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.displayJourneyGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Journey");
	}

	public void setToCheckStateGUI() {
	//Set to check state GUI
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.checkStateGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Check State");
	}

	public void setToRemoteControlGUI() {
	//Set to remote control GUI
		this.setSize(1200, 600);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.remoteControlGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Remote Control");
	}

	public void setToSyncGUI() {
	//Set to synchronization GUI
		this.setSize(600, 100);
		this.setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.syncGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sync");
	}

	public void setToSyncTrainGUI() {
	//Set to synchronization train GUI
		this.setSize(1200, 600);
		setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.syncTrainGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setTitle("Sync Train");
	}

	public void setToSyncStationGUI() {
	//Set to synchronization station GUI
		this.setSize(1200, 600);
		setLocationRelativeTo(null);
		if (currentPanel != null) {
			this.remove(currentPanel);
		}
		this.currentPanel = this.syncStationGUI;
		this.add(this.currentPanel, BorderLayout.CENTER);
		this.setTitle("Sync Station");
	}

	public class LoginSelection extends JPanel {
	//The first interface which make user to choose who they are
		private static final long serialVersionUID = -2505311453403939825L;
		JLabel loginLabel1 = new JLabel("Train Journey Management System");
		JLabel loginLabel2 = new JLabel("<== Tourist || Administrator ==>");
		JLabel loginLabel3 = new JLabel
				("Welcome to use our system! Tourist please click left button! Administrator please click right button!");
		public JButton userButton = new JButton();
		public JButton adminButton = new JButton();
		public LoginSelection() {
			this.loginLabel1.setFont(displayFont);
			this.loginLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			this.loginLabel2.setFont(displayFont);
			this.loginLabel2.setForeground(Color.RED);
			this.loginLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			this.loginLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 23));
			this.loginLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			this.loginLabel3.setForeground(Color.CYAN);
			this.setLayout(new BorderLayout());
			this.userButton.setFont(displayFont);
			this.userButton.setPreferredSize(new Dimension(300,100));
			this.userButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7372222314162592807L;

				{
					this.putValue(Action.NAME, "User");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String info = "Instruction\n You browse time table information in this interface.\n"
							+ "You can check which route you want to take below and then find the corresponding journey.\n";
					JOptionPane.showMessageDialog(null,info);
					setToDisplayJourneyGUI();
				}

			});
			this.adminButton.setFont(displayFont);
			this.adminButton.setPreferredSize(new Dimension(300,100));
			this.adminButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = -6357395300103483850L;

				{
					this.putValue(Action.NAME, "Admin");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToEnterPassword();
				}

			});

			this.add(BorderLayout.WEST, this.userButton);
			this.add(BorderLayout.EAST, this.adminButton);
			this.add(BorderLayout.NORTH, this.loginLabel1);
			this.add(BorderLayout.CENTER, this.loginLabel2);
			this.add(BorderLayout.SOUTH, this.loginLabel3);
		}

	}

	public class EnterPassword extends JPanel {
	//The GUI for user to enter password
		private static final long serialVersionUID = 7184337401140012611L;
		public Label textLabel = new Label("Password: ");
		public JPasswordField inputTextField = new JPasswordField(15);
		public JButton okButton = new JButton();
		public JButton cancelButton = new JButton();

		public EnterPassword() {
			this.textLabel.setFont(displayFont);
			this.inputTextField.setFont(displayFont);

			this.okButton.setFont(displayFont);
			this.okButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 4407571463075451211L;

				{
					this.putValue(Action.NAME, "Ok");
				}

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					if (inputTextField.getText().equals(adminPassword)) {
						inputTextField.setText("");
						setToGUISelection();
					} else {
						inputTextField.setText("");
						JOptionPane.showMessageDialog(null, "Wrong Password!", "Wrong Password!", JOptionPane.ERROR_MESSAGE);
					}
				}

			});
			this.cancelButton.setFont(displayFont);
			this.cancelButton.setAction(new AbstractAction() {

				/**
				 * 
				 */
				private static final long serialVersionUID = -4690620477674765441L;

				{
					this.putValue(Action.NAME, "Cancel");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToLoginSelection();
				}

			});

			this.setLayout(new BorderLayout());

			this.add(new JPanel() {
				private static final long serialVersionUID = 4059249642313497368L;

				{
					this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
					this.add(textLabel);
					this.add(inputTextField);
				}
			}, BorderLayout.CENTER);

			this.add(new JPanel() {
				private static final long serialVersionUID = 7919917894571756762L;

				{
					this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
					this.add(okButton);
					this.add(cancelButton);
				}
			}, BorderLayout.SOUTH);
		}
	}

	public class GUISelection extends JPanel {
	//This part is the main menu of management system
		private static final long serialVersionUID = 2369402687451595012L;

		public JButton loginSelectionButton = new JButton();
		public JButton trainGUIButton = new JButton();
		public JButton driverGUIButton = new JButton();
		public JButton routeGUIButton = new JButton();
		public JButton journeyGUIButton = new JButton();
		public JButton checkStateGUIButton = new JButton();
		public JButton remoteControlGUIButton = new JButton();
		public JButton syncGUIButton = new JButton();
		public JLabel GUISelectionLabel1 = new JLabel("Management Function Selection");

		public GUISelection() {
			
			this.GUISelectionLabel1.setFont(displayFont);
			this.loginSelectionButton.setFont(displayFont);
			this.trainGUIButton.setFont(displayFont);
			this.driverGUIButton.setFont(displayFont);
			this.routeGUIButton.setFont(displayFont);
			this.journeyGUIButton.setFont(displayFont);
			this.checkStateGUIButton.setFont(displayFont);
			this.remoteControlGUIButton.setFont(displayFont);
			this.syncGUIButton.setFont(displayFont);

			this.loginSelectionButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 8680839618980802238L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToLoginSelection();
				}
			});

			this.trainGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = -7133919037158105627L;

				{
					this.putValue(Action.NAME, "Train");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String trainInfo = "Instruction\n You can manage train information in this interface\n"
							+ "Double click the area you want to modify\n The train ID should be used like '#1XXX'\n"
							+ "You can click the bottom button to add or remove data";
					JOptionPane.showMessageDialog(null,trainInfo);
					setToTrainGUI();
				}
			});

			this.driverGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 6829663617933175598L;

				{
					this.putValue(Action.NAME, "Driver");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String driverInfo = "Instruction\n You can manage driver information in this interface\n"
							+ "Double click the area you want to modify\n The driver ID should be used like '#2XXX'\n"
							+ "You can click the bottom button to add or remove data";
					JOptionPane.showMessageDialog(null,driverInfo);
					setToDriverGUI();
				}
			});

			this.routeGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = -3060542420254193037L;

				{
					this.putValue(Action.NAME, "Route");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String routeInfo = "Instruction\n You can manage route information in this interface\n"
							+ "Double click the area you want to modify\n The route ID should be used like '#3XXX'\n"
							+ "You can click the bottom button to add or remove data\n" + "You can only assign 4 stations for a journey which is between character A and G";
					JOptionPane.showMessageDialog(null,routeInfo);
					setToRouteGUI();
				}
			});

			this.journeyGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = -7896816281163235049L;

				{
					this.putValue(Action.NAME, "Journey");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String journeyInfo = "Instruction\n You can manage journey information in this interface\n"
							+ "Double click the area you want to modify\n The journey ID should be used like '#4XXX'\n"
							+ "You can click the bottom button to add or remove data\n" + "You need to set the time for each station\n";
					JOptionPane.showMessageDialog(null,journeyInfo);
					setToJourneyGUI();
				}
			});

			this.checkStateGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 8052613349472325346L;

				{
					this.putValue(Action.NAME, "Check State");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String checkStateInfo = "Instruction\n You can check the live state in this interface\n" + "Before you want to get a location of train you need to click the set location button"
							+ "In set location you can input a location as (x,y)\n" + "This interface is used to simulate that the main system received a location from outside.";
					JOptionPane.showMessageDialog(null,checkStateInfo);
					setToCheckStateGUI();
				}
			});

			this.remoteControlGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 1286290679174235606L;

				{
					this.putValue(Action.NAME, "Remote Control");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String remoteControlInfo = "Instruction\n You can remotely control the train in this interface\n";
					JOptionPane.showMessageDialog(null,remoteControlInfo);
					setToRemoteControlGUI();
				}
			});

			this.syncGUIButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7579220782383632269L;

				{
					this.putValue(Action.NAME, "Sync");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String syncInfo = "Instruction\n You can synchronize train or station in this interface\n";
					JOptionPane.showMessageDialog(null,syncInfo);
					setToSyncGUI();
				}
			});
			
			this.setLayout(new BorderLayout());

			this.add(new JPanel() {
				private static final long serialVersionUID = 8059242923139237368L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));
					this.add(trainGUIButton);
					this.add(driverGUIButton);
					this.add(routeGUIButton);
					this.add(journeyGUIButton);
					this.add(checkStateGUIButton);
					this.add(remoteControlGUIButton);
					this.add(syncGUIButton);
					this.add(loginSelectionButton);
				}
			}, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 6905213254678756764L;

				{
					this.add(GUISelectionLabel1);
				}
			}, BorderLayout.NORTH);


		}
	}

	public class TableGUI extends JPanel {
	//The GUI for table
		private static final long serialVersionUID = 23507257711971676L;

		public Table dataTable = null;

		public JTable displayTable = null;
		public JScrollPane displayScollPane = null;

		public JButton addNewRowButton = new JButton();
		public JButton deleteSelectedRowButton = new JButton();
		public JButton backButton = new JButton();

		public TableGUI(Table table) {
			this.setLayout(new BorderLayout());

			this.dataTable = table;

			this.displayTable = new JTable(table);
			this.displayScollPane = new JScrollPane(displayTable);

			this.displayTable.setRowHeight(displayFont.getSize() + 2);
			this.displayTable.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable.getTableHeader().setFont(displayFont);
			this.displayTable.setFont(displayFont);

			for (int i = 0; i < this.displayTable.getColumnModel().getColumnCount(); i++) {
				this.displayTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField() {
					private static final long serialVersionUID = 1189965647815327601L;
					{
						this.setFont(displayFont);
					}
				}));
			}

			this.addNewRowButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Add New Data");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					dataTable.addNewRow();
					displayTable.updateUI();
				}

			});
			this.addNewRowButton.setFont(displayFont);

			this.deleteSelectedRowButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Delete Selected Row");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select Row to delete!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						dataTable.deleteRow(index);
						displayTable.updateUI();
					}
				}

			});
			this.deleteSelectedRowButton.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String checkRes = dataTable.checkIsValid();
					if (checkRes == null) {
						setToGUISelection();
					} else {
						JOptionPane.showMessageDialog(null, checkRes, "Wrong Data", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			this.backButton.setFont(displayFont);

			this.add(displayScollPane, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(addNewRowButton);
					this.add(deleteSelectedRowButton);
					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}


	public class DisplayTableGUI extends JPanel {	
		//This GUI is used for visitor to check time table
		private static final long serialVersionUID = 23507257711971676L;

		public Table dataTable1 = null;
		public Table dataTable2 = null;

		public JTable displayTable1 = null;
		public JScrollPane displayScollPane1 = null;
		public JTable displayTable2 = null;
		public JScrollPane displayScollPane2 = null;

		public JButton backButton = new JButton();

		public DisplayTableGUI(Table table1, Table table2) {
			this.setLayout(new BorderLayout());

			this.dataTable1 = table1;
			this.dataTable2 = table2;

			this.displayTable1 = new JTable(table1) {
				private static final long serialVersionUID = 2135726651288478597L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane1 = new JScrollPane(displayTable1);

			this.displayTable1.setRowHeight(displayFont.getSize() + 2);
			this.displayTable1.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable1.getTableHeader().setFont(displayFont);
			this.displayTable1.setFont(displayFont);

			this.displayTable2 = new JTable(table2) {
				private static final long serialVersionUID = 2135726651288478597L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane2 = new JScrollPane(displayTable2);

			this.displayTable2.setRowHeight(displayFont.getSize() + 2);
			this.displayTable2.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable2.getTableHeader().setFont(displayFont);
			this.displayTable2.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToLoginSelection();
				}

			});
			this.backButton.setFont(displayFont);

			this.add(new JPanel() {
				private static final long serialVersionUID = -9186375574141064475L;

				{
					this.setLayout(new GridLayout(2, 1));
					this.add(displayScollPane1);
					this.add(displayScollPane2);
				}
			}, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}

	public class CheckStateGUI extends JPanel {		
		//This GUI is used to check the train state
		private static final long serialVersionUID = 23507257712271676L;

		public Table dataTable = trainDatabase.jouneryTable;

		public JTable displayTable = null;
		public JScrollPane displayScollPane = null;

		public JButton setLocationButton = new JButton();
		public JButton getLocationButton = new JButton();
		public JButton backButton = new JButton();

		public HashMap<String, ArrayList<Double>> trainLocation = new HashMap<String, ArrayList<Double>>();

		public CheckStateGUI() {
			this.setLayout(new BorderLayout());

			this.displayTable = new JTable(dataTable) {
				private static final long serialVersionUID = 2135726651288478597L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane = new JScrollPane(displayTable);

			this.displayTable.setRowHeight(displayFont.getSize() + 2);
			this.displayTable.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable.getTableHeader().setFont(displayFont);
			this.displayTable.setFont(displayFont);

			for (int i = 0; i < this.displayTable.getColumnModel().getColumnCount(); i++) {
				this.displayTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField() {
					private static final long serialVersionUID = 1189965647815327601L;
					{
						this.setFont(displayFont);
					}
				}));
			}

			this.setLocationButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Set Location");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select train!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						double locX = Double.parseDouble(JOptionPane.showInputDialog(null, "Input x: ", "Input", JOptionPane.PLAIN_MESSAGE));
						double locY = Double.parseDouble(JOptionPane.showInputDialog(null, "Input y: ", "Input", JOptionPane.PLAIN_MESSAGE));

						String tid = (String) dataTable.getValueAt(index, 2);
						if (trainLocation.keySet().contains(tid)) {
							trainLocation.get(tid).set(0, locX);
							trainLocation.get(tid).set(1, locY);
						} else {
							ArrayList<Double> loc = new ArrayList<Double>();
							loc.add(locX);
							loc.add(locY);
							trainLocation.put(tid, loc);
						}
					}
				}

			});
			this.setLocationButton.setFont(displayFont);

			this.getLocationButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Get Location");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select train!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						String tid = (String) dataTable.getValueAt(index, 2);
						if (trainLocation.keySet().contains(tid)) {
							JOptionPane.showMessageDialog(null,
									String.format("Location is: %6.2f, %6.2f", trainLocation.get(tid).get(0), trainLocation.get(tid).get(1)),
									"Location", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "No Location", "No Location", JOptionPane.PLAIN_MESSAGE);
						}
					}
				}

			});
			this.getLocationButton.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToGUISelection();
				}

			});
			this.backButton.setFont(displayFont);

			this.add(displayScollPane, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(setLocationButton);
					this.add(getLocationButton);
					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}

	public class RemoteControlGUI extends JPanel {		
		//This GUI is used for remote control
		private static final long serialVersionUID = 23502227712271676L;

		public Table dataTable = trainDatabase.jouneryTable;

		public JTable displayTable = null;
		public JScrollPane displayScollPane = null;

		public JButton startButton = new JButton();
		public JButton stopButton = new JButton();
		public JButton backButton = new JButton();

		public RemoteControlGUI() {
			this.setLayout(new BorderLayout());

			this.displayTable = new JTable(dataTable) {
				private static final long serialVersionUID = 2135726651288478597L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane = new JScrollPane(displayTable);

			this.displayTable.setRowHeight(displayFont.getSize() + 2);
			this.displayTable.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable.getTableHeader().setFont(displayFont);
			this.displayTable.setFont(displayFont);

			for (int i = 0; i < this.displayTable.getColumnModel().getColumnCount(); i++) {
				this.displayTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField() {
					private static final long serialVersionUID = 1189965647815327601L;
					{
						this.setFont(displayFont);
					}
				}));
			}

			this.startButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Start");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select train!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						String tid = (String) dataTable.getValueAt(index, 2);
						JOptionPane.showMessageDialog(null, "Train \"" + tid + "\" started!", "Start Message", JOptionPane.PLAIN_MESSAGE);
					}
				}

			});
			this.startButton.setFont(displayFont);

			this.stopButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Stop");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select train!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						String tid = (String) dataTable.getValueAt(index, 2);
						JOptionPane.showMessageDialog(null, "Train \"" + tid + "\" stoped!", "Stop Message", JOptionPane.PLAIN_MESSAGE);
					}
				}

			});
			this.stopButton.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToGUISelection();
				}

			});
			this.backButton.setFont(displayFont);

			this.add(displayScollPane, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(startButton);
					this.add(stopButton);
					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}

	public class SyncGUI extends JPanel {		
	//This GUI is used for synchronization
		private static final long serialVersionUID = 2369411117451595012L;

		public JButton syncTrainButton = new JButton();
		public JButton syncStatiocButton = new JButton();
		public JButton backButton = new JButton();

		public SyncGUI() {
			this.setLayout(new FlowLayout(1, 10, 10));

			this.syncStatiocButton.setFont(displayFont);
			this.syncTrainButton.setFont(displayFont);
			this.backButton.setFont(displayFont);

			this.syncTrainButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = -7133919037158105627L;

				{
					this.putValue(Action.NAME, "Sync Train");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToSyncTrainGUI();
				}
			});

			this.syncStatiocButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 8680839618980802238L;

				{
					this.putValue(Action.NAME, "Sync Station");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToSyncStationGUI();
				}
			});

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 6829663617933175598L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToGUISelection();
				}
			});

			this.add(this.syncTrainButton);
			this.add(this.syncStatiocButton);
			this.add(this.backButton);
		}
	}

	public class SyncTrainGUI extends JPanel {		//This GUI is used for synchronization train
		private static final long serialVersionUID = 23502117712271676L;

		public Table dataTable = trainDatabase.jouneryTable;

		public JTable displayTable = null;
		public JScrollPane displayScollPane = null;

		public JButton syncButton = new JButton();
		public JButton backButton = new JButton();

		public SyncTrainGUI() {
			this.setLayout(new BorderLayout());

			this.displayTable = new JTable(dataTable) {
				private static final long serialVersionUID = -8524951994757922948L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane = new JScrollPane(displayTable);

			this.displayTable.setRowHeight(displayFont.getSize() + 2);
			this.displayTable.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable.getTableHeader().setFont(displayFont);
			this.displayTable.setFont(displayFont);

			for (int i = 0; i < this.displayTable.getColumnModel().getColumnCount(); i++) {
				this.displayTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField() {
					private static final long serialVersionUID = 1189965647815327601L;
					{
						this.setFont(displayFont);
					}
				}));
			}

			this.syncButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Sync");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int index = displayTable.getSelectedRow();

					if (index == -1) {
						JOptionPane.showMessageDialog(null, "Please select train!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						String tid = (String) dataTable.getValueAt(index, 2);
						String jid = (String) dataTable.getValueAt(index, 0);
						if (checkStateGUI.trainLocation.keySet().contains(tid)) {
							syncToTrain(tid, jid, checkStateGUI.trainLocation.get(tid).get(0), checkStateGUI.trainLocation.get(tid).get(1));
						} else {
							JOptionPane.showMessageDialog(null, "No Location", "No Location", JOptionPane.PLAIN_MESSAGE);
						}
					}
				}
			});
			this.syncButton.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToSyncGUI();
				}

			});
			this.backButton.setFont(displayFont);

			this.add(displayScollPane, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(syncButton);
					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}

	public class SyncStationGUI extends JPanel {		
		//This GUI is used for synchronization station
		private static final long serialVersionUID = 23502127712271676L;

		public Table dataTable = trainDatabase.routeTable;

		public JTable displayTable = null;
		public JScrollPane displayScollPane = null;

		public JButton syncButton = new JButton();
		public JButton backButton = new JButton();

		public SyncStationGUI() {
			this.setLayout(new BorderLayout());

			this.displayTable = new JTable(dataTable) {
				private static final long serialVersionUID = -8524951994757922948L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			this.displayScollPane = new JScrollPane(displayTable);

			this.displayTable.setRowHeight(displayFont.getSize() + 2);
			this.displayTable.getTableHeader().setPreferredSize(new Dimension(0, displayFont.getSize() + 2));
			this.displayTable.getTableHeader().setFont(displayFont);
			this.displayTable.setFont(displayFont);

			for (int i = 0; i < this.displayTable.getColumnModel().getColumnCount(); i++) {
				this.displayTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField() {
					private static final long serialVersionUID = 1189965647815327601L;
					{
						this.setFont(displayFont);
					}
				}));
			}

			this.syncButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Sync");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					int rowIndex = displayTable.getSelectedRow();
					int colIndex = displayTable.getSelectedColumn();

					if (rowIndex == -1 || colIndex == -1 || !(colIndex >= 1 && colIndex <= 4)) {
						JOptionPane.showMessageDialog(null, "Please select station!", "Need Selection", JOptionPane.ERROR_MESSAGE);
					} else {
						String station = (String) dataTable.getValueAt(rowIndex, colIndex);

						List<List<String>> journeys = trainDatabase.jouneryTable.getJourney(trainDatabase.routeTable.getRoutes(station));
						List<List<Double>> locs = new ArrayList<List<Double>>();

						for (int i = 0; i < journeys.size(); i++) {
							if (checkStateGUI.trainLocation.keySet().contains(journeys.get(i).get(2))) {
								locs.add(checkStateGUI.trainLocation.get(journeys.get(i).get(2)));
							} else {
								locs.add(null);
							}
						}

						syncToStation(station, journeys, locs);

						// void
					}
				}
			});
			this.syncButton.setFont(displayFont);

			this.backButton.setAction(new AbstractAction() {
				private static final long serialVersionUID = 7798534274933479763L;

				{
					this.putValue(Action.NAME, "Back");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					setToSyncGUI();
				}

			});
			this.backButton.setFont(displayFont);

			this.add(displayScollPane, BorderLayout.CENTER);
			this.add(new JPanel() {
				private static final long serialVersionUID = 5197516702331806375L;

				{
					this.setLayout(new FlowLayout(1, 10, 10));

					this.add(syncButton);
					this.add(backButton);
				}
			}, BorderLayout.SOUTH);
		}
	}
	/**
	 * sync message to train
	 * 
	 * @param tid
	 *            train id
	 * @param jid
	 *            journey id           
	 * @param locX
	 *            location x
	 * @param locY
	 *            location y
	 */
	public void syncToTrain(String tid, String jid, double locX, double locY) {
		JOptionPane.showMessageDialog(null,
				"Train \"" + tid + "\" in journey \"" + jid + "\" sync succeed!\n" + String.format("x:%.2f, y:%.2f", locX, locY), "Sync Message",
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * sync message to station
	 * 
	 * @param station
	 *            Station to sync
	 * @param journey
	 *            journey to sync
	 * @param locs
	 *            location of trains
	 */
	public void syncToStation(String station, List<List<String>> journey, List<List<Double>> locs) {
		String msg = "";

		for (int i = 0; i < journey.size(); i++) {
			msg += String.join(" ", journey.get(i));

			if (locs.get(i) != null) {
				msg += String.format(" x:%.2f, y:%.2f", locs.get(i).get(0), locs.get(i).get(1));
			}

			msg += "\n";
		}

		if (journey.size() == 0) {
			JOptionPane.showMessageDialog(null, "No Journey pass Station \"" + station + "\".", "Sync Message", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Station \"" + station + "\" sync succeed!\nRelated journey:\n" + msg, "Sync Message", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}

