/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras1.pkg0;

import udistrital.edu.co.mod2.figuras.Circulo;
import udistrital.edu.co.mod2.figuras.Figura;
import udistrital.edu.co.mod2.figuras.Poligono;

/**
 * clase principal del proyecto figura 1.0
 * @author Carlos
 * 
 */
public class Figuras {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        int xs[] = {0, 3, 3};
        int ys[] = {0, 0, 4};
        // TODO code application logic here
        Figura f = new Poligono(3,xs,ys);
        
        System.out.println(f.calcularArea());
        System.out.println(f.calcularPerimetro());
    }
    
}
