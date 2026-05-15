package model;

public class Produto extends ItemEstoque {
    private String descricao;
    private int idRestaurante;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    //Polimorfismo
    @Override
    public String toString() {

        return "Produto: " + nome +
               " | Preço: R$" + preco +
               " | Quantidade: " + quantidade;
    }
}