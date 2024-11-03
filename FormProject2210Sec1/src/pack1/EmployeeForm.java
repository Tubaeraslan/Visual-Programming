package pack1;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	ArrayList<Employee> employees = new ArrayList<Employee>();
	private JTextField txtName;
	private JTextField txtSurname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("Employee Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 26, 63, 14);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(88, 23, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 54, 63, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(88, 51, 86, 20);
		contentPane.add(txtSurname);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cbAge = new JComboBox();
		cbAge.setBounds(88, 88, 46, 22);
		contentPane.add(cbAge);
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setBounds(10, 134, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(82, 130, 109, 23);
		contentPane.add(rdbtnMale);
		rdbtnMale.setActionCommand("Male");
		
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(82, 157, 109, 23);
		contentPane.add(rdbtnFemale);
		rdbtnFemale.setActionCommand("Female");
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setBounds(10, 195, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cbCity = new JComboBox();
		cbCity.setModel(new DefaultComboBoxModel(new String[] {"Ankara", "Antalya", "Bursa", "Istanbul"}));
		cbCity.setBounds(88, 191, 86, 22);
		contentPane.add(cbCity);
		
		JLabel lblNewLabel_4 = new JLabel("Languages");
		lblNewLabel_4.setBounds(195, 26, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chEnglish = new JCheckBox("English");
		chEnglish.setBounds(195, 50, 97, 23);
		contentPane.add(chEnglish);
		chEnglish.setActionCommand("English");
		
		JCheckBox chGerman = new JCheckBox("German");
		chGerman.setBounds(195, 76, 97, 23);
		contentPane.add(chGerman);
		chGerman.setActionCommand("German");
		
		JCheckBox chSpanish = new JCheckBox("Spanish");
		chSpanish.setBounds(195, 102, 97, 23);
		contentPane.add(chSpanish);
		chSpanish.setActionCommand("Spanish");
		
		ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
		boxes.add(chEnglish);
		boxes.add(chGerman);
		boxes.add(chSpanish);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Employee emp = new Employee();
				emp.name = txtName.getText();
				emp.surname = txtSurname.getText();
				emp.age = Integer.parseInt( cbAge.getSelectedItem().toString() );
				emp.gender = genderGroup.getSelection().getActionCommand();
				emp.city = cbCity.getSelectedItem().toString();
				
				String _languages = "";
				for (JCheckBox c : boxes) {
					if(c.isSelected()) {
						_languages += c.getActionCommand()+" ";
					}
				}
				emp.languages = _languages;
				employees.add(emp);		
				JOptionPane.showMessageDialog(contentPane, "Employee Saved!");
				
				txtName.setText("");
				txtSurname.setText("");
				cbAge.setSelectedIndex(0);
				genderGroup.clearSelection();
				cbCity.setSelectedIndex(0);
				for (JCheckBox c : boxes) {
					c.setSelected(false);
				}
		
			}
		});
		btnSave.setBounds(184, 191, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(184, 225, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_5 = new JLabel("Employee List");
		lblNewLabel_5.setBounds(316, 26, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(412, 54, 112, 94);
		contentPane.add(textArea);
		
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 String selectedEmp = list.getSelectedValue().toString();
				 String output = "";
				 for (Employee emp : employees) {
					if((emp.name+" "+emp.surname).equals(selectedEmp) ) {
						output += emp.name+" "+emp.surname+"\n"+
								  emp.age+" "+emp.gender+"\n"+
								  emp.city+"\n"+emp.languages;
					}
				}
				textArea.setText(output);
			}
		});
		list.setModel(modelList);
		list.setBounds(315, 53, 87, 142);
		contentPane.add(list);
		
		JButton btnGetList = new JButton("Get List");
		btnGetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelList.removeAllElements();
				for (Employee emp : employees) {
					modelList.addElement(emp.name+" "+emp.surname);
				}
				
			}
		});
		btnGetList.setBounds(316, 206, 89, 23);
		contentPane.add(btnGetList);
		
		JLabel lblNewLabel_6 = new JLabel("Details");
		lblNewLabel_6.setBounds(412, 29, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		
	}
}
