package ru.geekbrains.home_work05;

public class Dog extends Animal {
    final double limRun = 500;
    final double limSwim = 10;
    final double limJump = 0.5;
    double limRunPers;
    double limSwimPers;
    double limJumpPers;

    public Dog(String name) {
        super(name);
    }
    public Dog(String name, double limRunPers, double limSwimPers, double limJumpPers) {
        super(name);
        this.limRunPers = limRunPers;
        this.limSwimPers = limSwimPers;
        this.limJumpPers = limJumpPers;
    }
    @Override
    public void run(int length) {
        double lim = Math.min(length,limRun);
        lim = Math.min(lim,this.limRunPers);
        System.out.println(this.name + " пробежал " + lim + "м.");
    }
    @Override
    public void jump(int height) {
        double lim = Math.min(height,limJump);
        lim = Math.min(lim,this.limJumpPers);
        System.out.println(this.name + " прыгнул на " + lim + "м.");
    }
    @Override
    public void swim(int length) {
        double lim = Math.min(length,limSwim);
        lim = Math.min(lim,this.limSwimPers);
        System.out.println(this.name + " проплыл " + lim + "м.");
    }
}

