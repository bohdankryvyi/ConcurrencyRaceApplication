import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class RaceMain {

    public static void main(String... args) {
        //Executor service for creating some threads (Thread pool) - 10 in my case
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //Create an instance of our task
        Callable<Car> racing = new Race();

        //20 second we will have for a race. Write models into list each second
        for (int i = 0; i < 20; i++) {
            List<Car> cars = new ArrayList<>();

            //Future interface that will return a result of task(Callable)
            List<Future<Car>> carRaces = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                //run 10 threads with a task (racing). Each task starts on submit()
                carRaces.add(executor.submit(racing));
            }

            //Return results from each thread (method call(Callable)) and write it to the list
            for (Future<Car> carRace : carRaces) {
                try {
                    cars.add(carRace.get());// Callable will return result only on get()
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("second: " + (i + 1));

            //use
            cars.stream().sorted(Comparator.comparing(Car::getSpeed).reversed()).limit(3).forEach(System.out::println);

            try {
                Thread.sleep(1000); // to return results each second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}