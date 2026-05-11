package Menu;

import java.util.Scanner;

public class MenuPrincipal {
	
	public static void exibir() {
		Scanner sc =  new Scanner(System.in);
		int opcoes;
		
	do {
		System.out.println("Bem Vindo ao Ratatulanches!");
		System.out.println("Escolha Uma Opcao.");
		System.out.println("1 - Cadastrar um Restaurante");
		System.out.println("2 -  Cadastrar Como Cliente.");
		System.out.println("Sair.");
		
        opcoes = sc.nextInt();
        
        switch(opcoes) {
        case 1:
        	new MenuRestaurante().exibir();
        	break;
        case 2:
        	new MenuCliente().exibir();
        	break;
        	
        default:
        	System.out.println("Opcao Invalida!");
        	
        sc.close();
        
        	}
		} while (opcoes != 0);
	}
}
