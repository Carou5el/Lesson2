/*
1.  Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;

2.

 */

package geekbrains.lesson2Arrays;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//========================================================================
        /*  Задание 1.
            Задать целочисленный массив, состоящий из элементов 0 и 1.
            Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
            С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */

        // Генерация массива, заполненного случайным образом.
        int[] arrayFor1stTask = FillArrayRandomly(10, 2);

        System.out.println("Задание 1.");
        System.out.println("Содержимое массива.");
        PutArrayOnConsole(arrayFor1stTask, 0, arrayFor1stTask.length);

        // Инверсия элементов массива.
        for (int i = 0; i < arrayFor1stTask.length; i++)    {
            switch (arrayFor1stTask[i]) {
                case 1:
                    arrayFor1stTask[i] = 0;
                    break;
                case 0:
                    arrayFor1stTask[i] = 1;
                    break;
            }
        }
        System.out.println("Содержимое массива после инверсии.");
        PutArrayOnConsole(arrayFor1stTask, 0, arrayFor1stTask.length);
        System.out.println();

//========================================================================
        /*  Задание 2.
            Задать пустой целочисленный массив размером 8.
            С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
         */
        int[] arrayFor2ndTask = new int[8];

        for (int i = 0; i <= 7; i++)  {
            arrayFor2ndTask[i] = i * 3;             // Заполнение массива с помощью умножения на 3.
        }

        System.out.println("Задание 2.");
        System.out.println("Содержимое массива.");
        PutArrayOnConsole(arrayFor2ndTask, 0, arrayFor2ndTask.length);
        System.out.println();

