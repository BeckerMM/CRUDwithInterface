package classes.Automovel;

public class Bicicleta extends Automovel{

    private int numeroDoAro;
    private int numeroDoQuadro;

    public Bicicleta(String modelo, String marca, String cor, int numeroDoAro, int numeroDoQuadro) {
        super(modelo, marca, cor);
        this.numeroDoAro = numeroDoAro;
        this.numeroDoQuadro = numeroDoQuadro;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "numeroDoAro=" + numeroDoAro +
                ", numeroDoQuadro=" + numeroDoQuadro +
                '}';
    }
}
