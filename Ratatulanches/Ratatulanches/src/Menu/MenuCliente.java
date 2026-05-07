package Menu;

import java.util.Scanner;

public class MenuCliente {
	public class exibir {

	}
	static Scanner sc = new Scanner(System.in);
	public void exibir() {
		int opclien;
		
		do {
			System.out.println("Bem Vindo AO aadada");
			System.out.println("1 - Cadastrar Nome");
			System.out.println("2 - Aaasdas");
			
			opclien = sc.nextInt();
			
			switch (opclien) {
			
			case 1:
				System.out.println("FoI!");
			case 2:
				System.out.println("Aalala");
			
			default:
				System.out.println("Nao foi!");
			}
		} while (opclien != 0);
	} 
		
		
	}

