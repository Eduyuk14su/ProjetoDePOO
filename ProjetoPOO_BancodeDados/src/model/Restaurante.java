package model;

public class Restaurante {

    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cnpj;
    private String categoria_culinaria;

    // ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID inválido!");
        }
    }

    // NOME
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome != null && nome.length() <= 100) {
            this.nome = nome;
        } else {
            System.out.println("Nome inválido!");
        }
    }

    // TELEFONE
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (telefone.matches("\\d{11}")) {
            this.telefone = telefone;
        } else {
            System.out.println("Telefone inválido!");
        }
    }

    // ENDEREÇO
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        if (endereco != null && endereco.length() <= 150) {
            this.endereco = endereco;
        } else {
            System.out.println("Endereço inválido!");
        }
    }

    // CNPJ
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        if (cnpj.matches("\\d{14}")) {
            this.cnpj = cnpj;
        } else {
            System.out.println("CNPJ inválido!");
        }
    }

    // CATEGORIA CULINÁRIA
    public String getCategoriaCulinaria() {
        return categoria_culinaria;
    }
    public void setCategoriaCulinaria(String categoria_culinaria) {
        if (categoria_culinaria != null &&
            categoria_culinaria.length() <= 50) {
            this.categoria_culinaria = categoria_culinaria;
        } else {
            System.out.println("Categoria culinária inválida!");
        }
    }
}