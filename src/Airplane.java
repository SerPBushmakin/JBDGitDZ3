// Класс для описания самолета
final class Airplane extends Transport {
    public Airplane(String name, int power, FuelType fuelType) {
        super(name, power, fuelType);
    }

    @Override
    public String getInfo() {
        return "Самолет: " + name + ", Мощность: " + power + " л.с., Топливо: " + fuelType;
    }
}
