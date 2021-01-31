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

        /*  Задание 2.
            Задать пустой целочисленный массив размером 8.
            С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
         */
        int[] arrayFor2ndTask = new int[8];

        for (int i = 0; i <= 7; i++)  {
            arrayFor2ndTask[i] = i * 3;
        }

        /*  Задание 3.
            Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
            пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        int[] arrayFor3rdTask = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int rangeForCycle = arrayFor3rdTask.length;

        for (int i = 0; i < rangeForCycle; i++) {
            if (arrayFor3rdTask[i] < 6)   {
                arrayFor3rdTask[i] *= 2;
            }
        }

        /*  Задание 4.
            Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
            и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        */
//        final int SIZE_SQUARE_ARRAY = 8;
//        int[][] arrayFor4ndTask = new int[SIZE_SQUARE_ARRAY][SIZE_SQUARE_ARRAY];
//
//        for(int i = 0; i < SIZE_SQUARE_ARRAY; i++)    {
//            for (int j = 0; j < SIZE_SQUARE_ARRAY; j++)   {
//                if (i == j) {
//                    arrayFor4ndTask[i][j] = 1;
//                }
//                System.out.print(arrayFor4ndTask[i][j]);
//                System.out.print(' ');
//            }
//            System.out.println();
//        }

        /*  Задание 5.
            Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
        */
        final int SIZE_ARRAY = 8;
        final int RND_RANGE = 100;

        int[] array5thTask = new int[SIZE_ARRAY];
        int maxArrayValue = 0;
        int minArrayValue = RND_RANGE;

        FillArrayRandomly(array5thTask, RND_RANGE);

        for (int d : array5thTask)  {
            if (d >= maxArrayValue) {
                maxArrayValue = d;
            }
            if (d <= minArrayValue) {
                minArrayValue = d;
            }
        }

        System.out.println("maxValue in array = " + maxArrayValue);
        System.out.println("minValue in array = " + minArrayValue);

        /*  Задание 6.
            Написать метод, в который передается не пустой одномерный целочисленный массив,
            метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
            Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
            граница показана символами ||, эти символы в массив не входят.
        */
        // Создаём пустой одномерный целочисленный массив.
        final int RANGE = 10;
        int[] testArray = new int[RANGE];

        FillArrayRandomly(testArray, RANGE);
        System.out.println("Вывод содержимого testArray");
        PutArrayOnConsole(testArray);



    }

    static void FillArrayRandomly (int[] array, int randomRange) {

        Random rndGenerator = new Random();
        int sizeArray = array.length;

        for (int i = 0; i < sizeArray; i++) {
            array[i] = rndGenerator.nextInt(randomRange);
        }
    }

    static void PutArrayOnConsole (int[] array)  {

        for(int g : array)    {
            System.out.print("g = ");
            System.out.println(g);

        }
    }
}
