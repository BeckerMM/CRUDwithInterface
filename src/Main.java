import interacao.InteracaoAutomovel;
import interacao.InteracaoPessoa;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final InteracaoPessoa interacaoPessoa = new InteracaoPessoa();
    private static final InteracaoAutomovel interacaoAutomovel = new InteracaoAutomovel();
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
    private static void readAll() {
        int decisao = escolha();
        switch (decisao) {
            case 1 -> interacaoPessoa.readAll();
            case 2 -> interacaoAutomovel.readAll();
            default -> System.out.println("Valor Inválido!");
        }
    }
    private static void readOne() {
        int decisao = escolha();
        System.out.println("Digite o id:");
        int id = sc.nextInt();
        switch (decisao) {
            case 1 ->interacaoPessoa.readOne(id);
            case 2 -> interacaoAutomovel.readOne(id);
            default -> System.out.println("Valor Inválido!");
        }
    }
    private static void update() {
        int decisao = escolha();
        System.out.println("informe o id");
        switch (decisao){
            case 1-> interacaoPessoa.update(sc.nextInt());
            case 2-> interacaoAutomovel.update(sc.nextInt());
            default -> System.out.println("Valor Inválido!");
        }
    }

    private static Object create( ) {
        int decisao = escolha();
        switch (decisao){
            case 1->{
              return interacaoPessoa.create();
                }
            case 2->{
            return interacaoAutomovel.create();
            }default -> System.out.println("Valor Inválido!");
        }
        return null;
    }
    private static void remove() {
        int decisao = escolha();
        System.out.println("Informe o id:");
        int id = sc.nextInt();
        switch (decisao) {
            case 1 -> {
                if (interacaoPessoa.remove(id)) {
                    System.out.println("Pessoa foi removida!");
                } else {
                    System.out.println("Não encontrado!");
                }
            }
            case 2 -> {
                if (interacaoAutomovel.remove(id)) {
                    System.out.println("Automovél removido!");
                } else {
                    System.out.println("Não encontrado!");
                }
            }default -> System.out.println("Valor Inválido!");
        }
    }
}