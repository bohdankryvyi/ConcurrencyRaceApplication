import java.util.Random;
import java.util.concurrent.Callable;

public class Race implements Callable<Car> {

    @Override
    public Car call() throws Exception {

        //Our task to generate random speed for cars. Task will be run in a new thread each time
        //It will return Car model (Thread name ( as a car name) and a random speed (20+ km/h))
        Random random = new Random();
        return new Car(Thread.currentThread().getName(), 20 + random.nextInt(120));
    }

}