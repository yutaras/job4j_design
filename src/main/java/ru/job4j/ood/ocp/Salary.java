package ru.job4j.ood.ocp;

import java.util.function.BiFunction;

public class Salary {
    /*
     * Чтобы расширить первый класс ,
     * поменяв условия нового расчета
     * нужно добавлять новый метод, тем самым изменив класс
     * */
    private static class SimpleSalaryCalc {

        public int salary(int quantityDays, int price) {
            return price * quantityDays;
        }
    }

    /*
     * Чтобы расширить второй класс ,
     * поменяв условия нового расчета
     * нужно добавлять новую лямбду, без
     * изменения класса
     * */
    private static class AbstractSalaryCalc<T> {

        public T abstractPrice(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }

    public static void main(String[] args) {
        SimpleSalaryCalc calc = new SimpleSalaryCalc();
        System.out.println(calc.salary(22, 4000));
        AbstractSalaryCalc<Integer> calc1 = new AbstractSalaryCalc<>();
        int i = calc1.abstractPrice((a, b) -> (a * b), 22, 4000);
        System.out.println(i);
    }
}
