public class Aufgabe1_1 {
    static void eieruhr (int ms, String txt) {
        Aufgabe1_1_Thread t = new Aufgabe1_1_Thread(ms, txt);
        t.start();
    }
    public static void main (String args[]) {
    eieruhr(5000, "Fertig");
    }
}
