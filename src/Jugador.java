import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by NACHZEHER on 10/03/2017.
 */
public class Jugador {

    private Scanner scanner =new Scanner(System.in);
    private String name;
    private static Integer ids =0;
    private Integer id;
    private List<Barco> flota = new ArrayList<>(5);

    public Jugador(String name){

        this.name=name;
        id=++ids;
        createFleet();
    }



    public String getName() {
        return name;
    }

    public void createFleet() {

        int barcos = 1;

        while (barcos <= 5) {

            Barco barco = construirBarco(barcos);

            flota.add(barco);

            barcos++;
        }
    }

    public boolean flotaUndida(){

        for (Barco barco: flota
             ) {
            if(!barco.barcoUndido()){
                return false;
            }
        }
        return true;

    }

    public Punto crearCordenadas(){

        System.out.println("X");
        int x = scanner.nextInt();
        System.out.println("Y:");
        int y = scanner.nextInt();

        Punto cordenadas = new Punto(x, y);

        return cordenadas;
    }

    private Barco construirBarco(int barcos) {

        System.out.println("***CREAR BARCOS*** \nBarco "+barcos+" Coordenadas");

        Punto pSource = crearCordenadas();

        int size=0;
        switch (barcos) {

            case 1:
                size = 5;
            case 2:
                size = 4;
            case 3:
                size = 3;
            case 4:
                size = 3;
            case 5:
                size = 2;

        }

        System.out.println("Orientacion");

        int o = scanner.nextInt();

        Orientation orientation = Orientation.values()[o - 1];

        return new Barco(pSource, size, orientation);
    }

    public List<Barco> getFlota() {
        return flota;
    }


    public boolean verifyAttack(Punto p) {
        for (Barco ship : flota) {
            if(ship.recibeAtaque(p)){
                return true;
            }
        }
        System.out.println("Agua...");
        return false;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
