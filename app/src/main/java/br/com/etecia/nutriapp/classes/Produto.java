package br.com.etecia.nutriapp.classes;

import java.util.Date;

public class Produto {
    private String nome, descricao;
    private int codProd;
    private double preco, quantidade, multiplicador, quantEstoque;
    private String validade, dataEntrada;


    public Produto(String nome, double preco, double quantidade, double multiplicador, double quantEstoque, String validade, String dataEntrada, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.multiplicador = multiplicador;
        this.quantEstoque = quantEstoque;
        this.validade = validade;
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
    }

    public Produto(String nome, double preco, double quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(double quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
}