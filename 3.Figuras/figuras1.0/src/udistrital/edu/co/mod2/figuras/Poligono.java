/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.figuras;

/**
 *
 * @author carlos
 */
public class Poligono extends Figura{

    private int vertices, x[], y[];

    public Poligono(int vertices, int[] x, int[] y) {
        this.vertices = vertices;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double calcularArea() {
        double temp = 0;
        for(int i = 1; i < x.length; i++){
            temp += x[i-1]* y[i];
        }
        temp += x[x.length-1]*y[0];
        for(int j = 1; j < x.length; j++){
            temp -= y[j-1]* x[j];
        }
        temp -= y[y.length-1]*x[0];
        this.area = temp/2; 
        return this.area;
    }

    @Override
    public double calcularPerimetro() {
        double temp = 0;
        for(int i = 1; i < x.length; i++){
            temp += Math.hypot((x[i]-x[i-1]), (y[i]-y[i-1]));
        }
        temp += Math.hypot((x[0]-x[x.length-1]), (y[0]-y[y.length-1]));
        this.perimetro = temp;
        return this.perimetro;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
    
    
    
}
