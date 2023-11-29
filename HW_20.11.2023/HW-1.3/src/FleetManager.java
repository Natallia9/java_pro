public class FleetManager {
    private String name;
    private Car[] listOfCar;
    private Driver[] listOfDrivers;

    public FleetManager(String name, String[] listOfCar) {
        this.name = name;
        this.listOfCar = new Car[5];
        this.listOfDrivers = new Driver[5];
    }

    public String getName() {
        return name;
    }

    public Car[] getListOfCar() {
        return listOfCar;
    }

    public Driver[] getListOfDrivers() {
        return listOfDrivers;
    }

    public void addCar(Car newCar) {
        for (int i = 0; i < listOfCar.length; i++) {
            if (listOfCar[i] == null) {
                listOfCar[i] = newCar;
                System.out.println("Автомобиль " + newCar.getMake() + " добавлен");
                return;
            }
        }
        System.out.println("Нельзя добавить автомобиль");
    }

    public void appoint(Driver driver, Car car) {
        if (driver != null && car != null) {
            driver.assign(car);
            System.out.println("Автомобиль" + car.getModel() + " назначен водитель " + driver.getName());
        } else {
            System.out.println("Невозможно назначить автомобиль");
        }
    }

}
