package classes.Pessoa;

public class Cliente extends Pessoa {

    private double saldo;
    private int qtdCompras;

    public Cliente(String nome, int idade, double peso, double saldo, int qtdCompras) {
        super(nome, idade, peso);
        this.saldo = saldo;
        this.qtdCompras = qtdCompras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "saldo=" + saldo +
                ", qtdCompras=" + qtdCompras +
                '}';
    }
}
