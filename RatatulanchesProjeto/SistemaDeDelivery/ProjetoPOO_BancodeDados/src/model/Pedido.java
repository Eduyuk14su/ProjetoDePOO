package model;

public class Pedido {
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

    // GETTERS E SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdRestaurante() {
        return idRestaurante;
    }
    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    public int getIdEntregador() {
        return idEntregador;
    }
    public void setIdEntregador(int idEntregador) {
        this.idEntregador = idEntregador;
    }
    public String getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    public String getDataHoraPedido() {
        return dataHoraPedido;
    }
    public void setDataHoraPedido(String dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    public double getTaxaEntrega() {
        return taxaEntrega;
    }
    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
    public double getValorFinal() {
        return valorFinal;
    }
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
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