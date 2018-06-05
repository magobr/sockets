import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serv = new ServerSocket(9696);
			while(true) {
				System.out.println("Aguarde o Cliente....");
				Socket socket = serv.accept();
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				String fileName = in.readUTF();
				long size = in.readLong();
				FileOutputStream fos = new FileOutputStream(fileName);
				byte[] buf = new byte[4096];
				while(true) {
					int len = in.read(buf);
					if(len == -1) break;
					
					fos.write(buf , 0 , len);
				}
				fos.flush();
				fos.close();
				System.out.print("Arquivo Recebido");
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
