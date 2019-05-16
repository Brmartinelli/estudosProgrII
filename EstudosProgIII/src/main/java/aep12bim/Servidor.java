package aep12bim;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) {
		Servidor server = new Servidor();

		server.start();
	}

	private void start() {

		do {

			try {
				ServerSocket socket = new ServerSocket(9098);

				Socket client = socket.accept();

				//System.out.println("Servidor Ligado2");
				Scanner fromClient = new Scanner(client.getInputStream());
				PrintWriter toClient = new PrintWriter(client.getOutputStream());

				do {
					String responseFromClient = " ";
					responseFromClient = fromClient.nextLine();

					toClient.println("no servidor -> " + responseFromClient);
					toClient.flush();

				} while (true);

			} catch (Exception e) {
				//e.printStackTrace();
			}
		} while (true);

	}

}
