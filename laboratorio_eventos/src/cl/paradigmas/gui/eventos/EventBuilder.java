package cl.paradigmas.gui.eventos;


import cl.paradigmas.modelo.Circulo; 
import cl.paradigmas.modelo.Linea; 
import java.awt.event.MouseAdapter; 
import cl.paradigmas.gui.Ventana; 
import cl.paradigmas.gui.Canvas;
import java.awt.Point; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent; 

final public class EventBuilder{
	private EventBuilder(){
	}
	public static ActionListener botonlimpiar(final Ventana a){
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				a.getCanvas().limpiar();
			}
		};
	}
	public static ActionListener createLine(final Ventana b){ 
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				b.setSeleccionado(Ventana.LINEA); 
			} 
		};
	} 
	public static ActionListener drawCircle(final Ventana c){
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				c.setSeleccionado(Ventana.CIRCULO); 
			}
		};
	}
	public static MouseAdapter dibujarcanvas(final Ventana d){
		return new MouseAdapter(){
			private Point point;
			public void mousePressed(MouseEvent event){ 
				Canvas c = d.getCanvas(); 
				int selected = d.getSeleccionado(); 
				if(!c.isDibujandoTmp()){ 
					c.setDibujandoTmp(true);
					if(Ventana.CIRCULO == selected){
						int rcirle=50;
						Point q=(Point)event.getPoint().clone();
						q.x =q.x - rcirle/4; 
						q.y=q.y - rcirle/4;
						Circulo circle = new Circulo(q, rcirle); 
						c.setDibujableTmp(circle);
					}
					if(Ventana.LINEA == selected){ 
						point=event.getPoint();
						Linea line = new Linea(point, point);
						d.getCanvas().setDibujableTmp(line);
					}
					d.getCanvas().repaint();
				}
			}
			public void mouseDragged(MouseEvent event){
				int sel = d.getSeleccionado();
				Canvas cc = d.getCanvas();
				if(cc.isDibujandoTmp()){
					if(Ventana.CIRCULO == sel){ 
						Circulo circumference = (Circulo)cc.getDibujableTmp();
						int ratio = circumference.getRadius();
						Point dot = (Point)event.getPoint().clone();
						dot.x =dot.x - ratio/2;
						dot.y =dot.y - ratio/2;
						circumference.setPosicion(dot);
					}
					if(Ventana.LINEA == sel){ 
						Linea lin = (Linea)d.getCanvas().getDibujableTmp();
						lin.setFin(event.getPoint());
					}
					cc.repaint();
				}
			}
			public void mouseReleased(MouseEvent event){
				int select=d.getSeleccionado(); 
				Canvas ca = d.getCanvas();
				if(ca.isDibujandoTmp()){ 
					if(Ventana.LINEA==select){ 
						Linea line = (Linea)ca.getDibujableTmp(); 
						ca.setDibujableTmp(null);
						ca.addDibujable(line);
					}
					if(Ventana.CIRCULO==select){
						Circulo cir=(Circulo)ca.getDibujableTmp();
						ca.setDibujableTmp(null); 
						ca.addDibujable(cir);
					}
					ca.setDibujandoTmp(false); 
					ca.repaint();
				}
			}
		};
	}
}  
