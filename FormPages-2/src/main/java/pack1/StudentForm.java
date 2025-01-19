package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setTitle("Student Form Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 31, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(81, 28, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 59, 71, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(81, 56, 86, 20);
		contentPane.add(txtSurname);
		
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(10, 107, 71, 14);
		contentPane.add(lblNewLabel);
		
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		
		
		
		JComboBox cbDept = new JComboBox(cbModel);
		cbDept.setBounds(81, 103, 86, 22);
		contentPane.add(cbDept);
		
		MainForm.departments.forEach(d-> {
			cbModel.addElement(d.title);
		});
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Student stu = new Student();
				stu.name = txtName.getText();
				stu.surname = txtSurname.getText();
				String selectedDept = cbDept.getSelectedItem().toString();
				
				stu.department = MainForm.departments.stream()
										.filter(d-> d.title.equals(selectedDept))
										.findFirst().get();
				
				MainForm.students.add(stu);
				
				JOptionPane.showMessageDialog(contentPane, "Student saved!");
				txtName.setText("");
				txtSurname.setText("");
				cbDept.setSelectedIndex(0);
			}
		});
		btnSave.setBounds(78, 165, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnBack.setBounds(78, 199, 89, 23);
		contentPane.add(btnBack);
	}

}
