import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Cliente {

	public static void main(String[] args) {
		File f = new File("/home/arquivo.txt");
		
		try {
			Socket socket = new Socket("192.168.0.18", 9696);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			System.out.print("Transferiando o arquivo " + f.getName());
			out.writeUTF(f.getName());
			out.writeLong(f.length());
			FileInputStream in = new FileInputStream(f);
			byte[] buf = new byte [4096];
			
			while (true) {
				int len = in.read(buf);
				if(len ==-1) break;
				out.write(buf, 0 , len);
			}
			out.close();
			socket.close();
			System.out.print("Pronto");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
