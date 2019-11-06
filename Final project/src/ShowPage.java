import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class ShowPage extends JFrame {

	private JLabel fitamazing;
	private JLabel name;
	private JLabel cost;
	private JLabel size;
	private JLabel describe;
	private int userID;
	private int productNM;
	private JTextField name1;
	private JTextField price1;
	private JTextArea des1;

	private JTextField cllabel;
	private JTextField pllabel;
	private JTextField wllabel;
	private JTextField sllable;
	private JTextField swlabel;
	private JTextField buslabel;
	private JTextField hiplabel;
	private JTextField thighlabel;

	private int fieldwidth = 200;
	private int fidleheight= 60;

	private JTextField nameshow;
	private JTextField costshow;
	private JTextArea describeshow;
	private JLabel sizeshow;
	private JLabel clothesLength;
	private JTextField cl;
	private JLabel pantsLength;
	private JTextField pl;
	private JLabel waistLine;
	private JTextField wl;
	private JLabel sleeveLength;
	private JTextField sl;
	private JLabel shoulderWidth;
	private JTextField sw;
	private JLabel bust;
	private JTextField bustt;
	private JLabel hip;
	private JTextField hipp;
	private JLabel Thigh;
	private JTextField Thighh;
	private JLabel showpicture;

    
	private final static int BIGSIGN = 100;
	private final static int MIDDLESIGN = 50;
	private final static int CONTENT = 32;
	private final static int TEXTFIELD = 5;
	private final static int HIGHFIELD = 45;
	private final static int WEIGHFIELD = 200;

	public ShowPage() {
		setSize(1400, 900);
		setTitle("Fit amazing");
		add(finalpanel());

	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public JPanel finalpanel() {
		JPanel rightpanel=new JPanel();
		rightpanel.setLayout(new GridLayout(5, 1));
		rightpanel.add(namepanel());
		rightpanel.add(costpanel());
		rightpanel.add(sizepanel());
		rightpanel.add(describepanel());
		rightpanel.add(backPanel());
	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2));
		center.add(pictureshow());
		center.add(rightpanel);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(createfitamazing(), BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);

		return panel;

	}

	/* fit amazing 標題排版 */
	public JPanel createfitamazing() {
		fitamazing = new JLabel("Fit Amazing", SwingConstants.CENTER);
		fitamazing.setFont(new Font("20th Centenary Faux", 1, BIGSIGN));
		fitamazing.setForeground(Color.PINK);
		JLabel show = new JLabel("  商品展示");
		show.setFont(new Font("微軟正黑體", 1, MIDDLESIGN));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(fitamazing);
		panel.add(show);
		return panel;
	}

	public JPanel namepanel() {
		name = new JLabel("名稱:  ");
		name.setFont(new Font("微軟正黑體", 0, CONTENT));
		nameshow = new JTextField();
		nameshow.setFont(new Font("微軟正黑體", 0, CONTENT));
		nameshow.setPreferredSize(new Dimension(fieldwidth, fidleheight));
		nameshow.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(name);
		panel.add(nameshow);
		return panel;

	}

	public JPanel costpanel() {
		cost = new JLabel("價錢:  ");
		cost.setFont(new Font("微軟正黑體", 0, CONTENT));
		costshow = new JTextField();
		costshow.setFont(new Font("微軟正黑體", 0, CONTENT));
		costshow.setPreferredSize(new Dimension(fieldwidth, fidleheight));
		costshow.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(cost);
		panel.add(costshow);
		return panel;
	}

	public JPanel sizepanel() {
		JPanel cd = new JPanel();
		cd.setLayout(new GridLayout(4, 2));
		clothesLength = new JLabel("衣長 :", SwingConstants.CENTER);
		clothesLength.setFont(new Font("微軟正黑體", 0, 20));
		cl = new JTextField();
		cl.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		cl.setEditable(false);
		cd.add(clothesLength);
		cd.add(cl);
		pantsLength = new JLabel("      褲長 :");
		pantsLength.setFont(new Font("微軟正黑體", 0, 20));
		pl = new JTextField();
		pl.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		pl.setEditable(false);
		cd.add(pantsLength);
		cd.add(pl);
		waistLine = new JLabel("腰圍 :", SwingConstants.CENTER);
		waistLine.setFont(new Font("微軟正黑體", 0, 20));
		wl = new JTextField();
		wl.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		wl.setEditable(false);
		cd.add(waistLine);
		cd.add(wl);
		sleeveLength = new JLabel("      袖長 :");
		sleeveLength.setFont(new Font("微軟正黑體", 0, 20));
		sl = new JTextField();
		sl.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		sl.setEditable(false);
		cd.add(sleeveLength);
		cd.add(sl);
		shoulderWidth = new JLabel("肩寬 :", SwingConstants.CENTER);
		shoulderWidth.setFont(new Font("微軟正黑體", 0, 20));
		sw = new JTextField();
		sw.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		sw.setEditable(false);
		cd.add(shoulderWidth);
		cd.add(sw);
		bust = new JLabel("      胸圍 :");
		bust.setFont(new Font("微軟正黑體", 0, 20));
		bustt = new JTextField();
		bustt.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		bustt.setEditable(false);
		cd.add(bust);
		cd.add(bustt);
		hip = new JLabel("臀圍 :", SwingConstants.CENTER);
		hip.setFont(new Font("微軟正黑體", 0, 20));
		hipp = new JTextField();
		hipp.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		hipp.setEditable(false);
		cd.add(hip);
		cd.add(hipp);
		Thigh = new JLabel("      大腿圍 :");
		Thigh.setFont(new Font("微軟正黑體", 0, 20));
		Thighh = new JTextField();
		Thighh.setPreferredSize(new Dimension(TEXTFIELD, TEXTFIELD));
		Thighh.setEditable(false);
		cd.add(Thigh);
		cd.add(Thighh);
		cd.setBorder(new TitledBorder(new EtchedBorder(), "尺寸"));
		return cd;

	}

	public JPanel describepanel() {
		describe = new JLabel("描述:  ");
		describe.setFont(new Font("微軟正黑體", 0, CONTENT));
		describeshow = new JTextArea();
		describeshow.setFont(new Font("微軟正黑體", 0, CONTENT));
		describeshow.setPreferredSize(new Dimension(530, 180));
		describeshow.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(describe);
		panel.add(describeshow);
		return panel;
	}

	public JPanel pictureshow() {
		JPanel panel = new JPanel();
		showpicture = new JLabel(" ");
		panel.add(showpicture);
		panel.setBorder(new EtchedBorder());
		return panel;
	}

	public JPanel backPanel() {
		JPanel panel = new JPanel();
		JButton b = new JButton();
		b.setText("返回");
		b.setFont(new Font("微軟正黑體", 0, 20));
		b.setPreferredSize(new Dimension(100, 50));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				frame.setUserID(userID);
				setVisible(false);
			}
		});
		panel.add(b);
		return panel;
	}

	public void showProduct(int number) throws SQLException {
		productNM = number;
		Connection connection = ConnectionSQL.getConnection();
		String query = "SELECT `name`,`price`,`description`,`photo`,`length(TOP)`,`length(Button)`,`shoulder width`,`sleeve length`,`bust`,`waistline`,`hip circumference`,`thigh circumference` FROM MG13.Product where `Product_Number`=? ";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, number);
		ResultSet resultSet = pStatement.executeQuery();
		
		if (resultSet.next()) {
			nameshow.setText(resultSet.getString("name"));;
			costshow.setText(Integer.toString(resultSet.getInt("price"))) ;
			describeshow.setText(resultSet.getString("description"));;
			cl.setText(Integer.toString(resultSet.getInt("length(TOP)")));
			pl.setText(Integer.toString(resultSet.getInt("length(Button)")));
			sw.setText(Integer.toString(resultSet.getInt("shoulder width")));
			sl.setText(Integer.toString(resultSet.getInt("sleeve length")));
			bustt.setText(Integer.toString(resultSet.getInt("bust"))); 
			wl.setText(Integer.toString(resultSet.getInt("waistline"))); 
			hipp.setText(Integer.toString(resultSet.getInt("hip circumference")));
			Thighh.setText(Integer.toString(resultSet.getInt("thigh circumference"))); 
			byte[] img = resultSet.getBytes("photo");
			ImageIcon imageIcon = new ImageIcon(img);
			Image in = imageIcon.getImage();
			Image myImage = in.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
			ImageIcon newicon = new ImageIcon(myImage);
			showpicture.setIcon(newicon);
			namepanel();costpanel();sizepanel();describepanel();backPanel();pictureshow();
		
		} else {
			System.out.println("something is wrong");
		}
		connection.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowPage showpageframe = new ShowPage();
		showpageframe.setDefaultCloseOperation(showpageframe.EXIT_ON_CLOSE);
		showpageframe.setVisible(true);
	}

}