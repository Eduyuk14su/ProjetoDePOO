package model;

// Herança
public class ItemEstoque {

    protected int id;
    protected String nome;
    protected String descricao;
    protected double preco;
    protected int quantidade;

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

    // DESCRIÇÃO
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao != null && descricao.length() <= 255) {
            this.descricao = descricao;
        } else {
            System.out.println("Descrição muito grande!");
        }
    }

    // PREÇO
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido!");
        }
    }

    // QUANTIDADE
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida!");
        }
    }
}