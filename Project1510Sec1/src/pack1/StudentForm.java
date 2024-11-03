package pack1;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;

	ArrayList<Student> students = new ArrayList<Student>();
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 31, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(95, 28, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(20, 65, 71, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(95, 62, 86, 20);
		contentPane.add(txtSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(20, 112, 46, 14);
		contentPane.add(lblAge);
		
		JComboBox cbAge = new JComboBox();
		cbAge.setBounds(95, 108, 46, 22);
		contentPane.add(cbAge);
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(20, 145, 71, 14);
		contentPane.add(lblDepartment);
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
		cbModel.addElement("Computing");
		cbModel.addElement("Business");
		cbModel.addElement("History");
		
		JComboBox cbDept = new JComboBox();
		cbDept.setModel(cbModel);
		cbDept.setBounds(95, 141, 86, 22);
		contentPane.add(cbDept);
		/*cbDept.addItem("Computing");
		cbDept.addItem("Business");
		cbDept.addItem("Literature");*/
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stu = new Student();
				stu.name = txtName.getText();
				stu.surname = txtSurname.getText();
				stu.age = Integer.parseInt( cbAge.getSelectedItem().toString() ); 
				stu.department = cbDept.getSelectedItem().toString();
				students.add(stu);
				JOptionPane.showMessageDialog(contentPane, "Student Saved!");
			}
		});
		btnSave.setBounds(92, 195, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setBounds(239, 31, 97, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(234, 62, 177, 84);
		contentPane.add(textArea);
		
		JButton btnGetList = new JButton("GetList");
		btnGetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				for (Student s : students) {
					output += s.name+" "+s.surname+", "+s.age+", "+s.department+"\n";
				}
				textArea.setText(output);
			}
		});
		btnGetList.setBounds(322, 161, 89, 23);
		contentPane.add(btnGetList);
	}
}
