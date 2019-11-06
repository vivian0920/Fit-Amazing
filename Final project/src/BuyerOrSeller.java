import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyerOrSeller extends JFrame {
 
 private final int FRAME_WIDTH = 700;
 private final int FRAME_HEIGHT = 400;
 
 private JLabel titleLabel;
 private JLabel askLabel;
 private JButton butbuyer;
 private JButton butseller;
 private JPanel class1;
 private JPanel class2;
 private JPanel class3;
 
 public BuyerOrSeller() {
  setTitle("Fit Amazing");
  setSize(FRAME_WIDTH, FRAME_HEIGHT);
  createPanel();
 }
 
 public JPanel createTitlePanel() {
  JPanel titlePanel = new JPanel ();
  titleLabel = new JLabel ("Fit Amazing");
  titleLabel.setFont(new Font("20th Centenary Faux", 1, 56));
  titleLabel.setForeground(Color.pink);
  titlePanel.add(titleLabel);
  return titlePanel;
 }
 
 public JPanel createAskPanel() {
  JPanel askPanel = new JPanel ();
  askLabel = new JLabel ("您是賣家還是買家?");
  Font f = new Font ("微軟正黑體", 0, 30);
  askLabel.setPreferredSize(new Dimension(270,150));
  askLabel.setFont(f);
  askPanel.add(askLabel);
  return askPanel;
 }
 
 public JPanel createButton() {
  JPanel butPanel = new JPanel();
  butbuyer = new JButton ("買家");
  butseller = new JButton ("賣家");
  Font f = new Font ("微軟正黑體", 1, 28);
  butbuyer.setFont(f);
  butseller.setFont(f);
  butbuyer.setPreferredSize(new Dimension(150,50));
  butseller.setPreferredSize(new Dimension(150,50));
  class buyeractionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			choosebuyer();
			   ThanksFor  thanksFor = new ThanksFor();
			   thanksFor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			   thanksFor.setVisible(true);
			   setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	  
  }
  class selleractionlistener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			chooseseller();
			    BankInformation frame = new BankInformation();
			   frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			   frame.setVisible(true);
			   setVisible(false);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	  
  }
  butbuyer.addActionListener(new buyeractionListener());
  butseller.addActionListener(new selleractionlistener());
  butPanel.add(butbuyer);
  butPanel.add(butseller);
  return butPanel;  
 }
 
 public void createPanel() {
  JPanel topPanel = new JPanel();
  JPanel midPanel = new JPanel();
  JPanel downPanel = new JPanel();
  class1 = createTitlePanel();
  class2 = createAskPanel();
  class3 = createButton();
  topPanel.add(class1);
  midPanel.add(class2);
  downPanel.add(class3);
  setLayout(new BorderLayout());
  add(topPanel, BorderLayout.NORTH);
  add(midPanel, BorderLayout.CENTER);
  add(downPanel, BorderLayout.SOUTH);
 }
 public void choosebuyer()throws SQLException{
	 Connection connection=ConnectionSQL.getConnection();
	 String query="UPDATE MG13.User SET `number`=? WHERE `number`='0'";
	 PreparedStatement pStatement=connection.prepareStatement(query);
	 
		pStatement.setInt(1, 2);
	
	 
	 pStatement.executeUpdate();
	 connection.close();
 }
 public void chooseseller( ) throws SQLException{
	 Connection connection=ConnectionSQL.getConnection();
	 String query="UPDATE MG13.User SET `number`=? WHERE `number`='0'";
	 PreparedStatement pStatement=connection.prepareStatement(query);
	 pStatement.setInt(1, 1);
	 pStatement.executeUpdate();
	 connection.close();
 }
 
 
 public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyerOrSeller buyerOrSeller=new BuyerOrSeller();
		buyerOrSeller.setDefaultCloseOperation(buyerOrSeller.EXIT_ON_CLOSE);
		buyerOrSeller.setVisible(true);
	}

}