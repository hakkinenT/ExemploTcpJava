/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            Scanner sc = new Scanner(System.in);
            String msg = "";
            
            while(!msg.equalsIgnoreCase("bye")){
                msg = sc.nextLine();
                
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
                
                byte[] buf2 = new byte[20]; // buffer de recepção

                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf2); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
            
                String msg2 = new String(buf2); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: "+ msg2);
                
                
            
                
            }
            //String msg = "Olá, DCOMP!!!";
           
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}