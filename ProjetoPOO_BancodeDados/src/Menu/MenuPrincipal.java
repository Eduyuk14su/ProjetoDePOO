package Menu;

import java.util.Scanner;

public class MenuPrincipal {
    public void exibir() {
        Scanner sc = new Scanner(System.in);
        int opcoes;

        do {
            System.out.println("\n=== BEM VINDO AO RATATULANCHES ===");
            System.out.println("1 - Cadastrar Restaurante");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Fazer Pedido");
            System.out.println("4 - Editar Restaurante");
            System.out.println("0 - Sair");

            opcoes = sc.nextInt();
            sc.nextLine();

            switch(opcoes) {
                case 1:
                    new MenuRestaurante().exibir();
                    break;

                case 2:
                    new MenuCliente().exibir();
                    break;

                case 3:
                    System.out.print("ID do Cliente: ");
                    int idCliente = sc.nextInt();

                    System.out.print("ID do Restaurante: ");
                    int idRestaurante = sc.nextInt();

                    MenuPedido mp = new MenuPedido();

                    mp.criarPedido(
                        idCliente,
                        idRestaurante);
                    break;

                case 4:
                    MenuRestaurante mr =
                    new MenuRestaurante();

                mr.entrar();

                break;
                    
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcoes != 0);
        sc.close();
    }
}