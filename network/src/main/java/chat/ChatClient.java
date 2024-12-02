package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
		
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			
			ChatClientThread ChatClientThread = new ChatClientThread(socket);
			ChatClientThread.start();
			
			while(true) {
				System.out.print(">>");
				String message = scanner.nextLine();
				
				if ("quit".equals(message)) {
					pw.println("quit");
				
					try {
						if(socket != null && !socket.isClosed()) {
							socket.close();
						}
					} catch(IOException e) {
						e.printStackTrace();
					}
					ChatServer.consoleLog("채팅방에서 퇴장하셨습니다.");
					break;
				} else {
					pw.println("message:" + message);
				}
			}
		} catch (IOException e) {
			ChatServer.consoleLog("error: " + e);
		} finally {
			try {
				scanner.close();
				
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
