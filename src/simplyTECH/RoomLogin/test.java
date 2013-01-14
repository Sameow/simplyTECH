package simplyTECH.RoomLogin;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;


public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCardholderName;
	private JTextField textFieldCountry;
	private JTextField textFieldStreetAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setSize(600,600);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(192, 164, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JFormattedTextField formattedTextFieldCardNumber1 = new JFormattedTextField();
		formattedTextFieldCardNumber1.setBounds(171, 11, 25, 20);
		contentPane.add(formattedTextFieldCardNumber1);
		
		textFieldCardholderName = new JTextField();
		textFieldCardholderName.setBounds(10, 82, 86, 20);
		contentPane.add(textFieldCardholderName);
		textFieldCardholderName.setColumns(10);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(10, 129, 86, 20);
		contentPane.add(textFieldCountry);
		
		textFieldStreetAddress = new JTextField();
		textFieldStreetAddress.setColumns(10);
		textFieldStreetAddress.setBounds(10, 184, 86, 20);
		contentPane.add(textFieldStreetAddress);
		
		JTextPane errorMessageCC = new JTextPane();
		errorMessageCC.setForeground(Color.RED);
		errorMessageCC.setFont(new Font("Calibri", Font.PLAIN, 14));
		errorMessageCC.setBackground(new Color(238,238,238));
		errorMessageCC.setBounds(42, 184, 115, 66);
		errorMessageCC.setText("ASDHIDOASDAS");
		contentPane.add(errorMessageCC);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		

	}
}
