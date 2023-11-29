public class Main {
    public static void main(String[] args) {

        Car car = new Car("Bentley", "Bentayga I", 2015);
        System.out.println(car.information());

        car.technicalInspection();

        System.out.println();

        Driver driver = new Driver("Сергей", 10, null);

        Car assignCar = new Car("Volkswagen ", "Passat B8", 2013);
        driver.assign(assignCar);

        Car releasCar = new Car("Peugeot", "e-208 allure", 2020);
        driver.release(releasCar);

        System.out.println();

        FleetManager fleetManager = new FleetManager("Дмитрий", null);

        Car car1 = new Car("Toyota", "Camry", 2020);

        Driver driver1 = new Driver("Иван", 5, null);

        fleetManager.addCar(car1);
        fleetManager.appoint(driver1, car1);

        System.out.println();

        Fleet fleet = new Fleet("Антон", "ул. Пушкина 4", new String[]{"Владимир", "Матвей", "Игорь"});
        fleet.addManager("Андрей");


        String name = fleet.search("Антон");
        if (name != null) {
            System.out.println("Имя " + name + " есть в списке");
        } else {
            System.out.println("Данного имени нет в списке");
        }


    }
}