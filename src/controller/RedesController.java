package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

    private String os (){
        return System.getProperty("os.name");
    }

    public void ip (){
        if(os().contains("Windows")){
            try{
                Process pr = Runtime.getRuntime().exec("IPCONFIG");
                InputStream is = pr.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                while(line != null){
                    if(line.contains("IPv4")){
                        String [] ipv4 = line.split(":");
                        System.out.println("Endereço é:"+ipv4[1]);
                    }
                    line = br.readLine();
                }
                is.close();
                isr.close();
                br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
           }else if(os().contains("Linux")){
                try {
                    Process pr = Runtime.getRuntime().exec("ip addr");
                    InputStream is = pr.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line = br.readLine();
                    while (line != null){
                        if(line.contains("inet ")){
                            String [] ipv4 = line.split(" ");
                            System.out.println("Endereço é:"+ipv4[5]);
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
                        if (line.contains("inet ")) {
                            String[] ipv4 = line.split(" ");
                            System.out.println("Endereço de IPv4 é: " + ipv4[9]);
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
    public void ping (){
        if(os().contains("Windows")){
            try {
                Process pr = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
                InputStream is = pr.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                while (line != null){
                	System.out.println("Carregando");
                    if (line.contains("ms, ")){
                       String [] a = line.split(" ");
                       System.out.println("A media é:"+a[11]+"ms");
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(os().contains("Linux")){
            try {
                Process pr = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
                InputStream is = pr.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                while (line != null){
                	System.out.println("Carregando...");
                    if (line.contains("rtt")){
                        String [] a = line.split(" ");
                        String [] b = a[3].split("/");
                        System.out.println("A media é:"+b[3]+"ms");
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
