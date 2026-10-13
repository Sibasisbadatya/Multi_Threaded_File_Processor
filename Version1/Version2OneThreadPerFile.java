public class Version2OneThreadPerFile {
    static void main() {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 100; i++) {

            final int fileNumber = i;

            Thread thread = new Thread(() -> {
                try {
                    FileProcessor.processFile(fileNumber);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " was interrupted"
                    );
                }
            });

            thread.setName("File-Thread-" + fileNumber);

            // Demonstrate thread priority
            thread.setPriority(Thread.NORM_PRIORITY);

            thread.start();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(
                "Total time: " + (endTime - startTime) / 1000.0 + " seconds"
        );

        System.out.println("Main method finished creating threads");
    }
}
