package aep12bim;

import java.io.File;

public class App {

	public static void main(String[] args) {
		try {
			File raiz = new File("/home/bruno/EngSoft4");
			percorresRecursivo(raiz, " ");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void percorresRecursivo(File entrada, String identacao) {
		enviaServer(identacao + entrada.getAbsolutePath());
		if (entrada.isDirectory()) {
			for (File arquivo : entrada.listFiles()) {
				percorresRecursivo(arquivo, identacao + " ");
			}
		}
		//System.out.println("Embaixo");

	}

	private static String enviaServer(String caminho) {
		System.out.println(caminho);
		return caminho;

	}

}
