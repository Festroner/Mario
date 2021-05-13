package back;

import alerta.alerta;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class Diary {
    private ArrayList<alerta> picks = new ArrayList<>();  // Creación del array list
    private int num;

    public void create(alerta t){
       picks.add(t);
       num++;
    }

    public void delete(int p) {
        alerta pick = picks.get(p);
        bbdd.Conexion.BorrarBbdd(pick.getId());
        picks.remove(p);
        num--;
    }


    public ArrayList<alerta> getPicks() {
        return picks;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}

