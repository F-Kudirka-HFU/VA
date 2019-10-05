

public class Aufgabe1_2{
    public static int[] execute (Aufgabe1_2_F f, int n) {
        Aufgabe1_2_Result r = new Aufgabe1_2_Result(n);
        for (int i = 0; i<n; i++) {
            new Aufgabe1_2_Thread(r, f, i, i).start();
        }
        return r.returnResult();
    }
    public static void main (String[] args) {
        int n = 100;
        Aufgabe1_2_F f = new Aufgabe1_2_F();
        int[] array = Aufgabe1_2.execute(f, n);
        for (int element : array) {
            System.out.println(element);
        }
        System.out.println("Program completed.");
    }
}
