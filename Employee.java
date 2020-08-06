package ru.geekbrains.home_work04;

public class Employee {
    private String fio;
    private double pay;
    private int age;
    private int num;
    private static int cnt = 0;

    Employee(String fio, double pay, int age ){
        this.fio = fio;
        this.pay = pay;
        this.age = age;
        this.num = incNum(cnt);
    }

    private int incNum(int n){
        cnt += 1;
        return cnt;
    }

    public String getFIO() {
        return this.fio;
    }

    public double getPay() {
        return this.pay;
    }

    public int getAge() {
        return this.age;
    }

    public int getNum() {
        return this.num;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
