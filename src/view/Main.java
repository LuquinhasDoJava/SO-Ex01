package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RedesController rc = new RedesController ();
		
		int x = 0;
		do {
			System.out.println("========================================");
			System.out.println("|            Menu Inicial              |");
			System.out.println("+======================================+");
			System.out.println("|1 - Mostrar IPv4                      |");
			System.out.println("|2 - Mostrar latência média do Ping    |");
			System.out.println("|9 - Para encerrar aplicação           |");
			System.out.println("========================================");
			System.out.print("Digite aqui:");
			x = sc.nextInt();
			switch(x) {
			case 1:
				rc.ip();
				break;
			case 2:
				System.err.println("2 foi escolhido");
				break;
			case 9:
				System.err.println("Fim do programa!");
				break;
			default:
				System.err.println("Numero invalido!");
			}
			sc.nextLine();
			System.out.println("Tecle 'ENTER' para continuar.");
			sc.nextLine();
		}while(x!=9);
	}

}
