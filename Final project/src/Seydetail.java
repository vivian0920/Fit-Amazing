import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.nio.channels.NonWritableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Seydetail extends JFrame {

 private JLabel fitamazing;

 private JLabel heigh;
 private JLabel weight;
 private JLabel shoulder;
 private JLabel chest;
 private JLabel waist;
 private JLabel butt;
 private JLabel thigh;
 private JTextField heighInput;
 private JTextField input;

 private JTextField weightInput;
 private JTextField input2;

 private JTextField shoulderInput;
 private JTextField input3;

 private JTextField chestInput;
 private JTextField input4;

 private JTextField waistInput;
 private JTextField input5;

 private JTextField buttInput;
 private JTextField input6;

 private JTextField thighInput;
 private JTextField input7;

 private JLabel to;
 private JButton update;
 private int userID;
 private final static int BIGSIGN = 100;
 private final static int MIDDLESIGN = 50;
 private final static int CONTENT = 32;
 private final static int TEXTFIELD = 15;
 private final static int HIGHFIELD = 45;
 private final static int WEIGHFIELD = 100;
 private int productNumber;

 public Seydetail() {
  setSize(1400, 900);
  setTitle("Fit amazing");
  add(finalpanel());
 }
 
 public void setUserID(int id) {
  this.userID = id;
 }

 public JPanel finalpanel() {
  JPanel north = new JPanel();
  JLabel detailset = new JLabel("     詳細設定");
  detailset.setFont(new Font("微軟正黑體", 1, MIDDLESIGN));
  north.setLayout(new GridLayout(2, 1));
  north.add(createfitamazing());
  north.add(detailset);
  JPanel center = new JPanel();
  center.setLayout(new GridLayout(4, 2));
  center.add(heighpanel());
  center.add(weightpanel());

  center.add(waistpanel());

  center.add(shoulderpanel());

  center.add(chestpanel());
  center.add(buttpanel());
  center.add(thighpanel());

  JPanel panel = new JPanel();
  panel.setLayout(new BorderLayout());
  panel.add(north, BorderLayout.NORTH);
  panel.add(center, BorderLayout.CENTER);
  panel.add(updatebutton(), BorderLayout.SOUTH);

  return panel;

 }

 /* fit amazing 標題排版 */
 public JLabel createfitamazing() {
  fitamazing = new JLabel("Fit Amazing", SwingConstants.CENTER);
  fitamazing.setFont(new Font("20th Centenary Faux", 1, BIGSIGN));
  fitamazing.setForeground(Color.pink);

  return fitamazing;
 }

 public JPanel heighpanel() {
  heigh = new JLabel("建議身高:  ");
  heigh.setFont(new Font("微軟正黑體", 0, CONTENT));
  heighInput = new JTextField();

  heighInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input = new JTextField();
  input.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(heigh);
  panel.add(input);
  panel.add(to);
  panel.add(heighInput);
  return panel;
 }

 public JPanel weightpanel() {
  weight = new JLabel("建議體重:  ");
  weight.setFont(new Font("微軟正黑體", 0, CONTENT));
  weightInput = new JTextField();
  weightInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input2 = new JTextField();
  input2.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(weight);
  panel.add(input2);
  panel.add(to);
  panel.add(weightInput);
  return panel;
 }

 public JPanel shoulderpanel() {
  shoulder = new JLabel("建議肩寬:  ");
  shoulder.setFont(new Font("微軟正黑體", 0, CONTENT));
  shoulderInput = new JTextField();
  shoulderInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input3 = new JTextField();
  input3.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(shoulder);
  panel.add(input3);
  panel.add(to);
  panel.add(shoulderInput);
  return panel;
 }

 public JPanel chestpanel() {
  chest = new JLabel("建議胸圍:  ");
  chest.setFont(new Font("微軟正黑體", 0, CONTENT));
  chestInput = new JTextField();
  chestInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input4 = new JTextField();
  input4.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(chest);
  panel.add(input4);
  panel.add(to);
  panel.add(chestInput);
  return panel;
 }

 public JPanel waistpanel() {
  waist = new JLabel("建議腰圍:  ");
  waist.setFont(new Font("微軟正黑體", 0, CONTENT));
  waistInput = new JTextField();
  waistInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input5 = new JTextField();
  input5.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(waist);
  panel.add(input5);
  panel.add(to);
  panel.add(waistInput);
  return panel;
 }

 public JPanel buttpanel() {
  butt = new JLabel("建議臀圍:  ");
  butt.setFont(new Font("微軟正黑體", 0, CONTENT));
  buttInput = new JTextField();
  buttInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input6 = new JTextField();
  input6.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(butt);
  panel.add(input6);
  panel.add(to);
  panel.add(buttInput);
  return panel;
 }

 public JPanel thighpanel() {
  thigh = new JLabel("    建議大腿圍:  ");
  thigh.setFont(new Font("微軟正黑體", 0, CONTENT));
  thighInput = new JTextField();
  thighInput.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  input7 = new JTextField();
  input7.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
  to = new JLabel("~");
  to.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(thigh);
  panel.add(input7);
  panel.add(to);
  panel.add(thighInput);
  return panel;
 }

 public JPanel updatebutton() {

  update = new JButton("上傳");
  update.setPreferredSize(new Dimension(200, 50));
  update.setFont(new Font("微軟正黑體", 1, CONTENT));
  JPanel panel = new JPanel();
  panel.add(update);
  
  class DetailActionlistener implements ActionListener {

   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

    try {
     selectuserid();
     setDetails();
     MySellPage frame=new MySellPage();
     frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     frame.setVisible(true);
     frame.setUserID(userID);
     frame.newbutton(productNumber);
     setVisible(false);

    } catch (Exception e1) {
     e1.printStackTrace();
    }

   }
  }

  update.addActionListener(new DetailActionlistener());
  return panel;
 }

 public void setDetails() throws SQLException {
  Connection conn = ConnectionSQL.getConnection();
  String query = "UPDATE MG13.Product SET `height_low`=?,`height_high`=?,`weight_low`=?,`weight_high`=?,`waistline_low`=?,`waistline_high`=?,`shoulder width_low`=?,`shoulder width_high`=?,`bust_low`=?,`bust_high`=?,`hip circumference_low`=?,`hip circumference_high`=?,`thigh circumference_low`=?,`thigh circumference_high`=? WHERE `price`!='0'AND`height_low`='0'";

  PreparedStatement pst = conn.prepareStatement(query);
  pst.setInt(1, Integer.parseInt(heighInput.getText()));
  pst.setInt(2, Integer.parseInt(input.getText()));
  pst.setInt(3, Integer.parseInt(weightInput.getText()));
  pst.setInt(4,Integer.parseInt(input2.getText()));
  pst.setInt(5, Integer.parseInt(waistInput.getText()));
  pst.setInt(6, Integer.parseInt(input5.getText()));
  pst.setInt(7, Integer.parseInt(shoulderInput.getText()));
  pst.setInt(8, Integer.parseInt(input3.getText()));
  pst.setInt(9, Integer.parseInt(chestInput.getText()));
  pst.setInt(10, Integer.parseInt(input4.getText()));
  pst.setInt(11, Integer.parseInt(buttInput.getText()));
  pst.setInt(12, Integer.parseInt(input6.getText()));
  pst.setInt(13, Integer.parseInt(thighInput.getText()));
  pst.setInt(14, Integer.parseInt(input7.getText()));
//   
//  Statement statement = conn.createStatement();
//  statement.execute(query);
  pst.executeUpdate();
  conn.close();
 }
 public int selectuserid() throws SQLException {
	 Connection connection=ConnectionSQL.getConnection();
	 String query="select `Product_Number` from MG13.Product where `price`!='0' AND `height_low`='0'";
	 PreparedStatement pStatement=connection.prepareStatement(query);
	 ResultSet resultSet=pStatement.executeQuery();
	 if (resultSet.next()) {
		productNumber=resultSet.getInt("Product_Number");
		
	}
	 return productNumber;
	 
	 
 }

 public static void main(String[] args) {
  Seydetail frame = new Seydetail();
  frame.setTitle("setDetail");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 }

}