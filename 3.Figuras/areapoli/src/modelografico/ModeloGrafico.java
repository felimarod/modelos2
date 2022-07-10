/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelografico;

import java.awt.Color;
import java.awt.Graphics;
import udistrital.edu.co.controller.Controlador;
import udistrital.edu.co.mp2.figuras.Circulo;
import udistrital.edu.co.model.CirculoGrafico;
import udistrital.edu.co.view.Ventana;

/**
 *
 * @author Estudiantes
 */
public class ModeloGrafico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v = new Ventana("Figuras en 2D");
        Controlador.lista.add(new CirculoGrafico(new Circulo(55), 100, 100));
        Controlador.lista.add(new CirculoGrafico(new Circulo(35), 200, 100));
        Controlador.lista.add(new CirculoGrafico(new Circulo(85), 200, 200));
    }
    
}
