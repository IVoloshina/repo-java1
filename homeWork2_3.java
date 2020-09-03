package ru.geekbrains.home_work2_3;

import java.util.ArrayList;
import java.util.HashSet;

public class homeWork2_3 {
    private static HashSet<String> ArrNotDouble(ArrayList a) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            hs.add((String) a.get(i));
        }
        return hs;
    }
    private static int clcCnt(String s, ArrayList a) {
        int n = a.indexOf(s);
        if (n < 0)
            return 0;
        n += 1;
        int cnt = 1;
        if (n == a.size())
            return cnt;
        for (int i = n + 1; i < a.size(); i++) {
            if (s.equals(a.get(i)))
                cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Январь");
        list.add("Февраль");
        list.add("Март");
        list.add("Апрель");
        list.add("Май");
        list.add("Июнь");
        list.add("Июль");
        list.add("Август");
        list.add("Сентябрь");
        list.add("Октябрь");
        list.add("Ноябрь");
        list.add("Декабрь");
        list.add("Июнь");
        list.add("Август");

        System.out.println("Список исходных элементов: " + list);
        System.out.println("Список из уникальных элементов: " + ArrNotDouble(list));
        System.out.println("Июнь - " + clcCnt("Июнь", list));
        System.out.println("Ноябрь - " + clcCnt("Ноябрь", list));
        System.out.println("Август - " + clcCnt("Август", list));

    }
}
