package classes.Pessoa;

public class Professor extends Pessoa{

    private String disciplina;
    private int qtdTurmas;


    public Professor(String nome, int idade, double peso, String disciplina, int qtdTurmas) {
        super(nome, idade, peso);
        this.disciplina = disciplina;
        this.qtdTurmas = qtdTurmas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "disciplina='" + disciplina + '\'' +
                ", qtdTurmas=" + qtdTurmas +
                '}';
    }
}
