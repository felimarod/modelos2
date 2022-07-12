/*
 * The MIT License
 *
 * Copyright 2022 felipe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mp2.udistrital.edu.co.figurasGraficas;

import java.awt.Color;
import java.awt.Graphics;

public class PolGrafIrr extends FiguraGrafica {


    public PolGrafIrr(String nombre) {
        super(nombre);
    }
    
    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int[] getCoordsX(){
        return coordsX;
    }

    public void setCoordsX(String posX) {
        posX = posX.replaceAll("\\s+", "");
        String[] auxCoor = posX.split(",");
        coordsX = new int[auxCoor.length];
        for(int i= 0;i<coordsX.length; i++)
            try{
                coordsX[i] = Integer.parseInt(auxCoor[i]);
            } catch (NumberFormatException nfe){
                System.out.println("Se ingreso mal una coordenada en x");
            }
    }

    public int[] getCoordsY() {
        return coordsY;
    }

    public void setCoordsY(String posY) {
        posY = posY.replaceAll("\\s+", "");
        String[] auxCoor = posY.split(",");
        coordsY = new int[auxCoor.length];
        for(int i= 0;i<coordsY.length; i++)
            try{
                coordsY[i] = Integer.parseInt(auxCoor[i]);
            } catch (NumberFormatException nfe){
                System.out.println("Se ingreso mal una coordenada en y");
            }
    }
    
    @Override
    public double getPerimetro(){
        double temp = 0;
        for(int i = 1; i < coordsX.length; i++){
            temp += Math.hypot((coordsX[i]-coordsX[i-1]), (coordsY[i]-coordsY[i-1]));
        }
        temp += Math.hypot((coordsX[0]-coordsX[coordsX.length-1]), (coordsY[0]-coordsY[coordsY.length-1]));
        return temp;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 900, 900);
        g.setColor(Color.DARK_GRAY);
        g.drawPolygon(coordsX, coordsY, vertices);
    }

    @Override
    public double getArea() {
        Coordenadas coor = Coordenadas.getInstance();
        //JOptionPane.showMessageDialog(null, "Coordenadas en X son: " + Arrays.toString(coordsXM));
        //JOptionPane.showMessageDialog(null, "Coordenadas en Y son: " + Arrays.toString(coordsYM));
        int[] valoresX = coor.recorrerCoordsDatos(coordsX, coordsY);
        int[] valoresY = coor.recorrerCoordsDatos(coordsY, coordsX);

        //JOptionPane.showMessageDialog(null, "Valores en X son: " + Arrays.toString(valoresX));
        //JOptionPane.showMessageDialog(null, "Valores en Y son: " + Arrays.toString(valoresY));
        int sumatoriaX = coor.sumatoriaDatos(valoresX);
        int sumatoriaY = coor.sumatoriaDatos(valoresY);

        //JOptionPane.showMessageDialog(null, "Sumatoria de X es: " + sumatoriaX);
        //JOptionPane.showMessageDialog(null, "Sumatoria de Y es: " + sumatoriaY);
        int diferenciaXY = Math.abs(sumatoriaX - sumatoriaY);
        
        return diferenciaXY / 2;
    }

}
