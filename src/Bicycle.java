// Класс для описания велосипеда
final class Bicycle extends Transport {
    public Bicycle(String name) {
        super(name, 0, FuelType.ELECTRIC); // Велосипед не имеет мощности, используем электрический
    }

    @Override
    public String getInfo() {
        return "Велосипед: " + name + ", Мощность: " + power + " л.с., Топливо: " + fuelType;
    }
}
