import java.util.Random;

/**
 * description:
 * 1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число. Постарайтесь придумать более оптимальный (асимптотически) алгоритм. Примеры:
 *
 * 1. [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
 * 2. [1, 2, 4, 5, 6] => 3
 * 3. [2, 3, 4, 5, 6, 7, 8] => 1
 * 4. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] => 15
 * 5. [] => 1
 *
 * 2. *Попробуйте реализовать двунаправленную очередь (чтобы элементы можно было добавлять и удалять не только в начало (из начала), но и в конец (с конца))
 */

public class MainHW3 {
    public static void main(String[] args) {
        int[] test = generator(15);
        for (int num:
             test) {
            System.out.print(num + ", ");
        }
    }

    /**
     * метод для генерации случайного массива от 1 до n с одни пропущеным значением
     * @param length
     * @return
     */
    public static int[] generator(int length){
        Random rnd = new Random();
        int xNumber = rnd.nextInt(length);
        int start = 1;
        int[] arr = new int[length];
        for (int i = 0; i < xNumber; i++) {
            arr[i] = start;
            start ++;
        }
        start++;
        for (int i = xNumber+1; i < arr.length; i++) {
            arr[i] = start;
            start++;
        }



        return arr;
    }
}
