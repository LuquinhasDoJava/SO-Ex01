package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void ip() {
		RedesController rc = new RedesController();
		
		if (rc.os().contains("Windows")) {
			try {
				Process pr = Runtime.getRuntime().exec("IPCONFIG");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					if(line.contains("IPv4")) {
					String[] ipv4 = line.split(":");
					System.out.println("Endereço de IPv4 é "+ ipv4[1]);
					}
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(rc.os().contains("Linux")) {
			try {
				Process pr = Runtime.getRuntime().exec("ip addr");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					if(line.contains("inet")) {
					String[] ipv4 = line.split(" ");
					System.out.println("Endereço de IPv4 é: "+ipv4[5]);
					}
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			try {
				Process pr = Runtime.getRuntime().exec("ifconfig");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					if(line.contains("inet")) {
					String[] ipv4 = line.split(" ");
					System.out.println("Endereço de IPv4 é: "+ipv4[9]);
					}
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}


	}

}
