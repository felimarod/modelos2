// Tamaño del tablero SIZE*SIZE
let SIZE = 9;

// Tablero en el cual se va a trabajar
var matrix = [
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0]
];

// Tablero a solucionar #1
var SUDOKU1 = [
    [0,6,0,1,0,4,0,5,0],
    [0,0,8,3,0,5,6,0,0],
    [2,0,0,0,0,0,0,0,1],
    [8,0,0,4,0,7,0,0,6],
    [0,0,6,0,0,0,3,0,0],
    [7,0,0,9,0,1,0,0,4],
    [5,0,0,0,0,0,0,0,2],
    [0,0,7,2,0,6,9,0,0],
    [0,4,0,5,0,8,0,7,0]
];

// Tablero a solucionar #2
var SUDOKU2 = [
    [1,0,0,0,0,0,0,9,0],
    [8,4,0,0,0,2,0,0,0],
    [0,0,0,3,8,0,2,0,0],
    [0,0,0,9,0,0,8,5,3],
    [0,0,0,0,0,0,0,0,0],
    [5,3,8,0,0,6,0,0,0],
    [0,0,1,0,7,9,0,0,0],
    [0,0,0,5,0,0,0,6,7],
    [0,2,0,0,0,0,0,0,9]
];

// Tablero a solucionar #3
SUDOKU3 = [
    [0,0,7,0,2,0,0,0,0],
    [0,5,8,0,0,3,4,0,0],
    [0,0,0,0,0,4,0,7,1],
    [0,0,5,0,0,8,0,1,7],
    [7,0,0,9,0,6,0,0,8],
    [3,8,0,5,0,0,6,0,0],
    [5,3,0,7,0,0,0,0,0],
    [0,0,6,3,0,0,7,9,0],
    [0,0,0,0,5,0,1,0,0]
];

/*
 * Función para verificar si todas las celdas están asignadas o no
 * ¿hay números sin asignar? 0 = si 1 = no
 * { valor de verdad, fila, columna}
 * fila y columna de la casilla VACÍA
 */
function numberUnassigned(row, col){
    var numunassign = 0;
    for ( i = 0; i < SIZE; i++) {
        for (j = 0; j < SIZE; j++) {
            // la celda no esta asignada
            if (matrix[i][j] == 0) {
                // cambiando los valores de row y col
                row = i;
                col = j;
                // hay una o mas celdas sin asignar
                numunassign = 1;
                return [ numunassign, row, col ];
            }
        }
    }
    return [ numunassign, -1, -1];
}
