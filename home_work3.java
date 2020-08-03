package ru.geekbrains.home_work3;

import java.util.Random;
import java.util.Scanner;

public class home_work3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int winSize;
    private static char[][] field;

    private static void initField() {
        fieldSizeX = fieldSizeY = 5;
        winSize    = 4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до " + fieldSizeX + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        // hor
        int k = fieldSizeX - winSize + 1; //3
        int i = 0;
        int x, y;

        while (i < k){
            x = 0;
            while (x < k) {
                y = 0;
                while (y < k) {
                    if (checkHor (x, y, winSize, c)){
                        return true;
                    }
                    if (checkVer (x, y, winSize, c)){
                        return true;
                    }
                    if (checkDiag (x, y, winSize, c)){
                        return true;
                    }
                    y += 1;
                }
                x += 1;
            }
            i += 1;
        }
        return false;
    }
    private static boolean checkVer (int x, int y, int k, int c){
       boolean eqItem = true;
       int j;
       int i;
       for (i = y; i < y + k; i++) {
           eqItem = true;
           for (j = x; j < x + k; j++) {
               eqItem &= (field[j][i] == c);
           }
           if (eqItem)
              return true;
       }
        return eqItem;
    }
    private static boolean checkHor (int x, int y, int k, int c){
        boolean eqItem = true;
        int j;
        int i;
        for (i = x; i < x + k; i++) {
            eqItem = true;
            for (j = y; j < y + k; j++) {
                eqItem &= (field[i][j] == c);
            }
            if (eqItem)
                return true;
        }
        return eqItem;
    }
    private static boolean checkDiag (int x, int y, int k, int c){
        boolean eqItem = true;
        int i;
        // диагональ \
        for (i = 0; i < k; i++) {
            eqItem &= (field[y + i][x + i] == c);

        }
        if (eqItem)
            return eqItem;
        // диагональ /
        eqItem = true;
        int j = y + k - 1;
        for (i = 0; i < k; i++) {
            eqItem &= (field[j - i][x + i] == c);
        }
        return eqItem;
    }

    public static void main(String[] args) {
        String answer;
        do {
            initField();
            printField();
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}

