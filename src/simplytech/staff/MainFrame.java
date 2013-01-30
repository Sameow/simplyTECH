package simplytech.staff;

import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import simplytech.entity.Person;
import simplytech.entity.Staff;


import java.awt.Dimension;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JFrame myFrame = null;
	private static Person personWhoLogin;
	

	public static Staff getPersonWhoLogin() {
		return (Staff)personWhoLogin;
	}

	public static void setPersonWhoLogin(Staff personWhoLogin) {
		MainFrame.personWhoLogin = personWhoLogin;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel panel=new WelcomePanel(thisClass);
				thisClass.getContentPane().add(panel);
				thisClass.setVisible(true);
				
			}
		});
	}

	/**
	 * This is the default constructor
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			jContentPane.setLayout(null);
		}
		return jContentPane;
	}
	
}
