package naumDeveloper.javaCore3.unit_1.homework.fruit_apple_orange;

public class Apples extends Fruit {


    public Apples(int maara, int massa) {
        super(maara, massa);
    }

    @Override
    public int getMassa() {
        int fullMassa= maara * massa;
        return fullMassa;
    }
}
