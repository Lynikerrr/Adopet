package br.com.alura.domain;

public class Pet {

    public Pet(){

    }

    public Pet(String tipo, String nome, String raca, int idade2, String cor, Float peso2){
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.idade = idade2;
        this.cor = cor;
        this.peso = peso2;

    }

    private long id;
    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private float peso;

    public String getCor() {
        return cor;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    public float getPeso() {
        return peso;
    }public String getRaca() {
        return raca;
    }public String getTipo() {
        return tipo;
    }
    public long getId() {
        return id;
    }
}
