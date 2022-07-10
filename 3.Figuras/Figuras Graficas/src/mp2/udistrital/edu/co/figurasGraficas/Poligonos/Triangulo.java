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
public class Triangulo extends AbstractPoligonoRegular {

    Triangulo(double lon) {
        super(3, lon, lon*(Math.sqrt(3))/4, "Cuadrado");
    }
}
