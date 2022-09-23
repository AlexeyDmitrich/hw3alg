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
    static Random rnd = new Random();

    public static void main(String[] args) {
        quickTest();

    }

    /**
     * Метод для быстрой обкатки работоспособности
     */
    static void quickTest (){
        //int[] test = generator(rnd.nextInt(48));
         int[] test1 = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // => 11
         int[] test2 = {1, 2, 4, 5, 6};  // => 3
         int[] test3 = {2, 3, 4, 5, 6, 7, 8}; // => 1
         int[] test4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // => 15
         int[] test5 = { }; // => 1

        for (int num: test5) {
            System.out.print(num + " ");
        }

        System.out.println();
        int res = searchLose(test5);
        System.out.println("В массиве пропущено число " + res);
    }

    /**
     * Самое очевидное решение поиска - идти подряд по всем элементам
     * @param array на вход принимаем массив
     * @return возвращаем пропущенное число
     */
    public static int searchLose (int[] array){
        int searchedNum = 0;
        if (array.length < 2 || array[0] != 1){    // проверяем, вдруг нам повезло получить пустой массив, или массив без 1
            searchedNum = 1;
            return searchedNum;
        }
        for (int i = 1; i < array.length; i++) {     // проходим по всем элементам массива, сравнивая их с предыдущими
            if ((array[i] - array[i-1]) != 1) {     // если видим скачек больше единицы - пропавшее число там
                searchedNum = array[i] - 1;
                return searchedNum;
            }
        }
        searchedNum = array.length + 1;    // если пропавшего числа не нашлось, значит оно было последним
        return searchedNum;
    }

    /**
     * метод для генерации случайного массива от 1 до n с одни пропущеным значением
     * @param length
     * @return
     */
    public static int[] generator(int length){
        int xNumber = (rnd.nextInt(length-2)+2);
        int start = 1;
        int[] arr = new int[length];
        for (int i = 0; i < xNumber; i++) {
            arr[i] = start;
            start ++;
        }
        start++;
        for (int i = xNumber; i < arr.length; i++) {
            arr[i] = start;
            start++;
        }
        return arr;
    }
}
