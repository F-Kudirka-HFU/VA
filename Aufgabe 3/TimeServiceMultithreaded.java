import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServiceMultithreaded extends Thread {
    private Socket s;
    private static int i = 0;
    private boolean clientConnected = true;

    public TimeServiceMultithreaded(ServerSocket serverSocket) throws IOException {
        this.s = serverSocket.accept();
    }

    private void startTimeService() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.s.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
        writer.write("time service");
        writer.newLine();
        writer.flush();
        String received = reader.readLine();
        System.out.println("Command received: " + received);
        switch (received) {
            case "date":
                writer.write(Clock.date());
                writer.newLine();
                writer.flush();
                break;
            case "time":
                writer.write(Clock.time());
                writer.newLine();
                writer.flush();
                break;
            default:
                this.s.close();
                this.clientConnected = false;
                break;
        }
    }

    @Override
    public void run() {
        int tempI = i;
        System.out.println("Thread " + tempI + " started.");
        System.out.println("Client connected.");
        i++;
        while (this.clientConnected) {
            try {
                this.startTimeService();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + tempI + " stopped.");
        i--;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(75);
        System.out.println("Server started.");
        while (true) {
            new TimeServiceMultithreaded(serverSocket).start();
        }
    }
}
