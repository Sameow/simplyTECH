package simplytech.room;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import simplytech.dao.BookingDAO;
import simplytech.dao.CustomerDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;

public class Booking extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelBooking = null;
	private JFrame myFrame = null;
	private JLabel jLabelMovies = null;
	private JLabel jLabelGames = null;
	private JLabel jLabelBack = null;
	private JTextPane jTextPane = null;
	private JPanel moviesPane;
	private JButton btnMovies;
	private JButton btnConsoleGames;
	private JLabel lblMovies;
	private JButton buttonM1;
	private JButton buttonM2;
	private JButton buttonM3;
	private JPanel consoleGamesPane;
	private JLabel lblConsoleGames;
	private JButton buttonCG1;
	private JButton buttonCG2;
	private JButton buttonCG3;
	private String title;
	private double price;
	private int points;
	private String username;
	private int currentPoints;
	private int id;
	private int finalPoints;
	private double currentCharges;
	private double finalCharges;
	private Calendar calendar;
	private long start;
	private long stop;

	/**
	 * This method initializes jButtonMovies
	 * 
	 * @return javax.swing.JButton
	 */
	private JLabel getJButtonMovies() {
		if (jLabelMovies == null) {
			jLabelMovies = new JLabel();
			jLabelMovies.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/movies.png")));
			jLabelMovies.setSize(new Dimension(167, 138));
			jLabelMovies.setText("Movies");
			jLabelMovies.setLocation(new Point(101, 130));
		}
		return jLabelMovies;
	}

	/**
	 * This method initializes jButtonGames
	 * 
	 * @return javax.swing.JButton
	 */
	private JLabel getJButtonGames() {
		if (jLabelGames == null) {
			jLabelGames = new JLabel();
			jLabelGames.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/Console Games.png")));
			jLabelGames.setSize(new Dimension(167, 139));
			jLabelGames.setLocation(new Point(101, 313));
		}
		return jLabelGames;
	}

	/**
	 * This method initializes jTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBackground(new Color(91, 155, 213));
			jTextPane.setSize(new Dimension(371, 4));
			jTextPane.setLocation(new Point(0, 78));
		}
		return jTextPane;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * This is the default constructor
	 */
	public Booking() {
		super();
		initialize();
		moviesPane.setVisible(false);
	}

	public Booking(JFrame f) {
		this();
		myFrame = f;
		initialize();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		username = MainFrame.getPersonWhoLogin().getUsername();
		id = MainFrame.getPersonWhoLogin().getId();
		currentPoints = MainFrame.getPersonWhoLogin().getPoints();
		
		jLabelBack = new JLabel();
		jLabelBack.setText("");
		jLabelBack.setLocation(new Point(-13, -25));
		jLabelBack.setSize(new Dimension(128, 128));
		jLabelBack.setIcon(new ImageIcon(Booking.class
				.getResource("/simplytech/image/Swap Left.png")));
		jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				start = calendar.getInstance().getTimeInMillis();
			}
			public void mouseReleased(MouseEvent arg0) {
				stop = calendar.getInstance().getTimeInMillis();
				if (stop - start < 500) {
					JPanel panel = new Services(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				} else {
					JPanel panel = new RoomHomePagePanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			}
		});
		jLabelBooking = new JLabel();
		jLabelBooking.setHorizontalAlignment(SwingConstants.LEADING);
		jLabelBooking.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabelBooking.setFont(new Font("Arial", Font.BOLD, 28));
		jLabelBooking.setLocation(new Point(91, 23));
		jLabelBooking.setSize(new Dimension(216, 35));
		jLabelBooking.setText("Booking");
		this.setSize(1024, 600);
		this.setLayout(null);
		this.setBackground(new Color(227, 228, 250));
		this.add(jLabelBooking, null);
		this.add(getJButtonMovies(), null);
		this.add(getJButtonGames(), null);
		this.add(jLabelBack, null);
		this.add(getJTextPane(), null);
		add(getBtnMovies());
		add(getBtnConsoleGames());
		add(getConsoleGamesPane());
		add(getMoviesPane());
	}

	private JPanel getMoviesPane() {
		if (moviesPane == null) {
			moviesPane = new JPanel();
			moviesPane.setBorder(new LineBorder(SystemColor.activeCaptionText,
					3, true));
			moviesPane.setBounds(523, 130, 430, 437);
			moviesPane.setLayout(null);
			moviesPane.add(getLblMovies());
			moviesPane.add(getButtonM1());
			moviesPane.add(getButtonM2());
			moviesPane.add(getButtonM3());
		}
		return moviesPane;
	}

	private JButton getBtnMovies() {
		if (btnMovies == null) {
			btnMovies = new JButton("Movies");
			btnMovies.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					moviesPane.setVisible(true);
					consoleGamesPane.setVisible(false);
				}
			});
			btnMovies.setFont(new Font("Calibri", Font.BOLD, 18));
			btnMovies.setBounds(266, 129, 178, 139);
			btnMovies.setBackground(new Color(91, 155, 231));
		}
		return btnMovies;
	}

	private JButton getBtnConsoleGames() {
		if (btnConsoleGames == null) {
			btnConsoleGames = new JButton("Console Games");
			btnConsoleGames.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnConsoleGames.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					moviesPane.setVisible(false);
					consoleGamesPane.setVisible(true);
				}
			});
			btnConsoleGames.setFont(new Font("Calibri", Font.BOLD, 18));
			btnConsoleGames.setBounds(266, 313, 178, 139);
			btnConsoleGames.setBackground(new Color(91, 155, 231));
		}
		return btnConsoleGames;
	}

	private JLabel getLblMovies() {
		if (lblMovies == null) {
			lblMovies = new JLabel("Movies");
			lblMovies.setHorizontalAlignment(SwingConstants.CENTER);
			lblMovies.setFont(new Font("Calibri", Font.BOLD, 20));
			lblMovies.setOpaque(true);
			lblMovies.setBackground(new Color(91, 155, 231));
			lblMovies.setBounds(0, 0, 430, 50);
		}
		return lblMovies;
	}

	private JButton getButtonM1() {
		if (buttonM1 == null) {
			buttonM1 = new JButton("");
			buttonM1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int m = JOptionPane
							.showConfirmDialog(
									myFrame,
									"Finding Nemo \n"
											+ "After his son is captured in the Great Barrier Reef and taken to Sydney, a\n"
											+ "timid clownfish sets out on a journey to bring him home.\n"
											+ "Price: SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (m == JOptionPane.YES_OPTION) {
						title = "Finding Nemo";
						price = 5;
						points = (int) price;

						setTitle(title);
						setPrice(price);
						setPoints(points);
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setUsername(username);
						booking.setPrice(price);
						booking.setPoints(points);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}
			});
			buttonM1.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/nemo.png")));
			buttonM1.setBounds(48, 76, 146, 153);
		}
		return buttonM1;
	}

	private JButton getButtonM2() {
		if (buttonM2 == null) {
			buttonM2 = new JButton("");
			buttonM2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int m = JOptionPane
							.showConfirmDialog(
									myFrame,
									"Paranormal Activity 4 \n"
											+ "It has been five years since the disappearance of Katie and Hunter, and\n"
											+ "a suburban family witness strange events in their neighborhood\n"
											+ "when a woman and a mysterious child move in.\n"
											+ "Price : SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (m == JOptionPane.YES_OPTION) {
						title = "Paranormal Activity 4";
						price = 5;
						points = (int) price;

						setTitle(title);
						setPrice(price);
						setPoints(points);
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setPrice(price);
						booking.setPoints(points);
						booking.setUsername(username);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			buttonM2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

				}
			});
			buttonM2.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/PA4.png")));
			buttonM2.setBounds(232, 76, 146, 153);
		}
		return buttonM2;
	}

	private JButton getButtonM3() {
		if (buttonM3 == null) {
			buttonM3 = new JButton("");
			buttonM3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int m = JOptionPane
							.showConfirmDialog(
									myFrame,
									"TaiChi 2 \n"
											+ "The second instalment of the \"Tai Chi\" trilogy continues the journey of \n"
											+ "Yang Luchan, a gifted child with a fleshy growth on his forehead who helped save\n"
											+ "a village from a frightening army of steampunk soldiers bearing strange machines with the \n"
											+ "knowledge of Tai Chi that they entrusted him with. \n"
											+ "Price : SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (m == JOptionPane.YES_OPTION) {

						title = "TaiChi 2";
						price = 5;
						points = (int) price;
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						
						setTitle(title);
						setPrice(price);
						setPoints(points);
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setPrice(price);
						booking.setUsername(username);
						booking.setPoints(points);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			buttonM3.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/TC.png")));
			buttonM3.setBounds(48, 253, 146, 153);
		}
		return buttonM3;
	}

	private JPanel getConsoleGamesPane() {
		if (consoleGamesPane == null) {
			consoleGamesPane = new JPanel();
			consoleGamesPane.setBounds(523, 130, 430, 437);
			consoleGamesPane.setLayout(null);
			consoleGamesPane.setBorder(new LineBorder(
					SystemColor.activeCaptionText, 3, true));
			consoleGamesPane.add(getLblConsoleGames());
			consoleGamesPane.add(getButtonCG1());
			consoleGamesPane.add(getButtonCG2());
			consoleGamesPane.add(getButtonCG3());
		}
		return consoleGamesPane;
	}

	private JLabel getLblConsoleGames() {
		if (lblConsoleGames == null) {
			lblConsoleGames = new JLabel("Console Games");
			lblConsoleGames.setOpaque(true);
			lblConsoleGames.setHorizontalAlignment(SwingConstants.CENTER);
			lblConsoleGames.setFont(new Font("Calibri", Font.BOLD, 20));
			lblConsoleGames.setBackground(new Color(91, 155, 231));
			lblConsoleGames.setBounds(0, 0, 430, 50);
		}
		return lblConsoleGames;
	}

	private JButton getButtonCG1() {
		if (buttonCG1 == null) {
			buttonCG1 = new JButton("");
			buttonCG1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int g = JOptionPane
							.showConfirmDialog(
									myFrame,
									"Gran Turismo 5 \n"
											+ "The fifth edition of the Gran Turismo sim racing video game series. Developed by Polyphony Digital \n"
											+ "and published by Sony Computer Entertainment, it was released for PlayStation 3 on November 24, 2010. \n"
											+ "It expands on the game's Prologue version and is the first entry of the series to be developed for PlayStation 3. \n"
											+ "Price : SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (g == JOptionPane.YES_OPTION) {
						title = "Gran Turismo 5";
						price = 5;
						points = (int) price;

						setTitle(title);
						setPrice(price);
						setPoints(points);
						
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setPrice(price);
						booking.setUsername(username);
						booking.setPoints(points);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			buttonCG1.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/GT5.PNG")));
			buttonCG1.setBounds(48, 81, 146, 153);
		}
		return buttonCG1;
	}

	private JButton getButtonCG2() {
		if (buttonCG2 == null) {
			buttonCG2 = new JButton("");
			buttonCG2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int g = JOptionPane
							.showConfirmDialog(
									myFrame,
									"Grand Theft Auto 4 \n"
											+ " The game is a reboot of the Grand Theft Auto series, depicting a separate timeline and world than its \n"
											+ "predecessors (known as the \"high-definition universe\") and is set in fictional Liberty City, based heavily on \n"
											+ "modern day New York City. The game follows Niko Bellic, a veteran of an unnamed war in Eastern Europe, who \n"
											+ "comes to the United States in search of the American Dream, but quickly becomes entangled in a world of gangs, crime, and \n"
											+ "corruption. \n"
											+ "Price : SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (g == JOptionPane.YES_OPTION) {
						title = "Grand Theft Auto 4";
						price = 5;
						points = (int) price;

						setTitle(title);
						setPrice(price);
						setPoints(points);
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setPrice(price);
						booking.setPoints(points);
						booking.setUsername(username);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			});
			buttonCG2.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/GTA4.PNG")));
			buttonCG2.setBounds(230, 81, 146, 153);
		}
		return buttonCG2;
	}

	private JButton getButtonCG3() {
		if (buttonCG3 == null) {
			buttonCG3 = new JButton("");
			buttonCG3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int g = JOptionPane
							.showConfirmDialog(
									myFrame,
									"Call of Duty: Modern Warfare 3 \n"
											+ "Call of Duty: Modern Warfare 3 is a first-person shooter video game, developed by \n"
											+ " Infinity Ward and Sledgehammer Games (Treyarch for the Wii version), with \n"
											+ " Raven Software having assisted in development. It is the third installment in the Modern Warfare series, a \n"
											+ "direct sequel to 2009's Call of Duty: Modern Warfare 2, and the eighth Call of Duty installment. \n"
											+ "Price : SGD$5.00",
									"Are you sure you want to book?",
									JOptionPane.YES_NO_OPTION);
					if (g == JOptionPane.YES_OPTION) {
						title = "Call of Duty: Modern Warfare 3";
						price = 5;
						points = (int) price;

						setTitle(title);
						setPrice(price);
						setPoints(points);
						finalPoints = currentPoints + points;
						finalCharges = currentCharges + price;
						
						JOptionPane.showMessageDialog(myFrame,
								"You have booked " + title + "\nPrice: $"
										+ price + "\n You've earned " + points
										+ " points.");

						simplytech.entity.Booking booking = new simplytech.entity.Booking();
						booking.setTitle(title);
						booking.setPrice(price);
						booking.setUsername(username);
						booking.setPoints(points);
						booking.setId(id);
						BookingDAO.save(booking);
						try {
							CustomerDAO.updatePoints(finalPoints, MainFrame.getPersonWhoLogin().getId());
							CustomerDAO.updateCharges(finalCharges, MainFrame.getPersonWhoLogin().getId());
							MainFrame.getPersonWhoLogin().setPoints(finalPoints);
							MainFrame.getPersonWhoLogin().setExtraCharges(finalCharges);
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			});
			buttonCG3.setIcon(new ImageIcon(Booking.class
					.getResource("/simplytech/image/Modern Warfare 3.PNG")));
			buttonCG3.setBounds(48, 245, 146, 153);
		}
		return buttonCG3;
	}
}
