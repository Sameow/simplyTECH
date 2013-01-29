package simplytech.room;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import simplytech.entity.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JFrame myFrame = null;
	private static Person personWhoLogin;

	public static Customer getPersonWhoLogin() {
		return (Customer) personWhoLogin;
	}

	public static void setPersonWhoLogin(Person personWhoLogin) {
		if (personWhoLogin instanceof Customer) {
			MainFrame.personWhoLogin = (Customer) personWhoLogin;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				JPanel panel = new RoomLoginPanel(thisClass);
				thisClass.getContentPane().add(panel);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 * 
	 */
	public MainFrame() {
		super();
		myFrame = this;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1024, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Checkmate");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

}
