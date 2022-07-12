/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras2.pkg0;

import udistrital.edu.co.mod2.controller.Control;
import udistrital.edu.co.mod2.figuras.Poligono;
import udistrital.edu.co.mod2.model.Poligono2D;
import udistrital.edu.co.mod2.view.Ventana;

/**
 *
 * @author Carlos
 */
public class Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int xs[] = {100, 300, 300, 500, 550};
        int ys[] = {100, 100, 200, 400, 500};
        
        // TODO code application logic here
        Control.vent = new Ventana("Dibujador");
        Poligono2D p2 = new Poligono2D(new Poligono(5, xs, ys));
        Control.figuras.add(p2);
        
        System.out.println(p2.calcularArea());
        System.out.println(p2.calcularPerimetro());
    }
    
}
