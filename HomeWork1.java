package ru.geekbrains.home_work1;

public class HomeWork1 {

    public static void main(String[] args) {
        int a = 21, b = 4, c = 3, d = 8;
        float e;
        boolean logA;
        int posX = -8;
        String name = "Ирина";
        int y = 2108;

        // расчет a * (b + (c / d))
        e = ArifmCalc(a, b, c, d);
        System.out.println("a * (b + (c / d)) = " + e);
        // проверка суммы от 10 до 20
        logA = CheckSumm(a, b);
        System.out.println("Сумма a и b от 10 до 20: " + logA);
        // проверка на положительное число
        CheckPositive(posX);
        // вывод "Привет, ...!"
        PrintName(name);
       // проверка високосного года
        logA = CheckYear(y);
        System.out.println("Год " + y + " - високосный: " + logA);
    }
    private static float ArifmCalc (float a,float b,float c,float d) {
        return a * (b + (c / d));
    }
    private static boolean CheckSumm(int a, int b) {
        int sumAB;
        sumAB = a + b;
        if (sumAB >= 10 && sumAB <= 20) {
            return true;
        }
        else {
            return false;
        }
    }
    private static void CheckPositive(int x) {
        boolean res;
        if (x >= 0) {
            res = true;
        }
        else {
            res = false;
        }
        System.out.println("Число положительное: " + res);
    }
    private static void PrintName(String n) {
        String privet;
        privet = "Привет, " + n + "!";
        System.out.println(privet);
    }
    private static boolean CheckYear(int y) {
        // проверить для 100-х годов
        if (y % 100 == 0) {
            if (y / 100 % 4 == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        // для остальных
        else if (y % 4 == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
