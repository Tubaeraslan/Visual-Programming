package pack2;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	ArrayList<User> users = new ArrayList<User>();
	
	public boolean checkUser(String username, String password) {
		return users.stream()
					.filter(u-> u.username.equals(username)&& u.password.equals(password))
					.findFirst()
					.isPresent();
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					User u = new User("marryh","m123","Marry");
					frame.users.add(u);
				
					frame.users.add(new User("admin","1234","Mark"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 31, 76, 14);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(96, 28, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 62, 76, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(96, 59, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				if(checkUser(username, password)) {
					MainPage mp = new MainPage();
					mp.setVisible(true);
					
					mp.setUserLabel( users.stream()
							 .filter(u-> u.username.equals(username)&& u.password.equals(password))
							 .findFirst()
							 .get() );
					
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Login Failed!");
				}
				
				
				
			}
		});
		btnLogin.setBounds(93, 110, 89, 23);
		contentPane.add(btnLogin);
	}
}
