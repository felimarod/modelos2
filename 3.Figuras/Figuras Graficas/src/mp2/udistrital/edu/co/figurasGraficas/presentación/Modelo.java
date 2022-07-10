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
package mp2.udistrital.edu.co.figurasGraficas.presentación;

import mp2.udistrital.edu.co.figurasGraficas.Coordenadas;
import javax.swing.JOptionPane;
import mp2.udistrital.edu.co.figuras.Circulo;
import mp2.udistrital.edu.co.figurasGraficas.CirculoGrafico;
import mp2.udistrital.edu.co.figurasGraficas.PolGrafIrr;

/**
 *
 * @author felipe
 */
public class Modelo {

    Vista v;
    VistaPoligono vp;

    Vista getVista() {
        if (v == null) {
            v = new Vista(this);
        }
        return v;
    }

    public void iniciar() {
        getVista().setVisible(true);
        getVista().getTxtCoordX().setText("20,40,40,20");
        getVista().getTxtCoordY().setText("20,20,40,40");
        getVista().getBtnCalculate().doClick();
    }

    void mostrarArea() {
        Coordenadas coor = Coordenadas.getInstance();
        coor.setCoordsXDatos(getVista().getTxtCoordX().getText());
        coor.setCoordsYDatos(getVista().getTxtCoordY().getText());
        int[] coordsYM = coor.getCoordsYDatos();
        int[] coordsXM = coor.getCoordsXDatos();

        if (coordsYM.length == 0 || coordsXM.length == 0) {
            JOptionPane.showMessageDialog(null, "Las coordenadas no deben estar vacias, intentelo nuevamente");
        } else if (coordsYM.length > 0 && coordsYM.length <= 3 || coordsXM.length > 0 && coordsXM.length <= 3) {
            if (coordsYM.length == 1 && coordsYM.length == 1) {
                CirculoGrafico cg = new CirculoGrafico(new Circulo(coordsYM[0]), (int) coordsYM[0], (int) coordsYM[0]);
                cg.dibujar(getVistaPoligono().getGraphics());
                JOptionPane.showMessageDialog(null, "El área del circulo es: " + cg.getArea());
            } else {
                JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
            }
        } else if (coordsYM.length > 3 && coordsXM.length > 3) {
            PolGrafIrr pgi = new PolGrafIrr("",coordsXM,coordsYM);
            getVistaPoligono().setVisible(true);
            pgi.dibujar(getVistaPoligono().getGraphics());
            JOptionPane.showMessageDialog(null, "El area del poligono irregular evaluado es: " + pgi.getArea());
        }
    }

    public VistaPoligono getVistaPoligono() {
        if (vp == null) {
            vp = new VistaPoligono();
        }
        return vp;
    }

}
