package Exercise1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* 
 * Задание 1.
    * 1.
        Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
        Фамилия Имя Отчество датарождения номертелефона пол
        Форматы данных:
        фамилия, имя, отчество - строки

        дата_рождения - строка формата dd.mm.yyyy

        номер_телефона - целое беззнаковое число без форматирования

        пол - символ латиницей f или m.

        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

        <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

        Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

        Не забудьте закрыть соединение с файлом.

        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
    *
*/


public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите данные: ");
        String input = scanner.nextLine();
        
        String[] data = input.split(" ");
        
        if (data.length != 5) {
            System.out.println("Неверное количество данных");
            return;
        }
        
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        
        try {
            validateInput(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            saveDataToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static void validateInput(String lastName, String firstName, String middleName,
            String birthDate, String phoneNumber, String gender) {
        
        if (!isValidDate(birthDate)) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }
        
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
        
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }
    
    private static boolean isValidDate(String date) {
        return false;
    }
    
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return false;
    }
    
    private static boolean isValidGender(String gender) {
        return false;
    }
    
    private static void saveDataToFile(String lastName, String firstName, String middleName,
            String birthDate, String phoneNumber, String gender) throws IOException {
        
        String fileName = lastName + ".txt";
        FileWriter writer = null;
        
        try {
            writer = new FileWriter(fileName, true);
            String dataLine = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender + "\n";
            writer.write(dataLine);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}