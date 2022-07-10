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
import os
import time

def generar_numero_secreto():
    """
    Genera un número secreto el cual:
    - No tiene números repetidos
    - Es de 3 cifras
    """
    global numero_secreto
    lista = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    numeros_secretos = random.sample(lista, 3)
    numero_secreto = numeros_secretos[0] * 100 # Centenas
    numero_secreto += numeros_secretos[1] * 10 # Decenas
    numero_secreto += numeros_secretos[2]      # Unidades
    return numero_secreto


def adivina_numero (numero_secreto):
    """
    Verifica y compara si el número ingresado por el usuario es mayor, menor o igual al número generado en la
    función "generar_numero_secreto()"
    """
    numero_ingresado = int(input("Ingrese un número: "))
    if numero_ingresado > numero_secreto:
        print("El número secreto es menor")
        adivina_numero(numero_secreto)
    elif numero_ingresado < numero_secreto:
        print("El número secreto es mayor")
        adivina_numero(numero_secreto)
    else:
        print("\nDiste con el número secreto!!!\nFelicidades!!!\nGanaste!!!\n\n")
        jugar()


def jugar_adivina_numero():
    """
    Juego inicial de adivina el número, se genera el número secreto para luego
    comenzar a adivinar cuál es 
    """
    adivina_numero(generar_numero_secreto())


def obtener_posicion(turno):
    """
    Verifica las casillas por posición en forma de matriz 3*3
    """
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
    """
    Revisa si hay casillas disponibles para ocupar, de ser cierto le retorna verdadero de lo contrario retorna falso
    """
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
    """
    Comprueba si tres casillas han sido ocupadas, puede ser de manera vertical, horizontal o diagonal
    """
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
                limpiar_terminal()
                turno_triqui("o")
            elif turno == "o":
                limpiar_terminal()
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
    print("Posiciones:\n 7 | 8 | 9 \n-----------\n 4 | 5 | 6 \n-----------\n 1 | 2 | 3 ")
    turno_triqui("x")


def limpiar_terminal():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")


def generar_numero_secreto():
    """
    Genera un número secreto el cual:
    - No tiene números repetidos
    - Es de 3 cifras
    """
    global numeros_secretos
    lista = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    numeros_secretos = random.sample(lista, 3)
    numero_secreto = numeros_secretos[0] * 100
    numero_secreto += numeros_secretos[1] * 10
    numero_secreto += numeros_secretos[2]
    return numero_secreto


def mostrar_jugadas_anteriores():
    if len(registro) > 0:
        print("Número\tPicas\tFijas")
        for intento in registro:
            print(intento["Numero"], "\t", intento["Picas"], "\t", intento["Fijas"], "\n")


def ingresar_numero():
    global str_numero
    str_numero = input("Digita un número de 3 cifras: ")

    if str_numero.isnumeric():  # Verifica que sea un número
        num = int(str_numero)
        if num < 100 or num > 999:
            print("Error, ingrese un número entre 100 y 999\n")
            time.sleep(2)
            return ingresar_numero()
        lista = [int(str_numero[0]), int(str_numero[1]), int(str_numero[2])]
        for i in lista:
            if lista.count(i) >= 2:
                print("Error, los 3 números deben ser diferentes\n")
                time.sleep(2)
                return ingresar_numero()
        return num
    else:
        print("Error, ingrese un número\n")
        time.sleep(2)
        return ingresar_numero()

def jugar_picas_fijas():
    num = 0
    num_fijas = 0
    num_picas = 0
    global registro
    registro = []

    # Mensaje pantalla principal
    limpiar_terminal()
    print("-----------------------------")
    print("Vamos a jugar Picas & Fijas!!!")
    print("-----------------------------")
    time.sleep(2)

    numero_secreto = generar_numero_secreto()

    while num != numero_secreto:
        num_fijas = 0
        num_picas = 0
        limpiar_terminal()
        mostrar_jugadas_anteriores()
        num = ingresar_numero()
        for i in range(0, 3):
            if numeros_secretos.count(int(str_numero[i])) == 1:
                if int(str_numero[i]) == numeros_secretos[i]:
                    num_fijas += 1
                else:
                    num_picas += 1
        if num != numero_secreto:
            dic = {"Numero": num, "Picas": num_picas, "Fijas": num_fijas}
            registro.append(dic)

    limpiar_terminal()
    print("-----------------------------")
    mostrar_jugadas_anteriores()
    print(f"Felicidades!!! Lo encontraste!!!\nGanaste en {1 + len(registro)} intentos\nEl número era: {numero_secreto}")
    print("-----------------------------")
    jugar()




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
        print("Ingrese un valor valido\n")
        jugar()


if __name__ == "__main__":
    jugar()
