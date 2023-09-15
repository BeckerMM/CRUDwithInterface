package interacao;

import java.util.ArrayList;

public interface IInteracao <ID,T> {

    T create();
    T cadastro();
    void update(ID id);
    boolean remove(ID id);
    void readOne(ID id);
    void readAll();
    ArrayList<String> getValoresComum();
}
