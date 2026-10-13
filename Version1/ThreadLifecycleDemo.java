public class ThreadLifecycleDemo {
    static void main() throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Lifecycle-Worker");
        System.out.println(worker.getState());
        worker.start();
        Thread.sleep(1000);//if not sleep then getState() can return RUNNABLE
        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        worker.join();

        System.out.println(worker.getState()); // TERMINATED
        System.out.println(worker.isAlive());// false
    }


}
