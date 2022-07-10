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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author felipe
 */
public class VistaPoligono extends JFrame {
    Canvas lienzo;
    
    public VistaPoligono() {
        super("Dibujo del poligono");
        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(new FlowLayout());
        setSize(300, 300);
        
//        lienzo = new Canvas();
//        lienzo.setSize(200,200);
//        lienzo.setBackground(Color.blue);
//        add(lienzo);
        //lienzo.addMouseListener(new ManejoRaton(lienzo));

        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

//    @Override
//    public Graphics getGraphics() {
//        return lienzo.getGraphics();
//    }    
}
