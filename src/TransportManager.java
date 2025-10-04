import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportManager {
    private static List<Transport> transports = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("(1) - создать автомобиль");
            System.out.println("(2) - создать самолет");
            System.out.println("(3) - создать корабль");
            System.out.println("(4) - создать велосипед");
            System.out.println("(5) - показать созданный транспорт");
            System.out.println("(0) - выход");
            System.out.print("Введите Ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    createCar(scanner);
                    break;
                case 2:
                    createAirplane(scanner);
                    break;
                case 3:
                    createShip(scanner);
                    break;
                case 4:
                    createBicycle(scanner);
                    break;
                case 5:
                    showTransports();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 0);
    }

    private static void createCar(Scanner scanner) {
        System.out.print("Введите название автомобиля: ");
        String name = scanner.nextLine();
        System.out.print("Введите мощность (л.с.): ");
        int power = scanner.nextInt();
        System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
        FuelType fuelType = FuelType.values()[scanner.nextInt() - 1];
        transports.add(new Car(name, power, fuelType));
        System.out.println("Автомобиль создан.");
    }

    private static void createAirplane(Scanner scanner) {
        System.out.print("Введите название самолета: ");
        String name = scanner.nextLine();
        System.out.print("Введите мощность (л.с.): ");
        int power = scanner.nextInt();
        System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
        FuelType fuelType = FuelType.values()[scanner.nextInt() - 1];
        transports.add(new Airplane(name, power, fuelType));
        System.out.println("Самолет создан.");
    }

    private static void createShip(Scanner scanner) {
        System.out.print("Введите название корабля: ");
        String name = scanner.nextLine();
        System.out.print("Введите мощность (л.с.): ");
        int power = scanner.nextInt();
        System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
        FuelType fuelType = FuelType.values()[scanner.nextInt() - 1];
        transports.add(new Ship(name, power, fuelType));
        System.out.println("Корабль создан.");
    }

    private static void createBicycle(Scanner scanner) {
        System.out.print("Введите название велосипеда: ");
        String name = scanner.nextLine();
        transports.add(new Bicycle(name));
        System.out.println("Велосипед создан.");
    }

    private static void showTransports() {
        if (transports.isEmpty()) {
            System.out.println("Нет созданного транспорта.");
        } else {
            System.out.println("Созданный транспорт:");
            for (Transport transport : transports) {
                System.out.println(transport.getInfo());
            }
        }
    }
}
