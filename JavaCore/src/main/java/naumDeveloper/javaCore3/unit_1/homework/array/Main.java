package naumDeveloper.javaCore3.unit_1.homework.array;

public class Main {

    public static void main(String[] args) {
        IArray array = new MyArray();
        int[] nums = { 1, 2, 3, 5 };
        System.out.println(array.setArrayList(nums));

        IMove move = new Move();
        int[] num = { 6, 7 };
        System.out.println(move.myMove(num));


        

    }
}
