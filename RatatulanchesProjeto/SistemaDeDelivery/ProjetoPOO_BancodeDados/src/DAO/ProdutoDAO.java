package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import Sql.Conector;

public class ProdutoDAO {

    // INSERT
    public void inserir(Produto p) {

        String sql = "INSERT INTO produto(nome, descricao, preco, quantidade id_restaurante) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidade());
            stmt.setInt(5, p.getIdRestaurante());

            stmt.executeUpdate();

            System.out.println("Produto cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setIdRestaurante(rs.getInt("id_restaurante"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR POR ID
    public Produto buscarPorId(int id) {

        String sql = "SELECT * FROM produto WHERE id_produto=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setIdRestaurante(rs.getInt("id_restaurante"));

                return p;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public void atualizar(Produto p) {

        String sql = "UPDATE produto SET nome=?, descricao=?, preco=?, id_restaurante=? WHERE id_produto=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidade());
            stmt.setInt(5, p.getIdRestaurante());
            stmt.setInt(6, p.getId());

            stmt.executeUpdate();

            System.out.println("Produto atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {

        String sql = "DELETE FROM produto WHERE id_produto=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Produto deletado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
