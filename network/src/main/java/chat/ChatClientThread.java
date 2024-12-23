package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true) {
				String data = br.readLine();
				
				if(socket.isClosed()) {
					ChatServer.consoleLog("클라이언트로부터 연결 끊김");
					break;
				}
				System.out.println(data);
			}
			
		} catch (SocketException e) {
			ChatServer.consoleLog("Socket Exception" + e);
		} catch (IOException e) {
			ChatServer.consoleLog("error " + e);
		}
	}
}
