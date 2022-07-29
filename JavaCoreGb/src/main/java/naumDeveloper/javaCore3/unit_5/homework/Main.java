package naumDeveloper.javaCore3.unit_5.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
	Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом (Car - 20\2.5, Truck - 60\15, Bus - 40\7.5) и уникальных значением для определения среди разных транспортных средств.
	Для каждого транспортного средства оставшиеся в баке количество топлива вычисляется раз в 3 сек.
	Создать до 10 экземпляров разных транспортных средств и запустить их в работу.
	Создать класс GasPool. Обладает максимальными запасом топлива 200f и методами: request(float amount) - для получения необходимого кол-ва топлива и info() - для выведения информации о фактическом состоянии.
	Создать класс FuelStaion. Обладает свойством GasPool.
	FuelStaion одновременно может заправлять только 3 автомобиля, остальные должны пока не освободится место (порядок не имеет значения).
	При заправке автомобиля запрашивается необходимое количество топливо, которое поступает из GasPool. Необходимое топливо для автомобиля вычисляется на основании формулы R = C - F, где С это объем бака, а F - фактическое состояние бака
	Заправка занимает 5 сек, зачем транспортное средство освобождает место
	* Транспортные средства должны выстраиваться в очередь, если нет свобожных мест для заправки и начинать заправку в строгом порядке своей очередь
	* Транспортные средства после заправки возвращаются на дорогу и продолжают свое движение
 */


public class Main {

    public static void main(String[] args) {

    	// количество одновременных заправок )
    	Semaphore semaphore = new Semaphore(3);
    	GasPool gasPool = new GasPool();
		FuelStaion fuelStaion = new FuelStaion(semaphore, gasPool);

		// Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом (Car - 20\2.5, Truck - 60\15, Bus - 40\7.5)

	    Car car1 = new Car("BMV", 20, 2.5F , 20.0F, fuelStaion);
	    Car car2 = new Car("GAZ",20,2.5F, 20F, fuelStaion);
	    Car car3 = new Car("VAZ", 20,2.5F, 20F, fuelStaion);


		Bus bus1 = new Bus("PAZ", 40,7.5F,60, fuelStaion);
		Bus bus2 = new Bus("KRAZ", 40,7.5F,60,fuelStaion);
		Bus bus3 = new Bus("MAN", 40,7.5F,60,fuelStaion);


		Track track1 = new Track("T002", 60,15,60,  fuelStaion);
		Track track2 = new Track("T003", 60,15,60,fuelStaion);
		Track track3 = new Track("T0045",60,15,60, fuelStaion);


		ExecutorService executorService = Executors.newFixedThreadPool(10);

     	executorService.submit(car1);
	    executorService.submit(car2);
	    executorService.submit(car3);


	    executorService.submit(bus1);
		executorService.submit(bus2);
		executorService.submit(bus3);

		executorService.submit(bus1);
		executorService.submit(bus2);
		executorService.submit(bus3);

		executorService.submit(track1);
	    executorService.submit(track2);
	    executorService.submit(track3);
		executorService.submit(track1);



		executorService.shutdown();

    }


}
