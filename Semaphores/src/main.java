public class main {
    public static void main(String[] args) {
        BinarySemaphore X = new BinarySemaphore(1);
        BinarySemaphore Y = new BinarySemaphore(0);
        Semaphore Z = new Semaphore(0);

        //makes the threads
        XThread xThread = new XThread(X,Y,Z);
        YThread yThread = new YThread(Y,X,Z);
        ZThread zThread = new ZThread(Z);

        //start the threads.
        xThread.start();
        yThread.start();
        zThread.start();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) { }
        System.exit(0);

    }
}
