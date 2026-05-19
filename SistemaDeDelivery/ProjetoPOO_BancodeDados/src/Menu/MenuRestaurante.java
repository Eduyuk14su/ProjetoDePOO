package Menu;

import java.util.List;
import java.util.Scanner;
import DAO.RestauranteDAO;
import model.Restaurante;

	public class MenuRestaurante {

	    Scanner sc = new Scanner(System.in);

	    RestauranteDAO dao = new RestauranteDAO();

	    public void exibir() {

	        int opcao;

	        do {

	            System.out.println("\n=== MENU RESTAURANTE ===");
	            System.out.println("1 - Cadastrar restaurante");
	            System.out.println("2 - Listar restaurantes");
	            System.out.println("3 - Buscar restaurante");
	            System.out.println("4 - Atualizar restaurante");
	            System.out.println("5 - Deletar restaurante");
	            System.out.println("0 - Voltar");

	            opcao = sc.nextInt();
	            sc.nextLine();

	            switch(opcao) {

	                case 1:
	                    cadastrar();
	                    break;

	                case 2:
	                    listar();
	                    break;

	                case 3:
	                    buscar();
	                    break;

	                case 4:
	                    atualizar();
	                    break;

	                case 5:
	                    deletar();
	                    break;

	                case 0:
	                    System.out.println("Voltando...");
	                    break;

	                default:
	                    System.out.println("Opção inválida!");
	            }

	        } while(opcao != 0);
	    }
	    // CADASTRAR
	    public void cadastrar() {

	        Restaurante r = new Restaurante();

	        System.out.print("Nome: ");
	        r.setNome(sc.nextLine());

	        System.out.print("Telefone: ");
	        r.setTelefone(sc.nextLine());

	        System.out.print("Endereço: ");
	        r.setEndereco(sc.nextLine());

	        System.out.print("CNPJ: ");
	        r.setCnpj(sc.nextLine());

	        System.out.print("Categoria culinária: ");
	        r.setCategoriaCulinaria(sc.nextLine());

	        dao.inserir(r);
	    }
	    // LISTAR
	    public void listar() {

	        List<Restaurante> lista = dao.listar();
	        
	        if (lista.isEmpty()) {

	            System.out.println("Não há restaurantes registrados!");
	            return;
	        }
	        
	        for (Restaurante r : lista) {

	            System.out.println("------------------");
	            System.out.println("ID: " + r.getId());
	            System.out.println("Nome: " + r.getNome());
	            System.out.println("Telefone: " + r.getTelefone());
	            System.out.println("Endereço: " + r.getEndereco());
	            System.out.println("CNPJ: " + r.getCnpj());
	            System.out.println("Categoria: " + r.getCategoriaCulinaria());
	        }
	    }

	    // BUSCAR
	    public void buscar() {

	        System.out.print("Digite o ID: ");
	        int id = sc.nextInt();

	        Restaurante r = dao.buscarPorId(id);

	        if (r != null) {

	            System.out.println("Nome: " + r.getNome());
	            System.out.println("Telefone: " + r.getTelefone());
	            System.out.println("Endereço: " + r.getEndereco());
	            System.out.println("CNPJ: " + r.getCnpj());
	            System.out.println("Categoria: " + r.getCategoriaCulinaria());

	        } else {
	            System.out.println("Restaurante não encontrado!");
	        }
	    }

	    // ATUALIZAR
	    public void atualizar() {

	        Restaurante r = new Restaurante();

	        System.out.print("ID do restaurante: ");
	        r.setId(sc.nextInt());
	        sc.nextLine();

	        System.out.print("Novo nome: ");
	        r.setNome(sc.nextLine());

	        System.out.print("Novo telefone: ");
	        r.setTelefone(sc.nextLine());

	        System.out.print("Novo endereço: ");
	        r.setEndereco(sc.nextLine());

	        System.out.print("Novo CNPJ: ");
	        r.setCnpj(sc.nextLine());

	        System.out.print("Nova categoria: ");
	        r.setCategoriaCulinaria(sc.nextLine());

	        dao.atualizar(r);
	    }

	    // DELETE
	    public void deletar() {
	        System.out.print("ID do restaurante: ");
	        int id = sc.nextInt();
	        dao.deletar(id);
	    }
	}