import java.util.Scanner;

public class Matriz {

    public static double[][] matriz;
    public static int m_dimension;
    public static int n_dimension;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solicitarDimensionM();
        solicitarDimensionN();
        crearMatriz(m_dimension, n_dimension);
        imprimirMatriz(matriz);
        llenarMatriz(matriz);
        imprimirMatriz(matriz);
    }

    public static void menu() {
        int opcion;

        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);

        } while (opcion != 5);
    }

    public static void mostrarOpciones() {
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Crear matriz");
        System.out.println("2. Restar matrices");
        System.out.println("3. Multiplicar matrices");
        System.out.println("4. Dividir matrices");
        System.out.println("5. Salir");
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
            case 1 -> System.out.println("A");
            case 2 -> System.out.println("A");
            case 3 -> System.out.println("A");
            case 4 -> System.out.println("A");
            case 5 -> {
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
            return;
        }
    }

    public static void solicitarDimensionN() {
        try {
            System.out.println("Ingrese la dimension m de la matriz: ");
            n_dimension = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return;
        }
    }


    public static void crearMatriz(int m_dimension, int n_dimension) {
        matriz = new double[m_dimension][m_dimension];
    }

    public static boolean validarDimensiones(double[][] matriz) {
        if (m_dimension > 0 && n_dimension > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void llenarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                double random = Math.random()*10;
                matriz[i][j] = random;
                }

            }
        }

    public static void imprimirMatriz(double[][] matriz) {
        for (double[] doubles : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(doubles[j] + "\t");
            }
            System.out.println();
        }
    }
    }

