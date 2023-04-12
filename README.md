# Исключения в программировании и их обработка (семинары)
## Урок 2. Исключения и их обработка


1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. <br><br>
2. Если необходимо, исправьте данный код
   *<br><br> try {
   <br> int d = 0;
   <br> double catchedRes1 = intArray[8] / d;
   <br> System.out.println("catchedRes1 = " + catchedRes1);
   <br> } catch (ArithmeticException e) {
   <br> System.out.println("Catching exception: " + e);
   <br> }* <br><br>
3. Дан следующий код, исправьте его там, где требуется
   *<br><br> public static void main(String[] args) throws Exception {
   <br><br> try {
   <br> int a = 90;
   <br> int b = 3;
   <br> System.out.println(a / b);
   <br> printSum(23, 234);
   <br> int[] abc = { 1, 2 };
   <br> abc[3] = 9;
   <br> } catch (Throwable ex) {
   <br> System.out.println("Что-то пошло не так...");
   <br> } catch (NullPointerException ex) {
   <br> System.out.println("Указатель не может указывать на null!");
   <br> } catch (IndexOutOfBoundsException ex) {
   <br> System.out.println("Массив выходит за пределы своего размера!");
   <br> }
   <br> }
   <br><br> public static void printSum(Integer a, Integer b) throws FileNotFoundException {
   <br> System.out.println(a + b);
   <br> }* <br><br>

4. Исправьте код, примените подходящие способы обработки исключений:
*<br><br> public static void main(String[] args) {
<br> InputStream inputStream;
<br> try {
<br> String[] strings = {"apple", "orange"};
<br> String strings1 = strings[2];
<br> test();
<br> int a = 1 / 0;
<br> inputStream = new FileInputStream("/broken_reference");
<br> } catch (ArithmeticException e) {
<br> e.printStackTrace();
<br> System.out.println("На ноль делить нельзя");
<br> }
<br> catch (Throwable e) {
<br> e.printStackTrace();
<br> } catch (StackOverflowError error) {
<br> System.out.println("Что-то сломалось");
<br> } finally {
<br> System.out.println("Я все равно выполнился");
<br> }
<br> System.out.println("Я жив!");
<br> }
<br><br> private static void test() throws IOException {
<br> File file = new File("1");
<br> file.createNewFile();
<br> FileReader reader = new FileReader(file);
<br> reader.read();
<br> test();
<br> }* 
