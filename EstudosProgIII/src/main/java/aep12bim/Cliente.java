package aep12bim;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Cliente client = new Cliente();
		client.start();

	}

	private void start() {

		Scanner console = new Scanner(System.in);
		String comando = " ";

		boolean conexao = false;
		do {
			comando = " ";
			if (!conexao) {

				do {
					System.out.print("Digite Entrar >>");
					comando = console.nextLine();
				} while (!comando.equals("entrar"));
				System.out.println("Conectado Ao Servidor");
				conexao = true;
			}
			if (conexao) {

				try {
					Socket server = new Socket("localhost", 9098);
					PrintWriter toServer = new PrintWriter(server.getOutputStream());
					Scanner fromServer = new Scanner(server.getInputStream());
					do {

						System.out.print("Terminal >> ");
						comando = console.nextLine();
						if (comando.equals("ls")) {
							do {
								toServer.println(comando);
								toServer.flush();
								String resposta = fromServer.nextLine();
								System.out.println("Resposta  " + resposta);
								
							} while (!fromServer.nextLine().equals("acabou"));
						}
						toServer.println(comando);
						toServer.flush();
						String resposta = fromServer.nextLine();
						System.out.println("Resposta  " + resposta);

					} while (!comando.equals("sair"));
					System.out.println("Desconectou do Servidor");
					conexao = false;
					server.close();

				} catch (Exception e) {
					conexao = false;
					System.out.println("Estouaqui");
					e.printStackTrace();

				}
			}

		} while (true);
	}

}
