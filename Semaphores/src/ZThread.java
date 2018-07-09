public class ZThread extends Thread {
    private Semaphore Z;

    public ZThread(Semaphore z) {
        Z = z;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) { }
            System.out.println("Z");
            Z.V();
        }
    }

}
