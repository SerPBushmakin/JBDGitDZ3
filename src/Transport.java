// Абстрактный класс для описания транспорта
sealed abstract class Transport permits Car, Airplane, Ship, Bicycle {
    protected String name;
    protected int power; // мощность в л.с.
    protected FuelType fuelType; // тип топлива

    // Конструктор
    public Transport(String name, int power, FuelType fuelType) {
        this.name = name;
        this.power = power;
        this.fuelType = fuelType;
    }

    // Метод для получения информации о транспорте
    public abstract String getInfo();
}
