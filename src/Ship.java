// Класс для описания корабля
final class Ship extends Transport {
    public Ship(String name, int power, FuelType fuelType) {
        super(name, power, fuelType);
    }

    @Override
    public String getInfo() {
        return "Корабль: " + name + ", Мощность: " + power + " л.с., Топливо: " + fuelType;
    }
}
