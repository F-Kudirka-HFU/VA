public class Aufgabe1_1_Thread extends Thread {
    private int ms;
    private String txt;
    public Aufgabe1_1_Thread(int ms, String txt) {
        this.ms = ms;
        this.txt = txt;
    }
        @Override
        public void run() {
            while(this.ms != -1000) {
                schlafen();
                System.out.println("Noch Zeit uebrig: " + this.ms);
                this.ms -=1000;
            }
            System.out.println(txt);
        }
        public void schlafen () {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException t) { }
        }
}
