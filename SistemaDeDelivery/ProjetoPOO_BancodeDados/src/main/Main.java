package main;

import Menu.MenuPrincipal;
import Sql.Conector;

public class Main {
	public static void main (String[] args) {
	        Conector.conectar();
	        
		MenuPrincipal MP = new MenuPrincipal();
		MP.exibir();
	}
}