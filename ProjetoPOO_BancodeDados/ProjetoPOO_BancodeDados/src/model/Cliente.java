package model;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    
    //Getters e Setters
    // ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // NOME
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.length() <= 100) {
            this.nome = nome;
        } else {
            System.out.println("Nome muito grande!");
        }
    }

    // CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido! Deve conter 11 números.");
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

    // EMAIL
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email.length() <= 100 && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email inválido!");
        }
    }
}