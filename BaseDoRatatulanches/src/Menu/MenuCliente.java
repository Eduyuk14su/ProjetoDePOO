package Menu;

import java.util.Scanner;

public class MenuCliente {

	public void exibir() {
		Scanner sc =  new Scanner(System.in);
		int opcoes;
		
		System.out.println("Bem Vindo ao Menu de Cliente!");
		System.out.println("Preencha Os Campos Para Fazer Um Pedido!.");
		
		System.out.println("1 - Nome");
		String Nome = sc.nextLine();
		
		System.out.println("2 - CPF.");
		String CPF = sc.nextLine(); 
		
		System.out.println("3 - Telefone.");
		String Telefone = sc.nextLine();
		
		System.out.println("4 - Email.");
		String Email = sc.nextLine();
		
		System.out.println("Nome: "+ Nome + " CPF: "+ CPF + " Telefone: "+ Telefone + " Email: "+ Email);
		
		
        opcoes = sc.nextInt();
	}
}
