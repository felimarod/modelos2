/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package udistrital.edu.co.model;

import java.awt.Graphics;

/**
 *
 * @author Estudiantes
 */
public abstract class FiguraGrafica {
    protected int px,py;

    public FiguraGrafica(int px, int py) {
        this.px = px;
        this.py = py;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }
    public abstract void dibujar(Graphics g);
}
