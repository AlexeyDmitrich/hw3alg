import java.util.Random;

public class TestClass {
    static Random rnd = new Random();

    interface Methods{
        int method (int[] arr);
    }

    public static int[][] myDatabase (int manualSize){
        int[][] myDatabase = new int[6][];
        myDatabase[0] = generator(rnd.nextInt(manualSize));
        myDatabase[1] = new int[] {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // => 11
        myDatabase[2] = new int[] {1, 2, 4, 5, 6};  // => 3
        myDatabase[3] = new int[] {2, 3, 4, 5, 6, 7, 8}; // => 1
        myDatabase[4] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // => 15
        myDatabase[5] = new int[] { }; // => 1

        return myDatabase;
    }

    /**
     * метод для генерации случайного массива от 1 до n с одни пропущеным значением
     * @param len
     * @return
     */
    public static int[] generator(int len){
        int length = len;
        int[] arr = new int[length];
        int xNumber = (rnd.nextInt(length - 2) + 2);
        if (xNumber >= 0 && xNumber <= length) {
            int start = 1;

            for (int i = 0; i < xNumber; i++) {
                arr[i] = start;
                start++;
            }
            start++;
            for (int i = xNumber; i < arr.length; i++) {
                arr[i] = start;
                start++;
            }
        }
        else {
            generator(length);
        }
        return arr;
    }

    static void uniMethod (TestClass.Methods function){
        int[][] data = myDatabase(48);
        System.out.println("Тест для ручной проверки");
        for (int num: data[0]) {
            System.out.print(num + " ");
        }
        int res0 = function.method(data[0]);

        System.out.println("\nВ массиве пропущено число "+ res0);

        System.out.println("Тест №1");
        int res1 = function.method(data[1]);
        if (res1 == 11) {
            System.out.println("Пройден успешно");
        } else {
            System.out.println("Провален! \nОжидаемый результат: 11, " +
                    "\n Получен результат: " + res1);
        }
        System.out.println("Тест №2");
        int res2 = function.method(data[2]);
        if (res2 == 3) {
            System.out.println("Пройден успешно");
        } else {
            System.out.println("Провален! \nОжидаемый результат: 3, " +
                    "\n Получен результат: " + res2);
        }

        System.out.println("Тест №3");
        int res3 = function.method(data[3]);
        if (res3 == 1) {
            System.out.println("Пройден успешно");
        } else {
            System.out.println("Провален! \nОжидаемый результат: 1, " +
                    "\n Получен результат: " + res3);
        }

        System.out.println("Тест №4");
        int res4 = function.method(data[4]);
        if (res4 == 15) {
            System.out.println("Пройден успешно");
        } else {
            System.out.println("Провален! \nОжидаемый результат: 15, " +
                    "\n Получен результат: " + res4);
        }

        System.out.println("Тест №5");
        int res5 = function.method(data[5]);
        if (res5 == 1) {
            System.out.println("Пройден успешно");
        } else {
            System.out.println("Провален! \nОжидаемый результат: 1, " +
                    "\n Получен результат: " + res1);
        }

    }
}
