import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

public class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол):");
        String input = scanner.nextLine();

        try {
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new InvalidDataFormatException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            // Здесь можно добавить дополнительные проверки форматов данных и создание исключений при несоответствии

            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender);
            writer.newLine();
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
