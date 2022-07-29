package naumDeveloper.javaCore1.unit_6.myauto.auto;

public interface Car {

    void move(); // Я могу реолезовать этот метод в классах которые унаследуются от него

    abstract void test(); // Я обязан реолезовать этот метод в классах которые унаследуются от него
}
