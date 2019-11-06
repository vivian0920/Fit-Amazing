import javax.swing.*;
import javax.swing.event.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.*;
import java.awt.*;

public class NewGood extends JFrame {

 private final static int FRAME_WIDTH = 1400;
 private final static int FRAME_HEIGHT = 900;
 private final static int RE_HEIGHT = 30;
 private final static int RE_WIDTH = 40;
 private final static int FIELD_WIDTH = 15;
 private final static int DETAIL_WIDTH = 15;
 private final static int DESCRIPTION_WIDTH = 15;
 private final static int NAME_HEIGHT = 1;
 private final static int NAME_WIDTH = 1;

 private JLabel titleLabel;
 private JLabel itemnameLabel;
 private JLabel itempriceLabel;
 private JLabel classifyLabel;
 private JLabel sizeLabel;
 private JLabel clothesLength;
 private JLabel pantsLength;
 private JLabel waistLine;
 private JLabel sleeveLength;
 private JLabel shoulderWidth;
 private JLabel description;
 private JLabel ctss;
 private JLabel bust;
 private JLabel hip;
 private JLabel Thigh;
 private JTextField itemnameField;
 private JTextField itempriceField;
 private JTextField cl;
 private JTextField pl;
 private JTextField wl;
 private JTextField sl;
 private JTextField sw;
 private JTextField bustt;
 private JTextField hipp;
 private JTextField Thighh;
 private JTextArea df;
 private JButton uploadPhoto;
 private JButton nextStep;
 private JComboBox<String> classifyCombo;
 private JComboBox<String> sizeCombo;
 private ScrollPane scroll;
 private File selectedFile;
 private int userID;

 private JPanel class1;
 private JPanel class2;
 private JPanel class3;
 private JPanel class4;
 private JPanel class5;
 private JPanel class6;
 private JPanel class7;
 private JPanel class8;
 private JPanel class9;
 private JPanel class10;
 private JPanel class11;
 private JPanel class12;
 private JPanel class13;
 private JPanel class14;
 private JPanel class15;
 
 public void setUserID(int id) {
  this.userID = id;
 }
 
 // �ȴ��N�Ϥ�
 private JTextArea substitute;

 public NewGood() {
  setTitle("");
  setSize(FRAME_WIDTH, FRAME_HEIGHT);
  createPanel();
 }

 public JPanel createTitlePanel() {
  JPanel titlePanel = new JPanel();
  titleLabel = new JLabel("Fit Amazing");
  titleLabel.setFont(new Font("20th Centenary Faux", 1, 100));
  titleLabel.setForeground(Color.pink);
  titlePanel.add(titleLabel);
  return titlePanel;
 }

 public JPanel createNameAndPrice() {
  JPanel cnas = new JPanel();
  itemnameLabel = new JLabel("�ӫ~�W�� : ", SwingConstants.CENTER);
  itemnameLabel.setFont(new Font("�L�n������", 0, 32));
  itemnameLabel.setPreferredSize(new Dimension(200, 50));
  itemnameField = new JTextField();
  itemnameField.setFont(new Font("�L�n������", 0, 32));
  itemnameField.setPreferredSize(new Dimension(200, 50));
  cnas.add(itemnameLabel);
  cnas.add(itemnameField);
  return cnas;

 }

 public JPanel createNameAndPrice2() {
  JPanel cnas2 = new JPanel();
  itempriceLabel = new JLabel("�ӫ~���� : ", SwingConstants.CENTER);
  itempriceLabel.setFont(new Font("�L�n������", 0, 32));
  itempriceLabel.setPreferredSize(new Dimension(200, 50));
  itempriceField = new JTextField();
  itempriceField.setFont(new Font("�L�n������", 0, 30));
  itempriceField.setPreferredSize(new Dimension(200, 50));
  cnas2.add(itempriceLabel);
  cnas2.add(itempriceField);
  return cnas2;

 }

