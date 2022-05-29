// Tamaño del tablero SIZE*SIZE
const SIZE = 9

// Tablero en el cual se va a trabajar
let matrix = [
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
]

// Tablero a solucionar #1
const SUDOKU1 = [
  [0, 6, 0, 1, 0, 4, 0, 5, 0],
  [0, 0, 8, 3, 0, 5, 6, 0, 0],
  [2, 0, 0, 0, 0, 0, 0, 0, 1],
  [8, 0, 0, 4, 0, 7, 0, 0, 6],
  [0, 0, 6, 0, 0, 0, 3, 0, 0],
  [7, 0, 0, 9, 0, 1, 0, 0, 4],
  [5, 0, 0, 0, 0, 0, 0, 0, 2],
  [0, 0, 7, 2, 0, 6, 9, 0, 0],
  [0, 4, 0, 5, 0, 8, 0, 7, 0],
]

// Tablero a solucionar #2
const SUDOKU2 = [
  [1, 0, 0, 0, 0, 0, 0, 9, 0],
  [8, 4, 0, 0, 0, 2, 0, 0, 0],
  [0, 0, 0, 3, 8, 0, 2, 0, 0],
  [0, 0, 0, 9, 0, 0, 8, 5, 3],
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
  [5, 3, 8, 0, 0, 6, 0, 0, 0],
  [0, 0, 1, 0, 7, 9, 0, 0, 0],
  [0, 0, 0, 5, 0, 0, 0, 6, 7],
  [0, 2, 0, 0, 0, 0, 0, 0, 9],
]

// Tablero a solucionar #3
const SUDOKU3 = [
  [0, 0, 7, 0, 2, 0, 0, 0, 0],
  [0, 5, 8, 0, 0, 3, 4, 0, 0],
  [0, 0, 0, 0, 0, 4, 0, 7, 1],
  [0, 0, 5, 0, 0, 8, 0, 1, 7],
  [7, 0, 0, 9, 0, 6, 0, 0, 8],
  [3, 8, 0, 5, 0, 0, 6, 0, 0],
  [5, 3, 0, 7, 0, 0, 0, 0, 0],
  [0, 0, 6, 3, 0, 0, 7, 9, 0],
  [0, 0, 0, 0, 5, 0, 1, 0, 0],
]

/*
 * Función para verificar si todas las celdas están asignadas o no
 * ¿hay números sin asignar? 0 = si 1 = no
 * { valor de verdad, fila, columna}
 * fila y columna de la casilla VACÍA
 */
function numberUnassigned(row, col) {
  var numunassign = 0
  for (i = 0; i < SIZE; i++) {
    for (j = 0; j < SIZE; j++) {
      // la celda no esta asignada
      if (matrix[i][j] == 0) {
        // cambiando los valores de row y col
        row = i
        col = j
        // hay una o mas celdas sin asignar
        numunassign = 1
        return [numunassign, row, col]
      }
    }
  }
  return [numunassign, -1, -1]
}

/**
 * Función para comprobar si podemos poner un
 * valor en una celda particular o no
 */
function isSafe(n, r, c) {
  // comprobando en fila
  for (let i = 0; i < SIZE; i++) if (matrix[r][i] == n && i != c) return false;
  // comprobando la columna
  for (let i = 0; i < SIZE; i++) if (matrix[i][c] == n && i != r) return false
  // comprobación de submatriz
  row_start = (r / 3) * 3
  col_start = (c / 3) * 3
  for (let i = row_start; i < row_start + 3; i++)
    for (let j = col_start; j < col_start + 3; j++)
      if (matrix[i][j] == n && i != r && j != c) return false
  return true
}

/** Función para resolver sudoku usando recursividad */
function solveSudoku() {
  row = 0
  col = 0
  a = numberUnassigned(row, col)
  /*
   * si todas las celdas están asignadas, el sudoku ya está resuelto
   * pasar por referencia porque number_unassigned cambiará los valores de row y
   * col */
  if (a[0] == 0) return true
  // número entre 1 y 9
  row = a[1]
  col = a[2]
  for (let i = 1; i <= SIZE; i++) {
    // si podemos asignar i a la celda o no
    // la celda es matriz [fila] [col]
    if (isSafe(i, row, col)) {
      matrix[row][col] = i
      // retroceder
      if (solveSudoku()) return true
      // si no podemos continuar con esta solución
      // reasignar la matriz de celda
      matrix[row][col] = 0
    }
  }
  return false
}

/** Verificar que los números sean correctos */
function isFine() {
  for (let i = 0; i < SIZE; i++)
    for (let j = 0; j < SIZE; j++)
      if (!isSafe(matrix[i][j], i, j)) return false
  return true
}

function verificar() {
  console.log("\n")
  if (isFine()) {
    console.log("\nSolución:\n")
    imprimirMatriz()
    console.log("\nSe ha solucionado el sudoku")
  } else console.log("El sudoku no tiene solución")
}

function mensajeInicial() {
  // imprimir matriz inicial
  console.log("\nSudoku a resolver:\n")
  imprimirMatriz()
}

function imprimirMatriz() {
  for (let i = 0; i < SIZE; i++) {
    let palabra = ""
    for (let j = 0; j < SIZE; j++)
      if (j == 2 || j == 5) palabra += matrix[i][j] + " | "
      else palabra += matrix[i][j] + "   "
    console.log(palabra)
    if (i == 2 || i == 5) console.log("---------------------------------")
    //console.log("\n")
  }
}

function setMatriz(numMatriz) {
  let matAux = null
  if (numMatriz == 1) matAux = SUDOKU1
  else if (numMatriz == 2) matAux = SUDOKU2
  else if (numMatriz == 3) matAux = SUDOKU3
  //console.log(JSON.stringify(matAux))

  for (let i = 0; i < 9; i++)
    for (let j = 0; j < 9; j++) matrix[i][j] = matAux[i][j]
}

function main() {
  //long time_start, time_end

  //java sudokuSolver = new java()
  setMatriz(2)
  mensajeInicial()

  //time_start = System.currentTimeMillis()

  solveSudoku()

  //time_end = System.currentTimeMillis()
  //System.out.println("the task has taken " + (time_end - time_start) + " milliseconds")

  verificar()
}
main()
