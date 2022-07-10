/*
 * Copyright (C) 2022 felipe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mp2.udistrital.edu.co.figuras;

/**
 *
 * @author felipe
 */
public class PoligonoRegular extends Figuras {
    int l; /* Cantidad de lados */
    double lon; /* Distancia entre los vertices */
    double ap; /* Apotema: Menor distancia entre el centro y cualquiera de sus lados */

    public PoligonoRegular(int lados, double longitudLado, double apotema, String nombre) {
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
