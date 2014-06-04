package cl.paradigmas.main;

import java.awt.event.MouseAdapter;
import javax.swing.JToggleButton;
import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.eventos.EventBuilder;

public class Main {
	
	public static void main(String[] args){
		Ventana v = new Ventana();
		v.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.botonlimpiar(v));
		v.getToolbar().addBtn("LINE", new JToggleButton("LINE"));
		v.getToolbar().getBtn("LINE").addActionListener(EventBuilder.createLine(v));
		v.getToolbar().addBtn("CIRCLE", new JToggleButton("CIRCLE"));
		v.getToolbar().getBtn("CIRCLE").addActionListener(EventBuilder.drawCircle(v));
		MouseAdapter adapter=EventBuilder.dibujarcanvas(v);
		v.getCanvas().addMouseListener(adapter);
		v.getCanvas().addMouseMotionListener(adapter);
		v.setVisible(true); 
	}
}
