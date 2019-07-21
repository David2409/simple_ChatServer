import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.TableStringConverter;

public class Server {
	public List<ServerThread> threads;
	public List<String> hostnames;
	private String path;
	
	public Server() {
		threads = new ArrayList<ServerThread>();
		hostnames = new ArrayList<String>();
		hostnames.add("DAVID");
		path = "server.log";
	}
	
	public static void main(String[] args){
		Server server = new Server();
		ServerSocket serverSocket = null;
		boolean running = true;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Port: ");
			serverSocket = new ServerSocket(scanner.nextShort());
		} catch (Exception e) {
			System.out.println("Starting Error");
			System.err.println(e);
			running = false;
		}
		scanner.close();
		
		System.out.println("Server Started");
		while(running){
			try{
				ServerThread thread = new ServerThread(serverSocket.accept(), server);
				thread.start();
				server.threads.add(thread);
				System.out.println("Created Thread");
			} catch(Exception e){ 
				System.out.println(e);
			}
		}
		try {
			serverSocket.close();
		} catch (Exception e) {}
		System.out.println("Shutdown Server");
	}
	
	public void RemoveThread(ServerThread serverThread){
		threads.remove(serverThread);
		hostnames.remove(serverThread.clientname.toUpperCase());
	}
	
	public void SendToAllClients(String message, ServerThread except){
		Log(message);
		for (ServerThread serverThread : threads) {
			if(serverThread != except){
				try {
					serverThread.outputStream.writeUTF("." + message);
					serverThread.outputStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean HostnameUsed(String name){
		return hostnames.contains(name.toUpperCase());
	}
	
	public void Log(String text){
		System.out.println(text);
		try {
		 	BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
			writer.write(text);
		 	writer.newLine();
		 	writer.close();
		} catch (IOException e) {
			System.err.println("Failt to write to Log!");
		}
	}
}