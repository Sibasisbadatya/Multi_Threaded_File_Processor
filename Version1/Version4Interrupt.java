
public class Version4Interrupt {

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {

            for (int file = 1; file <= 100; file++) {

                try {
                    FileProcessor.processFile(file);
                } catch (InterruptedException e) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " received an interrupt signal"
                    );

                    // Restore the interrupt status before exiting.
                    Thread.currentThread().interrupt();
                    return;
                }
            }

        }, "Interruptible-Worker");

        worker.start();

        // Let the worker process for approximately 2.5 seconds.
        Thread.sleep(2500);

        System.out.println("Main thread requests cancellation");
        worker.interrupt();

        worker.join();

        System.out.println("Worker has terminated");
    }
}
