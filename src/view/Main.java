package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rc = new RedesController ();
		
		String os = rc.os();
		System.out.println(os);
	}

}
