/**
 * Created by NACHZEHER on 10/03/2017.
 */
public class Partida {

    public static final int MAX=20;

    private Jugador j1;
    private Jugador j2;


    public void run() {

        initJugador();

        while (!isOver()) {
            attack(j1, j2);

            if (isOver()) {
                break;
            }

            attack(j2, j1);
        }

        getGanador();
    }

    public void initJugador() {
//        Inicializa el jugador1 y construye su flota
        j1 = new Jugador(GamePrinter.readPlayerName(1));

//        Inicializa el jugador2 y construye su flota
        j2 = new Jugador(GamePrinter.readPlayerName(2));

}



    public boolean isOver() {

        if (j1.flotaUndida() || j2.flotaUndida()) {
            return true;
        } else {
            return false;
        }
    }


    public void getGanador() {

        if(j2.flotaUndida()) {
            GamePrinter.printWinner(j1, j2);
        }
        if ((j1.flotaUndida())){
            GamePrinter.printWinner(j2,j1);
    }}

    public void attack(Jugador j1, Jugador j2) {

        GamePrinter.printTurn(j1);
        j2.verifyAttack(j1.crearCordenadas());
    }

}

