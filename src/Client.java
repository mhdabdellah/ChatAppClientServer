import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1", 1026);
		System.out.println("Nom client");
		Scanner sc = new Scanner(System.in);
		String nomClient = sc.next();
		// on envoie la donnee au serveur
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		out.writeUTF(nomClient);
		// on recuper la donnee envoie par le serveur 
		DataInputStream in = new DataInputStream(client.getInputStream());
		String s1 = in.readUTF();
		System.out.println(s1);
		//chat
		// client to server
		PrintWriter pr = new PrintWriter(client.getOutputStream());
		pr.println("hello my server");
		pr.flush();
		// message received from server
		InputStreamReader in1 = new InputStreamReader(client.getInputStream());
		BufferedReader bf = new BufferedReader(in1);
		
		String str = bf.readLine();
		System.out.println("server :"+ str);
		
	}

}
