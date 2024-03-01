package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public String ip() {
		RedesController ass = new RedesController();
		if (ass.os().contains("Windows")) {
			try {
				Process pr = Runtime.getRuntime().exec("IPCONFIG");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					if(line.contains("IPv4")) {
					String[] ipv4 = line.split(":");
					return ipv4[1].toString();
					}
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
				return "Sem IPv4";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(ass.os().contains("Linux")) {
			try {
				Process pr = Runtime.getRuntime().exec("ip addr");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					if(line.contains("IPv4")) {
					String[] ipv4 = line.split(":");
					return ipv4[1].toString();
					}
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
				return "Sem IPv4";
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}

		return "0";

	}

}
