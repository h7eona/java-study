package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import chat.ChatServer;

public class ChatWindow {

	private static final String SERVER_IP = "127.0.0.1";
	
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private String name;
	private Socket socket = null;
	private PrintWriter pw;
	private BufferedReader br;
	
	public ChatWindow(String name) {
		this.name = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
//		buttonSend.addActionListener(actionEvent -> {});
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) { 
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		try {	
			//1. 소켓 생성
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			// 2. IOStream
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 3. JOIN protocol
		pw.println("join:" + name);
		pw.flush();
		
		// 4. ChatClientThread 생성
		new ChatClientThread().start();
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		textField.setText("");
		textField.requestFocus();
		
		if("quit".equals(message)) {
			finish();
		} else {
			pw.println("message:" + message);
		}
	}
	
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		pw.println("quit");
		
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread{
		@Override
		public void run() {
			try {
				while(true) {
					String data = br.readLine();
					
					if(socket.isClosed()) {
						break;
					}
					
					updateTextArea(data);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
