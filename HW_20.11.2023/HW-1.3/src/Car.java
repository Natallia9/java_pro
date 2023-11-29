public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String information() {
        return "Информация об Автомобиле\n" +
                "Марка: " + make + '\n' +
                "Модель: " + model + '\n' +
                "Год выпуска: " + year;
    }

    public void technicalInspection() {
        int thisYear = 2023;
        int yearInspect = 2022;
        System.out.println("Техосмотр был пройден в " + yearInspect + " году");
        if (thisYear - year < 4) {
            System.out.println("Автомобиль младше четырех лет. Техосмотр не требуется");
        } else if (thisYear - year == yearInspect) {
            System.out.println("Техосмотр пройден в этом году");
        } else {
            System.out.println("Требуется техосмотр");
        }

    }

}
