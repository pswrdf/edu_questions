package elevator;

import java.util.Scanner;

/**
 * Требуется разработать программу — эмулятор лифта.
 * При старте программа должна запрашивать этажность дома.
 * Программа должна выводить пользователю текущее состояние лифта
 * (номер этажа, направление движения (вверх, вниз, остановка).
 * Скорость движения лифта: 1 этаж в секунду. Пользователь должен
 * иметь возможность в любой момент, включая периоды движения лифта,
 * «нажать» кнопку вызова на любом этаже. Во время движения может быть
 * нажато произвольное количество кнопок «вызов» на разных этажах.
 * Пользователь должен иметь возможность «нажать» кнопку любого этажа
 * на вызывной панели внутри кабины лифта. При написании программы надо
 * руководствоваться собственными здравым смыслом и знаниями о работе лифтов.
 * Остальные ограничения по работе программы должны устанавливаться программистом по
 * его собственному усмотрению. Дополнительные уточнения по заданию не выдаются.
 */
public class Elevator extends Thread {
    private static final int SPEED = 100;

    private enum DIRECTION {
        UP(1), DOWN(-1), IDLE(0);
        int step;

        DIRECTION(int i) {
            step = i;
        }
    }

    private int floors;
    private boolean[] calledFrom;
    private boolean[] orderedTo;
    private DIRECTION direction = DIRECTION.IDLE;
    private int current = 1;
    private int fastestCalled = -1;

    public Elevator(Integer integer) {
        floors = integer;
        calledFrom = new boolean[floors];
        orderedTo = new boolean[floors];
        start();
    }

    synchronized void called(int from) {
        System.out.println("called from " + from);
        calledFrom[from - 1] = true;
        if (fastestCalled == -1) {
            fastestCalled = from;
        }
        notify();
    }

    synchronized void order(int to) {
        System.out.println("ordered to " + to);
        orderedTo[to - 1] = true;
        notify();
    }

    @Override
    public void run() {
        while (true) {
            waitWhileNoCalls();

            if(!noCalls()) {
                goCalled();
            }
            if (haveOrder()) {
                goOrdered();
            } else {
                direction = DIRECTION.IDLE;
            }
        }
    }

    private synchronized void waitWhileNoCalls() {
        while (noCalls() && !haveOrder()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean noCalls() {
        for (int i = 0; i < floors; i++) {
            if (calledFrom[i]) {
                return false;
            }
        }
        return true;
    }

    private void goCalled() {
        int floor = calledFloor();

        System.out.println("going to floor = " + floor);
        defineDirection(floor);
        while (current != floor) {
            move();
        }
        stoped();
    }

    private void defineDirection(int floor) {
        direction = current < floor ? DIRECTION.UP : DIRECTION.DOWN;
        System.out.println(direction);
    }

    private void move() {
        try {
            Thread.sleep(SPEED);
        } catch (InterruptedException e) {
        }
        current += direction.step;
    }

    private int calledFloor() {
        if (fastestCalled != -1) {
            int tar = fastestCalled;
            fastestCalled = -1;
            return tar;
        }
        for (int i = floors; i > 0; i--) {
            if (calledFrom[i - 1]) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    private boolean haveOrder() {
        for (int i = 0; i < floors; i++) {
            if (orderedTo[i]) {
                return true;
            }
        }
        return false;
    }

    private void goOrdered() {
        int floor = minOrdered();
        System.out.println("going to floor = " + floor);
        defineDirection(floor);
        while (current != floor) {
            move();
            if (direction == DIRECTION.DOWN && orderedTo[current - 1]) {
                stoped();
            }
            if (current != floor) {
                floor = minOrdered();
            }
        }
        stoped();
    }

    private int minOrdered() {
        for (int i = 0; i < floors; i++) {
            if (orderedTo[i]) {
                return i + 1;
            }
        }
        throw new RuntimeException();
    }

    private void stoped() {
        System.out.println("stoped = " + current);
        calledFrom[current - 1] = false;
        orderedTo[current - 1] = false;
        if (fastestCalled == current) {
            fastestCalled = -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator(read());
        Thread.sleep(3000);
        elevator.called(read());
        elevator.order(read());
        elevator.called(read());
        elevator.order(read());

//        elevator.called(5);
//        elevator.called(10);
//        elevator.called(3);
//        Thread.sleep(5000);
//        elevator.called(5);
    }

    public static int read() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = Integer.valueOf(str);
        return i;
    }
}
