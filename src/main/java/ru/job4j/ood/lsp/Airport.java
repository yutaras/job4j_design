package ru.job4j.ood.lsp;

public class Airport {
    public int planes;
    public int pilots;


    public void completed(int planes, int pilots) {
        if (planes < 9 || pilots < 18) {
            throw new IllegalArgumentException("Not enough planes or pilots!");
        }
        System.out.println("Airport competed.");
    }

    public static void main(String[] args) {
        Airport airport = new Airport();
        airport.completed(14, 20);
    }

    /**
     * 1. Предусловия (Preconditions) не могут быть усилены в подклассе
     */
    public static class AirportBig extends Airport {
        public int planes;

        public void completed(int planes, int pilots) {
            if (planes < 50 || pilots < 100) {
                throw new IllegalArgumentException("Not enough planes or pilots!");
            }
            System.out.println("Airport competed.");
        }
    }

    /**
     * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
     */
    public static class AirportC extends Airport {
        public int planes;

        public void completed(int planes, int pilots) {
            System.out.println("Airport competed.");
        }
    }

    /**
     * Инварианты (Invariants) — все условия базового класса также должны быть сохранены и в подклассе
     */
    public static class AirportB extends Airport {
        public int planes;

        public void completed(int planes, int pilots) {
            if (planes < 9 || pilots < 18) {
                System.out.println("Not enough planes or pilots!");
            }
            System.out.println("Airport competed.");
        }
    }
}
