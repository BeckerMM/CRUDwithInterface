package interacao;
import banco.*;
import classes.Automovel.*;
import java.util.ArrayList;

public class InteracaoAutomovel implements IInteracao<Integer, Automovel> {
    private static Interacao interacao = new Interacao();
    private static BancoAutomovel bancoAutomovel = new BancoAutomovel();
    private int escolhaEspecifica() {
        int decisao = interacao.printInt("""
                ===== Escolha Especifica =====
                1- Carro
                2- Moto
                3- Bicleta
                """);
        return decisao > 0 && decisao <= 3 ? decisao : 0;
    }
    @Override
    public Automovel create() {
       return bancoAutomovel.create(cadastro());
    }
    @Override
    public Automovel cadastro() {
        ArrayList<String> listaDeValores = getValoresComum();
        String modelo = listaDeValores.get(0);
        String marca = listaDeValores.get(1);
        String cor = listaDeValores.get(2);
        switch (escolhaEspecifica()) {
            case 1 -> {
                int qtdPortas = interacao.printInt("Informe a quantidade de portas: ");
                int numeroDePedais = interacao.printInt("Informe a quantidade de pedais: ");
                return (new Carro(modelo, marca, cor, qtdPortas, numeroDePedais));
            }
            case 2 -> {
                boolean guardaVolume;
                if (interacao.printString("Possui guarda volumes").equals("sim")) {
                    guardaVolume = true;
                } else {
                    guardaVolume = false;
                }
                int qtdPecasOriginais = interacao.printInt("Informe quantas peças são originais: ");
                return (new Moto(modelo, marca, cor, guardaVolume, qtdPecasOriginais));
            }
            case 3 -> {
                int numeroDoAro = interacao.printInt("Informe o número do aro: ");
                int numeroDoQuadro = interacao.printInt("Informe o número do quadro: ");
                return (new Bicicleta(modelo, marca, cor, numeroDoAro, numeroDoQuadro));
            }
            default -> System.out.println("Valor Inválido!");
        }
        return null;
    }
    @Override
    public void update(Integer id) {
        bancoAutomovel.update(id, cadastro());
    }
    @Override
    public boolean remove(Integer id) {
        if (bancoAutomovel.remove(id)) {
            System.out.println("Pessoa foi removida!");
            return true;
        } else {
            System.out.println("Não encontrado!");
            return false;
        }
    }
    @Override
    public void readOne(Integer id) {
        System.out.println(bancoAutomovel.readOne(id) !=null? bancoAutomovel.readOne(id) : "Não encontrado!");
    }
    @Override
    public void readAll() {
        System.out.println(bancoAutomovel.readAll());
    }
    @Override
    public ArrayList<String> getValoresComum() {
        ArrayList<String> valores = new ArrayList<>();
        valores.add(interacao.printString("Informe o modelo: "));
        valores.add( interacao.printString("Informe a marca: "));
        valores.add(interacao.printString("informe o cor: "));
        return valores;
    }
}
