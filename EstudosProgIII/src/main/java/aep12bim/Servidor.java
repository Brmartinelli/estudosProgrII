package aep12bim;

import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.RepositoryIdHelper;

public class Servidor {
	String dir = "";

	public static void main(String[] args) {
		Servidor server = new Servidor();
		server.start();

	}

	private void start() {

		do {

			try {
				ServerSocket socket = new ServerSocket(9098);
				Socket client = socket.accept();
				File raiz = new File("/home/bruno/EngSoft4");
				// System.out.println("Servidor Ligado2");
				Scanner fromClient = new Scanner(client.getInputStream());
				PrintWriter toClient = new PrintWriter(client.getOutputStream());
				String responseFromClient = " ";
				do {
					
					responseFromClient = fromClient.nextLine();
					if (responseFromClient.equals("ls")) {
						percorresRecursivo(raiz, " ", toClient);
						toClient.println("acabou");
						toClient.flush();
					}else {
						if(responseFromClient.equals("mkdir")) {
							
						}
					}

					toClient.println("no servidor -> " + responseFromClient);
					toClient.flush();

				} while (true);

			} catch (Exception e) {
				// e.printStackTrace();
			}
		} while (true);

	}

	private static void percorresRecursivo(File entrada, String identacao, PrintWriter toClient) {
		toClient.println(identacao + entrada.getAbsolutePath());
		toClient.flush();
		if (entrada.isDirectory()) {
			for (File arquivo : entrada.listFiles()) {
				percorresRecursivo(arquivo, identacao + " ", toClient);
			}
		}
		// System.out.println("Embaixo");

	}

}
