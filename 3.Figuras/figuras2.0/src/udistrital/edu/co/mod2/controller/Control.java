/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.controller;

import java.awt.Graphics;
import java.util.ArrayList;
import udistrital.edu.co.mod2.model.Figura2D;
import udistrital.edu.co.mod2.view.Ventana;

/**
 *
 * @author carlos
 */
public class Control {
    public static Ventana vent;
    public static ArrayList<Figura2D> figuras = new ArrayList<>();
    
    public static void graficar(Graphics g){
        for(Figura2D f:figuras){
            f.dibujar(g);
        }
    }
    
}
