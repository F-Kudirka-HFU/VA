
public class Aufgabe1_2_Result {
    private int[] result;

    public Aufgabe1_2_Result (int n) {
        result = new int[n];
    }

   public synchronized void addResult (int add, int i) {
       result[i] = add;
       notify();
    }
    public synchronized int[] returnResult () {
        try {
            wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.result;
    }
}
