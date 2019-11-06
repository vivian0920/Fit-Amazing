import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.xdevapi.PreparableStatement;

public class MySellPage extends JFrame {

	private static int FRAME_WIDTH = 1400;
	private static int FRAME_HEIGHT = 900;
	private static int AREA_WIDTH = 350;
	private static int AREA_HEIGHT = 350;
	private int productNumber;
	private JButton upload;
	private JButton back;
	private JLabel title;
	private JLabel title1;
	private int userID;
	private JPanel inPanel;

	public MySellPage() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		createPanel();
	}

	public JPanel createTitle() {
		title = new JLabel("Fit Amazing", SwingConstants.CENTER);
		title.setFont(new Font("20th Centenary Faux", 1, 100));
		title.setForeground(Color.PINK);
		title1 = new JLabel("  我的賣場");
		title1.setFont(new Font("微軟正黑體", 1, 40));
		title1.setForeground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(title);
		panel.add(title1);

		return panel;
	}

	public ScrollPane createMainPanel() {
		ScrollPane scrollPane = new ScrollPane();
		inPanel = new JPanel();
		inPanel.setLayout(new GridLayout(0, 3));

//		JButton t1 = new JButton();
//		t1.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t2 = new JButton();
//		t2.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t3 = new JButton();
//		t3.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t4 = new JButton();
//		t4.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t5 = new JButton();
//		t5.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t6 = new JButton();
//		t6.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t7 = new JButton();
//		t7.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t8 = new JButton();
//		t8.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t9 = new JButton();
//		t9.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t10 = new JButton();
//		t10.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t11 = new JButton();
//		t11.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t12 = new JButton();
//		t12.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t13 = new JButton();
//		t13.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t14 = new JButton();
//		t14.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t15 = new JButton();
//		t15.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t16 = new JButton();
//		t16.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t17 = new JButton();
//		t17.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t18 = new JButton();
//		t18.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t19 = new JButton();
//		t19.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t20 = new JButton();
//		t20.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t21 = new JButton();
//		t21.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t22 = new JButton();
//		t22.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t23 = new JButton();
//		t23.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t24 = new JButton();
//		t24.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t25 = new JButton();
//		t25.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t26 = new JButton();
//		t26.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t27 = new JButton();
//		t27.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t28 = new JButton();
//		t28.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t29 = new JButton();
//		t29.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//		JButton t30 = new JButton();
//		t30.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
//
//		JPanel p1 = new JPanel();
//		p1.setBorder(new EtchedBorder());
//		p1.add(t1);
//		JPanel p2 = new JPanel();
//		p2.setBorder(new EtchedBorder());
//		p2.add(t2);
//		JPanel p3 = new JPanel();
//		p3.setBorder(new EtchedBorder());
//		p3.add(t3);
//		JPanel p4 = new JPanel();
//		p4.setBorder(new EtchedBorder());
//		p4.add(t4);
//		JPanel p5 = new JPanel();
//		p5.setBorder(new EtchedBorder());
//		p5.add(t5);
//		JPanel p6 = new JPanel();
//		p6.setBorder(new EtchedBorder());
//		p6.add(t6);
//		JPanel p7 = new JPanel();
//		p7.setBorder(new EtchedBorder());
//		p7.add(t7);
//		JPanel p8 = new JPanel();
//		p8.setBorder(new EtchedBorder());
//		p8.add(t8);
//		JPanel p9 = new JPanel();
//		p9.setBorder(new EtchedBorder());
//		p9.add(t9);
//		JPanel p10 = new JPanel();
//		p10.setBorder(new EtchedBorder());
//		p10.add(t10);
//		JPanel p11 = new JPanel();
//		p11.setBorder(new EtchedBorder());
//		p11.add(t11);
//		JPanel p12 = new JPanel();
//		p12.setBorder(new EtchedBorder());
//		p12.add(t12);
//		JPanel p13 = new JPanel();
//		p13.setBorder(new EtchedBorder());
//		p13.add(t13);
//		JPanel p14 = new JPanel();
//		p14.setBorder(new EtchedBorder());
//		p14.add(t14);
//		JPanel p15 = new JPanel();
//		p15.setBorder(new EtchedBorder());
//		p15.add(t15);
//		JPanel p16 = new JPanel();
//		p16.setBorder(new EtchedBorder());
//		p16.add(t16);
//		JPanel p17 = new JPanel();
//		p17.setBorder(new EtchedBorder());
//		p17.add(t17);
//		JPanel p18 = new JPanel();
//		p18.setBorder(new EtchedBorder());
//		p18.add(t18);
//		JPanel p19 = new JPanel();
//		p19.setBorder(new EtchedBorder());
//		p19.add(t19);
//		JPanel p20 = new JPanel();
//		p20.setBorder(new EtchedBorder());
//		p20.add(t20);
//		JPanel p21 = new JPanel();
//		p21.setBorder(new EtchedBorder());
//		p21.add(t21);
//		JPanel p22 = new JPanel();
//		p22.setBorder(new EtchedBorder());
//		p22.add(t22);
//		JPanel p23 = new JPanel();
//		p23.setBorder(new EtchedBorder());
//		p23.add(t23);
//		JPanel p24 = new JPanel();
//		p24.setBorder(new EtchedBorder());
//		p24.add(t24);
//		JPanel p25 = new JPanel();
//		p25.setBorder(new EtchedBorder());
//		p25.add(t25);
//		JPanel p26 = new JPanel();
//		p26.setBorder(new EtchedBorder());
//		p26.add(t26);
//		JPanel p27 = new JPanel();
//		p27.setBorder(new EtchedBorder());
//		p27.add(t27);
//		JPanel p28 = new JPanel();
//		p28.setBorder(new EtchedBorder());
//		p28.add(t28);
//		JPanel p29 = new JPanel();
//		p29.setBorder(new EtchedBorder());
//		p29.add(t29);
//		JPanel p30 = new JPanel();
//		p30.setBorder(new EtchedBorder());
//		p30.add(t30);
//		inPanel.add(p1);
//		inPanel.add(p2);
//		inPanel.add(p3);
//		inPanel.add(p4);
//		inPanel.add(p5);
//		inPanel.add(p6);
//		inPanel.add(p7);
//		inPanel.add(p8);
//		inPanel.add(p9);
//		inPanel.add(p10);
//		inPanel.add(p11);
//		inPanel.add(p12);
//		inPanel.add(p13);
//		inPanel.add(p14);
//		inPanel.add(p15);
//		inPanel.add(p16);
//		inPanel.add(p17);
//		inPanel.add(p18);
//		inPanel.add(p19);
//		inPanel.add(p20);
//		inPanel.add(p21);
//		inPanel.add(p22);
//		inPanel.add(p23);
//		inPanel.add(p24);
//		inPanel.add(p25);
//		inPanel.add(p26);
//		inPanel.add(p27);
//		inPanel.add(p28);
//		inPanel.add(p29);
//		inPanel.add(p30);
		scrollPane.add(inPanel);

		return scrollPane;
	}

	public JPanel createButton() {
		JPanel buttonPanel = new JPanel();
		upload = new JButton("我要上傳");
		upload.setFont(new Font("微軟正黑體", 1, 32));
		upload.setPreferredSize(new Dimension(200, 60));
		back = new JButton("返回");
		back.setFont(new Font("微軟正黑體", 1, 32));
		back.setPreferredSize(new Dimension(200, 60));
		buttonPanel.add(upload);
		buttonPanel.add(back);
		class AddlogListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				NewGood frame = new NewGood();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		class backListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				frame.setUserID(userID);
				setVisible(false);
			}
		}
		upload.addActionListener(new AddlogListener());
		back.addActionListener(new backListener());
		return buttonPanel;
	}

	public Font getFont() {
		Font font = new Font("微軟正黑體", 0, 40);

		return font;
	}

	public void createPanel() {

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(createTitle(), BorderLayout.NORTH);
		centerPanel.add(createMainPanel(), BorderLayout.CENTER);
		centerPanel.add(createButton(), BorderLayout.SOUTH);
		add(centerPanel);

	}

	public void newbutton(int productNumber1) {
		try {
			productNumber = productNumber1;
			Connection connection = ConnectionSQL.getConnection();
			String query = "select `photo` from MG13.Product where `Product_Number`=?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, productNumber);
			ResultSet rSet = pStatement.executeQuery();
			JButton iconbutton = new JButton();
			iconbutton.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
			
			if (rSet.next()) {
				byte[] img = rSet.getBytes("photo");
				ImageIcon imageIcon = new ImageIcon(img);
				Image in = imageIcon.getImage();
				Image myImage = in.getScaledInstance(AREA_WIDTH, AREA_HEIGHT, Image.SCALE_SMOOTH);
				ImageIcon newicon = new ImageIcon(myImage);
				iconbutton.setIcon(newicon);
			}
			
			class goodsActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					ShowPage frame = new ShowPage();
					frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					try {
						frame.showProduct(productNumber1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setUserID(userID);
					setVisible(false);
				}
			}

			iconbutton.addActionListener(new goodsActionListener());
			updatePanel(iconbutton);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void updatePanel(JButton button) {
		inPanel.add(button);
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySellPage frame = new MySellPage();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setUserID(int id) {
		// TODO Auto-generated method stub
		this.userID = id;
	}

}