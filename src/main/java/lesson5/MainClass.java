package lesson5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    private static CountDownLatch finishCDL = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        //подготовка участников
        CountDownLatch preparationCDL = new CountDownLatch(CARS_COUNT);
        for (Car car : cars) {
            new Thread(() -> {
                car.preparation();
                preparationCDL.countDown();
            }).start();
        }
        preparationCDL.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        // старт гонки
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        //ожидание финиша
        finishCDL.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static CountDownLatch getFinishCDL() {
        return finishCDL;
    }
}

