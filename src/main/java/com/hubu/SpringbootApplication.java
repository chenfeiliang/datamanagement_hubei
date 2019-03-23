package com.hubu;

import com.hubu.socket.SocketThread;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class  SpringbootApplication {

	@Autowired
	SocketThread socketThreadTemp;

	static SocketThread socketThread;

	@Value("${sorcket.port}")
	String sorcketPortTmep;

	static String sorcketPort;

	@Autowired
	private BeanFactory beanFactory1;

	static BeanFactory beanFactory2;

	@PostConstruct
	public void init(){
		socketThread = socketThreadTemp;
		sorcketPort = sorcketPortTmep;
		beanFactory2 = beanFactory1;
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
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		//int clienNo = 1 ;
		try
		{
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(sorcketPort));

			System.out.println("等待客户端链接。。。");

			while (true)
			{
				//
				Socket socket = serverSocket.accept();

				SocketThread socketThread = beanFactory2.getBean(SocketThread.class);

				socketThread.setSocket(socket);

				//socketThread.setClientNo(clienNo);

				executorService.execute(socketThread);

				//clienNo++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
