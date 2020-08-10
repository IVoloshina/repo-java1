package ru.geekbrains.home_work05;

public class HomeWork05 {

    public static void main(String[] args) {
        Cat c = new Cat("Barseek",150,1);
        Dog d = new Dog("Toozeek",250,2,1.5);
        Animal[] zoo = {c, d, new Cat("Murzik",500,3), new Dog("Barbos",50,2.5,0.2)};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(300);
            zoo[i].jump(2);
            if (zoo[i] instanceof Cat) {
                Cat cat = (Cat) zoo[i];
                zoo[i].swim();
            }
            else
                zoo[i].swim(15);

        }
    }
}
