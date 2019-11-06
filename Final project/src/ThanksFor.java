import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ThanksFor extends JFrame {
	private static int FRAME_WIDTH = 700;
	private static int FRAME_HEIGHT = 400;

	private JLabel title;
	private JButton returnButton;
	private JLabel content;
	private JLabel content1;

	public ThanksFor() {

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		createPanel();

	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		returnButton = new JButton("返回登入畫面");
		returnButton.setFont(new Font("微軟正黑體", 1, 26));
		returnButton.setPreferredSize(new Dimension(200, 50));

		panel.add(returnButton);
		class backactionlistener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			    LogOn frame = new LogOn();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				setVisible(false);

			}
		}
        returnButton.addActionListener(new backactionlistener());
		return panel;
	}

	public void createPanel() {
		JPanel panel = new JPanel();
		title = new JLabel("Fit Amazing", SwingConstants.CENTER);
		title.setFont(new Font("20th Centenary Faux", 1, 56));
		title.setForeground(Color.PINK);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 1));
		content = new JLabel("您已註冊成功 !", SwingConstants.CENTER);
		content.setFont(new Font("微軟正黑體", 1, 30));
		content1 = new JLabel(" 感謝您的註冊！", SwingConstants.CENTER);
		content1.setFont(new Font("微軟正黑體", 1, 30));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel.setLayout(new BorderLayout());
		panel1.add(content);
		panel1.add(content1);
		panel1.add(createButton());
		panel.add(title, BorderLayout.NORTH);
		panel.add(panel1, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.WEST);
		panel.add(panel3, BorderLayout.EAST);
		add(panel);
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ThanksFor thankframe = new ThanksFor();
		thankframe.setDefaultCloseOperation(thankframe.EXIT_ON_CLOSE);
		thankframe.setVisible(true);

	}
}