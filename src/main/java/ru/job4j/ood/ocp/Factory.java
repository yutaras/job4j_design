package ru.job4j.ood.ocp;

/*
Объекты класса Production заготавливают Птицу(мясо). Если нужно реализовать
метод для производства свинины, то нужно будет изменить метод make(меняем класс)
чем нарушим OCP. Лучше создать интерфейс:
public interface Production<T> {
    T make();
}
 */
class Production {
    public Birds make() {
        return new Birds();
    }
}
