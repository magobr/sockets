import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serv = new ServerSocket(9696);
			while(true) {
				System.out.println("Aguarde o Cliente....");
				Socket socket = serv.accept();
				System.out.println("Cliente Logado");
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

				byte[] buf = new byte[4096];
				while(true) {
					int len = in.read(buf);
					if(len == -1) break;

				}

				System.out.println("Arquivo Recebido");
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