 public JPanel createPhotoPanel() {
  JPanel cpp = new JPanel();
  JPanel bt = new JPanel();
  JPanel photo = new JPanel();
  uploadPhoto = new JButton("�W�ǷӤ�");
  uploadPhoto.setSize(50, 10);
  uploadPhoto.setFont(new Font("�L�n������", 1, 18));
  bt.add(uploadPhoto);
  substitute = new JTextArea(10, 40);
  photo.add(substitute);
  // �Ϥ��٨S��
  class pictureupdateActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			createPhoto();
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} }
  uploadPhoto.addActionListener(new pictureupdateActionListener());
  cpp.add(photo);
  cpp.add(bt);
  return cpp;
 }

 public JPanel createSubTitle() {
  JPanel cst = new JPanel();
  ctss = new JLabel("�ӫ~�W��");
  ctss.setFont(new Font("�L�n������", 1, 40));
  ctss.setPreferredSize(new Dimension(500, 40));
  
  cst.add(ctss);
  return cst;
 }

 public JPanel createCombo() {
  JPanel ccc = new JPanel();
  classifyLabel = new JLabel("               ���� :");
  classifyLabel.setFont(new Font("�L�n������", 0, 32));
  classifyLabel.setPreferredSize(new Dimension(200, 50));
  classifyCombo = new JComboBox<String>();
  classifyCombo.setFont(new Font("�L�n������", 0, 28));
  classifyCombo.setPreferredSize(new Dimension(150, 50));
  classifyCombo.addItem("�W��");
  classifyCombo.addItem("�I��");
  classifyCombo.addItem("����");
  classifyCombo.addItem("�u��");
  classifyCombo.addItem("�u��");
  classifyCombo.addItem("����");
  classifyCombo.addItem("�~�M");
  classifyCombo.addItem(null);
  classifyCombo.setSelectedIndex(7);
  ccc.add(classifyLabel);
  ccc.add(classifyCombo);
  sizeLabel = new JLabel("               �ؤo :");
  sizeLabel.setFont(new Font("�L�n������", 0, 32));
  sizeLabel.setPreferredSize(new Dimension(200, 50));
  sizeCombo = new JComboBox<String>();
  sizeCombo.setFont(new Font("�L�n������", 0, 28));
  sizeCombo.setPreferredSize(new Dimension(150, 50));
//  sizeCombo.addItem("XS");
//  sizeCombo.addItem("S");
//  sizeCombo.addItem("M");
//  sizeCombo.addItem("L");
//  sizeCombo.addItem("XL");
  sizeCombo.addItem("F");
  ccc.add(sizeLabel);
  ccc.add(sizeCombo);
  return ccc;
 }

 public JPanel createDetail() {
  JPanel cd = new JPanel();
  cd.setLayout(new GridLayout(4, 2));
  clothesLength = new JLabel("��� :", SwingConstants.CENTER);
  clothesLength.setFont(new Font("�L�n������", 0, 32));
  cl = new JTextField();
  cl.setFont(new Font("�L�n������", 0, 20));
  cd.add(clothesLength);
  cd.add(cl);
  pantsLength = new JLabel("      �Ǫ� :");
  pantsLength.setFont(new Font("�L�n������", 0, 32));
  pl = new JTextField();
  pl.setFont(new Font("�L�n������", 0, 20));
  cd.add(pantsLength);
  cd.add(pl);
  waistLine = new JLabel("�y�� :", SwingConstants.CENTER);
  waistLine.setFont(new Font("�L�n������", 0, 32));
  wl = new JTextField();
  wl.setFont(new Font("�L�n������", 0, 20));
  cd.add(waistLine);
  cd.add(wl);
  sleeveLength = new JLabel("      �S�� :");
  sleeveLength.setFont(new Font("�L�n������", 0, 32));
  sl = new JTextField();
  sl.setFont(new Font("�L�n������", 0, 20));
  cd.add(sleeveLength);
  cd.add(sl);
  shoulderWidth = new JLabel("�Ӽe :", SwingConstants.CENTER);
  shoulderWidth.setFont(new Font("�L�n������", 0, 32));
  sw = new JTextField();
  sw.setFont(new Font("�L�n������", 0, 20));
  cd.add(shoulderWidth);
  cd.add(sw);
  bust = new JLabel("      �ݳ� :");
  bust.setFont(new Font("�L�n������", 0, 32));
  bustt = new JTextField();
  bustt.setFont(new Font("�L�n������", 0, 20));
  cd.add(bust);
  cd.add(bustt);
  hip = new JLabel("�v�� :", SwingConstants.CENTER);
  hip.setFont(new Font("�L�n������", 0, 32));
  hipp = new JTextField();
  hipp.setFont(new Font("�L�n������", 0, 20));
  cd.add(hip);
  cd.add(hipp);
  Thigh = new JLabel("      �j�L�� :");
  Thigh.setFont(new Font("�L�n������", 0, 32));
  Thighh = new JTextField();
  Thighh.setFont(new Font("�L�n������", 0, 20));
  cd.add(Thigh);
  cd.add(Thighh);
  cd.setBorder(new TitledBorder(new EtchedBorder(), "�ԲӸ��"));
  return cd;
 }

 public JPanel createDescription() {
  JPanel cde = new JPanel();
  cde.setLayout(new GridLayout(2, 1));
  description = new JLabel("�ӫ~�y�z:", SwingConstants.CENTER);
  description.setFont(new Font("�L�n������", 0, 32));
  df = new JTextArea();
  df.setPreferredSize(new Dimension(200, 200));
  df.setFont(new Font("�L�n������", 0, 20));
  df.setLineWrap(true);
  ScrollPane scroll = new ScrollPane();
  scroll.add(df);
  cde.add(description);
  cde.add(scroll);
  return cde;
 }

 public JPanel createNextBtn() {
  JPanel cnb = new JPanel();
  nextStep = new JButton("�U�@�B");
  nextStep.setPreferredSize(new Dimension(100, 40));
  nextStep.setFont(new Font("�L�n������", 1, 20));
  
  cnb.add(nextStep);
  cnb.setPreferredSize(new Dimension(100, 50));

  class NextActionListener implements ActionListener {

   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    try {
     key();
     Seydetail frame = new Seydetail();
     frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     frame.setVisible(true);
     frame.setUserID(userID);
     setVisible(false);
    } catch (Exception e1) {
     e1.printStackTrace();
    }
   }
  }
  nextStep.addActionListener(new NextActionListener());
  return cnb;
 }

 

 public void createPanel() {
  JPanel titlePanel = new JPanel();
  JPanel mainPanel = new JPanel();
  JPanel nextPanel = new JPanel();
  JPanel leftPanel = new JPanel();
  class1 = createNameAndPrice();
  class2 = createPhotoPanel();
  class3 = createCombo();
  class4 = createDetail();
  class5 = createDescription();
  class6 = createNextBtn();
  class7 = createTitlePanel();
  // class9 = createCombo2();
  class10 = createSubTitle();
  class14 = createNameAndPrice2();

  titlePanel.add(class7);

  leftPanel.setLayout(new GridLayout(4, 1));
  leftPanel.add(class10);
  leftPanel.add(class1);
  leftPanel.add(class14);
  leftPanel.add(class2);

  mainPanel.setLayout(new GridLayout(3, 1));
  mainPanel.add(class3);
  // mainPanel.add(class9);
  mainPanel.add(class4);
  mainPanel.add(class5);

  nextPanel.add(class6);

  setLayout(new BorderLayout());
  add(mainPanel, BorderLayout.CENTER);
  add(titlePanel, BorderLayout.NORTH);
  add(nextPanel, BorderLayout.SOUTH);
  add(leftPanel, BorderLayout.WEST);
 }
 public void createPhoto() throws SQLException, IOException {
	  JFileChooser fileChooser = new JFileChooser();
	  int returnValue = fileChooser.showOpenDialog(null);

	  if (returnValue == JFileChooser.APPROVE_OPTION) // �P�_�O�_����ɮ�
	  {
	   selectedFile = fileChooser.getSelectedFile();// ������File
	   String path = fileChooser.getSelectedFile().getPath();
	   substitute.setText(path);
	  }
	 }

 public void key() throws SQLException, IOException {
	  Connection conn = ConnectionSQL.getConnection();
	  String query = "INSERT INTO MG13.Product (`Product_Number`,`Type_Number`,`name`,`size`,`price`,`length(TOP)`,`length(Button)`,`shoulder width`,`sleeve length`,`bust`,`waistline`,`hip circumference`,`thigh circumference`,`User_Number`,`photo`,`description`,`height_low`,`height_high`,`weight_low`,`weight_high`,`waistline_low`,`waistline_high`,`shoulder width_low`,`shoulder width_high`,`bust_low`,`bust_high`,`hip circumference_low`,`hip circumference_high`,`thigh circumference_low`,`thigh circumference_high`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  File file=new File(substitute.getText());
	  InputStream fileInputStream=new FileInputStream(file);
	  PreparedStatement pst = conn.prepareStatement(query);
	  pst.setInt(1, 0);
	  pst.setInt(2, classifyCombo.getSelectedIndex());
	  pst.setString(3, itemnameField.getText());
	  pst.setString(4, sizeCombo.getSelectedItem().toString());
	  pst.setInt(5, Integer.parseInt(itempriceField.getText()));
	  pst.setInt(6, Integer.parseInt(cl.getText()));
	  pst.setInt(7, Integer.parseInt(pl.getText()));
	  pst.setInt(8, Integer.parseInt(sw.getText()));
	  pst.setInt(9, Integer.parseInt(sl.getText()));
	  pst.setInt(10, Integer.parseInt(bustt.getText()));
	  pst.setInt(11, Integer.parseInt(wl.getText()));
	  pst.setInt(12, Integer.parseInt(hipp.getText()));
	  pst.setInt(13, Integer.parseInt(Thighh.getText()));
	  pst.setInt(14, userID);
	  pst.setBinaryStream(15, fileInputStream, (int)file.length());
	  pst.setString(16,df.getText() );
	  pst.setInt(17, 0);
	  pst.setInt(18, 0);
	  pst.setInt(19, 0);
	  pst.setInt(20, 0);
	  pst.setInt(21, 0);
	  pst.setInt(22, 0);
	  pst.setInt(23, 0);
	  pst.setInt(24, 0);
	  pst.setInt(25, 0);
	  pst.setInt(26, 0);
	  pst.setInt(27, 0);
	  pst.setInt(28, 0);
	  pst.setInt(29, 0);
	  pst.setInt(30, 0);
	//   
	//  Statement statement = conn.createStatement();
	//  statement.execute(query);
	  pst.executeUpdate();
	  conn.close();
	 }

	 public static void main(String[] args) {
	  NewGood frame = new NewGood();
	  frame.setTitle("Fit Amazing");
	  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	 }
	}