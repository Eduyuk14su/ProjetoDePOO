package Menu;

import java.util.Scanner;

public class MenuRestaurante {

		public class exibir {

	}
		static Scanner sc = new Scanner(System.in);
		public static void exibir() {
			int opcren;
			
			do {
				System.out.println("Bem Vindo AO aadada");
				System.out.println("1 - Cadastrar Nome");
				System.out.println("2 - Aaasdas");
				
				opcren = sc.nextInt();
				
				switch (opcren) {
				case 1:
					System.out.println("FoI!");
				case 2:
					System.out.println("Aalala");
				
				default:
					System.out.println("Nao foi!");
				}
			} while (opcren != 0);
		} 
	}



