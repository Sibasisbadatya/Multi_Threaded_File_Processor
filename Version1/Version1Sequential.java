public class Version1Sequential {
    static void main() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for(int i=1;i<=10;i++){
            FileProcessor.processFile(i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(
                "Total time: " + (endTime - startTime) / 1000.0 + " seconds"
        );
    }
}
