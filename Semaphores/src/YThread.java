
public class YThread extends Thread {
    private BinarySemaphore X;
    private BinarySemaphore Y;
    private Semaphore Z;

    public YThread(BinarySemaphore y, BinarySemaphore x, Semaphore z) {
        X = x;
        Y = y;
        Z = z;
    }

    public void run() {
        while (true) {
            try {
                Z.P();
                Y.P();
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println("Y");
            } catch (InterruptedException e) {
            }
            X.V();
        }
    }
}

