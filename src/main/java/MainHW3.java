import java.lang.reflect.Method;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Комментарий к домашнему заданию:
 * много времени потратил на класс для тестирования методов, в расчёте, что найду
 * хотя бы 3 штуки. В итоге, так увлёкся, что адекватным получился только способ тестирования.
 * На большее не хватает времени. Надеюсь, скоро смогу собрать машину, которая не будет думать
 * полчаса над каждым вводимым символом)
 */

public class MainHW3 {

    public static void main(String[] args) {
        TestClass.uniMethod(MainHW3::searchLose);

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

}
