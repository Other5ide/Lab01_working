import java.util.Scanner;

public class Matriz {

    public static double[][] matriz;
    public static int m_dimension;
    public static int n_dimension;
    public static Scanner scanner = new Scanner(System.in);
    public static int filaParaRevisar;

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int opcion;

        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);

        } while (opcion != 6);
    }

    public static void mostrarOpciones() {
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Crear matriz");
        System.out.println("2. Llenar matriz");
        System.out.println("3. Imprimir matriz");
        System.out.println("4. Revisar fila");
        System.out.println("5. Revisar si es matriz cero");
        System.out.println("6. Salir");
    }

    public static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {
                solicitarDimensionM();
                solicitarDimensionN();
                if (validarDimensiones()) {
                    crearMatriz(m_dimension, n_dimension);
                } else {
                    System.out.println("Las dimensiones son incorrectas");
                }
            }
            case 2 -> llenarMatriz(matriz);
            case 3 -> imprimirMatriz(matriz);
            case 4 -> {
                mostrarFila(matriz,filaParaRevisar);
            }
            case 5 -> matrizCero(matriz);
            case 6 -> {
                System.out.println("Se ha finalizado el programa.");
                scanner.close();
            }
            default -> System.out.println("Opcion invalida.");
        }
    }

    public static void solicitarDimensionM() {
        try {
            System.out.println("Ingrese la dimension m de la matriz: ");
            m_dimension = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Dimension invalida");
        }
    }

    public static void solicitarDimensionN() {
        try {
            System.out.println("Ingrese la dimension m de la matriz: ");
            n_dimension = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Dimension invalida");
        }
    }


    public static void crearMatriz(int m_dimension, int n_dimension) {
        matriz = new double[m_dimension][m_dimension];
    }

    public static boolean validarDimensiones() {
        if (m_dimension > 0 && n_dimension > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void llenarMatriz(double[][] matriz) {
        if (validarDimensiones()) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    double random = Math.round((Math.random() * 10));
                    if (random == 10) {
                        random = 9;
                    }
                    matriz[i][j] = random;
                }

            }
        } else {
            System.out.println("Las dimensiones de la matriz son incorrectas");
        }
    }

    public static void imprimirMatriz(double[][] matriz) {
        if (validarDimensiones()) {
            System.out.println("Matriz: ");
            for (double[] doubles : matriz) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(doubles[j] + "\t");
                }
                System.out.println();
            }

        } else {
            System.out.println("Las dimensiones de la matriz son incorrectas");
        }

    }

    public static void mostrarFila(double[][] matriz, int numeroFila) {
        solicitarNumeroFila();
        System.out.println("Fila " + numeroFila + " : ");
        try {
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[numeroFila][i] + " ");
            }
        } catch (Exception e) {
            System.out.println("La matriz no tiene una fila " + numeroFila);
        }
    }
    public static void solicitarNumeroFila() {
        try {
            System.out.println("Ingrese el numero de fila: ");
            int fila = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Fila invalida");
        }
    }

    public static void matrizCero(double[][] matriz) {
        if (validarDimensiones()) {
            int contadorCeros = 0;
            int casillasTotales = 0;
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        casillasTotales++;
                        if (matriz[i][j] == 0) {
                            contadorCeros++;
                        }
                }
                }
                if (contadorCeros*100 > casillasTotales*50) {
                    System.out.println("La matriz es una Matriz tipo Cero");
                } else {
                    System.out.println("La matriz no es una Matriz tipo Cero");
                }
            } else {
            System.out.println("Las dimensiones de la matriz son incorrectas o no se ha creado");
        }

    }
}



