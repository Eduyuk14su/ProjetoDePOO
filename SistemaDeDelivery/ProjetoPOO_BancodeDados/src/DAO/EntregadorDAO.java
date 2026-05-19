package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Entregador;
import Sql.Conector;

	public class EntregadorDAO {

	    // INSERT
	    public void inserir(Entregador e) {

	    String sql = "INSERT INTO entregador(nome, cpf, telefone, veiculo) VALUES (?, ?, ?, ?)";

	        try (
	            Connection conn = Conector.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, e.getNome());
	            stmt.setString(2, e.getCpf());
	            stmt.setString(3, e.getTelefone());
	            stmt.setString(4, e.getVeiculo());

	            stmt.executeUpdate();

	            System.out.println("Entregador cadastrado!");

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    // LISTAR
	    public List<Entregador> listar() {
	        List<Entregador> lista = new ArrayList<>();

	        String sql = "SELECT * FROM entregador";

	        try (
	            Connection conn = Conector.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {

	                Entregador e = new Entregador();

	                e.setId(rs.getInt("id_entregador"));
	                e.setNome(rs.getString("nome"));
	                e.setCpf(rs.getString("cpf"));
	                e.setTelefone(rs.getString("telefone"));
	                e.setVeiculo(rs.getString("veiculo"));

	                lista.add(e);
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return lista;
	    }

	    // BUSCAR POR ID
	    public Entregador buscarPorId(int id) {

	        String sql = "SELECT * FROM entregador WHERE id_entregador = ?";

	        try (
	            Connection conn = Conector.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {

	                Entregador e = new Entregador();

	                e.setId(rs.getInt("id_entregador"));
	                e.setNome(rs.getString("nome"));
	                e.setCpf(rs.getString("cpf"));
	                e.setTelefone(rs.getString("telefone"));
	                e.setVeiculo(rs.getString("veiculo"));

	                return e;
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }

	    // UPDATE
	    public void atualizar(Entregador e) {

	        String sql = "UPDATE entregador SET nome=?, cpf=?, telefone=?, veiculo=? WHERE id_entregador=?";

	        try (
	            Connection conn = Conector.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, e.getNome());
	            stmt.setString(2, e.getCpf());
	            stmt.setString(3, e.getTelefone());
	            stmt.setString(4, e.getVeiculo());
	            stmt.setInt(5, e.getId());

	            stmt.executeUpdate();

	            System.out.println("Entregador atualizado!");

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    // DELETE
	    public void deletar(int id) {

	        String sql = "DELETE FROM entregador WHERE id_entregador=?";

	        try (
	            Connection conn = Conector.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, id);
	            stmt.executeUpdate();

	            System.out.println("Entregador deletado!");

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}