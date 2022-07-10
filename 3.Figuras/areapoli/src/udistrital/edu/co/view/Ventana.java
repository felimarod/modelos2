package udistrital.edu.co.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import udistrital.edu.co.controller.Controlador;
import udistrital.edu.co.model.FiguraGrafica;

/**
 *
 * @author Estudiantes
 */
public class Ventana extends JFrame {
    
    //private JPanel canvas = new JPanel();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); 
        this.dibujar(g);
    }

    
    public Ventana(String title) throws HeadlessException {
        super(title);
        //canvas.setBackground(Color.red);
        //this.add(canvas);
        this.setBounds(0, 0, 600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);  
    }

//    public JPanel getCanvas() {
//        return canvas;
//    }
//
//    public void setCanvas(JPanel canvas) {
//        this.canvas = canvas;
//    }
//    
//    public Graphics2D getGraficos2D(){
//        return (Graphics2D) canvas.getGraphics().create();
//    }
    
    public void dibujar(Graphics g){
        for(FiguraGrafica fg: Controlador.lista){
            fg.dibujar(g);
        }
    }
    
}
