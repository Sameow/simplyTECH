package simplytech.staff;

import java.awt.GridLayout;

import java.awt.Label;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;

import java.io.File;

import java.io.FileInputStream;

import java.net.URL;

import java.net.URLConnection;

import javax.swing.*;

public class UploadForm extends JFrame implements ActionListener {

	File image;
	JTextField imagePath = new JTextField("");
	JButton imageBrowse = new JButton("Find Image");
	private final JLabel lblNewLabel = new JLabel("New label");

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(imageBrowse)) {
			String s;
			JFileChooser jfc = new JFileChooser();
			jfc.showDialog(jfc, "Choose an image file");
			s = jfc.getSelectedFile().getAbsolutePath();
			imagePath.setText(s);
			lblNewLabel.setIcon(new ImageIcon(s));
			}
		else {
			File f = new File(imagePath.getText());
			try {
				FileInputStream in = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

	public UploadForm() {
		imageBrowse.setBounds(0, 64, 312, 64);
		imageBrowse.addActionListener(this);
		this.setSize(640,168);
		getContentPane().setLayout(null);
		imagePath.setBounds(0, 0, 312, 64);
		getContentPane().add(imagePath);
		lblNewLabel.setBounds(345, 0, 185, 128);
		getContentPane().add(lblNewLabel);
		getContentPane().add(imageBrowse);
	}

	public static void main(String[] args) {
		JFrame f = new UploadForm();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
