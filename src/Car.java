// Класс для описания автомобиля
final class Car extends Transport {
    public Car(String name, int power, FuelType fuelType) {
        super(name, power, fuelType);
    }

    @Override
    public String getInfo() {
        return "Автомобиль: " + name + ", Мощность: " + power + " л.с., Топливо: " + fuelType;
    }
}
