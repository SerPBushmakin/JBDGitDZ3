// Класс для описания велосипеда
final class Bicycle extends Transport {
    public Bicycle(String name) {
        super(name, 0, FuelType.ELECTRIC); // для Велосипеда используем только электричество
    }

    @Override
    public String getInfo() {
        return "Велосипед: " + name + ", Мощность: " + power + " л.с., Топливо: " + fuelType;
    }
}
