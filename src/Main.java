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

        System.out.println(">> " + getFloat());

    }

    private static float getFloat() {
        boolean askUser = true;
        float number = 0;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (askUser) {
            System.out.print("Enter the float number > ");
            String getFromUser = scanner.nextLine().replace('.',',');

            try {
                Scanner scanner1 = new Scanner(getFromUser);

                if (!scanner1.hasNextFloat()) {
                    throw new IllegalArgumentException("Incorrect Input");
                }

                number = scanner1.nextFloat();
                askUser = false;
                scanner1.close();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown error");
            }
        }
        scanner.close();
        return number;
    }
}