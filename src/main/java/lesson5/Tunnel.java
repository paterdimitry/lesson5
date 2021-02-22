package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    //создаем семафор с допуском половины участников в тоннель
    Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                //участник ждет разрешения въезда в тоннель
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                //после выезда из тоннеля сбрасывает семафор
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
