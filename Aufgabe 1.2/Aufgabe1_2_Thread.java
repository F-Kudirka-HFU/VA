public class Aufgabe1_2_Thread extends Thread {
    private Aufgabe1_2_Result r;
    private Aufgabe1_2_F f;
    private int x;
    private int i;

    public Aufgabe1_2_Thread(Aufgabe1_2_Result r, Aufgabe1_2_F f, int x, int i) {
        this.r = r;
        this.f = f;
        this.x = x;
        this.i = i;
    }
    @Override
    public void run() {
        int result = this.f.f(x);
        r.addResult(result, i);
    }
}
