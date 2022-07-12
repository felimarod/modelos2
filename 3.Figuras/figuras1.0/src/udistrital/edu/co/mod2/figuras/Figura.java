/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.figuras;

/**
 *  
 * clase abstracta figura clase abstracta para formas que tienen area y perimetro
 * @author carlos 
 *
 */
public abstract class Figura {

    protected double area, perimetro;

    public Figura() {
        this.area = 0;
        this.perimetro = 0;
    }

    public Figura(double area, double perimetro) {
        this.area = area;
        this.perimetro = perimetro;
    }
    
    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
