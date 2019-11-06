import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.xml.soap.Text;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Main extends JFrame {
	private final int FRAME_WIDTH = 1400;
	private final int FRAME_HEIGHT = 900;
	private static int AREA_WIDTH = 10;
	private static int AREA_HEIGHT = 10;
	private static int CONTENT = 32;
	private final static int WEIGHFIELD = 180;
	private final static int HIGHFIELD = 45;
	private JLabel fit;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField shoulderField;
	private JTextField chestField;
	private JTextField waistField;
	private JTextField hipField;
	private JTextField thighField;
	private JLabel heightLabel;
	private JLabel weightLabel;
	private JLabel shoulderLabel;
	private JLabel chestLabel;
	private JLabel waistLabel;
	private JLabel hipLabel;
	private JLabel thighLabel;
	private JButton searchButton;
	private JComboBox<String> option;
	private JTextArea picture;
	private JTextArea picture1;
	private JTextArea picture2;
	private JTextArea picture3;
	private JButton myShop;
	private int userID;
	private JButton show1;
	private JButton show2;
	private JButton show3;
	private JButton show4;
	private JButton show5;
	private JButton show6;
	private JButton show7;
	private JButton show8;
	private JButton show9;
	private JPanel panel11;
	private JPanel mainPanel;

	public Main() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		createHomePage();

	}

	private JPanel createSizePanel() {
		JPanel sizePanel = new JPanel();
		sizePanel.setLayout(new BorderLayout());
		JPanel smallPan = new JPanel();
		sizePanel.setPreferredSize(new Dimension(300, 2000));
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new TitledBorder(new EtchedBorder()));
		myShop = new JButton("我的賣場");
		myShop.setFont(new Font("微軟正黑體", 1, 25));
		myShop.setPreferredSize(new Dimension(150, 50));
		class sellpageActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				MySellPage frame = new MySellPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				frame.setUserID(userID);
				setVisible(false);

			}
		}

		myShop.addActionListener(new sellpageActionListener());
		smallPan.add(myShop);
		// sizePanel.setPreferredSize(new Dimension(500,100));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();

		heightLabel = new JLabel("身高: ");
		heightLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		weightLabel = new JLabel("體重: ");
		shoulderLabel = new JLabel("肩寬: ");
		chestLabel = new JLabel("胸圍:  ");
		waistLabel = new JLabel("腰圍:  ");
		hipLabel = new JLabel("臀圍: ");
		thighLabel = new JLabel("大腿圍: ");
		weightLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		chestLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		shoulderLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		hipLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		thighLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		waistLabel.setFont(new Font("微軟正黑體", 0, CONTENT));
		weightField = new JTextField();
		weightField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		heightField = new JTextField();
		heightField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		shoulderField = new JTextField();
		shoulderField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		chestField = new JTextField();
		chestField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		waistField = new JTextField();
		waistField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		hipField = new JTextField();
		hipField.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		thighField = new JTextField();
		thighField.setPreferredSize(new Dimension(160, HIGHFIELD));

		gridPanel.setLayout(new GridLayout(8, 1));
		panel1.add(heightLabel);
		panel1.add(heightField);
		gridPanel.add(panel1);
		panel2.add(weightLabel);
		panel2.add(weightField);
		gridPanel.add(panel2);
		panel3.add(shoulderLabel);
		panel3.add(shoulderField);
		gridPanel.add(panel3);
		panel4.add(chestLabel);
		panel4.add(chestField);
		gridPanel.add(panel4);
		panel5.add(waistLabel);
		panel5.add(waistField);
		gridPanel.add(panel5);
		panel6.add(hipLabel);
		panel6.add(hipField);
		gridPanel.add(panel6);
		panel7.add(thighLabel);
		panel7.add(thighField);
		gridPanel.add(panel7);
		gridPanel.add(createSearchButton());

		sizePanel.add(gridPanel, BorderLayout.CENTER);
		sizePanel.add(smallPan, BorderLayout.SOUTH);
		// sizePanel.add(myShop);
		return sizePanel;

	}

	public JPanel createSearchButton() {
		searchButton = new JButton("搜尋");
		searchButton.setFont(new Font("微軟正黑體", 1, 25));
		searchButton.setPreferredSize(new Dimension(200, 50));
//  searchButton.setPreferredSize(new Dimension(10,10));
		JPanel panel = new JPanel();
		panel.add(searchButton);

		class AddedListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					search();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		searchButton.addActionListener(new AddedListener());
		return panel;

	}

	public JPanel createTitlePanel() {
		JPanel panel = new JPanel();
		fit = new JLabel("Fit Amazing", SwingConstants.CENTER);
		fit.setFont(new Font("20th Centenary Faux", 1, 100));
		Color c = Color.PINK;
		fit.setForeground(c);
		panel.add(fit);
		return panel;
	}

	public JPanel createCombo() {
		JPanel panel2 = new JPanel();
		option = new JComboBox<>();
		// option.setSize(30,10);
		option.setPreferredSize(new Dimension(800, 60));
		option.setFont(new Font("微軟正黑體", 0, 32));
		option.addItem("上衣");
		option.addItem("背心");
		option.addItem("長褲");
		option.addItem("短褲");
		option.addItem("短裙");
		option.addItem("長裙");
		option.addItem("外套");
		option.addItem("全部");
		option.setSelectedIndex(7);
		panel2.add(option);
		return panel2;
	}

	public ScrollPane createShowPanel() {

		mainPanel = new JPanel();
		ScrollPane scrollPane = new ScrollPane();

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();

		p1.setBorder(new EtchedBorder());
		p2.setBorder(new EtchedBorder());
		p3.setBorder(new EtchedBorder());
		p4.setBorder(new EtchedBorder());
		p5.setBorder(new EtchedBorder());
		p6.setBorder(new EtchedBorder());
		p7.setBorder(new EtchedBorder());
		p8.setBorder(new EtchedBorder());
		p9.setBorder(new EtchedBorder());

		try {
			p1.add(createshow1());
			p2.add(createshow2());
			p3.add(createshow3());
			p4.add(createshow4());
			p5.add(createshow5());
			p6.add(createshow6());
			p7.add(createshow7());
			p8.add(createshow8());
			p9.add(createshow9());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mainPanel.add(option);
		mainPanel.setLayout(new GridLayout(5, 2));
		mainPanel.add(p1);
		mainPanel.add(p2);
		mainPanel.add(p2);
		mainPanel.add(p3);
		mainPanel.add(p4);
		mainPanel.add(p5);
		mainPanel.add(p6);
		mainPanel.add(p7);
		mainPanel.add(p8);
		mainPanel.add(p9);

		scrollPane.add(mainPanel);

		return scrollPane;
	}

	public JButton createshow1() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='37'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goodsActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(37);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goodsActionListener());
		connection.close();
		return show;
	}

	public JButton createshow2() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='38'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods2ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(38);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods2ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow3() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='39'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods3ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(39);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods3ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow4() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='40'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods4ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(40);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods4ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow5() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='41'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods5ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(41);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods5ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow6() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='42'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods6ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(42);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods6ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow7() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='43'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods7ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(43);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods7ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow8() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='44'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods8ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(44);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods8ActionListener());
		connection.close();
		return show;
	}

	public JButton createshow9() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select photo from MG13.Product where `Product_Number`='45'";
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(query);
		JButton show = new JButton();
		show.setPreferredSize(new Dimension(400, 250));
		if (rSet.next()) {
			byte[] img = rSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			show.setIcon(newicon);
		}
		class goods9ActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(45);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		show.addActionListener(new goods9ActionListener());
		connection.close();
		return show;
	}

	public void createHomePage() {
		panel11 = new JPanel();
		panel11.setLayout(new GridLayout(2, 1));
		panel11.add(createTitlePanel());
		panel11.add(createCombo());
		setLayout(new BorderLayout());
		add(createSizePanel(), BorderLayout.WEST);
		add(panel11, BorderLayout.NORTH);
		add(createShowPanel(), BorderLayout.CENTER);

	}

	public void search() throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		int sl;
		if (option.getSelectedIndex() != 7) {
			sl = option.getSelectedIndex();
			if (sl == 0 && heightField != null && weightField != null && shoulderField != null && chestField != null) {
				String query = "SELECT `Product_Number` FROM MG13.Product WHERE  `Type_Number`='2' and  `height_low`<=? AND `height_high`>=? AND `weight_low`<= ? AND `weight_high`>= ? AND `shoulder_low`<= ? AND `shoulder_high`>= ? AND `chest_low`<= ? AND `chest_high`>=? ";
				PreparedStatement pStatement = connection.prepareStatement(query);
				pStatement.setInt(1, Integer.parseInt(heightField.getText()));
				pStatement.setInt(2, Integer.parseInt(heightField.getText()));
				pStatement.setInt(3, Integer.parseInt(weightField.getText()));
				pStatement.setInt(4, Integer.parseInt(weightField.getText()));
				pStatement.setInt(5, Integer.parseInt(shoulderField.getText()));
				pStatement.setInt(6, Integer.parseInt(shoulderField.getText()));
				pStatement.setInt(7, Integer.parseInt(chestField.getText()));
				pStatement.setInt(8, Integer.parseInt(chestField.getText()));
				ResultSet resultSet = pStatement.executeQuery();
				mainPanel.removeAll();
				mainPanel.setLayout(new GridLayout(5, 2));
				if (resultSet.next()) {
					System.out.println(resultSet.getInt("Product_Number"));
					for (int i = 1; i <=resultSet.getRow(); i++) {
						mainPanel.add(createNewbutton(resultSet.getInt("Product_Number")));
					}
				} else if(!resultSet.next()){
                     JLabel label=new JLabel("Sorry!Nothing fits you !") ;
                     label.setFont(new Font("微軟正黑體", 1, 72));
                     JPanel textpamel=new JPanel();
                     textpamel.add(label);
                     mainPanel.add(textpamel);
				}
				mainPanel.revalidate();
			} else if (sl == 2 && heightField != null && weightField != null && waistField != null && hipField != null
					&& thighField != null) {
				String query1 = "SELECT `Product_Number` FROM MG13.Product WHERE `Type_Number`='2' and  `height_low`<=? and ?<=`height_high` AND `weight_low`<=? and ?<=`weight_high`AND `waistline_low`<=? and ?<= `waistline_high`AND `hip circumference_low`<=? and ?<=`hip circumference_high`AND `thigh circumference_low`<= ? and ?<=`thigh circumference_high`";
				PreparedStatement pStatement=connection.prepareStatement(query1);
				pStatement.setInt(1, Integer.parseInt(heightField.getText()));
				pStatement.setInt(2, Integer.parseInt(heightField.getText()));
				pStatement.setInt(3, Integer.parseInt(weightField.getText()));
				pStatement.setInt(4, Integer.parseInt(weightField.getText()));
				pStatement.setInt(5,Integer.parseInt(waistField.getText()));
				pStatement.setInt(6,Integer.parseInt(waistField.getText()));
				pStatement.setInt(7, Integer.parseInt(hipField.getText()));
				pStatement.setInt(8, Integer.parseInt(hipField.getText()));
				pStatement.setInt(9, Integer.parseInt(thighField.getText()));
				pStatement.setInt(10, Integer.parseInt(thighField.getText()));
				ResultSet resultSet = pStatement.executeQuery();
				mainPanel.removeAll();
				mainPanel.setLayout(new GridLayout(5, 2));
				if (resultSet.next()) {
					System.out.println(resultSet.getInt("Product_Number"));
					for (int i = 1; i <=resultSet.getRow(); i++) {
						mainPanel.add(createNewbutton(resultSet.getInt("Product_Number")));
					}
				} else if(!resultSet.next()){
                     JLabel label=new JLabel("Sorry!Nothing fits you !") ;
                     label.setFont(new Font("微軟正黑體", 1, 72));
                     JPanel textpamel=new JPanel();
                     textpamel.add(label);
                     mainPanel.add(textpamel);
				}
				mainPanel.revalidate();
				

			} else if (sl == 5 && heightField != null && weightField != null && waistField != null
					&& hipField != null) {
				String query2 = "SELECT `Product_Number` FROM MG13.Product WHERE `height_low`<= ? AND `height_high`>=? AND `weight_low`<= ? AND `weight_high`>=? AND `waistline_low`<= ? AND `waistline_high`>=? AND `hip circumference_low`<=? AND `hip circumference_high`>=?";
				PreparedStatement pStatement2 = connection.prepareStatement(query2);
				pStatement2.setInt(1, Integer.parseInt(heightField.getText()));
				pStatement2.setInt(2, Integer.parseInt(heightField.getText()));
				pStatement2.setInt(3, Integer.parseInt(weightField.getText()));
				pStatement2.setInt(4, Integer.parseInt(weightField.getText()));
				pStatement2.setInt(5,Integer.parseInt(waistField.getText()));
				pStatement2.setInt(6, Integer.parseInt(waistField.getText()));
				pStatement2.setInt(7, Integer.parseInt(hipField.getText()));
				pStatement2.setInt(8, Integer.parseInt(hipField.getText()));
				ResultSet resultSet = pStatement2.executeQuery();
				mainPanel.removeAll();
				mainPanel.setLayout(new GridLayout(5, 2));
				if (resultSet.next()) {
					System.out.println(resultSet.getInt("Product_Number"));
					for (int i = 1; i <=resultSet.getRow(); i++) {
						mainPanel.add(createNewbutton(resultSet.getInt("Product_Number")));
					}
				} else if(!resultSet.next()){
                     JLabel label=new JLabel("Sorry!Nothing fits you !") ;
                     label.setFont(new Font("微軟正黑體", 1, 72));
                     JPanel textpamel=new JPanel();
                     textpamel.add(label);
                     mainPanel.add(textpamel);
				}
				mainPanel.revalidate();

		}}

		connection.close();
	}

	public JPanel createNewbutton(int productNumber) throws SQLException {
		Connection connection = ConnectionSQL.getConnection();
		String query = "select `photo` from MG13.Product where `Product_Number`=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, productNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		JPanel littlepanel = new JPanel();
		littlepanel.setBorder(new EtchedBorder());
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(400, 250));
		if (resultSet.next()) {
			byte[] img = resultSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			button.setIcon(newicon);

		}
		class goodsActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ShowPage frame = new ShowPage();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				try {
					frame.showProduct(productNumber);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		button.addActionListener(new goodsActionListener());
		littlepanel.add(button);
		connection.close();
		return littlepanel;
	}

	public static void main(String[] args) {
		JFrame frame = new Main();
		frame.setTitle("SURE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setUserID(int id) {
		// TODO Auto-generated method stub
		this.userID = id;
	}
}