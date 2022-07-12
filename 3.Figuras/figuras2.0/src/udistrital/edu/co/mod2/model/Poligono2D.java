/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.model;

import java.awt.Graphics;
import udistrital.edu.co.mod2.figuras.Poligono;

/**
 *
 * @author carlos
 */
public class Poligono2D extends Figura2D {

    private Poligono p;

    public Poligono2D(Poligono p) {
        super(p.getX()[0], p.getY()[0]);
        this.p = p;
    }
    
    @Override
    public double calcularArea() {
        return p.calcularArea();
    }

    @Override
    public double calcularPerimetro() {
        return p.calcularPerimetro();
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawPolygon(p.getX(), p.getY(), p.getVertices());
    }
    
}
