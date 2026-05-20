package Menu;

import java.util.List;
import java.util.Scanner;
import DAO.ProdutoDAO;
import model.Produto;

public class MenuProduto {

    Scanner sc = new Scanner(System.in);

    ProdutoDAO dao = new ProdutoDAO();

    public void exibir() {

        int opcao;

        do {
            System.out.println("\n=== MENU RESTAURANTE ===");
            System.out.println("1 - Adicionar Produtos.");
            System.out.println("2 - Listar Produtos.");
            System.out.println("3 - Buscar Produtos.");
            System.out.println("4 - Atualizar Produtos.");
            System.out.println("5 - Deletar Produtos.");
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

        Produto p = new Produto();

        System.out.print("Nome: ");
        p.setNome(sc.nextLine());

        System.out.print("Descricao: ");
        p.setDescricao(sc.nextLine());

        System.out.print("Preco: ");
        p.setPreco(sc.nextDouble());
        sc.nextLine();
        
        System.out.print("Quantidade: ");
        p.setQuantidade(sc.nextInt());
        sc.nextLine();

        dao.inserir(p);
        
    }
    // LISTAR
    public void listar() {

        List<Produto> lista = dao.listar();
        
        if (lista.isEmpty()) {

            System.out.println("Não há Entregadores Registrados!");
            return;
        }
        
        for (Produto p : lista) {

            System.out.println("------------------");
            System.out.println("ID: " + p.getId());
            System.out.println("ID: " + p.getIdRestaurante());
            
            System.out.println("Nome: " + p.getNome());
            System.out.println("Descricao: " + p.getDescricao());
            System.out.println("Preco: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());
        }
        
    }
    // BUSCAR
    public void buscar() {

        System.out.print("Digite o ID: ");
        int id = sc.nextInt();

        Produto p = dao.buscarPorId(id);

        if (p != null) {

            System.out.println("Nome: " + p.getNome());
            System.out.println("Descricao: " + p.getDescricao());
            System.out.println("Preco: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());

        } else {
            System.out.println("Entregador não encontrado!");
        }
        
    }
    // ATUALIZAR
    public void atualizar() {

        Produto p = new Produto();

        System.out.print("ID do Produto: ");
        p.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Novo nome do produto: ");
        p.setNome(sc.nextLine());

        System.out.print("Nova Descricao: ");
        p.setDescricao(sc.nextLine());

        System.out.print("Novo Preco: ");
        p.setPreco(sc.nextDouble());
        sc.hasNextLine();
        
        System.out.print("Nova Quantidade: ");
        p.setQuantidade(sc.nextInt());
        sc.nextLine();

        dao.atualizar(p);
    }
    // DELETAR
    public void deletar() {

        System.out.print("ID do Produto: ");
        int id = sc.nextInt();

        dao.deletar(id);
    }
}