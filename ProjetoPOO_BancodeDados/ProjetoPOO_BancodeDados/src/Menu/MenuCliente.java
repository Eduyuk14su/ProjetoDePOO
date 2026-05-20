package Menu;

import java.util.List;
import java.util.Scanner;
import DAO.ClienteDAO;
import model.Cliente;

	public class MenuCliente {

	    Scanner sc = new Scanner(System.in);

	    ClienteDAO dao = new ClienteDAO();

	    public void exibir() {

	        int opcao;

	        do {

	            System.out.println("\n=== MENU CLIENTE ===");
	            System.out.println("1 - Cadastrar Cliente.");
	            System.out.println("2 - Listar Clientes.");
	            System.out.println("3 - Buscar Clientes.");
	            System.out.println("4 - Atualizar Cliente.");
	            System.out.println("5 - Deletar Cliente.");
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

	        Cliente c = new Cliente();

	        System.out.print("Nome: ");
	        c.setNome(sc.nextLine());

	        System.out.print("CPF: ");
	        c.setCpf(sc.nextLine());

	        System.out.print("Telefone: ");
	        c.setTelefone(sc.nextLine());

	        System.out.print("Email: ");
	        c.setEmail(sc.nextLine());

	        dao.inserir(c);
	    }
	    // LISTAR
	    public void listar() {

	        List<Cliente> lista = dao.listar();
	        
	        if (lista.isEmpty()) {

	            System.out.println("Não há Clientes Registrados!");
	            return;
	        }
	        
	        for (Cliente c : lista) {

	            System.out.println("------------------");
	            System.out.println("ID: " + c.getId());
	            System.out.println("Nome: " + c.getNome());
	            System.out.println("CPF: " + c.getCpf());
	            System.out.println("Telefone: " + c.getTelefone());
	            System.out.println("Email: " + c.getEmail());
	        }
	    }

	    // BUSCAR
	    public void buscar() {

	        System.out.print("Digite o ID: ");
	        int id = sc.nextInt();

	        Cliente c = dao.buscarPorId(id);

	        if (c != null) {

	            System.out.println("Nome: " + c.getNome());
	            System.out.println("CPF: " + c.getCpf());
	            System.out.println("Telefone: " + c.getTelefone());
	            System.out.println("Email: " + c.getEmail());

	        } else {
	            System.out.println("Cliente não encontrado!");
	        }
	    }

	    // ATUALIZAR
	    public void atualizar() {

	        Cliente c = new Cliente();

	        System.out.print("ID do restaurante: ");
	        c.setId(sc.nextInt());
	        sc.nextLine();

	        System.out.print("Novo nome: ");
	        c.setNome(sc.nextLine());

	        System.out.print("Novo Cpf: ");
	        c.setCpf(sc.nextLine());

	        System.out.print("Novo Telefone: ");
	        c.setTelefone(sc.nextLine());

	        System.out.print("Novo Email: ");
	        c.setEmail(sc.nextLine());

	        dao.atualizar(c);
	    }

	    // DELETAR
	    public void deletar() {

	        System.out.print("ID do restaurante: ");
	        int id = sc.nextInt();

	        dao.deletar(id);
	    }
	}