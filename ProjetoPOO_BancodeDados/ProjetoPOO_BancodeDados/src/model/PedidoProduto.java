package model;

public class PedidoProduto {

    private int idPedido;
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    // ID PEDIDO
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        if (idPedido > 0) {
            this.idPedido = idPedido;
        } else {
            System.out.println("ID do pedido inválido!");
        }
    }

    // ID PRODUTO
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        if (idProduto > 0) {
            this.idProduto = idProduto;
        } else {
            System.out.println("ID do produto inválido!");
        }
    }

    // QUANTIDADE
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida!");
        }
    }

    // PREÇO UNITÁRIO
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario > 0) {
            this.precoUnitario = precoUnitario;
        } else {
            System.out.println("Preço unitário inválido!");
        }
    }
}