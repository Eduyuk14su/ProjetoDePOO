package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Restaurante;
import Sql.Conector;

public class RestauranteDAO {
    public void inserir(Restaurante r) {
        // INSERT
    	    String sql = "INSERT INTO restaurante (nome, telefone, endereco, cnpj, categoria_culinaria) VALUES (?, ?, ?, ?, ?)";

    	    try (
    	        Connection conn = Conector.conectar();
    	        PreparedStatement stmt = conn.prepareStatement(sql)
    	    ) {

    	        stmt.setString(1, r.getNome());
    	        stmt.setString(2, r.getTelefone());
    	        stmt.setString(3, r.getEndereco());
    	        stmt.setString(4, r.getCnpj());
    	        stmt.setString(5, r.getCategoriaCulinaria());

    	        stmt.executeUpdate();

    	        System.out.println("Restaurante cadastrado!");

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}
    
    // SELECT
    public List<Restaurante> listar() {
    	List<Restaurante> lista = new ArrayList<>();
    	
    	 String sql = "SELECT * FROM restaurante";

    	    try (
    	        Connection conn = Conector.conectar();
    	        PreparedStatement stmt = conn.prepareStatement(sql);
    	        ResultSet rs = stmt.executeQuery()) {
    	        while (rs.next()) {

    	            Restaurante r = new Restaurante();

    	            r.setId(rs.getInt("id_restaurante"));
    	            r.setNome(rs.getString("nome"));
    	            r.setTelefone(rs.getString("telefone"));
    	            r.setEndereco(rs.getString("endereco"));
    	            r.setCnpj(rs.getString("cnpj"));
    	            r.setCategoriaCulinaria(rs.getString("categoria_culinaria"));

    	            lista.add(r);
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return lista;
    }
    
    // SELECT WHERE
    public Restaurante buscarPorId(int id) {

        String sql = "SELECT * FROM restaurante WHERE id_restaurante = ?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Restaurante r = new Restaurante();

	            r.setId(rs.getInt("id_restaurante"));
	            r.setNome(rs.getString("nome"));
	            r.setTelefone(rs.getString("telefone"));
	            r.setEndereco(rs.getString("endereco"));
	            r.setCnpj(rs.getString("cnpj"));
	            r.setCategoriaCulinaria(rs.getString("categoria_culinaria"));

                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //UPDATE
    public void atualizar(Restaurante r) {
        String sql = "UPDATE restaurante SET nome=?, telefone=?, endereco=?, cnpj=?, categoria_culinaria=? WHERE id_restaurante=?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            
            stmt.setString(1, r.getNome());
            stmt.setString(2, r.getTelefone());
            stmt.setString(3, r.getEndereco());
            stmt.setString(4, r.getCnpj());
            stmt.setString(5, r.getCategoriaCulinaria());
            stmt.setInt(6, r.getId());
            stmt.executeUpdate();

            System.out.println("Restaurante atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //DELETE
    public void deletar(int id) {

        String sql = "DELETE FROM restaurante WHERE id_restaurante = ?";

        try (
            Connection conn = Conector.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Restaurante deletado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
