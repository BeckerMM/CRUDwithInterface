package banco;

import classes.Automovel.Automovel;

import java.util.ArrayList;

public class BancoAutomovel implements ICrud<Integer, Automovel> {

    private final ArrayList<Automovel> listAutomovel = new ArrayList<>();

    @Override
    public Automovel create(Automovel object) {
        if (listAutomovel.add(object)) {
            return object;
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        if (this.listAutomovel.get(id) != null) {
            this.listAutomovel.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Automovel update(Integer id, Automovel object) {
        if (this.listAutomovel.get(id) != null) {
            this.listAutomovel.set(id, object);
            return object;
        }
        return null;
    }

    @Override
    public Automovel readOne(Integer id) {
        if (this.listAutomovel.get(id)!=null){
            return this.listAutomovel.get(id);
        }
        return null;
    }

    @Override
    public ArrayList<Automovel> readAll() {
        return this.listAutomovel;
    }


}
