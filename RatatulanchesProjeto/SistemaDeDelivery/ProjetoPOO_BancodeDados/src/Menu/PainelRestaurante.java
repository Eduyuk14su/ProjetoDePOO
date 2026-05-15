package Menu;

import java.util.Scanner;
import model.Restaurante;

public class PainelRestaurante {
	private Restaurante restaurante;
	Scanner sc = new Scanner(System.in);
	
	public PainelRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public void exibir() {
		int opcao
		
		do {
			System.out.println("\n=== Painel do Restaurante ==");
			System.out.println("Restaurante " + restaurante.getNome());
			System.out.println("1 - Gerenciar Produtos";
			System.out.println("2 - Gerenciar Produtos";
			System.out.println("0 - Voltar";
			
			opcao = sc.nextInt();
				sc.nextLine();
				
				switch(opcao) {
				
				case 1:
					MenuProduto mp = new MenuProduto(restaurante);
					mp.exibir();
					brak;
					
				case 2:
					MenuEntregador me = new MenuEntregador(restaurante);
					me.exibir();
					break;
					
				case 0:
					System.out.println("Saindo Do Painel...");
					break;
					
				default:
					System.out.println("Opção Invalida");	
				} while(opcao != 0);
		}
	}
}
