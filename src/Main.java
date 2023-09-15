

import banco.*;
import classes.Pessoa.*;
import classes.Automovel.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final BancoAutomovel bancoAutomovel = new BancoAutomovel();
    private static final BancoPessoa bancoPessoa = new BancoPessoa();

    public static void main(String[] args) {

        do{
            menu();
        }while(true);
    }

    private static void menu() {
        System.out.println("""
                ===== Menu =====
                1- Create
                2- Update
                3- ReadOne
                4- ReadAll
                5- Remove
                """);
        int decisao = sc.nextInt();
        switch (decisao) {
            case 1 -> create();
            case 2 -> update();
            case 3 -> readOne();
            case 4 -> readAll();
            case 5 -> remove();

        }

    }

    public static int escolha() {
        System.out.println("""
                ===== Escolha =====
                1- Pessoa
                2- Automovel
                """);
        return sc.nextInt();
    }

    private static int escolhaEspecifica(int x) {
        System.out.println("===== Escolha Específica =====");
        switch (x) {
            case 1 -> {
                System.out.println("""
                        1- CLiente
                        2- Professor
                        3- Vendedor
                        """);
                return sc.nextInt();
            }case 2 ->{
                System.out.println("""
                        1- Carro
                        2- Moto
                        3- Bicicleta
                        """);
                return sc.nextInt();
            }
        }
        return 0;
    }

    private static void readAll() {
        int decisao = escolha();
        switch (decisao) {
            case 1 -> {
                System.out.println(bancoPessoa.readAll());
            }
            case 2 -> {
                System.out.println(bancoAutomovel.readAll());
            }
            default -> System.out.println("Valor Inválido!");
        }
    }


    private static void readOne() {
        int decisao = escolha();
        System.out.println("Digite o id:");
        int id = sc.nextInt();
        switch (decisao) {
            case 1 -> System.out.println(bancoPessoa.readOne(id)!=null? bancoPessoa.readOne(id): "Objeto não encontrado!");
            case 2 -> System.out.println(bancoAutomovel.readOne(id) !=null);
        }
    }

    private static void update() {
        int decisao = escolha();
        System.out.println("informe o id");
        switch (decisao){
            case 1-> bancoPessoa.update(sc.nextInt(), cadastroPessoa(decisao));
            case 2-> bancoAutomovel.update(sc.nextInt(),cadastroAtutomovel(decisao));
        }
    }

    private static Object  create( ) {
        int decisao = escolha();
        ArrayList<String> listaDeValores = new ArrayList<>();
        switch (decisao){
            case 1->{
              return cadastroPessoa(decisao);
                }
            case 2->{
            return cadastroAtutomovel(decisao);
            }
        }
        return null;
    }
    private static Pessoa cadastroPessoa (int decisao) {
        ArrayList<String> listaDeValores = getValoresComumPessoa();
        String nome = listaDeValores.get(0);
        int idade = Integer.parseInt(listaDeValores.get(1));
        double peso = Double.parseDouble(listaDeValores.get(2));
        switch (escolhaEspecifica(decisao)) {
            case 1 -> {

                System.out.println("Infome o saldo:");
                double saldo = sc.nextDouble();
                return bancoPessoa.create(new Cliente(nome, idade, peso, saldo, 0));
            }
            case 2 -> {
                System.out.println("Informe a disciplina: ");
                String disciplina = sc.next();
                System.out.println("Informe a quantidade de turmas: ");
                int qtdTurmas = sc.nextInt();
                return bancoPessoa.create(new Professor(nome, idade, peso, disciplina, qtdTurmas));
            }
            case 3 -> {
                System.out.println("Informe a quantidade de vendas: ");
                int qtdVendas = sc.nextInt();
                System.out.println("Informe a taxa de Comissão: ");
                double taxaDeComissao = sc.nextDouble();
                return bancoPessoa.create(new Vendedor(nome, idade, peso, qtdVendas, taxaDeComissao));
            }
        }
        return null;
    }
    private static Automovel cadastroAtutomovel(int decisao){
        ArrayList<String> listaDeValores = getValoresComumAutomovel();
        String modelo = listaDeValores.get(0);
        String marca = listaDeValores.get(1);
        String cor = listaDeValores.get(2);
        switch (escolhaEspecifica(decisao)){
            case 1 ->{
                System.out.println("Informe a quantidade de portas:");
                int qtdPortas = sc.nextInt();
                System.out.println("Informe o numero de pedais");
                int numeroDePedais = sc.nextInt();
                return bancoAutomovel.create(new Carro(modelo, marca,cor, qtdPortas,numeroDePedais));
            }case 2 ->{
                System.out.println("Possui guarda volume?");
                boolean guardaVolume;
                if (sc.next().equals("sim")){
                    guardaVolume = true;
                } else {
                    guardaVolume = false;
                }
                System.out.println("Informe quantas peças são originais:");
                int qtdPecasOriginais = sc.nextInt();
                return bancoAutomovel.create(new Moto(modelo,marca,cor,guardaVolume,qtdPecasOriginais));
            }case 3 ->{
                System.out.println("Informe o número do aro:");
                int numeroDoAro = sc.nextInt();
                System.out.println("Informe o número do quadro");
                int numeroDoQuadro = sc.nextInt();
                return bancoAutomovel.create(new Bicicleta(modelo,marca,cor,numeroDoAro,numeroDoQuadro));
            }
        }
        return null;
    }
    private static void remove() {
        int decisao = escolha();
        System.out.println("Informe o id:");
        int id = sc.nextInt();
        switch (decisao) {
            case 1 -> {
                if (bancoPessoa.remove(id)) {
                    System.out.println("Pessoa foi removida!");
                } else {
                    System.out.println("Não encontrado!");
                }
            }
            case 2 -> {
                if (bancoAutomovel.remove(id)) {
                    System.out.println("Automovél removido!");
                } else {
                    System.out.println("Não encontrado!");
                }
            }
        }
    }

    private static ArrayList<String> getValoresComumPessoa() {
        ArrayList<String> valores = new ArrayList<>();
        System.out.println("Infome o seu nome");
        valores.add(sc.next());
        System.out.println("Informe a idade:");
        valores.add( sc.next());
        System.out.println("informe o peso:");
        valores.add( sc.next());
        return valores;
    }

    private static ArrayList<String> getValoresComumAutomovel() {
        ArrayList<String> valores = new ArrayList<>();
        System.out.println("Infome o seu modelo");
        valores.add(sc.next());
        System.out.println("Informe a marca:");
        valores.add( sc.next());
        System.out.println("informe o cor:");
        valores.add( sc.next());
        return valores;
    }
}