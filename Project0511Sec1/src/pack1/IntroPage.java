package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					IntroPage frame = new IntroPage();
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
	public IntroPage() {
		setTitle("Introduction Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnFrame3 = new JButton("Frame 3");
		btnFrame3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameThree f3 = new FrameThree();
				f3.setVisible(true);
			}
		});
		btnFrame3.setBounds(335, 200, 89, 23);
		contentPane.add(btnFrame3);
		
		JButton btnFrame2 = new JButton("Frame 2");
		btnFrame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameTwo f2 = new FrameTwo();
				f2.setVisible(true);
			}
		});
		btnFrame2.setBounds(335, 172, 89, 23);
		contentPane.add(btnFrame2);
	}
}
