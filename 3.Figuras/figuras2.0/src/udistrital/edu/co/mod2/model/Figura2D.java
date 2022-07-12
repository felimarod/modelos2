/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.model;

import udistrital.edu.co.mod2.figuras.Figura;

/**
 *
 * @author carlos
 */
public abstract class Figura2D extends Figura implements Dibujable {
    protected int xi, yi;

    public Figura2D(int xi, int yi) {
        this.xi = xi;
        this.yi = yi;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getYi() {
        return yi;
    }

    public void setYi(int yi) {
        this.yi = yi;
    }
    
    
}
