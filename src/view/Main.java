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
			System.out.println("|1 - Identificar o Sistema Operacional |");
			System.out.println("|2 - Mostrar IPv4                      |");
			System.out.println("|3 - Mostrar latência média do Ping    |");
			System.out.println("|9 - Para encerrar aplicação           |");
			System.out.println("========================================");
			System.out.print("Digite aqui:");
			x = sc.nextInt();
			switch(x) {
			case 1:
				System.out.println("O sistema operacional é: "+rc.os());
				break;
			case 2:
				System.out.println("O endereço de IPv4 é:"+rc.ip());
				break;
			case 3:
				System.out.println("3 escolhido");
				break;
			case 9:
				System.out.println("Fim do programa!");
				break;
			default:
				System.out.println("Numero invalido!");
			}
			sc.nextLine();
			System.out.println("Tecle 'ENTER' para continuar.");
			sc.nextLine();
		}while(x!=9);
		String os = rc.os();
		System.out.println(os);
	}

}
