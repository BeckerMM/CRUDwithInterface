package banco;

import classes.Automovel.Automovel;

import java.util.ArrayList;

public interface ICrud<ID,T> {

    T create (T object);

    boolean remove(ID id);

    T update(ID id,T object);
    T readOne(ID id);

    ArrayList<T> readAll();


}

