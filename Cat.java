package ru.geekbrains.home_work05;

public class Cat extends Animal {
    final double limRun = 200;
    final double limJump = 2;
    double limRunPers;
    double limJumpPers;

    public Cat(String name) {
        super(name);
    }
    public Cat(String name, double limRunPers, double limJumpPers) {
        super(name);
        this.limRunPers = limRunPers;
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
    public void swim() {
        System.out.println(this.name + " не поплыл ");
    }

}
