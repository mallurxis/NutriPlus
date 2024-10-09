package br.com.etecia.nutriapp.classes;

public class Prato {
    private String nomePrato;
    private double precoPrato;

    public Prato(String nomePrato, double precoPrato) {
        this.nomePrato = nomePrato;
        this.precoPrato = precoPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public double getPrecoPrato() {
        return precoPrato;
    }

    public void setNomePrato(String nome) {
        this.nomePrato = nomePrato;
    }

    public void setPrecoPrato(double precoPrato) {
        this.precoPrato = precoPrato;
    }
}
