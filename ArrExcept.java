package ru.geekbrains.home_work2_2;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrExcept {
    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        int x = 4;
        int y = 4;
        float res;
        String[][] arrStr = new String[x][y];
        int[][] arrInt = new int[x][y];

        try {
            fillArray(str, arrStr, 4, 4);
            convArray(arrStr, arrInt);
            res = recalcArray(arrInt,2);
            System.out.println("Результат: " + res);
        } catch (NoSuchElementException e) {
            System.out.println("Размер массива отличен от " + x + "x" + y);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строкового элемента в число");
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    private static float recalcArray(int[][] arrInt, int d) throws ArithmeticException {
        int res = 0;
        if (d == 0) {
            throw new ArithmeticException("Ошибка: деление на 0");
        }
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt.length; j++) {
                res += arrInt[i][j];
            }
        }
        return (float) res / d;
    }
    private static void convArray(String[][] arrStr, int[][] arrInt) throws RuntimeException {
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr.length; j++) {
                arrInt[i][j] = Integer.parseInt(arrStr[i][j]);
                // System.out.println("i" + i + "j" + j + " " + arrInt[i][j]);
            }
        }
    }

    private static void fillArray(String str, String[][] arrStr,int x, int y) throws RuntimeException {
        String tmpStr;
        Scanner scan = new Scanner(str);
        for (int i = 0; i < x; i++) {
            tmpStr = scan.nextLine();
            Scanner scan1 = new Scanner(tmpStr);
            for (int j = 0; j < y; j++) {
                arrStr[i][j] = scan1.next();
                //System.out.println("i" + i + "j" + j + " " + arrStr[i][j]);
            }
        }
    }
}
