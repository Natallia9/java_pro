public class Driver {
    private String name;
    private int currentExperience;
    private Car currentCar;

    public Driver(String name, int currentExperience, String currentCar) {
        this.name = name;
        this.currentExperience = currentExperience;
    }

    public String getName() {
        return name;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void assign(Car car) {
        if (currentCar == null) {
            currentCar = car;
            System.out.println("Водитель " + name + " получил новый автомобиль: " + car.getModel());
        } else {
            System.out.println("Водитель " + name + " уже имеет автомобиль " + car.getModel());
        }
    }

    public void release(Car car){
        if (currentCar != null) {
            currentCar = null;
            System.out.println("Водитель " + name + " освободил автомобиль: " + currentCar.getModel());
        } else {
            System.out.println("У водителя " + name + " нет автомобиля для освобождения");
        }
    }
}

