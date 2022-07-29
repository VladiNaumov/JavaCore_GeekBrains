package naumDeveloper.javaCore3.unit_4.homeWork;

public abstract class Thread {
    protected String nime;
    protected SinhronaizerManager manager;
    protected int counter = 5;


    public Thread(SinhronaizerManager manager) {
        this.manager = manager;
    }


}

