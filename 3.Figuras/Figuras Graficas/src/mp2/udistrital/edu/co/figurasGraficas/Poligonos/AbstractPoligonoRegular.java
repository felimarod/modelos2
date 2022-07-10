package mp2.udistrital.edu.co.figuras;

abstract class AbstractPoligonoRegular extends Figuras {
    int l; /* cantidad de lados */
    double lon; /* Distancia entre los vertices */
    double ap; /* Apotema: Menor distancia entre el centro y cualquiera de sus lados */

    public AbstractPoligonoRegular(int lados, double longitudLado, double apotema, String nombre) {
        super(nombre);
        this.l = lados;
        this.lon = longitudLado;
        this.ap = apotema;
    }

    public int getLados() {
        return l;
    }

    public void setLados(int lados) {
        this.l = lados;
    }

    public double getLongitudLado() {
        return lon;
    }

    public void setLongitudLado(double longitudLado) {
        this.lon = longitudLado;
    }

    public double getApotema() {
        return ap;
    }

    public void setApotema(double apotema) {
        this.ap = apotema;
    }
    
    @Override
    public double getPerimetro() {
        return lon*l;
    }
    
    @Override
    public double getArea() {
        return ((lon*ap)/2)*l;
    }
    
}
