public class XThread extends Thread {

    private  BinarySemaphore X;
    private BinarySemaphore Y;
    private Semaphore Z;

    public XThread(BinarySemaphore x, BinarySemaphore y, Semaphore z) {
        X = x;
        Y = y;
        Z = z;
    }

    public  void run() {
        while(true) {
            try {
                //Z and X threads both use the acquired methods at the same time to ensure the number of X's and Y's don't exceed the number of Z's.
                Z.P();
                X.P();
                //makes the thread sleep for a random amount of time before printing it's statement.
                Thread.sleep((long)(Math.random() * 1000));
                System.out.println("X");
            }
            catch (InterruptedException e) { }
            //X thread has finished its run statement. Y thread is now set to one, unlocking the run statement.
            Y.V();
        }
    }
}
