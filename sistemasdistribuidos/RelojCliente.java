/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemasdistribuidos;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class RelojCliente {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String port,hostName;
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese el numero de puerto: ");port=stdIn.readLine();
		
		int portNumber=Integer.parseInt(port);
		System.out.println("Ingrese el nombre del host: ");hostName=stdIn.readLine();
		
		try (
			Socket echoSocket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		)
	
		{
			String userInput;
			System.out.println("Usuario Iniciado");
			System.out.println("Presione Salir para salir ");
			
				long tiempoCero;
				long tiempoServidor;
				long tiempoUno;
				long tiempoFinal;
				
			out.println(tiempoCero=System.currentTimeMillis());
			tiempoServidor=Long.parseLong(in.readLine());
			
			tiempoUno= System.currentTimeMillis();
			tiempoFinal= (tiempoServidor+(tiempoUno - tiempoCero)/2);
			DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSSS");
			
			System.out.println("Tiempo del cliente: "+ formatter.format(new Date(tiempoUno)));
			System.out.println("Tiempo del servidor: "+ formatter.format(new Date(tiempoServidor)));
			System.out.println("Tiempo del cliente despues del reinicio: "+ formatter.format(new Date(tiempoFinal)));
			out.println("Salida");
			
		}
		catch(Exception e) {
			System.out.println("Tiempo agotado ...");
		}
	}

}