package naumDeveloper.javaCore2.unit_2;

public class MyArrayDataException extends Exception{
    MyArrayDataException(int row, int col) {
        super(String.format("Invalid data in %d row, %d column", row, col));
    }

}
