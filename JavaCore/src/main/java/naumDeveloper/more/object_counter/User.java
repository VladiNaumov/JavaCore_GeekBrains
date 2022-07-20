package naumDeveloper.more.object_counter;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    int ID ;
    String Name;


    public User(String name) {
        Name = name;
        ID = COUNTER.getAndIncrement();
    }

    public User() {
        ID = COUNTER.getAndIncrement();

    }


    public int getRandomDiceNumber()
    {
        int random = (int )(Math.random() * 100 + 1);
        return random;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
