import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1026);
		System.out.println("En attente de connection d'un client ");
		Socket s = ss.accept();
		System.out.println("Connection etablie");
		//on recupere la donnee envoyee par le client 
		DataInputStream in = new DataInputStream(s.getInputStream());
		String nomClient = in.readUTF();
		//On effectuer un traitement 
		String s1 = "Bienvenue "+nomClient+", t'es bien connecte";
		// on envoie la donnee au client 
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		out.writeUTF("server : "+s1);
		// chat
		// message reseived from client 
		InputStreamReader in1 = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in1);
		
		String str = bf.readLine();
		System.out.println(nomClient +":"+ str);
		// server to client
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("hello my client "+nomClient+" what do you want I'm here for you and you are my best client do you now that "+nomClient);
		pr.flush();
	}

}
