/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.model;

import java.awt.Graphics;
import udistrital.edu.co.mp2.figuras.Circulo;

/**
 *
 * @author Estudiantes
 */
public class CirculoGrafico extends FiguraGrafica {
    
    private Circulo c;

    public CirculoGrafico(Circulo c, int px, int py) {
        super(px, py);
        this.c = c;
    }

    public Circulo getC() {
        return c;
    }

    public void setC(Circulo c) {
        this.c = c;
    }

    @Override
    public void dibujar(Graphics g) {
        g.fillOval(px+(int)c.getRadio(), py+(int)c.getRadio(), 2*(int)c.getRadio(), 2*(int)c.getRadio());
    }
    
}
