package br.com.etecia.nutriapp.classes;

public class Semana {
    private String nomeSemana;
    private String dataSemana;

    // Construtor
    public Semana(String nomeSemana, String dataSemana) {
        this.nomeSemana = nomeSemana;
        this.dataSemana = dataSemana;
    }

    // Getters e Setters
    public String getNomeSemana() {
        return nomeSemana;
    }

    public void setNomeSemana(String nomeSemana) {
        this.nomeSemana = nomeSemana;
    }

    public String getDataSemana() {
        return dataSemana;
    }

    public void setDataSemana(String dataSemana) {
        this.dataSemana = dataSemana;
    }

}
