/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.figuras;

/**
 *
 * @author carlos
 */
public class Circulo extends Figura{

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        this.area = Math.PI * Math.pow(this.radio, 2);
        return this.area;
    }

    @Override
    public double calcularPerimetro() {
        this.perimetro = 2 * Math.PI * this.radio;
        return this.perimetro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
