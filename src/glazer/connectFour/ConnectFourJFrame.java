package glazer.connectFour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConnectFourJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxComponent[][] emptyBox;
	private int player;
	private Container contentPane;
	private JButton play;
	private JLabel gameName;
	private JLabel four;
	private YellowChecker yellowChecker;
	private YellowChecker yellowChecker2;
	private YellowChecker yellowChecker3;
	private YellowChecker yellowChecker4;
	private JLabel instructions;
	private JLabel detailInstructions;
	private StringBuilder text;
	private JButton start;
	private Color lightBlue;
	private JLabel yellow;
	private JLabel red;
	private JButton playAgain;
	private JLabel youWon;
	private int selectedOption;

	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = getContentPane();
		this.start = new JButton("START");
		this.play = new JButton("START");
		this.gameName = new JLabel("CONNECT");
		this.four = new JLabel("FOUR");
		this.yellowChecker = new YellowChecker();
		this.yellowChecker2 = new YellowChecker();
		this.yellowChecker3 = new YellowChecker();
		this.yellowChecker4 = new YellowChecker();
		this.lightBlue = new Color(31, 190, 214);
		this.instructions = new JLabel("INSTRUCTIONS");
		this.text = new StringBuilder(
				"<html>Take turns with another player moving your mouse to move your pegs into the play area. You will win when four consecutive pegs of your color line up either vertically, horizontally, or diagnally.</html>");
		this.detailInstructions = new JLabel(text.toString());
		this.player = 1;
		this.yellow = new JLabel("Go Yellow!");
		this.red = new JLabel("Go Red!");
		this.youWon = new JLabel("YOU WON!", JLabel.CENTER);
		this.playAgain = new JButton("Click here to play again!");
		startScreen();
	}

	public void startScreen() {
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(lightBlue);
		this.contentPane.setForeground(lightBlue);
		this.gameName.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 75));
		this.gameName.setForeground(Color.blue);
		this.gameName.setBounds(50, 20, 500, 140);
		this.four.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 75));
		this.four.setForeground(Color.blue);
		this.four.setBounds(120, 80, 250, 140);
		this.yellowChecker.setBounds(108, 58, 63, 63);
		this.yellowChecker2.setBounds(171, 120, 63, 63);
		this.yellowChecker3.setBounds(234, 182, 63, 63);
		this.yellowChecker4.setBounds(297, 244, 63, 63);
		this.play.setBackground(lightBlue);
		this.play.setForeground(Color.RED);
		this.play.setFont(new Font("Algerian", Font.BOLD, 90));
		this.play.setBorder(BorderFactory.createLineBorder(lightBlue));
		this.play.setBounds(430, 350, 310, 150);
		this.contentPane.add(gameName, lightBlue);
		this.contentPane.add(four, lightBlue);
		this.contentPane.add(play);
		this.contentPane.add(yellowChecker);
		this.contentPane.add(yellowChecker2);
		this.contentPane.add(yellowChecker3);
		this.contentPane.add(yellowChecker4);
		this.contentPane.setComponentZOrder(yellowChecker, 0);
		this.contentPane.setComponentZOrder(yellowChecker2, 1);
		this.contentPane.setComponentZOrder(gameName, 2);

		this.play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// call the instructions screen
				Instructions();
			}
		});
	}

	public void Instructions() {
		this.contentPane.removeAll();
		validate();
		repaint();
		this.contentPane.setForeground(lightBlue);
		this.contentPane.setBackground(lightBlue);
		this.contentPane.setLayout(null);
		this.instructions.setBounds(140, 25, 550, 100);
		this.instructions.setFont(new Font("Rockwell Extra Bold", Font.PLAIN,
				60));
		this.detailInstructions.setFont(new Font("Calibri", Font.PLAIN, 26));
		this.detailInstructions.setBounds(200, 150, 400, 200);
		this.start.setBounds(250, 350, 310, 150);
		this.start.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 50));
		this.start.setBackground(lightBlue);
		this.start.setForeground(Color.RED);
		this.start.setBorder(BorderFactory.createLineBorder(lightBlue));
		this.contentPane.add(this.instructions, BorderLayout.CENTER);
		this.contentPane.add(this.detailInstructions, BorderLayout.CENTER);
		this.contentPane.add(start, BorderLayout.CENTER);

		this.start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// play the game!
				setUpGame();
			}
		});
	}

	public void setUpGame() {
		this.contentPane.removeAll();
		setLayout(new GridLayout(6, 7));
		this.player = 1;
		this.emptyBox = new BoxComponent[6][7];
		addComponents();
	}

	public void addComponents() {
		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 7; n++) {
				final int row = m;
				final int column = n;
				this.emptyBox[m][n] = new BoxComponent();
				add(this.emptyBox[m][n]);
				this.emptyBox[m][n].setBorder(BorderFactory
						.createLineBorder(Color.BLUE));
				this.emptyBox[m][n].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean done = false;
						for (int x = 5; x > row; x--) {
							if (!emptyBox[x][column].isFlagged()) {
								if (player % 2 == 1) {
									emptyBox[x][column].setYellow();
									player++;
									if (player == 43) {
										selectedOption = JOptionPane
												.showConfirmDialog(
														null,
														"Sorry there is no winner to this game. Would you like to play again?",
														"Choose",
														JOptionPane.YES_NO_OPTION);
										if (selectedOption == JOptionPane.YES_OPTION) {
											setUpGame();
										}
									}
									done = true;
								} else {
									emptyBox[x][column].setRed();
									player++;
									if (player == 43) {
										selectedOption = JOptionPane
												.showConfirmDialog(
														null,
														"Sorry there is no winner to this game. Would you like to play again?",
														"Choose",
														JOptionPane.YES_NO_OPTION);
										if (selectedOption == JOptionPane.YES_OPTION) {
											setUpGame();
										}

									}
									done = true;
								}
								break;
							}
						}
						if (!done && !emptyBox[row][column].isFlagged()) {
							if (player % 2 == 1) {
								emptyBox[row][column].setYellow();
							} else {
								emptyBox[row][column].setRed();
							}
							player++;
							if (player == 43) {
								selectedOption = JOptionPane
										.showConfirmDialog(
												null,
												"Sorry there is no winner to this game. Would you like to play again?",
												"Choose",
												JOptionPane.YES_NO_OPTION);
								if (selectedOption == JOptionPane.YES_OPTION) {
									setUpGame();
								}

							}
						}
						checkSet();
					}
				});
				/**
				 * emptyBox[m][n] .addMouseListener(new
				 * java.awt.event.MouseAdapter() {
				 * 
				 * @Override public void mouseEntered( java.awt.event.MouseEvent
				 *           evt) { System.out.println("entered"); Arrow arrow =
				 *           new Arrow(); emptyBox[0][column].add(arrow); if
				 *           (player % 2 == 0) { arrow.setColor(Color.RED); }
				 *           else { arrow.setColor(Color.yellow); } //
				 *           repaint(); } });
				 */
			}
		}
	}

	public void checkSet() {
		// check vertical rows
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 7; n++) {
				if (emptyBox[m][n].isFlagged()) {
					if (emptyBox[m][n].getColor().equals(
							emptyBox[m + 1][n].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m + 2][n].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m + 3][n].getColor())) {
						youWon(emptyBox[m][n].getColor());
						break;
					}
				}
			}
		}
		// check horizontal rows
		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 4; n++) {
				if (emptyBox[m][n].isFlagged()) {
					if (emptyBox[m][n].getColor().equals(
							emptyBox[m][n + 1].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m][n + 2].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m][n + 3].getColor())) {
						youWon(emptyBox[m][n].getColor());
						break;
					}
				}
			}
		}
		// check diagonal rows- negative slope!

		for (int m = 0; m <= 2; m++) {
			for (int n = 0; n <= 3; n++) {
				if (emptyBox[m][n].isFlagged()) {
					if (emptyBox[m][n].getColor().equals(
							emptyBox[m + 1][n + 1].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m + 2][n + 2].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m + 3][n + 3].getColor())) {
						youWon(emptyBox[m][n].getColor());
						break;
					}
				}
			}
		}

		// check diagonal rows-positive slope! for (int m = 3; m <= 6; m++) {
		for (int m = 3; m < 6; m++) {
			for (int n = 0; n <= 3; n++) {
				if (emptyBox[m][n].isFlagged()) {
					if (emptyBox[m][n].getColor().equals(
							emptyBox[m - 1][n + 1].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m - 2][n + 2].getColor())
							&& emptyBox[m][n].getColor().equals(
									emptyBox[m - 3][n + 3].getColor())) {
						youWon(emptyBox[m][n].getColor());
						break;
					}
				}
			}
		}

	}

	private void youWon(Color color) {

		this.contentPane.removeAll();
		validate();
		repaint();
		this.contentPane.setBackground(this.lightBlue);
		this.contentPane.setLayout(new BorderLayout());

		if (color == Color.yellow) {
			this.yellow.setBounds((getWidth() / 2) - 240, 74, 480, 90);
			this.yellow.setFont(new Font("Serif", Font.BOLD, 100));
			add(this.yellow);
		} else {
			this.red.setFont(new Font("Serif", Font.BOLD, 100));
			this.red.setBounds((getWidth() / 2) - 200, 74, 400, 90);
			add(this.red);
		}
		this.youWon.setForeground(Color.RED);
		this.youWon.setFont(new Font("Serif", Font.BOLD, 140));
		this.contentPane.add(youWon, BorderLayout.CENTER);
		this.playAgain.setBackground(Color.BLUE);
		this.contentPane.add(this.playAgain, BorderLayout.SOUTH);
		setVisible(true);
		this.playAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setUpGame();
			}
		});

	}

}
