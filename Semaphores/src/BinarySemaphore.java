public class BinarySemaphore extends Semaphore {
    public BinarySemaphore() {
        super();
    }

    public BinarySemaphore(int initial) {
        //can only store a 0 or 1, if the initial is less than 1, set it as initial, else set it as 1.
        super((initial <= 1) ? initial : 1);
    }

    //overrides the v method, value may be incremented twice, an if statement checks this and stores the value as 1.
    @Override
    public synchronized void V() {
        value++;
        if (value > 1) {
            value = 1;
            //wakes a thread that is waiting.
            notify();
        }
    }
}

