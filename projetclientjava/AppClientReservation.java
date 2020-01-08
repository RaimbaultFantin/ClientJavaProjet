package projetclientjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppClientReservation {

	public static void main(String[] args) {

		Scanner clavier = new Scanner(new InputStreamReader(System.in));
		System.out.println("Entrez l'URL :");
		String url = clavier.nextLine();
		String params[] = url.split(":");
		String host = params[0];
		int port = Integer.parseInt(params[1]);
		System.out.println(url);

		try {
			Socket socket = new Socket(host, port);

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String feedback = null;
			// ecoute le serveur : "Liste des abonnes"
			feedback = in.readLine();
			System.out.println(feedback);
			// identification
			System.out.print("-> Votre numéro ? : ");
			feedback = clavier.nextLine();
			out.println(feedback);
			// ecoute : "Liste des livres disponibles"
			feedback = in.readLine();
			System.out.println(feedback);
			// envoit du numero du livre
			System.out.print("-> Que voulez vous reserver ? : ");
			feedback = clavier.nextLine();
			out.println(feedback);
			// réponse positive ou négative sur le livre
			feedback = in.readLine();
			System.out.println(feedback);
			socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
