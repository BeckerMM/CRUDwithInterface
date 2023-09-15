package interacao;
import banco.BancoPessoa;
import classes.Pessoa.*;
import java.util.ArrayList;
public class InteracaoPessoa implements IInteracao<Integer,Pessoa>{
private static Interacao interacao = new Interacao();
private static BancoPessoa bancoPessoa = new BancoPessoa();
    @Override
    public Pessoa create() {
        return bancoPessoa.create(cadastro());
    }
    @Override
    public Pessoa cadastro() {
        ArrayList<String> listaDeValores = getValoresComum();
        String nome = listaDeValores.get(0);
        int idade = Integer.parseInt(listaDeValores.get(1));
        double peso = Double.parseDouble(listaDeValores.get(2));
        switch (escolhaEspecifica()) {
            case 1 -> {
                double saldo = interacao.printDouble("Informe o saldo: ");
                return (new Cliente(nome, idade, peso, saldo, 0));
            }
            case 2 -> {
                String disciplina = interacao.printString("Informe a disciplina: ");
                int qtdTurmas =interacao.printInt("Informe a quantidade de turmas: ");
                return (new Professor(nome, idade, peso, disciplina, qtdTurmas));
            }
            case 3 -> {
                return (new Vendedor(nome, idade, peso, interacao.printInt("Informe a qunatidade de vendas:"), interacao.printDouble("Informe a taxa de comissão: ")));
            }default -> System.out.println("Valor Inválido!");
        }
        return null;
    }

    @Override
    public void update(Integer id) {
        bancoPessoa.update(id, cadastro());
    }

    @Override
    public boolean remove(Integer id) {
        if (bancoPessoa.remove(id)) {
            System.out.println("Pessoa foi removida!");
            return true;
        } else {
            System.out.println("Não encontrado!");
            return false;
        }
    }

    @Override
    public void readOne(Integer id) {
        System.out.println(bancoPessoa.readOne(id)!=null?
                bancoPessoa.readOne(id) : "Objeto não encontrado!");
    }

    @Override
    public void readAll() {
        System.out.println(bancoPessoa.readAll());
    }

    @Override
    public ArrayList<String> getValoresComum() {
        ArrayList<String> valores = new ArrayList<>();
        valores.add(interacao.printString("Informe o nome: "));
        valores.add(interacao.printString("Informe a idade: "));
        valores.add(interacao.printString("informe o peso: "));
        return valores;
    }
    private int  escolhaEspecifica(){
        int decisao = interacao.printInt("""
                        ===== Escolha Especifica =====
                        1- Cliente
                        2- Professor
                        3- Vendedor
                        """);
        return  decisao>0 && decisao<=3 ? decisao : 0 ;
    }
}
