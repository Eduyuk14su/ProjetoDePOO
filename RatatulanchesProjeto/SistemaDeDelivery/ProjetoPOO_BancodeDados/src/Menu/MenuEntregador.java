package Menu;

import java.util.List;
import java.util.Scanner;
import DAO.EntregadorDAO;
import model.Entregador;

public class MenuEntregador {

    Scanner sc = new Scanner(System.in);

    EntregadorDAO dao = new EntregadorDAO();

    public void exibir() {

        int opcao;

        do {
            System.out.println("\n=== MENU RESTAURANTE ===");
            System.out.println("1 - Adicionar Entregador.");
            System.out.println("2 - Listar Entregadores.");
            System.out.println("3 - Buscar Entregador.");
            System.out.println("4 - Atualizar Entregador.");
            System.out.println("5 - Deletar Entregador.");
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

        Entregador e = new Entregador();

        System.out.print("Nome: ");
        e.setNome(sc.nextLine());

        System.out.print("CPF: ");
        e.setCpf(sc.nextLine());

        System.out.print("Telefone: ");
        e.setTelefone(sc.nextLine());

        System.out.print("Veiculo: ");
        e.setVeiculo(sc.nextLine());

        dao.inserir(e);
    }
    // LISTAR
    public void listar() {

        List<Entregador> lista = dao.listar();
        
        if (lista.isEmpty()) {

            System.out.println("Não há Entregadores Registrados!");
            return;
        }
        
        for (Entregador e : lista) {

            System.out.println("------------------");
            System.out.println("ID: " + e.getId());
            System.out.println("Nome: " + e.getNome());
            System.out.println("CPF: " + e.getCpf());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("Email: " + e.getVeiculo());
        }
    }

    // BUSCAR
    public void buscar() {

        System.out.print("Digite o ID: ");
        int id = sc.nextInt();

        Entregador e = dao.buscarPorId(id);

        if (e != null) {

            System.out.println("Nome: " + e.getNome());
            System.out.println("CPF: " + e.getCpf());
            System.out.println("Telefone: " + e.getTelefone());
            System.out.println("Veiculo: " + e.getVeiculo());

        } else {
            System.out.println("Entregador não encontrado!");
        }
    }

    // ATUALIZAR
    public void atualizar() {

        Entregador e = new Entregador();

        System.out.print("ID do restaurante: ");
        e.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Novo nome: ");
        e.setNome(sc.nextLine());

        System.out.print("Novo Cpf: ");
        e.setCpf(sc.nextLine());

        System.out.print("Novo Telefone: ");
        e.setTelefone(sc.nextLine());

        System.out.print("Novo Veiculo: ");
        e.setVeiculo(sc.nextLine());

        dao.atualizar(e);
    }

    // DELETAR
    public void deletar() {

        System.out.print("ID do restaurante: ");
        int id = sc.nextInt();

        dao.deletar(id);
    }
}
