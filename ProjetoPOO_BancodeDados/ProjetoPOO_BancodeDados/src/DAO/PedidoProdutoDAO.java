package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Sql.Conector;
import model.PedidoProduto;

public class PedidoProdutoDAO {
    // INSERT
    public void inserir(PedidoProduto pp) {
        String sql = "INSERT INTO pedido_produto " +
                     "(id_pedido, id_produto, quantidade, preco_unitario) " +
                     "VALUES (?, ?, ?, ?)";
        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, pp.getIdPedido());
            stmt.setInt(2, pp.getIdProduto());
            stmt.setInt(3, pp.getQuantidade());
            stmt.setDouble(4, pp.getPrecoUnitario());
            stmt.executeUpdate();
            
            System.out.println("Item do pedido cadastrado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public List<PedidoProduto> listar() {
        List<PedidoProduto> lista =
            new ArrayList<>();
        String sql = "SELECT * FROM pedido_produto";
        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt =
                conn.prepareStatement(sql);
            ResultSet rs =
                stmt.executeQuery()
        ) {
            while (rs.next()) {
                PedidoProduto pp =
                    new PedidoProduto();
                pp.setIdPedido(
                    rs.getInt("id_pedido")
                );
                pp.setIdProduto(
                    rs.getInt("id_produto")
                );
                pp.setQuantidade(
                    rs.getInt("quantidade")
                );
                pp.setPrecoUnitario(
                    rs.getDouble("preco_unitario")
                );
                lista.add(pp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT WHERE
    public List<PedidoProduto> buscarPorPedido(int idPedido) {

        List<PedidoProduto> lista =
            new ArrayList<>();

        String sql =
            "SELECT * FROM pedido_produto " +
            "WHERE id_pedido = ?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt =
                conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, idPedido);

            ResultSet rs =
                stmt.executeQuery();

            while (rs.next()) {
                PedidoProduto pp =
                    new PedidoProduto();
                pp.setIdPedido(
                    rs.getInt("id_pedido")
                );
                pp.setIdProduto(
                    rs.getInt("id_produto")
                );
                pp.setQuantidade(
                    rs.getInt("quantidade")
                );
                pp.setPrecoUnitario(
                    rs.getDouble("preco_unitario")
                );
                lista.add(pp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public void atualizar(PedidoProduto pp) {
        String sql =
            "UPDATE pedido_produto " +
            "SET quantidade=?, preco_unitario=? " +
            "WHERE id_pedido=? AND id_produto=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt =
                conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, pp.getQuantidade());
            stmt.setDouble(2,
                pp.getPrecoUnitario());
            stmt.setInt(3,
                pp.getIdPedido());
            stmt.setInt(4,
                pp.getIdProduto());
            stmt.executeUpdate();

            System.out.println(
                "Item atualizado!"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(
        int idPedido,
        int idProduto
    ) {
        String sql =
            "DELETE FROM pedido_produto " +
            "WHERE id_pedido=? " +
            "AND id_produto=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt =
                conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, idPedido);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
            
            System.out.println(
                "Item deletado!"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}