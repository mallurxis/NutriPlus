package br.com.etecia.nutriapp.classes;

import java.util.Date;

public class Produto  {
    private String nome ;
    private int codProd;
    private double preco, quantidade, multiplicador;
    private Date validade, dataEntrada;

    public Produto(String nome, int codProd, double preco, double quantidade, double multiplicador, Date validade, Date dataEntrada) {
        this.nome = nome;
        this.codProd = codProd;
        this.preco = preco;
        this.quantidade = quantidade;
        this.multiplicador = multiplicador;
        this.validade = validade;
        this.dataEntrada = dataEntrada;
    }

    public Produto(int id, String nome, double quantidade, double preco, double multiplicador, double quantEstoque, String desc, String dataEntrada, String validade) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}