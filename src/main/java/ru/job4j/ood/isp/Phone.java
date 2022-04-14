package ru.job4j.ood.isp;

/**
 * Здесь методы снять на камеру и играть музыку надо вынести в отдельные интерфейсы
 * или добавлять уже в класае - реализации.
 * потому как не всем телефонам они нужны.
 */
public interface Phone {
    void call();

    void shootOnCamera();

    void playMusic();
}
