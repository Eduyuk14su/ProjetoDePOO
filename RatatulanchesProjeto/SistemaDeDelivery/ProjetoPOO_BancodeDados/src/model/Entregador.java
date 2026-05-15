package model;

public class Entregador {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String veiculo;

    
    //Getters e Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getVeiculo() {return veiculo;}
    public void setVeiculo(String veiculo) {this.veiculo = veiculo;}
}

