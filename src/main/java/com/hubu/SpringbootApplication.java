package com.hubu;

import com.hubu.socket.SocketThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class  SpringbootApplication {

	@Autowired
	SocketThread socketThreadTemp;

	static SocketThread socketThread;

	@Value("${sorcketPort}")
	String sorcketPortTmep;

	static String sorcketPort;

	@PostConstruct
	public void init(){
		socketThread = socketThreadTemp;
		sorcketPort = sorcketPortTmep;
	}

	public SocketThread getSocketThread() {
		return socketThread;
	}

	public void setSocketThread(SocketThread socketThread) {
		this.socketThread = socketThread;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		socketRun();
	}

	public  static void socketRun(){

		try
		{
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(sorcketPort));
			System.out.println("等待。。。");

			while (true)
			{
				//
				Socket socket = serverSocket.accept();

				socketThread.setSocket(socket);

				new Thread(socketThread).start();

			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
