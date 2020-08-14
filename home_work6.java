package ru.geekbrains.home_work6;

import java.io.*;
import java.util.Scanner;

public class home_work6 {

    private static String inputFile(String fn) {
        String str = "";
        try {
        Scanner sc = new Scanner(new FileInputStream(fn));
        while (sc.hasNext())
            str += sc.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
        ex.printStackTrace();
        }
        return str;
    }

    private static boolean findStr(String findStr, String fn) {
        int n = 0;
        String str = "";
        str = inputFile(fn);
        if (str.indexOf(findStr) > 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        byte [] abc = new byte[26];
            for (int i = 65; i < 91; i++) {
            abc[i - 65] += (char) i;
        }
        String cba = "";
        for (int i = 90; i > 64; i--) {
            cba += (char) i;
        }
        InputStream in;
        OutputStream out;

        // 1-й файл
        try {
        FileOutputStream fABC = new FileOutputStream("abc.txt");
        fABC.write(abc);
        fABC.flush();
        fABC.close();

        // 2-й файл
        FileOutputStream fBCA = new FileOutputStream("cba.txt");
        fBCA.write(cba.getBytes());
        fBCA.flush();
        fBCA.close();

        // чтение из 2-го файла
        String r02 = "";
        r02 = inputFile("cba.txt");
        System.out.println(r02);

        // запись 2-го в 1-й файл
        FileOutputStream fABC1 = new FileOutputStream("abc.txt",true);
        fABC1.write(r02.getBytes());
        fABC1.flush();
        fABC1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // поиск строки  файле
        System.out.println(findStr("BCD","abc.txt"));
        System.out.println(findStr("B0D","abc.txt"));
    }
}
