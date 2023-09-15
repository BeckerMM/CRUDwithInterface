package banco;

import classes.Pessoa.Pessoa;

import java.util.ArrayList;

public class BancoPessoa implements ICrud<Integer, Pessoa> {

    private final ArrayList<Pessoa> listPessoa = new ArrayList<>();
    @Override
    public Pessoa create(Pessoa object) {
        if (this.listPessoa.add(object)){
            return object;
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        if(this.listPessoa.get(id)!= null && listPessoa.size()>0){
            this.listPessoa.remove(id.intValue());
        }
        return false;
    }

    @Override
    public Pessoa update(Integer id, Pessoa object) {
        if (this.listPessoa.get(id)!=null){
            System.out.println("foi'");
            this.listPessoa.set(id,object);
        }
        return null;
    }

    @Override
    public Pessoa readOne(Integer id) {
        if (this.listPessoa.get(id)!=null){
            return this.listPessoa.get(id);
        }
        return null;
    }

    @Override
    public ArrayList<Pessoa> readAll() {
        return this.listPessoa;
    }
}
