public class FileProcessor {
    public static void processFile(int fileNumber) throws InterruptedException {
        Thread current = Thread.currentThread();
        System.out.println(current.getName() + " Started file" + fileNumber + ".txt");

        Thread.sleep(1000);
        System.out.println(current.getName() + " completed file" + fileNumber + ".txt");
    }
}
