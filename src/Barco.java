
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NACHZEHER on 10/03/2017.
 */
public class Barco {

    private static Integer idsB =0;
    private Integer idB;
    private List<Punto> puntos = new ArrayList<>();
    private List<Boolean> hits = new ArrayList<>();

    public Barco (Punto source, int size, Orientation orientation){

        idB=++idsB;

        for (int i = 0; i < size ; i++) {
            hits.add(false);
        }

        puntos.add(source);

        switch(orientation){

            case NORTH:
                for (int i = 0; i < size; i++) {
                    Punto pAnterior= puntos.get(puntos.size()-1);
                    Punto pNuevo=new Punto(source.getX(), pAnterior.getY() +1 );
                    puntos.add(pNuevo);

                }

            case SOUTH:
                for (int i = 0; i < size; i++) {
                    Punto pAnterior= puntos.get(puntos.size()-1);
                    Punto pNuevo=new Punto(source.getX(), pAnterior.getY() -1 );
                    puntos.add(pNuevo);
                }

            case EAST:
                for (int i = 0; i < size; i++) {
                    Punto pAnterior= puntos.get(puntos.size()-1);
                    Punto pNuevo=new Punto(source.getY(), pAnterior.getX() +1 );
                    puntos.add(pNuevo);
                }

            case WEST:
                for (int i = 0; i < size; i++) {
                    Punto pAnterior= puntos.get(puntos.size()-1);
                    Punto pNuevo=new Punto(source.getY(), pAnterior.getX() -1 );
                    puntos.add(pNuevo);
                }
        }
    }

    public Integer getIdB() {
        return idB;
    }

    public boolean barcoUndido(){

        for (Boolean hit : hits
             ) {
            if(hit == false){
                return false;
            }
        }
        return true;
    }

    public boolean recibeAtaque(Punto p){

        for (int i = 0; i < puntos.size() ; i++) {
            if (puntos.get(i).equals(p)){
                hits.set(i,true);
                return true;
            }
        }
        return false;
    }
}
