package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {
	boolean status = false;
	private JPanel contentPane;
	private JTextField txtNewUserId;
	private JTextField txtNewName;
	private JTextField txtNewSurname;
	private JTextField txtNewUsername;
	private JTextField txtNewPassword;
	private JPanel panel;
	private JList list;
	DefaultListModel<String> model;
	UserServices userSer = new UserServices();
	
	public void filltheList() throws SQLException {
		model.removeAllElements();
		userSer.getUsers().forEach(user -> {
			model.addElement(user.getUserId()+" "+user.getName()+" "+user.getSurname()
											 +" "+user.getUserRole());
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminPage() throws SQLException {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User List");
		lblNewLabel.setBounds(10, 21, 74, 14);
		contentPane.add(lblNewLabel);
		
		model = new DefaultListModel<String>();
		
		list = new JList(model);
		list.setBounds(10, 47, 104, 163);
		contentPane.add(list);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					filltheList();
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(10, 221, 104, 23);
		contentPane.add(btnRefresh);
		
		//filltheList();
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status==false) {
					status = true;
					panel.setVisible(status);
					setBounds(100, 100, 450, 300);
				}
				else {
					status = false;
					panel.setVisible(status);
					setBounds(100, 100, 250, 300);
				}
				
			}
		});
		btnNewUser.setBounds(124, 44, 104, 23);
		contentPane.add(btnNewUser);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				String selectedUser = list.getSelectedValue().toString();
				selectedUser.substring(0, 1);
				//Java  substring(0,1) j
				//2 Mile Holl admin
				//selectedUser.split(" ")[0];
				
				int selectedID = userSer.getUsers().stream()
									  .filter(u -> (u.getUserId()+" "+u.getName()+" "+u.getSurname()+" "+u.getUserRole()).equals(selectedUser) )
								      .findFirst().get().getUserId();
				
				 userSer.deleteUser(Integer.parseInt( selectedUser.split(" ")[0] ) );
				 filltheList();
				 
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnDelete.setBounds(125, 221, 89, 23);
		contentPane.add(btnDelete);
		
		JComboBox cbUserRole = new JComboBox();
		cbUserRole.setModel(new DefaultComboBoxModel(new String[] {"admin", "normal"}));
		cbUserRole.setBounds(124, 158, 90, 22);
		contentPane.add(cbUserRole);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String newRole = cbUserRole.getSelectedItem().toString();
					String selectedUser = list.getSelectedValue().toString();
					
					
					int selectedID = userSer.getUsers().stream()
							  .filter(u -> (u.getUserId()+" "+u.getName()+" "+u.getSurname()+" "+u.getUserRole()).equals(selectedUser) )
						      .findFirst().get().getUserId();
					
					userSer.updateUser(Integer.parseInt( selectedUser.split(" ")[0] ), newRole);
					filltheList();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(125, 187, 89, 23);
		contentPane.add(btnUpdate);
		
		
		
		panel = new JPanel();
		panel.setBounds(238, 21, 186, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 24, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtNewUserId = new JTextField();
		txtNewUserId.setText("");
		txtNewUserId.setBounds(90, 21, 36, 20);
		panel.add(txtNewUserId);
		txtNewUserId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(10, 52, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		txtNewName = new JTextField();
		txtNewName.setText("");
		txtNewName.setColumns(10);
		txtNewName.setBounds(90, 49, 86, 20);
		panel.add(txtNewName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Surname");
		lblNewLabel_1_2.setBounds(10, 80, 70, 14);
		panel.add(lblNewLabel_1_2);
		
		txtNewSurname = new JTextField();
		txtNewSurname.setText("");
		txtNewSurname.setColumns(10);
		txtNewSurname.setBounds(90, 77, 86, 20);
		panel.add(txtNewSurname);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setBounds(10, 108, 86, 14);
		panel.add(lblNewLabel_1_3);
		
		txtNewUsername = new JTextField();
		txtNewUsername.setText("");
		txtNewUsername.setColumns(10);
		txtNewUsername.setBounds(90, 105, 86, 20);
		panel.add(txtNewUsername);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setBounds(10, 135, 86, 14);
		panel.add(lblNewLabel_1_4);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setText("");
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(90, 132, 86, 20);
		panel.add(txtNewPassword);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("User Role");
		lblNewLabel_1_4_1.setBounds(10, 160, 86, 14);
		panel.add(lblNewLabel_1_4_1);
		
		JComboBox cbNewUserRole = new JComboBox();
		cbNewUserRole.setModel(new DefaultComboBoxModel(new String[] {"admin", "normal"}));
		cbNewUserRole.setBounds(90, 160, 86, 22);
		panel.add(cbNewUserRole);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					User user = new User();
					user.setUserId( Integer.parseInt( txtNewUserId.getText() ) );
					user.setName(txtNewName.getText());
					user.setSurname(txtNewSurname.getText());
					user.setUsername(txtNewUsername.getText());
					user.setPassword(txtNewPassword.getText());
					user.setUserRole(cbNewUserRole.getSelectedItem().toString());
					
					userSer.saveUser(user);
					JOptionPane.showMessageDialog(contentPane, "User saved!");
					txtNewName.setText("");
					txtNewSurname.setText("");
					txtNewUsername.setText("");
					txtNewPassword.setText("");
					txtNewUserId.setText("");
					cbNewUserRole.setSelectedIndex(0);
					panel.setVisible(false);
					setBounds(100, 100, 250, 300);
					
					filltheList();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnSave.setBounds(87, 193, 89, 23);
		panel.add(btnSave);
	}
}
