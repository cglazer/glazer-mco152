package glazer.weatherForecast16Day;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForecastFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelWeek1;
	private JPanel panelWeek2;
	private JPanel centerPanel;
	private JPanel[] firstWeek;
	private JPanel[] secondWeek;
	private JPanel south;
	private JLabel cityName;
	private JLabel todayTemp;
	private JLabel todayMinMax;
	private JLabel todayHumididy;
	private JLabel todayWind;
	private JLabel todayIcon;
	private JLabel description;
	private JLabel date;
	private JLabel nightTemp;
	private JLabel mornTemp;
	private JLabel ocean;
	private JLabel[] tempLabel;
	private JLabel[] dateLabel;
	private JLabel[] iconLabel;
	private String zip;
	private ImageIcon oceanPic;
	private JTextField textFieldZip;
	private Container container;
	private Dimension dim;
	private JPanel north;
	private JPanel centerCenterPanel;
	private JPanel iconAndDesc;
	private JPanel centerWest;
	private JPanel centerEast;
	private JLabel empty;
	private JLabel empty2;

	public ForecastFrame() {
		setTitle("JFrameDemo");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.container = getContentPane();

		this.panelWeek1 = new JPanel(new GridLayout(8, 2));
		this.panelWeek2 = new JPanel(new GridLayout(8, 2));
		this.centerPanel = new JPanel();
		this.oceanPic = new ImageIcon(this.getClass().getResource("ocean.jpg"));
		Image img = oceanPic.getImage();
		Image newimg = img.getScaledInstance(600, 200,
				java.awt.Image.SCALE_SMOOTH);
		this.oceanPic = new ImageIcon(newimg);
		this.ocean = new JLabel();
		this.todayIcon = new JLabel();
		this.date = new JLabel();
		this.nightTemp = new JLabel("nightTemp");
		this.mornTemp = new JLabel("mornTemp");
		this.description = new JLabel();
		this.cityName = new JLabel("city");
		this.todayTemp = new JLabel("76");
		this.todayMinMax = new JLabel();
		this.todayHumididy = new JLabel("humid");
		this.todayWind = new JLabel("wind");
		this.tempLabel = new JLabel[16];
		this.dateLabel = new JLabel[16];
		this.iconLabel = new JLabel[16];
		this.textFieldZip = new JTextField();
		this.dim = new Dimension(80, 40);
		this.south = new JPanel();
		this.north = new JPanel();
		this.centerCenterPanel = new JPanel();
		this.iconAndDesc = new JPanel();
		this.centerWest = new JPanel();
		this.centerEast = new JPanel();
		this.empty = new JLabel(" ");
		this.empty2 = new JLabel(" ");
		this.firstWeek = new JPanel[8];
		this.secondWeek = new JPanel[8];

		for (int i = 0; i < 8; i++) {
			final int num = i;
			this.firstWeek[i] = new JPanel();
			this.tempLabel[i] = new JLabel();
			this.tempLabel[i + 8] = new JLabel();
			this.dateLabel[i] = new JLabel();
			this.dateLabel[i + 8] = new JLabel();
			this.iconLabel[i] = new JLabel();
			this.iconLabel[i + 8] = new JLabel();
			this.firstWeek[i].setLayout(new BorderLayout());
			this.panelWeek1.add(firstWeek[i]);
			this.firstWeek[i].add(this.tempLabel[i], BorderLayout.WEST);
			this.firstWeek[i].add(this.dateLabel[i], BorderLayout.NORTH);
			this.firstWeek[i].add(this.iconLabel[i], BorderLayout.EAST);
			this.firstWeek[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					resetCenter(num);
				}
			});

			final int num2 = i + 8;
			this.secondWeek[i] = new JPanel();
			this.secondWeek[i].setLayout(new BorderLayout());
			this.panelWeek2.add(secondWeek[i]);
			this.secondWeek[i].add(this.tempLabel[i + 8], BorderLayout.WEST);
			this.secondWeek[i].add(this.dateLabel[i + 8], BorderLayout.NORTH);
			this.secondWeek[i].add(this.iconLabel[i + 8], BorderLayout.EAST);
			this.secondWeek[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					resetCenter(num2);
				}
			});
		}

		setComponents();
		addComponents();
		setZip("11367");
	}

	public void setComponents() {
		this.container.setLayout(new BorderLayout());
		this.centerPanel.setLayout(new BorderLayout());
		this.ocean.setIcon(oceanPic);
		this.cityName.setFont(new Font("SansSerif", Font.PLAIN, 100));
		this.nightTemp.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.mornTemp.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.todayTemp.setFont(new Font("SansSerif", Font.PLAIN, 60));
		this.todayTemp.setForeground(Color.RED);
		this.todayMinMax.setFont(new Font("SansSerif", Font.PLAIN, 15));
		this.cityName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.todayHumididy.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.todayWind.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.description.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.textFieldZip.setSize(30, 15);
		this.textFieldZip.setPreferredSize(dim);
		this.textFieldZip.setMaximumSize(dim);
		this.textFieldZip.setFont(new Font("SansSerif", Font.PLAIN, 25));
		this.centerCenterPanel.setLayout(new BoxLayout(centerCenterPanel,
				BoxLayout.PAGE_AXIS));
		this.centerWest
				.setLayout(new BoxLayout(centerWest, BoxLayout.PAGE_AXIS));
		this.centerEast
				.setLayout(new BoxLayout(centerEast, BoxLayout.PAGE_AXIS));
		this.empty.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.empty.setFont(new Font("SansSerif", Font.PLAIN, 30));
	}

	public void addComponents() {
		this.textFieldZip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setZip(textFieldZip.getText());
			}
		});
		this.south.add(new JLabel("ENTER CITY/ZIP"), BorderLayout.EAST);
		this.south.add(this.textFieldZip, BorderLayout.CENTER);
		this.north.add(cityName, BorderLayout.CENTER);
		this.centerPanel.add(north, BorderLayout.NORTH);
		this.centerPanel.add(south, BorderLayout.SOUTH);
		this.centerCenterPanel.add(date, BorderLayout.CENTER);
		this.centerWest.add(todayIcon);
		this.centerWest.add(todayTemp);
		this.centerWest.add(todayMinMax);
		this.centerEast.add(description);
		this.centerEast.add(empty);
		this.centerEast.add(empty2);
		this.centerEast.add(todayHumididy);
		this.centerEast.add(todayWind);
		this.centerEast.add(mornTemp);
		this.centerEast.add(nightTemp);
		this.iconAndDesc.add(ocean, BorderLayout.NORTH);
		this.iconAndDesc.add(centerWest, BorderLayout.WEST);
		this.iconAndDesc.add(centerEast, BorderLayout.EAST);

		this.centerCenterPanel.add(iconAndDesc);
		this.centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		this.container.add(panelWeek1, BorderLayout.WEST);
		this.container.add(panelWeek2, BorderLayout.EAST);
		this.container.add(centerPanel, BorderLayout.CENTER);

	}

	public void setZip(String zip) {
		this.zip = zip;
		ForecastThread thread = new ForecastThread(cityName, todayTemp,
				todayMinMax, todayHumididy, todayWind, todayIcon,
				this.description, this.date, this.zip, this.nightTemp,
				this.mornTemp, 0, this.tempLabel, this.dateLabel,
				this.iconLabel);
		thread.start();
	}

	public void resetCenter(int centerDay) {
		ForecastThread thread = new ForecastThread(cityName, todayTemp,
				todayMinMax, todayHumididy, todayWind, todayIcon,
				this.description, this.date, this.zip, this.nightTemp,
				this.mornTemp, centerDay, this.tempLabel, this.dateLabel,
				this.iconLabel);
		thread.start();
	}

}
