"""
PICAS & FIJAS
"""
import random
import os
import time


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

if __name__ == '__main__':
    jugar_picas_fijas()
