package mp2.udistrital.edu.co.figurasGraficas;

import mp2.udistrital.edu.co.figuras.Figuras;

abstract class FiguraGrafica extends Figuras implements Dibujable{
    int vertices, coordsX[], coordsY[];
    public FiguraGrafica(String nombre) {
        super(nombre);
    }
}
