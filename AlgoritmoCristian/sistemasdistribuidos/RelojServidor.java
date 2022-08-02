package sistemasdistribuidos;

import java.io.*;
import java.net.*;

public class RelojServidor {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String port;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese el numero de puerto: ");port=stdIn.readLine();
		int portNumber=Integer.parseInt(port);
		
		try (
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		)
		{
			String inputLine;
			System.out.println("Servidor Iniciado");
			while(true) {
				inputLine=in.readLine();
				if(inputLine.equalsIgnoreCase("Salir")) {
					System.out.println("Saliendo");
					out.println("Servidor saliendo");
					break;
				}
				out.println(System.currentTimeMillis()+5000);
			}
		}
		catch(Exception e){
			System.out.println("Tiempo agotado");
		}
		
		
	}

}