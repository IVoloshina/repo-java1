package ru.geekbrains.home_work04;

import java.io.PrintStream;

public class Work04 {
    private static void upPay(Employee s) {
        if (s.getAge() > 45) {
            s.setPay(s.getPay() + 5000);
        }
    }

    private static double averagePay(Employee[] s) {
        double sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i].getPay();
        }
        return sum / s.length;
    }

    private static double averageAge(Employee[] s) {
        double sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i].getAge();
        }
        return sum / s.length;
    }

    public static void main(String[] args) {
        Employee e01 = new Employee("Трегубов Н.В.", 100500, 58);
        // 4
        System.out.printf("ФИО: %s ВОЗРАСТ %d\n", e01.getFIO(), e01.getAge());
        // 5
        Employee[] s = {e01,
                new Employee("Миронова А.В.", 25000, 19),
                new Employee("Штольман Я.П", 80000, 46),
                new Employee("Коробейников А.А", 38000, 25),
                new Employee("Жолдина Е.Т.", 22000, 22)
        };
        System.out.println("Все сотрудники:");
        for (int i = 0; i < s.length; i++)
            System.out.printf("ФИО: %s ВОЗРАСТ %d\n", s[i].getFIO(), s[i].getAge());

        // 5
        System.out.println("Старше 40 лет:");
        for (int i = 0; i < s.length; i++) {
            if (s[i].getAge() > 40)
                System.out.printf("ФИО: %s ВОЗРАСТ %d\n", s[i].getFIO(), s[i].getAge());
        }
        // 6
        System.out.println("ЗП с изменениями:");
        for (int i = 0; i < s.length; i++) {
            upPay(s[i]);
            System.out.printf("ФИО: %s ЗАРПЛАТА: %s\n", s[i].getFIO(), s[i].getPay());
        }
        // 7
        System.out.printf("Средняя арифм. ЗП: %s Средний возраст %s\n",
                averagePay(s), averageAge(s));
        // 8
        for (int i = 0; i < s.length; i++) {
            System.out.printf("Номер: %s ФИО: %s ЗАРПЛАТА: %s\n", s[i].getNum(), s[i].getFIO(), s[i].getPay());
        }
    }
}
