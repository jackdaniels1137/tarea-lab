package laboratorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ventana {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JLabel label = new JLabel();
		label.setText("Holaaa soy un Label");
		frame.add(label);
		
		JButton button = new JButton();
		button.setText("Presioname pls");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Finished");
					}
			}
		);
		frame.add(button);
		
		frame.setTitle("My first windows");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
}
