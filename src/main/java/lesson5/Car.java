package lesson5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean winFlag = false;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }


    @Override
    public void run() {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        //сообщаем о победителе
        if (!winFlag) {
            System.out.println(this.name + " WIN!!!");
            winFlag = true;
        }
        //принимаем счетчик из главного класса и понижаем на 1 после "финиша" участника
        MainClass.getFinishCDL().countDown();
    }

    //вынесем подготовку участников в отдельный метод
    public void preparation() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
