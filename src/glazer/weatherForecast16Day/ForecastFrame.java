package glazer.weatherForecast16Day;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForecastFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelWeek1;
	JPanel panelWeek2;
	JPanel centerPanel;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	private JButton[] firstWeek;
	private JButton[] secondWeek;
	private JLabel cityName;
	private JLabel todayTemp;
	private JLabel todayMinMax;
	private JLabel todayHumididy;
	private JLabel todayWind;
	private JLabel todayIcon;
	private JTextField textFieldZip;
	private JLabel description;
	private JLabel date;
	private JPanel south;
	private String zip;

	public ForecastFrame() {
		setTitle("JFrameDemo");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		Color lightBlue = new Color(204, 255, 255);
		panelWeek1 = new JPanel(new GridLayout(8, 2));
		this.panelWeek1.setBorder(BorderFactory.createLineBorder(lightBlue));
		// panelWeek1.setBorder(new LineBorder(Color.black));
		panelWeek2 = new JPanel(new GridLayout(8, 2));
		this.panelWeek2.setBorder(BorderFactory.createLineBorder(lightBlue));
		// panelWeek2.setBorder(new LineBorder(Color.black));
		centerPanel = new JPanel();
		// centerPanel.setLayout(new BorderLayout());
		this.centerPanel.setLayout(new BoxLayout(centerPanel,
				BoxLayout.PAGE_AXIS));
		this.cityName = new JLabel("city");
		this.cityName.setFont(new Font("SansSerif", Font.PLAIN, 50));
		this.todayTemp = new JLabel("76");
		this.todayTemp.setFont(new Font("SansSerif", Font.PLAIN, 90));
		this.todayTemp.setForeground(Color.RED);
		this.todayMinMax = new JLabel("87/45");
		this.cityName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.todayHumididy = new JLabel("humid");
		this.todayHumididy.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.todayWind = new JLabel("wind");
		this.todayWind.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.todayIcon = new JLabel();
		this.date = new JLabel();
		this.description = new JLabel();
		this.textFieldZip = new JTextField();
		this.textFieldZip.setSize(30, 15);
		Dimension dim = new Dimension(80, 40);
		this.textFieldZip.setPreferredSize(dim);
		this.textFieldZip.setMaximumSize(dim);
		// this.textFieldZip.setMinimumSize(dim);
		this.textFieldZip.setFont(new Font("SansSerif", Font.PLAIN, 25));
		/**
		 * this.textFieldZip.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyPressed(KeyEvent ke) {
		 * 
		 *           System.out.println("User is editing something in TextField"
		 *           );
		 * 
		 *           } });
		 */
		this.textFieldZip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setComponents(textFieldZip.getText());
			}
		});
		centerPanel.add(todayIcon, BorderLayout.WEST);
		centerPanel.add(date, BorderLayout.NORTH);
		centerPanel.add(description, BorderLayout.EAST);
		centerPanel.add(cityName, BorderLayout.CENTER);

		centerPanel.add(todayTemp, BorderLayout.CENTER);

		centerPanel.add(todayMinMax, BorderLayout.CENTER);
		centerPanel.add(todayHumididy, BorderLayout.CENTER);
		centerPanel.add(todayWind, BorderLayout.CENTER);
		// centerPanel.add(this.textFieldZip, BorderLayout.SOUTH);
		this.south = new JPanel();
		south.add(this.textFieldZip, BorderLayout.CENTER);

		// this.panelWeek1.setLayout(new BoxLayout(panelWeek1,
		// BoxLayout.PAGE_AXIS));
		// this.panelWeek2.setLayout(new BoxLayout(panelWeek2,
		// BoxLayout.PAGE_AXIS));
		label1 = new JLabel("label1");
		label2 = new JLabel("label2");
		label3 = new JLabel("label3");
		firstWeek = new JButton[8];

		south.setBackground(lightBlue);
		centerPanel.setBackground(lightBlue);
		container.setBackground(lightBlue);
		// container.setBackground();
		secondWeek = new JButton[8];

		for (int i = 0; i < 8; i++) {
			final int num = i;
			firstWeek[i] = new JButton();
			firstWeek[i].setBackground(lightBlue);
			panelWeek1.add(firstWeek[i]);
			firstWeek[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resetCenter(num);
				}
			});
			final int num2 = i + 8;
			secondWeek[i] = new JButton();
			secondWeek[i].setBackground(lightBlue);
			secondWeek[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resetCenter(num2);
				}
			});
			panelWeek2.add(secondWeek[i]);
		}
		container.add(panelWeek1, BorderLayout.WEST);
		container.add(panelWeek2, BorderLayout.EAST);
		container.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(new JLabel(), BorderLayout.SOUTH);
		centerPanel.add(new JLabel("ENTER CITY/ZIP"), BorderLayout.SOUTH);
		centerPanel.add(south, BorderLayout.SOUTH);
		container = getContentPane();
		setComponents("11367");
	}

	public void setComponents(String zip) {
		this.zip = zip;
		ForecastThread thread = new ForecastThread(firstWeek, secondWeek,
				cityName, todayTemp, todayMinMax, todayHumididy, todayWind,
				todayIcon, this.description, this.date, this.zip, 0);
		thread.start();
	}

	public void resetCenter(int centerDay) {
		ForecastThread thread = new ForecastThread(firstWeek, secondWeek,
				cityName, todayTemp, todayMinMax, todayHumididy, todayWind,
				todayIcon, this.description, this.date, this.zip, centerDay);
		thread.start();
	}

}
