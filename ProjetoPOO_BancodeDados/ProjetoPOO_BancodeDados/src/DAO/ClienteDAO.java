package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import Sql.Conector;

public class ClienteDAO {
    public void inserir(Cliente c) {
        // INSERT
    	    String sql = "INSERT INTO cliente(nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";

    	    try (
    	        Connection conn = Conector.conectar();
    	        PreparedStatement stmt = conn.prepareStatement(sql)
    	    ) {

    	        stmt.setString(1, c.getNome());
    	        stmt.setString(2, c.getCpf());
    	        stmt.setString(3, c.getTelefone());
    	        stmt.setString(4, c.getEmail());

    	        stmt.executeUpdate();

    	        System.out.println("Cliente cadastrado!");

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}
    
    // SELECT
    public List<Cliente> listar() {
    	List<Cliente> lista = new ArrayList<>();
    	
    	 String sql = "SELECT * FROM cliente";

    	    try (
    	        Connection conn = Conector.conectar();
    	        PreparedStatement stmt = conn.prepareStatement(sql);
    	        ResultSet rs = stmt.executeQuery()) {
    	        while (rs.next()) {

    	            Cliente c = new Cliente();

    	            c.setId(rs.getInt("id_cliente"));
    	            c.setNome(rs.getString("nome"));
    	            c.setCpf(rs.getString("cpf"));
    	            c.setTelefone(rs.getString("telefone"));
    	            c.setEmail(rs.getString("email"));

    	            lista.add(c);
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return lista;
    }
    
    // SELECT WHERE
    public Cliente buscarPorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));

                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //UPDATE
    public void atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, telefone=?, email=? WHERE id_cliente=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEmail());
            stmt.setInt(5, c.getId());

            stmt.executeUpdate();

            System.out.println("Cliente atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //DELETE
    public void deletar(int id) {

        String sql = "DELETE FROM cliente WHERE id_cliente=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Cliente deletado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}