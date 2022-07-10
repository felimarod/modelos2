package mp2.udistrital.edu.co.figurasGraficas;

import java.awt.Graphics;
import mp2.udistrital.edu.co.figuras.Figuras;

abstract class FiguraGrafica extends Figuras {

    public FiguraGrafica(String nombre) {
        super(nombre);
    }

    public abstract void dibujar(Graphics g);
}
