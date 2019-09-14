package modelo;

public class Funcionario {

    private String nome;
    private int dependentes;
    private int horasTrabalhadas;
    private double salarioHora;

    public Funcionario(String nome, int dependentes, int horasTrabalhadas, double salarioHora) {
        this.nome = nome;
        this.dependentes = dependentes;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }

}
