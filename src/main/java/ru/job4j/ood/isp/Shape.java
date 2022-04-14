package ru.job4j.ood.isp;

/**
 * Здесь надо разделить Shape на отдельные интерфейсы, потому что  классам имлементирующим интерфейс Shape,
 * скорее всего понадобится только один из этих методов
 */
public interface Shape {
    void drawCircle();

    void drawSquare();

    void drawRectangle();
}
