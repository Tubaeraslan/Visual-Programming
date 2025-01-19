package pack1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class DepartmentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txt_title;
	private JTextField txt_Faculty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentForm frame = new DepartmentForm();
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
	public DepartmentForm() {
		setTitle("Department Form Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(10, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		txt_title = new JTextField();
		txt_title.setBounds(87, 30, 86, 20);
		contentPane.add(txt_title);
		txt_title.setColumns(10);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 67, 46, 14);
		contentPane.add(lblFaculty);
		
		txt_Faculty = new JTextField();
		txt_Faculty.setColumns(10);
		txt_Faculty.setBounds(87, 64, 86, 20);
		contentPane.add(txt_Faculty);
		
		JLabel lblNewLabel_1 = new JLabel("Departments");
		lblNewLabel_1.setBounds(262, 11, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList list = new JList(listModel);
		list.setBounds(262, 80, 112, 170);
		contentPane.add(list);
				
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		
		MainForm.departments.forEach(d-> {
			cbModel.addElement(d.title);
		});
		
		JComboBox cb_Depts = new JComboBox(cbModel);
		cb_Depts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				MainForm.students.stream()
								 .filter(s-> s.department.title.equals(cb_Depts.getSelectedItem().toString()))
								 .forEach(s-> {
									 listModel.addElement(s.name+" "+s.surname);
								 });
			}
		});
		cb_Depts.setBounds(262, 29, 86, 22);
		contentPane.add(cb_Depts);
		
		
		
		
		JButton btn_Save = new JButton("Save");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = txt_title.getText();
				String faculty = txt_Faculty.getText();
				
				Department dept = new Department();
				dept.title = title;
				dept.faculty = faculty;
				
				MainForm.departments.add(dept);
				JOptionPane.showMessageDialog(contentPane, "Department Saved!");
				txt_title.setText("");
				txt_Faculty.setText("");
				
				cbModel.removeAllElements();
				MainForm.departments.forEach(d-> {
					cbModel.addElement(d.title);
				});
				
			}
		});
		btn_Save.setBounds(10, 146, 89, 23);
		contentPane.add(btn_Save);
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btn_Back.setBounds(10, 180, 89, 23);
		contentPane.add(btn_Back);
		
		
	}
}
