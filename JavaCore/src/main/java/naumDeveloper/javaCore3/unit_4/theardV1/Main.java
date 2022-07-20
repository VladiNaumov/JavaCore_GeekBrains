package naumDeveloper.javaCore3.unit_4.theardV1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Synchroniz packet = new Synchroniz();
        Transmitter transmitter = new Transmitter(packet);
        Receiver receiver = new Receiver(packet);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(transmitter);
        executorService.submit(receiver);

        executorService.shutdown();
    }
}
