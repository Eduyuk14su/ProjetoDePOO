package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Sql.Conector;
import model.Pedido;

public class PedidoDAO {
    public void inserir(Pedido p) {
        String sql = "INSERT INTO pedido (status_pedido, data_hora_pedido, id_cliente, id_restaurante, id_entregador, subtotal, desconto, taxa_entrega, valor_final) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getStatusPedido());
            stmt.setString(2, p.getDataHoraPedido());

            stmt.setInt(3, p.getIdCliente());
            stmt.setInt(4, p.getIdRestaurante());
            stmt.setInt(5, p.getIdEntregador());

            stmt.setDouble(6, p.getSubtotal());
            stmt.setDouble(7, p.getDesconto());
            stmt.setDouble(8, p.getTaxaEntrega());
            stmt.setDouble(9, p.getValorFinal());

            stmt.executeUpdate();

            System.out.println("Pedido cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}