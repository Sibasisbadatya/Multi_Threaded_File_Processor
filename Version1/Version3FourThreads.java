public class Version3FourThreads {
    static void main() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] workers = new Thread[4];
        for (int i = 0; i < 4; i++) {

            final int startFile = i * 25 + 1;
            final int endFile = (i + 1) * 25;

            workers[i] = new Thread(() -> {

                for (int file = startFile; file <= endFile; file++) {
                    try {
                        FileProcessor.processFile(file);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(
                                Thread.currentThread().getName()
                                        + " stopped"
                        );
                        return;
                    }
                }

            }, "Worker-" + (i + 1));

            workers[i].start();
        }
        for(Thread worker:workers){
            worker.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(
                "All files processed in "
                        + (endTime - startTime) / 1000.0 + " seconds"
        );

    }
}