//========================================================================
        /*  Задание 3.
            Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
            пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        int[] arrayFor3rdTask = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int rangeForCycle = arrayFor3rdTask.length;

        System.out.println("Задание 3.");
        System.out.println("Содержимое массива.");
        PutArrayOnConsole(arrayFor3rdTask, 0, arrayFor3rdTask.length);

        for (int i = 0; i < rangeForCycle; i++) {
            if (arrayFor3rdTask[i] < 6)   {
                arrayFor3rdTask[i] *= 2;
            }
        }

        System.out.println("Содержимое массива после *2 чисел < 6.");
        PutArrayOnConsole(arrayFor3rdTask, 0, arrayFor3rdTask.length);
        System.out.println();
//========================================================================
        /*  Задание 4.
            Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
            и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        */
        final int SIZE_SQUARE_ARRAY = 10;                    // Размер квадратного массива.

        int[][] arrayFor4thTask = new int[SIZE_SQUARE_ARRAY][SIZE_SQUARE_ARRAY];

        System.out.println("Задание 4.");

        for(int i = 0; i < SIZE_SQUARE_ARRAY; i++)    {

            int j1 = i;                                         // уравнение прямой y = x
            int j2 = -i + (SIZE_SQUARE_ARRAY - 1);              // уравнение прямой y = -x + b

            arrayFor4thTask[i][j1] = 1;                         // заполнение диагоналей "1",
            arrayFor4thTask[i][j2] = 1;                         // при инициализации массив заполнен "0"
        }

        // Красивый вывод в консоль.
        for (int i = 0; i < SIZE_SQUARE_ARRAY; i++) {
            for (int j = 0; j < SIZE_SQUARE_ARRAY; j++) {
                System.out.printf("%d ", arrayFor4thTask[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
//========================================================================
        /*  Задание 5.
            Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
        */
        final int SIZE_ARRAY = 8;                                       // Размер массива
        final int RND_RANGE = 100;                                      // Диапазон случ. чисел для заполнения

        int[] array5thTask;
        int maxArrayValue = 0;
        int minArrayValue = RND_RANGE;

        array5thTask =  FillArrayRandomly(SIZE_ARRAY, RND_RANGE);       // Заполнение массива случайно

        for (int d : array5thTask)  {
            if (d >= maxArrayValue) {
                maxArrayValue = d;
            }
            if (d <= minArrayValue) {
                minArrayValue = d;
            }
        }

        System.out.println("Задание 5.");
        System.out.println("Содержимое массива.");
        PutArrayOnConsole(array5thTask, 0, array5thTask.length);
        System.out.println("maxValue = " + maxArrayValue);
        System.out.println("minValue = " + minArrayValue);
        System.out.println();
//========================================================================
        /*  Задание 6.
            Написать метод, в который передается не пустой одномерный целочисленный массив,
            метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
            Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
            граница показана символами ||, эти символы в массив не входят.
        */

        // Создаём пустой одномерный целочисленный массив.
        final int SIZE = 8;
        final int RANGE = 10;

//        int[] testArray;                                      // массив генерируется случайно
        int[] testArray = { 2, 2, 2, 1, 2, 2, 10, 1 };          // установи SIZE = 8, закомментируй FillArrayRandomly()
//        int[] testArray = { 1, 1, 1, 2, 1 };                  // установи SIZE = 5, закомментируй FillArrayRandomly()

//        testArray = FillArrayRandomly(SIZE, RANGE);

        System.out.println("Задание 6.");
        System.out.println("Содержимое массива.");
        PutArrayOnConsole(testArray, 0, testArray.length);
        System.out.println("Проверка массива на наличине баланса.");
        System.out.println(CheckArrayForBalance(testArray));
        System.out.println();
//========================================================================
        /*  Задание 7.
            Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
            при этом метод должен сместить все элементы массива на n позиций.
            Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
            Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
            При каком n в какую сторону сдвиг можете выбирать сами.
        */
        int[] testArray3 = { 2, 2, 2, 1, 2, 2, 10, 1 };
        int shiftValue = -4;

        System.out.println("Задание 7.");
        System.out.println("Сдвиг массива: " + shiftValue);
        PutArrayOnConsole(testArray3, 0, testArray3.length);

        ShiftNArray(testArray3, shiftValue);

        PutArrayOnConsole(testArray3, 0, testArray3.length);
        System.out.println();
    }

    // Метод для Задания 7.
    // Сдвиг массива.
    static int[] ShiftNArray (int[] array, int shift)  {

        int tempVar = 0;

        if (shift > 0)  {
            // Цикл сдвига в положительном направлении.
            for(int j = 0; j < shift; j++)  {
                // Цикл исполнения сдвига на 1 шаг.
                for(int i = array.length - 1; i >= 0; i--)   {

                    if (i == array.length - 1)  {
                        tempVar = array[i];
                        continue;
                    }

                    array[i+1] = array[i];

                    if (i == 0) {
                        array[i] = tempVar;
                    }
                }
            }
        } else  {
            // Цикл сдвига в отрицательном направлении.
            for (int j = shift; j < 0; j++) {
                for(int i = 0; i < array.length; i++)   {

                    if (i == 0)  {
                        tempVar = array[i];
                        continue;
                    }

                    array[i-1] = array[i];

                    if (i == array.length - 1) {
                        array[i] = tempVar;
                    }
                }
            }
        }

        return array;
    }


    // Метод для Задания 6.
    static boolean CheckArrayForBalance(int[] checkArray)  {

        int sum1 = 0;
        int sumOfArray = SumOfSubArray(checkArray, 0, checkArray.length - 1);     // сумма всего массива, пригодится
        int lengthOfArray = checkArray.length;
        boolean result = false;

        for (int i = 0; i < (lengthOfArray - 1); i++)  {

            sum1 += checkArray[i];                               // сумма нарастающим итогом "слева"
            sumOfArray -= checkArray[i];                         // сумма убывающим итогом "справа"

            if (sum1 == sumOfArray)   {
                result = true;                                   // баланс найден
            }
        }

        return result;
    }

    // Сумма субмассива.
    static int SumOfSubArray(int[] array, int index1, int index2)   {
        int resultSum = 0;
        for (int i = index1; i <= index2; i++) {
            resultSum += array[i];
        }

        return resultSum;
    }

    // Получение массива, заполненного случайно.
    static int[] FillArrayRandomly (int sizeArray, int randomRange) {

        int[] resultArray = new int[sizeArray];
        Random rndGenerator = new Random();

        for (int i = 0; i < sizeArray; i++) {
            resultArray[i] = rndGenerator.nextInt(randomRange);
        }

        return resultArray;
    }

    // "Красивый" вывод массива на консоль.
    static void PutArrayOnConsole (int[] array, int index1, int index2)  {

        System.out.print("{ ");
        for (int i = index1; i < index2; i++)   {
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.printf("\b\b }\n");
    }
}
