package naumDeveloper.javaCore3.unit_4.theardV1;

//ПОЛУЧАТЕЛЬ
public class Receiver implements Runnable {
    private Synchroniz packet;

    public Receiver(Synchroniz packet) {
        this.packet = packet;
    }

    @Override
    public void run() {
        for (String str = packet.receive(); !"-EOP".equals(str); str = packet.receive()) {
            System.out.println(String.format("[%s] Message received: %s", Thread.currentThread().getName(), str));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("EOD reached...");
    }
}
