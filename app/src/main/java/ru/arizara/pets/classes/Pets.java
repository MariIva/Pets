package ru.arizara.pets.classes;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    private static int count = 0;

    public String name;
    // вид животного - элемент перечисления
    public KindAnimal kind;
    public String description;

    public Pets(String name, KindAnimal kind, String description) {
        this.name = name;
        this.kind = kind;
        this.description = description;
    }

    // создание заранее заданных объектов
    public static List<Pets> createList(){
        List<Pets> list = new ArrayList<>();

        list.add(new Pets("Шарик"+count, KindAnimal.DOG, "Хороший мальчик"));
        list.add(new Pets("Мурка"+count, KindAnimal.CAT, "Пушистая и ласковая"));
        list.add(new Pets("Кеша"+count, KindAnimal.BIRD, "Любит петь"));

        count++;
        return list;
    }

}
