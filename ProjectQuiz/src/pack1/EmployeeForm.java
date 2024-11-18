package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtSurname;
	ArrayList<Employee> employees = new  ArrayList<Employee>();
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
		setTitle("Employee Form Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(96, 28, 39, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 59, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(96, 56, 86, 20);
		contentPane.add(txtName);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setBounds(10, 87, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(96, 84, 86, 20);
		contentPane.add(txtSurname);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(10, 123, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdMale = new JRadioButton("Male");
		rdMale.setBounds(96, 119, 109, 23);
		contentPane.add(rdMale);
		rdMale.setActionCommand("Male");
		
		JRadioButton rdFemale = new JRadioButton("Female");
		rdFemale.setBounds(96, 145, 109, 23);
		contentPane.add(rdFemale);
		rdFemale.setActionCommand("Female");
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdFemale);
		genderGroup.add(rdMale);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setBounds(10, 180, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox cbAge = new JComboBox();
		cbAge.setBounds(96, 175, 39, 22);
		contentPane.add(cbAge);
		
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Department");
		lblNewLabel_5.setBounds(10, 205, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		cbModel.addElement("Accounting");
		cbModel.addElement("IT");
		cbModel.addElement("Sales");
		cbModel.addElement("Human Resources");
		
		JComboBox cbDept = new JComboBox(cbModel);
		cbDept.setBounds(96, 201, 86, 22);
		contentPane.add(cbDept);
		
		
		JButton btnSave = new JButton("Save Employe");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str_ID = txtID.getText();
				if(str_ID.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "ID cannot be empty!");
				}
				else {
					Employee emp = new Employee();
					emp.id = Integer.parseInt(str_ID);
					emp.name = txtName.getText();
					emp.surname = txtSurname.getText();
					emp.gender = genderGroup.getSelection().getActionCommand();
					emp.age = Integer.parseInt(cbAge.getSelectedItem().toString());
					emp.department = cbDept.getSelectedItem().toString();
					employees.add(emp);
					JOptionPane.showMessageDialog(contentPane, "Employee Saved");
					System.out.println(employees);
				}
				
				
			}
		});
		btnSave.setBounds(10, 230, 172, 23);
		contentPane.add(btnSave);
		
		
		
		
		JComboBox cbDepartment = new JComboBox();
		cbDepartment.setBounds(365, 27, 86, 22);
		contentPane.add(cbDepartment);
		cbDepartment.addItem("All");
		cbDepartment.addItem("Accounting");
		cbDepartment.addItem("Sales");
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Department");
		lblNewLabel_6.setBounds(365, 11, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList list = new JList(listModel);
		list.setBounds(229, 58, 248, 82);
		contentPane.add(list);
		
		
		JButton btnGetList = new JButton("Get Employees");
		btnGetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listModel.removeAllElements();
				String selectedDept = cbDepartment.getSelectedItem().toString();
				if(selectedDept.equals("All")) {
					for (Employee emp : employees) {
						listModel.addElement(emp.name+" "+emp.name+" "+emp.age);
					}
				}
				else {
					for (Employee emp : employees) {
						if(emp.department.equals(selectedDept)) {
							listModel.addElement(emp.name+" "+emp.name+" "+emp.age);
						}
					}
				}
				
				
			}
		});
		btnGetList.setBounds(229, 27, 133, 23);
		contentPane.add(btnGetList);
		
	}
}
