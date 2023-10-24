package org.seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человека
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; // Двумерный массив хранит состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static int WIN_COUNT; // Кол-во фишек для победы

    public static void main(String[] args) {

        while (true) {
            initialize();
            setWinCount();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, WIN_COUNT,"Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, WIN_COUNT,"Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация начального состояния игры
     */
    private static void initialize() {
     fieldInputProcessing();
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовать текущее состояние игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Установка колличества для выигрыша
     */
        private static void setWinCount(){
        int count;
        do {
            System.out.print("Укажите выигрышный ряд для победы: \n");
            count = scanner.nextInt();
        }while (count>fieldSizeX);
        WIN_COUNT = count;



    }

    /**
     * Установка размера игрового поля
     */
    private static void fieldInputProcessing(){
        int field1, field2;
        do {
            System.out.print("Какой размер поля для игры через пробел: \n");
            field1 = scanner.nextInt();
            field2 = scanner.nextInt();
        }while (field1 != field2);
            fieldSizeX = field1;
            fieldSizeY = field2;
    }
    /**
     * Обработка хода игрока (человека)
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Укажите координаты хода X и Y \nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода компьютера
     */
    static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot    фишка игрока
     * @param winStr победный слоган
     * @return признак продолжения игры (true - завершение игры)
     */
    static boolean gameCheck(char dot, int win, String winStr) {
        if (checkWin(dot,win)) {
            System.out.println(winStr);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Продолжим игру
    }

    /**
     * Проверка корректности ввода
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка победы
     *
     * @param c фишка игрока (X или 0)
     * @return
     */
    static boolean checkWin(char c, int win) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checRight(i, j, c, win) || checDown(i, j, c, win)
                        || diagonallyUp(i, j, c, win) || diagonallyDowu(i, j, c, win)) {
                    return true;
                }
            }
        }return false;
    }

    /**
     * Проверка на выигрыш в право.
     *
     * @param x
     * @param y
     * @param dot фишка игрока (X или 0)
     * @param win выигрышная длина
     * @return
     */

    static boolean checRight(int x, int y, char dot, int win) {
        if (y + win < fieldSizeY) {
            for (int i = 0; i < win; i++) {
                if (field[x][y] != dot) {
                    return false;
                }
                y++;
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка на выигрыш по диагонали вниз.
     *
     * @param x координата х
     * @param y координата у
     * @param dot символ игрока
     * @param win выигрышный ряд
     * @return
     */
    static boolean diagonallyDowu(int x, int y, char dot, int win) {
        if (y + win < fieldSizeY && x + win < fieldSizeX) {
            for (int i = 0; i < win; i++) {
                if (field[x][y] != dot) {
                    return false;
                }
                x++;
                y++;
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка на победу вниз
     *
     * @param x
     * @param y
     * @param dot выигрышная фишка
     * @param win выигрышная комбинация
     * @return
     */
    static boolean checDown(int x, int y, char dot, int win) {
        if (x + win < fieldSizeX) {
            for (int i = 0; i < win; i++) {
                if (field[x][y] != dot) {
                    return false;
                }
                x++;
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка на победу  по диагонали вверх
     *
     * @param x
     * @param y
     * @param dot
     * @param win
     * @return
     */
    static boolean diagonallyUp(int x, int y, char dot, int win) {
        if (y + win < fieldSizeY && x - win > 0) {
            for (int i = 0; i < win; i++) {
                if (field[x][y] != dot) {
                    return false;
                }
                x--;
                y++;
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }


}
