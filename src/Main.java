import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
          HW2. Task1
         Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
         и возвращает введенное значение.
         Ввод текста вместо числа не должно приводить к падению приложения,
         вместо этого, необходимо повторно запросить у пользователя ввод данных.
         */

        System.out.println(">> " + askFloat());

    }

    private static float askFloat() {
        boolean askUser = true;
        float number = 0;
        while (askUser) {
            System.out.print("Enter the float number > ");
            try {
                Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

                if (!scanner.hasNextFloat()) {
                    throw new IllegalArgumentException("Incorrect Input");
                }

                number = scanner.nextFloat();
                askUser = false;
                scanner.close();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown error");
            }
        }
        return number;
    }
}