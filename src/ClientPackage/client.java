package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        // Affiche un message pour indiquer que le client n'est pas encore connecté.
        System.out.println("Je suis un client pas encore connecté");
        
        // Crée une instance de Socket pour se connecter au serveur sur localhost (port 2020).
        Socket s = new Socket("localhost", 2020);
        
        // Affiche un message pour indiquer que le client est connecté.
        System.out.println("Je suis un client connecté");

        // Obtient les flux d'entrée et de sortie du socket pour la communication.
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        
        // Crée un objet Scanner pour lire l'entrée utilisateur.
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez un nombre : ");
        int nb = sc.nextInt();
        
        // Envoie le nombre saisi au serveur via le flux de sortie.
        os.write(nb);
        
        // Attend la réponse du serveur, lit la réponse depuis le flux d'entrée, et l'affiche.
        int res = is.read();
        System.out.println("Réponse du serveur : " + res);

        // Ferme la connexion du socket.
        s.close();
    }
}
