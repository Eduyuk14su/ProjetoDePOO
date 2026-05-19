package model;

public class PedidoProduto {

    private int id;
    private int idCliente;
    private int idRestaurante;
    private int idEntregador;
    private String statusPedido;
    private String dataHoraPedido;
    private double subtotal;
    private double desconto;
    private double taxaEntrega;
    private double valorFinal;

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

    // ID CLIENTE
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        if (idCliente > 0) {
            this.idCliente = idCliente;
        } else {
            System.out.println("ID do cliente inválido!");
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

    // ID ENTREGADOR
    public int getIdEntregador() {
        return idEntregador;
    }
    public void setIdEntregador(int idEntregador) {
        if (idEntregador > 0) {
            this.idEntregador = idEntregador;
        } else {
            System.out.println("ID do entregador inválido!");
        }
    }

    // STATUS PEDIDO
    public String getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        if (statusPedido != null && statusPedido.length() <= 30) {
            this.statusPedido = statusPedido;
        } else {
            System.out.println("Status inválido!");
        }
    }

    // DATA E HORA
    public String getDataHoraPedido() {
        return dataHoraPedido;
    }
    public void setDataHoraPedido(String dataHoraPedido) {
        if (dataHoraPedido != null && dataHoraPedido.length() <= 50) {
            this.dataHoraPedido = dataHoraPedido;
        } else {
            System.out.println("Data inválida!");
        }
    }

    // SUBTOTAL
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        if (subtotal >= 0) {
            this.subtotal = subtotal;
        } else {
            System.out.println("Subtotal inválido!");
        }
    }

    // DESCONTO
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        if (desconto >= 0) {
            this.desconto = desconto;
        } else {
            System.out.println("Desconto inválido!");
        }
    }

    // TAXA ENTREGA
    public double getTaxaEntrega() {
        return taxaEntrega;
    }
    public void setTaxaEntrega(double taxaEntrega) {
        if (taxaEntrega >= 0) {
            this.taxaEntrega = taxaEntrega;
        } else {
            System.out.println("Taxa inválida!");
        }
    }

    // VALOR FINAL
    public double getValorFinal() {
        return valorFinal;
    }
    public void setValorFinal(double valorFinal) {
        if (valorFinal >= 0) {
            this.valorFinal = valorFinal;
        } else {
            System.out.println("Valor final inválido!");
        }
    }

    // CALCULAR TOTAL
    public void calcularTotal() {
        if (subtotal > 300) {
            desconto = subtotal * 0.15;
        } else if (subtotal > 200) {
            desconto = subtotal * 0.10;
        } else if (subtotal > 100) {
            desconto = subtotal * 0.05;
        } else {
            desconto = 0;
        }
        taxaEntrega = 8;
        valorFinal = subtotal - desconto + taxaEntrega;
    }
}