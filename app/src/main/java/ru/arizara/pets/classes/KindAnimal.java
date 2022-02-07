package ru.arizara.pets.classes;

import ru.arizara.pets.R;

public enum KindAnimal {
    // элемент перечисления
    DOG{
        public int draw(){
            // картинка для этого элемента
            return R.drawable.dog;
        }
    },
    CAT{
        public int draw(){
            return R.drawable.cat;
        }
    },
    BIRD{
        public int draw(){
            return R.drawable.bird;
        }
    };

    // метод, который реализует каждый элемент
    public abstract int draw();
}
