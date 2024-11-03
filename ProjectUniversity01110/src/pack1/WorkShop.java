package pack1;

import javax.swing.JOptionPane;

public class WorkShop {

	public static void main(String[] args) {

		String name = JOptionPane.showInputDialog("Your name?");
		
		int age = Integer.parseInt( JOptionPane.showInputDialog("Your age?") );
		
		JOptionPane.showMessageDialog(null, "Hello "+name+" an your age is "+age);

	}

}
