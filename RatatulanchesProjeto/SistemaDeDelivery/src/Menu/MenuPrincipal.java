package Menu;

import java.util.Scanner;

public class MenuPrincipal {
	
	public void exibir() {
		Scanner sc =  new Scanner(System.in);
		int opcoes;
		
	do {
		System.out.println("Bem Vindo ao Ratatulanches!");
		System.out.println("Escolha Uma Opcao.");
		System.out.println("1 - Cadastrar um Restaurante");
		System.out.println("2 - Cadastrar Como Cliente.");
		System.out.println("0 - Sair.");
		
        opcoes = sc.nextInt();
        
        switch(opcoes) {
        case 1:
        	new MenuRestaurante().exibir();
        	break;
        case 2:
        	new MenuCliente().exibir();
        	break;
        	
        case 0:
        	System.out.println("Saindo...");
        	
        default:
        	System.out.println("Opcao Invalida!");
        	

        	}
		} while (opcoes != 0);
	}
}
