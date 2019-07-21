public class ClientThread extends Thread{
	Client client;
	
	public ClientThread(Client iClient) {
		client = iClient;
	}
	@Override
	public void run() {
		boolean running = true;
		String input;
		try {
			while(running){
				input = client.inputStream.readUTF();
				if(Client.IsCommand(input)){
					System.out.println("//Server Message: " + Client.GetString(input));
				} else{
					System.out.println(Client.GetString(input));
				}
			}
		} catch (Exception e) { }
	}
}
