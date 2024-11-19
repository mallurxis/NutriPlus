package br.com.etecia.nutriapp.classes;

public class HistoricoPrato {

    private String pratoHistorico;
    private String ingredienteHistorico;
    private double precoHistorico;


    public HistoricoPrato(String pratoHistorico, String ingredienteHistorico, double precoHistorico) {
        this.pratoHistorico = pratoHistorico;
        this.ingredienteHistorico = ingredienteHistorico;
        this.precoHistorico = precoHistorico;
    }

    public String getPratoHistorico() {
        return pratoHistorico;
    }

    public void setPratoHistorico(String pratoHistorico) {
        this.pratoHistorico = pratoHistorico;
    }

    public String getIngredienteHistorico() {
        return ingredienteHistorico;
    }

    public void setIngredienteHistorico(String ingredienteHistorico) {
        this.ingredienteHistorico = ingredienteHistorico;
    }

    public double getPrecoHistorico() {
        return precoHistorico;
    }

    public void setPrecoHistorico(double precoHistorico) {
        this.precoHistorico = precoHistorico;
    }
}
