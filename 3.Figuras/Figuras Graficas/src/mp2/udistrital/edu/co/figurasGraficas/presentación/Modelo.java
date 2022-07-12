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

import java.util.Arrays;
import javax.swing.JOptionPane;
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
//        getVista().getTxtCoordX().setText("20,40,40,20");
//        getVista().getTxtCoordY().setText("20,20,40,40");
        getVista().getTxtCoordX().setText("100, 300, 300, 500, 550");
        getVista().getTxtCoordY().setText("100, 100, 200, 400, 500");
        getVista().getBtnCalculate().doClick();
    }

    void mostrarArea() {
        PolGrafIrr pgi = new PolGrafIrr("poli");

        pgi.setCoordsX(getVista().getTxtCoordX().getText());
        pgi.setCoordsY(getVista().getTxtCoordY().getText());

        pgi.setVertices(pgi.getCoordsX().length);
//        System.out.println(pgi.getVertices());
//        System.out.println(Arrays.toString(pgi.getCoordsX()));
//        System.out.println(Arrays.toString(pgi.getCoordsY()));

        if (pgi.getVertices() == 0) {
            JOptionPane.showMessageDialog(null, "Las coordenadas no deben estar vacias, intentelo nuevamente");
        } else if (pgi.getVertices() > 0 && pgi.getVertices() <= 2) {
            JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
        } else if (pgi.getVertices() > 3) {
            getVistaPoligono().setVisible(true);
            pgi.dibujar(getVistaPoligono().getGraphics());
            JOptionPane.showMessageDialog(null, "Para dibujar el grafico primero debe calcular el área, vuelva a calcular.\nEl area del poligono irregular evaluado es: " + pgi.getArea() + "\nEl perimetro es: " + pgi.getPerimetro());
        }
    }

    public VistaPoligono getVistaPoligono() {
        if (vp == null) {
            vp = new VistaPoligono();
        }
        return vp;
    }

}
