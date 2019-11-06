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
import javax.swing.SwingConstants;
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

public class BankInformation extends JFrame {
 private final int FRAME_WIDTH = 700;
 private final int FRAME_HEIGHT = 400;

 private JTextField accountField;
 private JTextField bankField;
 private JButton sureButton;
 private JLabel nameLabel;
 private JLabel bankLabel;
 private JLabel accountLabel;
 private JLabel fit;
 public BankInformation() {
  setSize(FRAME_WIDTH,FRAME_HEIGHT);
  createHomePage();
  createTitlePanel();
 }
 private JPanel createHeadPanel() {
  JPanel mainpanel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel gridPanel = new JPanel();
  JLabel label = new JLabel("");
  JLabel label1 = new JLabel("");
  bankField = new JTextField(15);
  nameLabel = new JLabel("Fit Amazing");
  bankLabel = new JLabel("銀行代碼");
  bankLabel.setFont(new Font("微軟正黑體",0,20));
  accountLabel = new JLabel("銀行帳號");
  accountLabel.setFont(new Font("微軟正黑體",0,20));
  accountField = new JTextField();
  accountField.setPreferredSize(new Dimension(200,30));
  bankField.setPreferredSize(new Dimension(200,30));
  panel1.add(bankLabel);
  panel1.add(bankField);
  panel2.add(accountLabel);
  panel2.add(accountField);
   mainpanel.setLayout(new GridLayout(3, 1));
  mainpanel.add(panel1);
  mainpanel.add(panel2);
  createAddWorkDayButton();
  return mainpanel;
  
 }
 
 
 public JLabel createTitlePanel() {
  fit = new JLabel("Fit Amazing",SwingConstants.CENTER);
  fit.setFont(new Font("20th Centenary Faux", 1, 56));
  Color c = Color.PINK;
  fit.setForeground(c);
  return fit;
 }
 public JPanel createButtonPanel() {
  JPanel mainpanel = new JPanel();
  createAddWorkDayButton();
  mainpanel.add(sureButton);
  return mainpanel;
 }
 public void createAddWorkDayButton() {
  sureButton = new JButton("確認");
  sureButton.setPreferredSize(new Dimension(100, 50));
  sureButton.setFont(new Font("微軟正黑體",0,20));
  class AddedListener implements ActionListener{
   public void actionPerformed(ActionEvent e)
   {try {
	updatebankinformation();
	   ThanksFor frame = new ThanksFor();
	   frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   frame.setVisible(true);
	   setVisible(false);
} catch (Exception e2) {
	// TODO: handle exception
	e2.getMessage();
}
    
   }
  }
  sureButton.addActionListener(new AddedListener());

 }
 public void createHomePage() {
  setLayout(new BorderLayout());
  add(createHeadPanel(),BorderLayout.CENTER);
  add(createButtonPanel(), BorderLayout.SOUTH);
  add(createTitlePanel(), BorderLayout.NORTH);
 } 
 
 public void updatebankinformation( ) throws SQLException{
	 Connection connection=ConnectionSQL.getConnection();
	 String query="UPDATE MG13.User SET `bank code`=?,`bank account`=? WHERE `number`='1' AND `bank code`='0'";
	 PreparedStatement pStatement=connection.prepareStatement(query);
	 pStatement.setInt(1,Integer.parseInt(bankField.getText()));
	 pStatement.setInt(2, Integer.parseInt(accountField.getText()));
	 pStatement.executeUpdate();
	 connection.close();
 }
 public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankInformation bankInformation=new BankInformation();
		bankInformation.setDefaultCloseOperation(bankInformation.EXIT_ON_CLOSE);
		bankInformation.setVisible(true);
	}
 
}