import java.io.PrintWriter;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;


public class Cliente {

	public static void main(String[] args) {
		File f = new File("C:/users/e-tnovaes/teste/teste.txt");
		File novoDiretorio = new File ("C:/users/e-tnovaes/teste");
		novoDiretorio.mkdir();

		try {
			Socket socket = new Socket("10.26.21.25", 9696);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			System.out.print("Criando Diretório " + f.getName());
			PrintWriter fw = new PrintWriter(f);
			FileInputStream in = new FileInputStream(f);
			fw.write("teste prova de fogo");
			fw.close();
			byte[] buf = new byte [4096];

			while (true) {
				int len = in.read(buf);
				if(len == -1) break;
				out.write(buf, 0 , len);
			}
			out.close();
			socket.close();
			System.out.println("Pronto");

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
