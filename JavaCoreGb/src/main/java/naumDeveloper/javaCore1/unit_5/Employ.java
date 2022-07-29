package naumDeveloper.javaCore1.unit_5;

public class Employ {

    //ФИО, должность, email, телефон, зарплата, возраст;
    private String fullName;
    private String position;
    private String email;
    private int phone;
    private int salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Employ(){

    };
    public Employ(String fullName, String position, String email, int phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


public void print(){
        System.out.println( "fullName- " + fullName + " position- "  +  position + " email- " + email + " phone-  " + phone + " salary-  " + salary + " age- " + age);

}


    @Override
    public String toString() {
        return "Employ{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }


}
