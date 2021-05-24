public class Lc {
    public static int pos = 0;
    public static void rumpf() {
        for (int i=0; i<10000; i++) {
            pos++;
            if (pos == 10) { pos= 0; }
        }
    }
    public static void main(String[] args) {
        Thread t2 = new Thread(new Runnable() {
            @Override public void run() { rumpf(); }
        });
        t2.start();
        rumpf();
    }
}