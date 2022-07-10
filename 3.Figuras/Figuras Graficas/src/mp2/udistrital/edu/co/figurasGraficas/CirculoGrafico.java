/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp2.udistrital.edu.co.figurasGraficas;

import java.awt.Color;
import java.awt.Graphics;
import mp2.udistrital.edu.co.figuras.Circulo;

/**
 *
 * @author felipe
 */
public class CirculoGrafico extends FiguraGrafica {
    Circulo c;
    int px, py;

    public CirculoGrafico(Circulo c, int px, int py) {
        super(c.getNombre());
        this.px = px;
        this.py = py;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.white);
        g.drawOval(px, py, px+(int)(2*c.getRadio()), py+(int)(2*c.getRadio()));
    }

    @Override
    public double getArea() {
        return c.getArea();
    }

    @Override
    public double getPerimetro() {
        return c.getPerimetro();
    }
    
}
