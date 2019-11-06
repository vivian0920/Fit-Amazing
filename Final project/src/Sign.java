import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Sign extends JFrame {
 //連結、創一個update的method、改button的actionlisten、
 private JLabel fitamazing;
 
 private JLabel account;
 private JLabel password;
 private JLabel nickname;
 private JLabel birthday;
 private JLabel phone;
 private JLabel sex;
 private JButton next;
 private JTextField accountfield;
 private JTextField passwordfield;
 private JTextField nicknamefield;
 
 private JTextField phonefield;
 private JRadioButton boy;
 private JRadioButton girl;
 
 private final static int BIGSIGN=100;
 private final static int MIDDLESIGN=50;
 private final static int CONTENT=32;
 private final static int TEXTFIELD=15;
 private final static int HIGHFIELD=45;
 private final static int WEIGHFIELD=200;
 private JComboBox<Integer> age;
 private JComboBox<Integer> month;
 private JComboBox<Integer> day;
 private ButtonGroup group;
 
    
	
	
	
	
	
 public Sign() {
  setSize(1400, 900);
   setTitle("Fit amazing");
   add(finalpanel());

	
		
	} 
 
 
 public JPanel finalpanel() {
  
  JPanel center =new JPanel();
  center.setLayout(new GridLayout(3,3));
  center.add(createaccount());
  center.add(createpassward());
  center.add(createnickname());
  center.add(createphone());
  center.add(createHBD());
  center.add(createsex());
  JPanel panel=new JPanel();
  panel.setLayout(new BorderLayout());
        panel.add(createfitamazing(), BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
        panel.add(createnext(), BorderLayout.SOUTH);
        return panel;
  
 }
   
 public JPanel createfitamazing() {
   fitamazing=new JLabel("Fit Amazing",SwingConstants.CENTER);
   fitamazing.setFont(new Font("20th Centenary Faux",1,BIGSIGN));
   fitamazing.setForeground(Color.PINK);
   JLabel show=new JLabel("  建立新帳號");
   show.setFont(new Font("微軟正黑體", 1, MIDDLESIGN));
   JPanel panel=new JPanel();
   panel.setLayout(new GridLayout(2, 1));
   panel.add(fitamazing);
   panel.add(show);
   return panel;
  }
  public JPanel createaccount(){
   JPanel panel =new JPanel();
   account=new JLabel("帳號:");
   account.setFont(new Font("微軟正黑體", 0, CONTENT));
         accountfield=new JTextField();
         accountfield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
         panel.add(account);
         panel.add(accountfield);
         
         return panel;
  }
 
  public JPanel createpassward(){
   JPanel panel =new JPanel();
   password=new JLabel("密碼:");
   password.setFont(new Font("微軟正黑體", 0, CONTENT));
         passwordfield=new JTextField();
         passwordfield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
         panel.add(password);
         panel.add(passwordfield);
         
         return panel;
  }
  public JPanel createnickname(){
   JPanel panel =new JPanel();
   nickname=new JLabel("暱稱:");
   nickname.setFont(new Font("微軟正黑體", 0, CONTENT));
         nicknamefield=new JTextField();
         nicknamefield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
         panel.add(nickname);
         panel.add(nicknamefield);
         
         return panel;
  }
  public JPanel createHBD(){
   JPanel panel =new JPanel();
   birthday=new JLabel("生日:  ");
   birthday.setFont(new Font("微軟正黑體", 0, CONTENT));
         age=new JComboBox<Integer>();
         age.setFont(new Font("微軟正黑體", 0, 25));
         age.setEditable(true);
         
         for (int i = 1950; i < 2019; i++) {
   age.addItem(i);
  }
         age.setPreferredSize(new Dimension(130, HIGHFIELD));
         
         month=new JComboBox<Integer>();
         month.setFont(new Font("微軟正黑體", 0, 25));
         for (int i = 1; i <= 12; i++) {
   month.addItem(i);
  }
         month.setPreferredSize(new Dimension(85, HIGHFIELD));
         day=new JComboBox<Integer>();
         day.setFont(new Font("微軟正黑體", 0, 25));
         for (int i = 1; i <=31; i++) {
   day.addItem(i);
  }
         day.setPreferredSize(new Dimension(85, HIGHFIELD));
         panel.add(birthday);
         panel.add(age);
         panel.add(month);
         panel.add(day);
         return panel;
  }
  public JPanel createphone(){
   JPanel panel =new JPanel();
   phone=new JLabel("手機:");
   phone.setFont(new Font("微軟正黑體", 0, CONTENT));
         phonefield=new JTextField();
         phonefield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
         panel.add(phone);
         panel.add(phonefield);
         
         return panel;
  }
  public JPanel createsex(){
   JPanel panel =new JPanel();
   sex=new JLabel("生理性別:   ");
   sex.setFont(new Font("微軟正黑體", 0, CONTENT));
   boy=new JRadioButton("男性");
   boy.setFont(new Font("微軟正黑體", 0, 30));
      girl=new JRadioButton("女性");
   girl.setFont(new Font("微軟正黑體", 0, 30));
   group=new ButtonGroup();
   group.add(boy);
   group.add(girl);  
   panel.add(sex);
   panel.add(boy);
   panel.add(girl);
         
         return panel;
  }
  public JPanel createnext(){
   JPanel panel =new JPanel();
   next=new JButton("下一步");
   next.setPreferredSize(new Dimension(200, 50));
   next.setFont(new Font("微軟正黑體", 1, CONTENT));
   panel.add(next);
   
   
   class NextActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
		try { createAccount();
		   BuyerOrSeller buyerOrSeller = new BuyerOrSeller();
		   buyerOrSeller.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		   buyerOrSeller.setVisible(true);
		   setVisible(false);
			
			
			
		}catch (Exception e1) {
			e1.printStackTrace();	}	
		
	}}
         
         
         
         
         next.addActionListener(new NextActionListener());
         return panel;
  }
  public void createAccount()throws SQLException{
	  Connection conn=ConnectionSQL.getConnection();
	  String query="INSERT INTO MG13.User (`User_Number`,`User_Account`,`number`,`password`,`sex`,`nickname`,`phone number`,`birthday`,`bank code`,`bank account`) VALUES (?, ?,?,?,?,?,?,?,?,?)";
	  
//	  query = "SELECT * FROM MG13.User";
	  PreparedStatement pst=conn.prepareStatement(query);
		pst.setInt(1, 0);
		pst.setString(2, accountfield.getText());
		pst.setInt(3, 0);
		pst.setString(4, passwordfield.getText());
		pst.setString(5, boy.isSelected()? "Boy":"Girl");
		pst.setString(6, nicknamefield.getText());
		pst.setInt(7, Integer.parseInt(phonefield.getText()));
		pst.setString(8,age.getSelectedItem().toString()+"/"+month.getSelectedItem().toString()
				+"/"+day.getSelectedItem().toString());
		pst.setInt(9, 0);
		pst.setInt(10, 0);
//	  
//		Statement statement = conn.createStatement();
//		statement.execute(query);
		int resultSet=pst.executeUpdate();
		conn.close();
  }
 
  
 
 
 
 
 
 
 
 

 public static void main(String[] args) throws SQLException {
  // TODO Auto-generated method stub
         Sign signframe=new Sign();
         signframe.setDefaultCloseOperation(signframe.EXIT_ON_CLOSE);
         signframe.setVisible(true);

 }

}