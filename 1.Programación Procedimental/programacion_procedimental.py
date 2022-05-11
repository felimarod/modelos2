"""
PARA TRIQUI
juega_triqui():
  - Turno de (x o): Ingresa la posición en que desea ubicar el signo
  - Verificar posicion por rango y por ocupación [ciclo]
  - Validar triqui(horizontal, vertical, diagonal)
  - Verificar ocupación de celdas(Nadie gana)
(
Generar número secreto de 3 dígitos, cumpliendo con los requisitos
PARA PICAS Y FIJAS:
 - Iteración(
  1. Ingresa número y verifica
  2. Mira si tiene picas
  3. Mira si tiene fijas
    3.1 Verifica si todas     son fijas
    Si todas son fijas, gano, sino, imprime la cantidad de picas y fijas y se hace una nueva iteración
)
ADIVINA EL NÚMERO:
  1. Función para verificar número - Si es mayor o menor y se llama a si mismo
)
"""

import random


def generar_numero_secreto():
    global numero_secreto
    lista = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    numeros_secretos = random.sample(lista, 3)
    numero_secreto = numeros_secretos[0] * 100
    numero_secreto += numeros_secretos[1] * 10
    numero_secreto += numeros_secretos[2]


def adivina_numero():
    numero_ingresado = int(input("Ingrese un número: "))
    if numero_ingresado > numero_secreto:
        print("El número secreto es menor")
        adivina_numero()
    elif numero_ingresado < numero_secreto:
        print("El número secreto es mayor")
        adivina_numero()
    else:
        print("\nDiste con el número secreto!!!\nFelicidades!!!\nGanaste!!!\n\n")
        jugar()


"""
Adivina el número
"""


def jugar_adivina_numero():
    generar_numero_secreto()
    adivina_numero()




def obtener_posicion(turno):
    print(f"Turno de: {turno}")
    posicion = int(input("\nIngrese el número de la posición elegida:\n"))
    if posicion == 7:
        fila = 0
        columna = 0
    elif posicion == 8:
        fila = 0
        columna = 1
    elif posicion == 9:
        fila = 0
        columna = 2
    elif posicion == 4:
        fila = 1
        columna = 0
    elif posicion == 5:
        fila = 1
        columna = 1
    elif posicion == 6:
        fila = 1
        columna = 2
    elif posicion == 1:
        fila = 2
        columna = 0
    elif posicion == 2:
        fila = 2
        columna = 1
    elif posicion == 3:
        fila = 2
        columna = 2
    else:
        print("No existe la posición\n")
        return obtener_posicion(turno)

    # Verificar que no este ocupado
    if tablero_triqui[fila][columna] == "":
        return (fila, columna)
    else:
        print("Ya esta ocupada la posición")
        return obtener_posicion(turno)


def hay_posiciones_libres():
    espacios = 0
    for fila in tablero_triqui:
        for posicion in fila:
            if posicion == "":
                espacios += 1
    if espacios > 0:
        return True
    else:
        return False


def gano(turno):
    for i in range(0, 3):
        if (
            tablero_triqui[i][0] == turno
            and tablero_triqui[i][1] == turno
            and tablero_triqui[i][2] == turno
        ):
            return True
        if (
            tablero_triqui[0][i] == turno
            and tablero_triqui[1][i] == turno
            and tablero_triqui[2][i] == turno
        ):
            return True
    if (
        tablero_triqui[0][0] == turno
        and tablero_triqui[1][1] == turno
        and tablero_triqui[2][2] == turno
    ):
        return True
    if (
        tablero_triqui[2][0] == turno
        and tablero_triqui[1][1] == turno
        and tablero_triqui[0][2] == turno
    ):
        return True
    return False


def imprimir_tablero():
    # Imprimir tablero
    for i in range(0, 3):
        print(
            f" {tablero_triqui[i][0]} | {tablero_triqui[i][1]} | {tablero_triqui[i][2]}"
        )
        if i != 2:
            print("-----------")



def turno_triqui(turno):
    if hay_posiciones_libres():

        # print(tablero_triqui)
        posicion = obtener_posicion(turno)
        tablero_triqui[posicion[0]][posicion[1]] = turno
        imprimir_tablero()
        if gano(turno):
            print(f"Gano la {turno}\n\n")
            jugar()
        else:
            if turno == "x":
                turno_triqui("o")
            elif turno == "o":
                turno_triqui("x")
    else:
        print("Nadie gano\n\n")
        jugar()

    # tablero_triqui[fila][columna] = turno
    pass


def jugar_triqui():
    """
    Triqui
    """
    global tablero_triqui
    tablero_triqui = [["", "", ""], ["", "", ""], ["", "", ""]]
    print("Posiciones:\n 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ")
    turno_triqui("x")


def jugar_picas_fijas():
    pass


def jugar():
    juego = int(
        input(
            "Ingresa el número correspondiente al juego que deseas:\n 1.\tAdivina el número\n 2.\tPicas y Fijas\n 3.\tTriqui\n 4.\tSalir\n"
        )
    )
    print("\n")
    if juego == 1:
        jugar_adivina_numero()
    elif juego == 2:
        jugar_picas_fijas()
    elif juego == 3:
        jugar_triqui()
    elif juego == 4:
        pass
    else:
        jugar()


if __name__ == "__main__":
    jugar()
