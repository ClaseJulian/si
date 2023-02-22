package examen;

import java.util.Scanner;

public class Examen {

    public static int pedirFilas(int filas, Scanner sc) {
        do {
            System.out.print("Filas: ");
            filas = sc.nextInt();
        } while ((filas < 4) || (filas > 8));

        return filas;
    }

    public static int pedirColumnas(int col, Scanner sc) {
        do {
            System.out.print("Columnas: ");
            col = sc.nextInt();
        } while ((col < 4) || (col > 8));

        return col;
    }

    public static char[][] rellenarTablero(char[][] tablero, int filas, int col) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                tablero[i][j] = 'X';
            }
        }
        return tablero;
    }

    public static void mostrarTablero(char[][] tablero, int filas, int col) {
        int numeros = 1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < col; i++) {
            System.out.print(numeros + " ");
            numeros++;
        }
    }

    public static void insertarFichaEnColumna(char[][] tablero, int filas, int jugador, Scanner sc, int col) {
        int columnaSeleccionada, fila = filas - 1, columnas = col - 1, colocado = 0;

        System.out.print("Selecciona una columna: ");
        columnaSeleccionada = sc.nextInt();
        columnaSeleccionada--;

        while (colocado == 0 && fila > -1) {
            if (fila > -1) {
                if (colocado == 0) {
                    if (tablero[fila][columnaSeleccionada] == 'X' && jugador == 1) {
                        tablero[fila][columnaSeleccionada] = 'R';
                        colocado++;
                    }

                    if (tablero[fila][columnaSeleccionada] == 'X' && jugador == 2) {
                        tablero[fila][columnaSeleccionada] = 'A';
                        colocado++;
                    }
                    fila--;
                }
            }
        }
        if (colocado == 0) {
            System.out.println("No cabe, pasa turno");
            System.out.println("");
        }

        /*  if (colocado == 1) {
            fila++;

            if (jugador == 1) {

                //Ariiba derecha
                if (tablero[fila - 1][columnaSeleccionada + 1] == 'A') {
                    tablero[fila - 1][columnaSeleccionada + 1] = 'R';
                }
                // Medio derecha
                if (tablero[fila][columnaSeleccionada + 1] == 'A') {
                    tablero[fila - 1][columnaSeleccionada + 1] = 'R';
                }

                //Abajo derecha
                if (tablero[fila + 1][columnaSeleccionada + 1] == 'A') {
                    tablero[fila + 1][columnaSeleccionada + 1] = 'R';
                }

                //Abajo Medio
                if (tablero[fila + 1][columnaSeleccionada] == 'A') {
                    tablero[fila + 1][columnaSeleccionada] = 'R';
                }

                //Abajo Izquierda
                if (tablero[fila + 1][columnaSeleccionada - 1] == 'A') {
                    tablero[fila + 1][columnaSeleccionada - 1] = 'R';
                }

                //Medio izquierda
                if (tablero[fila][columnaSeleccionada - 1] == 'A') {
                    tablero[fila][columnaSeleccionada - 1] = 'R';
                }

                //Arriba izquierda
                if (tablero[fila - 1][columnaSeleccionada - 1] == 'A') {
                    tablero[fila - 1][columnaSeleccionada - 1] = 'R';
                }
                if (jugador == 2) {
                    //Ariiba derecha Azules
                    if (tablero[fila - 1][columnaSeleccionada + 1] == 'R') {
                        tablero[fila - 1][columnaSeleccionada + 1] = 'A';
                    }
                    // Medio derecha
                    if (tablero[fila][columnaSeleccionada + 1] == 'R') {
                        tablero[fila - 1][columnaSeleccionada + 1] = 'A';
                    }

                    //Abajo derecha
                    if (tablero[fila + 1][columnaSeleccionada + 1] == 'R') {
                        tablero[fila + 1][columnaSeleccionada + 1] = 'A';
                    }

                    //Abajo Medio
                    if (tablero[fila + 1][columnaSeleccionada] == 'R') {
                        tablero[fila + 1][columnaSeleccionada] = 'A';
                    }

                    //Abajo Izquierda
                    if (tablero[fila + 1][columnaSeleccionada - 1] == 'R') {
                        tablero[fila + 1][columnaSeleccionada - 1] = 'A';
                    }

                    //Medio izquierda
                    if (tablero[fila][columnaSeleccionada - 1] == 'R') {
                        tablero[fila][columnaSeleccionada - 1] = 'A';
                    }

                    //Arriba izquierda
                    if (tablero[fila - 1][columnaSeleccionada - 1] == 'R') {
                        tablero[fila - 1][columnaSeleccionada - 1] = 'A';
                    }
                }
            }
        }*/
    }

    public static void contadorFichas(char[][] tablero, int filas, int col) {
        int rojas = 0, azules = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                if (tablero[i][j] == 'R') {
                    rojas++;
                }
                if (tablero[i][j] == 'A') {
                    azules++;
                }
            }
        }
        System.out.println("Hay " + rojas + " fichas rojas y " + azules + " fichas azules.");
    }

    public static boolean finJuego(char[][] tablero, int filas, int col) {
        boolean fin = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                if (tablero[i][j] == 'X') {
                    fin = false;
                }
            }
        }

        return fin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int filas = 0, col = 0, jugador = 1;

        System.out.println("Elige las dimensiones de tablero entre 4x4 y 8x8: ");
        filas = pedirFilas(filas, sc);
        col = pedirColumnas(col, sc);
        System.out.println("");

        char[][] tablero = new char[filas][col];

        tablero = rellenarTablero(tablero, filas, col);
        mostrarTablero(tablero, filas, col);
        System.out.println("");

        do {
            System.out.println("");
            System.out.print("Coloca el jugador: ");
            if (jugador == 1) {
                System.out.println("ROJO");
            } else {
                System.out.println("AZUL");
            }

            insertarFichaEnColumna(tablero, filas, jugador, sc, col);
            mostrarTablero(tablero, filas, col);
            System.out.println("");
            contadorFichas(tablero, filas, col);

            if (jugador == 1) {
                jugador++;
            } else {
                jugador--;
            }

        } while (!finJuego(tablero, filas, col));
    }
}
