import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static DataOutputStream dataOutputStream = null;
	private static DataInputStream dataInputStream = null;

	public static void main(String[] args)
	{
		// creating server socket at port 5000
		try (ServerSocket serverSocket
			= new ServerSocket(5000)) {
			System.out.println(
				"Server is Starting in Port 5000");
			// Accepting the client using the client accept method ; 

			Socket Client = serverSocket.accept();
			System.out.println("Connected");
			dataInputStream = new DataInputStream(
				Client.getInputStream());
			dataOutputStream = new DataOutputStream(
				Client.getOutputStream());
			
			// file
			receiveFile("Change.txt");

			dataInputStream.close();
			dataOutputStream.close();
			Client.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// receive file function is start here

	private static void receiveFile(String fileName)
		throws Exception
	{
		int variables = 0;
		FileOutputStream fileOutputStream
			= new FileOutputStream(fileName);

		long length
			= dataInputStream.readLong(); 
		byte[] buffer = new byte[4 * 1024];
		while ( length > 0
			&& (variables = dataInputStream.read(
					buffer, 0,
					(int)Math.min(buffer.length, length)))
					!= -1) {
			// we are writing the file using write method ; 
			fileOutputStream.write(buffer, 0, variables);
		 length -= variables; // read upto file length
		}
		// Here we have received the file 
		System.out.println("File is Received");
		fileOutputStream.close();
	}
}

