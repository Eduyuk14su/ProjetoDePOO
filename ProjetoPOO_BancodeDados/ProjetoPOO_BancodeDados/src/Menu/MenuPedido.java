package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DAO.PedidoDAO;
import DAO.PedidoProdutoDAO;
import DAO.ProdutoDAO;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;

public class MenuPedido {

    Scanner sc = new Scanner(System.in);

    ProdutoDAO produtoDAO = new ProdutoDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();

    public void criarPedido(int idCliente, int idRestaurante) {

        Pedido pedido = new Pedido();

        pedido.setIdCliente(idCliente);
        pedido.setIdRestaurante(idRestaurante);
        pedido.setStatusPedido("Em preparo");

        List<PedidoProduto> itens = new ArrayList<>();
        double subtotal = 0;
        int opcao = 0;

        do {
            System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
            List<Produto> produtos =
                produtoDAO.listarPorRestaurante(idRestaurante);
            if (produtos.isEmpty()) {
                System.out.println("Não há produtos cadastrados!");
                return;
            }

            for (Produto p : produtos) {
            	
                System.out.println("----------------------");
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Preço: R$ " + p.getPreco());
                System.out.println("Quantidade: " + p.getQuantidade());
            }

            System.out.print("\nDigite o ID do produto: ");
            int idProduto = sc.nextInt();
            Produto produto =
                produtoDAO.buscarPorId(idProduto);

            if (produto == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            if (quantidade > produto.getQuantidade()) {
                System.out.println("Estoque insuficiente!");
                continue;
            }

            PedidoProduto item = new PedidoProduto();

            item.setIdProduto(produto.getId());
            item.setQuantidade(quantidade);
            item.setPrecoUnitario(produto.getPreco());
            itens.add(item);
            subtotal +=
                produto.getPreco() * quantidade;

            System.out.println("Produto adicionado!");
            System.out.println("\n1 - Adicionar mais produtos");
            System.out.println("0 - Finalizar pedido");

            opcao = sc.nextInt();

        } while (opcao != 0);

        pedido.setSubtotal(subtotal);

        pedido.calcularTotal();

        System.out.println("\n=== RESUMO DO PEDIDO ===");

        System.out.println("Subtotal: R$ "
                + pedido.getSubtotal());

        System.out.println("Desconto: R$ "
                + pedido.getDesconto());

        System.out.println("Taxa de entrega: R$ "
                + pedido.getTaxaEntrega());

        System.out.println("Valor final: R$ "
                + pedido.getValorFinal());

        pedidoDAO.inserir(pedido);

        for (PedidoProduto item : itens) {

            item.setIdPedido(pedido.getId());

            pedidoProdutoDAO.inserir(item);
        }
        System.out.println("\nPedido realizado com sucesso!");
    }
}