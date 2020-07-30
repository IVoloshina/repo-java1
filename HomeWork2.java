package ru.geekbrains.home_work2;

import java.util.Arrays;

public class HomeWork2 {
    // 1.1 так проще
    private static void ReplArrAbs (int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i] - 1);
        }
    }
    // 1.2 или мы ещё не знаем про модуль числа? ;)
    private static void ReplArr(int[] a){
        for (int i = 0; i < a.length; i++){
            switch (a[i]){
                case 1:
                    a[i] = 0;
                    break;
                case 0:
                    a[i] = 1;
            }
        }
    }
    // 2
    private static void RecalcArrPlus3(int[] a){
        a[0] = 1;
        int b;
        for (int i = 1; i < a.length; i++){
            b = a[i - 1];
            a[i] = b + 3;
        }
    }
    // 3
    private static void RecalcArr(int[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        }
    }
    // 4 MIN
    private static int FindMinItem(int[] a){
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < m){
                m = a[i];
            }
        }
        return m;
    }
    // 4 MAX
    private static int FindMaxItem(int[] a){
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        return m;
    }
    // 5
    private static void FillDiag(int[][] a){
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length; y++) {
                if ((x == y) || ((x + y + 1) == a.length)) {
                    a[x][y] = 1;
                }
            }
        }
    }
    // 6
    private static boolean checkBalance(int[] a) {
        int sumArr = 0;
        int sumItems = 0;
        // сумма элементов массива
        for (int i = 0; i < a.length; i++) {
            sumArr += a[i];
        }
        // нечетная сумма - сразу выход
        if (sumArr % 2 == 1) {
            return false;
        }
        sumArr /= 2;
        // поиск - сумма левых элементов равна полусумме
        for (int i = 0; i < a.length && sumItems < sumArr; i++) {
            sumItems += a[i];
            //System.out.println("i = " + i + " " + a[i] + " " + sumArr + " " + sumItems);
            if (sumItems == sumArr) {
                return true;
            }
        }
        return false;
    }
    // 7.1
    private static void MoveArr(int[] a, int n) {
        int lenArr = a.length;
        int itemA = 0;
        // убрать полные циклы сдвига
        if ((n > lenArr) || (-1 * n > lenArr )){
            n %= lenArr;
        }
        // не надо сдвигать
        if ((n == 0) || (n == lenArr)) {
            return;
        }
        if (n > 0) {
            // сдвиг на 1 элемент n раз влево
            for (int i = 0; i < n; i++) {
                itemA = a[0];
                for (int j = 0; j < lenArr; j++) {
                    if (j == lenArr - 1) {
                        a[j] = itemA;
                    } else {
                        a[j] = a[j + 1];
                    }
                }
                itemA = a[0];
            }
        } else {
            n *= -1;
            // сдвиг на 1 элемент n раз вправо
            for (int i = 0; i < n; i++) {
                itemA = a[lenArr - 1];
                for (int j = lenArr - 1; j >= 0; j--) {
                    if (j == 0) {
                        a[j] = itemA;
                    } else {
                        a[j] = a[j - 1];
                    }
                }
                itemA = a[lenArr - 1];
            }
        }
    }
    // 7.2
    private static void MoveArr1(int[] a, int n) {
        int lenArr = a.length;
        int itemA = 0;
        // убрать полные циклы сдвига
        if ((n > lenArr) || (-1 * n > lenArr )){
            n %= lenArr;
        }
        // не надо сдвигать
        if ((n == 0) || (n == lenArr) || (-1 * n == lenArr)) {
            return;
        }
        // равнозначный сдвиг влево для -n
        if (n < 0){
            n = lenArr + n;
        }
        // сдвиг на 1 элемент n раз влево
        for (int i = 0; i < n; i++) {
            itemA = a[0];
            for (int j = 0; j < lenArr; j++) {
                if (j == lenArr - 1) {
                    a[j] = itemA;
                } else {
                    a[j] = a[j + 1];
                }
            }
            itemA = a[0];
        }
    }
    public static void main(String[] args) {
        int[] ar01 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] ar02 = new int[8];
        int[] ar03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] ar04 = {8, 12, 11, 34, 52, 2, 99, 88};
        int[][] ar05 = new int[5][5];
        //int[] ar06 = {8, 14, 11, 34, 51, 3, 24, 89};
        int[] ar06 = {8, 12, 11, 34, 51, 3, 24, 89};
        //int[] ar06 = {1, 1, 1, 2, 1};
        int[] ar07 = {1, 2, 3, 4, 5};
        int n = 13;

        // 1.1
        ReplArrAbs(ar01);
        System.out.println(Arrays.toString(ar01));
        // 1.2
        ReplArr(ar01);
        System.out.println(Arrays.toString(ar01));
        // 2
        RecalcArrPlus3(ar02);
        System.out.println(Arrays.toString(ar02));
        // 3
        System.out.println("old ar03: " + Arrays.toString(ar03));
        RecalcArr(ar03);
        System.out.println("new ar03: " + Arrays.toString(ar03));
        // 4 MIN
        System.out.println("ar04 MIN = " + FindMinItem(ar04));
        // 4 MAX
        System.out.println("ar04 MAX = " + FindMaxItem(ar04));
        // 5
        FillDiag(ar05);
        for (int x = 0; x < ar05.length; x++) {
            for (int y = 0; y < ar05.length; y++) {
                System.out.printf("%3d", ar05[x][y]);
            }
            System.out.println();
        }
        // 6
        System.out.println("Есть баланс: " + checkBalance(ar06));
        // 7.1 n > 0 - сдвиг влево, n < 0 - вправо
        System.out.println("old ar07:        " + Arrays.toString(ar07));
        MoveArr(ar07, n);
        System.out.println("7.1 new ar07 " + n + ": " + Arrays.toString(ar07));
        n *= -1;
        MoveArr(ar07, n);
        System.out.println("7.1 new ar07" + n + ": " + Arrays.toString(ar07));
        // 7.2 n > 0 - сдвиг влево, n < 0 - вправо
        n *= -1;
        MoveArr1(ar07, n);
        System.out.println("7.2 new ar07 " + n + ": " + Arrays.toString(ar07));
        n *= -1;
        MoveArr1(ar07, n);
        System.out.println("7.2 new ar07" + n + ": " + Arrays.toString(ar07));
    }
}
