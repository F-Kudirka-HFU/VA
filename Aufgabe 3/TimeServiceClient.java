import java.io.*;
import java.net.Socket;

public class TimeServiceClient {
    public static String dateFromServer(String s) throws IOException {
        Socket socket = new Socket(s, 75);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        reader.readLine();
        writer.write("date");
        writer.newLine();
        writer.flush();
        String r = reader.readLine();
        writer.write("exit");
        writer.newLine();
        writer.flush();
        socket.close();
        return r;
    }

    public static String timeFromServer(String s) throws IOException {
        Socket socket = new Socket(s, 75);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader((new InputStreamReader(socket.getInputStream())));
        reader.readLine();
        writer.write("time");
        writer.newLine();
        writer.flush();
        String r = reader.readLine();
        writer.write("exit");
        writer.newLine();
        writer.flush();
        socket.close();
        return r;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(TimeServiceClient.timeFromServer("localhost"));
        System.out.println(TimeServiceClient.dateFromServer("localhost"));
    }
}