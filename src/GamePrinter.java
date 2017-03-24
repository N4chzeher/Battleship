
import java.util.Scanner;

/**
 * Created by NACHZEHER on 23/03/2017.
 */
public class GamePrinter {

    private static Scanner scanner = new Scanner(System.in);

    public static String readPlayerName(int numberPlayer) {
        if (numberPlayer == 1) {
            System.out.println("Jugador 1 es tu turno de configurar la flota:");
            System.out.println("Escribe tu nombre:");
            return scanner.nextLine();
        } else if (numberPlayer == 2){
            System.out.println("Jugador 2 es tu turno de configurar la flota:");
            System.out.println("Escribe tu nombre:");
            return scanner.nextLine();
        } else {
            //TODO lanzar excepción
            return "ERROR";
        }
    }

    public static void printFleet(Jugador player) { System.out.println("Barcos de la flota " + player.getName() + ":" + player.getFlota()); }

    public static void printIntroduceX() { System.out.println("Introduce la coordenada x:"); }

    public static void printIntroduceY() { System.out.println("Introduce la coordenada y:"); }

    public static void printIntroduceShipName() { System.out.println("Escribe el nombre del barco:"); }

    public static void printIntroduceShipSource() { System.out.println("Introduce el origen de las coordenadas del barco:"); }

    public static void printIntroduceShipSize() { System.out.println("Que tamaño tendrá?"); }

    public static void printIntroduceShipOrientation() { System.out.println("Hacia que dirección? [1]NORTE [2]SUD [3]ESTE [4]OESTE"); }

    public static void printIsSunk(Barco ship) {
        System.out.println("Tocado y hundido!!");
        System.out.println("El barco " + ship.getIdB() + " ha sido hundido!");
    }

    public static void printWinner(Jugador j1, Jugador j2) {
        System.out.println("A " + j2.getName() + " no le quedan más barcos.");
        System.out.println("Gana " + j1.getName() + "!!!");
    }
    public static void printTurn(Jugador player) {
        System.out.println("Turno de " + player.getName() + ":");
        System.out.println("Introduce las coordenadas de tu ataque");
    }

    public static String printErrorTable() { return "Has superado el tamaño máximo del tablero."; }

    public static String printErrorSize() { return "El barco es demasiado grande. El tamaño máximo para los barcos es 5."; }

}
