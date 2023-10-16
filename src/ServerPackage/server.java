package ServerPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        // Crée un objet ServerSocket pour écouter les connexions entrantes sur le port 2020.
        ServerSocket ss = new ServerSocket(2020);
        
        // Affiche un message pour indiquer que le serveur est en attente de la connexion d'un client.
        System.out.println("Je suis un serveur en attente de la connexion d'un client");
        
        // Le serveur attend une connexion entrante et accepte la connexion lorsque qu'un client se connecte.
        Socket s = ss.accept();
        
        // Affiche un message pour indiquer qu'un client est connecté.
        System.out.println("Un client est connecté");

        // Obtient les flux d'entrée et de sortie du socket pour la communication.
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        
        // Lit un nombre reçu du client depuis le flux d'entrée.
        int nb = is.read();
        
        // Effectue un calcul (multiplie le nombre par 5) pour obtenir le résultat.
        int res = nb * 5;
        
        // Envoie le résultat au client via le flux de sortie.
        os.write(res);

        // Ferme la connexion du socket client.
        s.close();
        
        // Ferme le ServerSocket pour arrêter l'écoute des connexions entrantes.
        ss.close();
    }
}
