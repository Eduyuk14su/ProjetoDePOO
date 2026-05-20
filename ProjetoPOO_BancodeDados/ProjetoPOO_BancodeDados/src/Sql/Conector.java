package Sql;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class Conector {

	    public static Connection conectar() {

	        String url = "jdbc:postgresql://localhost:5432/ratatulanches";
	        String usuario = "postgres";
	        String senha = "1234";

	        try {

	            Connection conn =
	                DriverManager.getConnection(
	                    url, usuario, senha
	                );

	            System.out.println("Sql Rodando...");

	            return conn;

	        } catch (Exception e) {

	            System.out.println("Erro na conexão!");
	            e.printStackTrace();

	            return null;
	        }
	    }
	}
