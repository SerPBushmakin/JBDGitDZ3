import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TransportManager {
    private static List<Transport> transports = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("Меню:");
            System.out.println("(1) - создать автомобиль");
            System.out.println("(2) - создать самолет");
            System.out.println("(3) - создать корабль");
            System.out.println("(4) - создать велосипед");
            System.out.println("(5) - показать созданный транспорт");
            System.out.println("(0) - выход");
            System.out.print("Введите Ваш выбор: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после числа
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите цифру от 0 до 5.");
                scanner.nextLine(); // Очистка буфера после ошибки
                continue; // перейти к началу цикла заново
            }

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

        scanner.close();
    }

    // Метод создания автомобиля с проверкой ввода и обработкой исключений
    private static void createCar(Scanner scanner) {
        try {
            String name = readNonEmptyString(scanner, "Введите название автомобиля: ");

            System.out.print("Введите мощность (л.с.): ");
            int power = readPositiveInt(scanner);

            System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
            FuelType fuelType = readFuelType(scanner);

            transports.add(new Car(name, power, fuelType));
            System.out.println("Автомобиль создан.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании автомобиля: " + e.getMessage());
            scanner.nextLine(); // Очистка буфера для последующих операций
        }
    }

    // Метод создания самолета с проверкой ввода и обработкой исключений
    private static void createAirplane(Scanner scanner) {
        try {
            String name = readNonEmptyString(scanner, "Введите название самолета: ");

            System.out.print("Введите мощность (л.с.): ");
            int power = readPositiveInt(scanner);

            System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
            FuelType fuelType = readFuelType(scanner);

            transports.add(new Airplane(name, power, fuelType));
            System.out.println("Самолет создан.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании самолета: " + e.getMessage());
            scanner.nextLine();
        }
    }

    // Метод создания корабля с проверкой ввода и обработкой исключений
    private static void createShip(Scanner scanner) {
        try {
            String name = readNonEmptyString(scanner, "Введите название корабля: ");
            System.out.print("Введите мощность (л.с.): ");
            int power = readPositiveInt(scanner);

            System.out.print("Введите тип топлива (1 - PETROL, 2 - DIESEL, 3 - ELECTRIC, 4 - HYBRID): ");
            FuelType fuelType = readFuelType(scanner);

            transports.add(new Ship(name, power, fuelType));
            System.out.println("Корабль создан.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании корабля: " + e.getMessage());
            scanner.nextLine();
        }
    }

    // Метод создания велосипеда с минимальной проверкой (т.к. не требует мощности)
    private static void createBicycle(Scanner scanner) {
        try {
            String name = readNonEmptyString(scanner, "Введите название велосипеда: ");
            transports.add(new Bicycle(name));
            System.out.println("Велосипед создан.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании велосипеда: " + e.getMessage());
            scanner.nextLine();
        }
    }

    // Метод вывода списка созданного транспорта
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

    // Вспомогательный метод для безопасного чтения положительного целого числа
    private static int readPositiveInt(Scanner scanner) {
        int value = -1;
        while (value <= 0) {
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                if (value <= 0) {
                    System.out.print("Введите положительное число: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка ввода. Введите целое число: ");
                scanner.nextLine(); // очистка буфера после некорректного ввода
            }
        }
        return value;
    }

    // Вспомогательный метод для безопасного чтения типа топлива с проверкой диапазона
    private static FuelType readFuelType(Scanner scanner) {
        int fuelChoice = -1;
        while (true) {
            try {
                fuelChoice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                if (fuelChoice < 1 || fuelChoice > FuelType.values().length) {
                    System.out.print("Неверный выбор топлива. Введите число от 1 до " + FuelType.values().length + ": ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка ввода. Введите число от 1 до " + FuelType.values().length + ": ");
                scanner.nextLine(); // очистка буфера
            }
        }
        return FuelType.values()[fuelChoice - 1];
    }

    // Вспомогательный метод чтения непустой строки с запросом
    private static String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Ошибка: поле не может быть пустым. Пожалуйста, введите значение.");
            }
        }
    }
}

