package laboratorio;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		label.setText("Holaaa soy un Label");
		frame.add(label);
		frame.setTitle("My first windows");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}
