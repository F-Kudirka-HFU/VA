import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket s = serverSocket.accept();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer.write("time service");
        writer.newLine();
        writer.flush();
        System.out.println("Server started");
        while(true) {
                String received = reader.readLine();
                System.out.println("Telnet reception: " + received);
                if (received.equals("date")) {
                    writer.write(Clock.date());
                    writer.newLine();
                } else if (received.equals("time")) {
                    writer.write(Clock.time());
                    writer.newLine();
                } else if (received != null) {
                    s.close();
                    s = serverSocket.accept();
                    writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    writer.write("time service");
                    writer.newLine();
                }
                writer.flush();
            }
        }
    }


