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
package udistrital.edu.co.mp2.figuras;

import mp2.udistrital.edu.co.figuras.Figuras;

/**
 *
 * @author felipe
 */
public class Circulo extends Figuras  {
    double r;

    public Circulo(double r) {
        super("Circulo");
        this.r = r;
    }

    public void setRadio(double r) {
        this.r = r;
    }
    
    public double getRadio(){
        return r;
    }
    @Override
    public double getArea() {
        return Math.pow(r, 2)* Math.PI;
    }

    @Override
    public double getPerimetro() {
        return Math.PI*2*r;
    }
    
}
