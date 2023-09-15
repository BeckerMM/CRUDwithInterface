package classes.Pessoa;

public class Vendedor extends Pessoa {

    private int qtdVendas;
    private double taxaDeComissao;

    public Vendedor(String nome, int idade, double peso, int qtdVendas, double taxaDeComissao) {
        super(nome, idade, peso);
        this.qtdVendas = qtdVendas;
        this.taxaDeComissao = taxaDeComissao;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nome: " + getNome() +
                " idade: " + getIdade() +
                " peso: " + getPeso() +
                " qtdVendas=" + qtdVendas +
                " taxaDeComissao=" + taxaDeComissao +
                '}';
    }
}
