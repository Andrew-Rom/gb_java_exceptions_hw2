import java.io.*;
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

        System.out.println("\nTask 1");
        System.out.println(">> " + getFloat());


        /*
        HW2. Task2
         */

        System.out.println("\nTask 2");

        int[] intArray = null; // Return "Catching exception: "Array is null"
//        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7}; // Return "Catching exception: "Array Index is Out Of Bounds"
//        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8}; // Return "Catching exception: / by zero"


        try {

            if (intArray == null) {
                throw new NullPointerException("Array is null");
            }

            int d = 0;
            if (intArray.length > 8) {
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } else {
                throw new IndexOutOfBoundsException("Array Index is Out Of Bounds");
            }
        } catch (NullPointerException | IndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Catching exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error");
        }



        /*
        HW2. Task3
         */

        System.out.println("\nTask 3");

        try {
            int a = 90;
            int b = 3;
            if (b == 0) {
                throw new ArithmeticException("dividing by zero is invalid");
            }
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }



        /*
        HW2. Task4
         */

        System.out.println("\nTask 4");

        InputStream inputStream = null;
        try {
            String[] strings = {"apple", "orange"};
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("/broken_reference");
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            System.out.println("Invalid ask to array");
        } catch (IOException e) {
            System.out.println("Invalid operation with file");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("На ноль делить нельзя");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("Я все равно выполнился");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Exception while close");
                }
            }
        }
        System.out.println("Я жив!");
        
    }

    private static float getFloat() {
        boolean askUser = true;
        float number = 0;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (askUser) {
            System.out.print("Enter the float number > ");
            String getFromUser = scanner.nextLine().replace('.', ',');

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


    public static void printSum(Integer a, Integer b) {
        try {
            if (a == null || b == null) {
                throw new NullPointerException("Указатель не может указывать на null!");
            }
            System.out.println(a + b);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void test() {
        File file = new File("1");
        FileReader reader = null;
        try {
            file.createNewFile();
            reader = new FileReader(file);
        } catch (RuntimeException | IOException exception) {
            System.out.println("Invalid operation with file");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Exception while close");
                }
            }
        }
    }

}