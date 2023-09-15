package classes.Automovel;

public class Moto extends Automovel {

    private boolean guardaVolumes;
    private int pecasOriginais;


    public Moto(String modelo, String marca, String cor, boolean guardaVolumes, int pecasOriginais) {
        super(modelo, marca, cor);
        this.guardaVolumes = guardaVolumes;
        this.pecasOriginais = pecasOriginais;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "guardaVolumes=" + guardaVolumes +
                ", pecasOriginais=" + pecasOriginais +
                '}';
    }
}
