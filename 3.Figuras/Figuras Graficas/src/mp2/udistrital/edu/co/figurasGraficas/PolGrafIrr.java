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

    private final int[] coordsX, coordsY;

    public PolGrafIrr(String nombre, int[] coordsX, int[] coordsY) {
        super(nombre);
        this.coordsX = coordsX;
        this.coordsY = coordsY;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawPolygon(coordsX, coordsY, coordsX.length - 1);
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
        int diferenciaXY = 0;
        if (sumatoriaX > sumatoriaY) {
            diferenciaXY = sumatoriaX - sumatoriaY;
        }
        if (sumatoriaY > sumatoriaX) {
            diferenciaXY = sumatoriaY - sumatoriaX;
        }

        return diferenciaXY / 2;
    }

    @Override
    public double getPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
