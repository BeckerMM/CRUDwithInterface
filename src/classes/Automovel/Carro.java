package classes.Automovel;

import java.util.ArrayList;

public class Carro extends Automovel {
    private int qtdPortas;
    private int numeroDePedais;

    public Carro(String modelo, String marca, String cor, int qtdPortas, int numeroDePedais) {
        super(modelo, marca, cor);
        this.qtdPortas = qtdPortas;
        this.numeroDePedais = numeroDePedais;

    }

    @Override
    public String toString() {
        return "Carro{" +
                "qtdPortas=" + qtdPortas +
                ", numeroDePedais=" + numeroDePedais +
                '}';
    }
}
