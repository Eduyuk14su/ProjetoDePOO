package model;

public class Produto extends ItemEstoque {

    private String descricao;
    private int idRestaurante;

    // DESCRIÇÃO
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao != null && descricao.length() <= 255) {
            this.descricao = descricao;
        } else {
            System.out.println("Descrição inválida!");
        }
    }
    
    // ID RESTAURANTE
    public int getIdRestaurante() {
        return idRestaurante;
    }
    public void setIdRestaurante(int idRestaurante) {
        if (idRestaurante > 0) {
            this.idRestaurante = idRestaurante;
        } else {
            System.out.println("ID do restaurante inválido!");
        }
    }

    // POLIMORFISMO
    @Override
    public String toString() {

        return "Produto: " + nome +
               " | Preço: R$ " + preco +
               " | Quantidade: " + quantidade;
    }
}