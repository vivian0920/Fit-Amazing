import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class LogOn extends JFrame {
	private JLabel fitamazing;
	private JLabel account;
	private JLabel password;
	private JTextField accountfield;
	private JPasswordField passwordfield;
	private JButton logOnButton;
	private JButton signInButton;
	private int userID;
	private final static int BIGSIGN = 56;
	private final static int MIDDLESIGN = 40;
	private final static int CONTENT = 30;
	private final static int TEXTFIELD = 15;
	private final static int HIGHFIELD = 40;
	private final static int WEIGHFIELD = 200;

	public LogOn() {
		setSize(700, 400);
		setTitle("Fit amazing");
		add(finalpanel());

	}

	/* 集結且排版的panel ，最後constructor直接呼叫就好! */
	public JPanel finalpanel() {
		JPanel panel = new JPanel();
		JPanel accpass = new JPanel();
		accpass.setLayout(new GridLayout(4, 1));
		accpass.add(createAccPass());
		accpass.add(createpass());
		accpass.add(createbutton());
		accpass.add(createsign());

		panel.setLayout(new BorderLayout());
		panel.add(createfitamazing(), BorderLayout.NORTH);
		panel.add(accpass, BorderLayout.CENTER);

		return panel;

	}

	/* fit amazing 標題排版 */
	public JLabel createfitamazing() {
		fitamazing = new JLabel("Fit Amazing", SwingConstants.CENTER);
		fitamazing.setFont(new Font("20th Centenary Faux", 1, BIGSIGN));
		fitamazing.setForeground(Color.PINK);

		return fitamazing;
	}

	/* 帳號密碼輸入囉!! */
	public JPanel createAccPass() {
		JPanel panel = new JPanel();
		account = new JLabel("帳號:");
		account.setFont(new Font("微軟正黑體", 0, CONTENT));
		accountfield = new JTextField();
		accountfield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		panel.add(account);
		panel.add(accountfield);

		return panel;
	}

	public JPanel createpass() {
		JPanel panel = new JPanel();
		password = new JLabel("密碼:");
		password.setFont(new Font("微軟正黑體", 0, CONTENT));
		passwordfield = new JPasswordField();
		passwordfield.setPreferredSize(new Dimension(WEIGHFIELD, HIGHFIELD));
		panel.add(password);
		panel.add(passwordfield);
		return panel;
	}

	/* 登入跟註冊按鈕 */
	public JPanel createbutton() {
		JPanel panel = new JPanel();
		logOnButton = new JButton(" 登        入 ");
		logOnButton.setFont(new Font("微軟正黑體", 1, CONTENT));
		logOnButton.setPreferredSize(new Dimension(200, 40));

		class logonActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					checkuser();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.getMessage();
					e2.printStackTrace();
				}
			}

		}

		setContentPane(getContentPane());
		logOnButton.addActionListener(new logonActionListener());
		panel.add(logOnButton);

		return panel;

	}

	public JPanel createsign() {
		signInButton = new JButton("註冊");
		signInButton.setPreferredSize(new Dimension(100, 35));
		signInButton.setFont(new Font("微軟正黑體", 1, 25));
		JLabel space = new JLabel("                                                     ");
		JPanel littlepanel = new JPanel();
		littlepanel.add(space);
		littlepanel.add(signInButton);
		class signActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Sign sign1 = new Sign();
				sign1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				sign1.setVisible(true);
				setVisible(false);
			}
		}
		signInButton.addActionListener(new signActionListener());
		return littlepanel;
	}



	public void checkuser() throws SQLException {
		String customerNumber, pin;
		customerNumber = accountfield.getText();
		pin = passwordfield.getText();

		Connection connection = ConnectionSQL.getConnection();
		String query = "SELECT `password` ,`User_Number` FROM MG13.User where `User_Account`=? ";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, customerNumber);
		ResultSet resultSet = pStatement.executeQuery();
		if (resultSet.next() && pin.equals(resultSet.getString("password"))) {
			resultSet.getInt("User_Number");
			Main frame = new Main();
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			frame.setUserID(resultSet.getInt("User_Number"));
			setVisible(false);
			
		} else {
			accountfield.setText(" ");
			passwordfield.setText(" ");
		}
		connection.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogOn logOnframe = new LogOn();
		logOnframe.setDefaultCloseOperation(logOnframe.EXIT_ON_CLOSE);
		logOnframe.setVisible(true);

	}

}
