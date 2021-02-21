import java.util.Objects;

    public class Car {

        private String carName;
        private Integer speed;

        public Car() {}

        public Car(String carName) {
            this.carName = carName;
        }

        public Car(String carName, Integer speed) {
            this.carName = carName;
            this.speed = speed;
        }

        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "carName='" + carName + '\'' +
                    ", speed=" + speed +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(carName, car.carName) && Objects.equals(speed, car.speed);
        }

        @Override
        public int hashCode() {
            return Objects.hash(carName);
        }

    }

