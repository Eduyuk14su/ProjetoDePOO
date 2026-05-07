package Menu;

import java.util.Scanner;

public class MenuPrincipal {
	static Scanner sc = new Scanner(System.in);
	public static void exibir() {
		int opcoes;
		
	do {
		System.out.println("Ola, bem vindo");
		System.out.println("Escolha");
		System.out.println("1 - Cliente");
		System.out.println("2 - Restaurante");
		
		opcoes = sc.nextInt();
		
		switch (opcoes) {
		
		case 1: 
			new MenuCliente.exibir();
			break;
		case 2:
			new MenuRestaurante.exibir();
		case 3: 
			System.out.println("Saindo...");	
		default:
			System.out.println("Opcao Invalida!");
			while (opcoes != 0);
			}
		}
	}
}