package br.com.etecia.nutriapp.classes;

import java.util.Date;

public class Produto  {
    private String nome ;
    private int codProd;
    private double preco, quantidade, multiplicador, quantEstoque;
    private int validade, dataEntrada;

   public Produto(String nome,  double preco, double quantidade, int codProd, double multiplicador, double quantEstoque, int validade, int dataEntrada) {
       this.nome = nome;
      this.preco = preco;
       this.quantidade = quantidade;
      this.codProd = codProd;

        
        this.multiplicador = multiplicador;
      this.quantEstoque = quantEstoque;
        this.validade = validade;
        this.dataEntrada = dataEntrada;
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

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {this.validade = validade;}

    public int getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(int dataEntrada) {this.dataEntrada = dataEntrada;}
}