package model;

public class Produto {
	private int id;
    private int idrestaurante;
    private String nome;
    private String descricao;
    private Double preco;
    
    //Getters e Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public int getIdRestaurante() {return idrestaurante;}
    public void setIdRestaurante(int idrestaurante) {this.idrestaurante = idrestaurante;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao()  {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}

}