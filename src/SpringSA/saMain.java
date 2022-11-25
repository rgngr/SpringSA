package SpringSA;

public class saMain {
    public static void main(String[] args) {

        bus bus1 = new bus();
        bus bus2 = new bus();

        bus1.onBoard(2);
        bus1.oilAmount(-50);
        bus1.garage();
        bus1.oilAmount(10);
        bus1.runBus();
        bus1.onBoard(45);
        bus1.onBoard(5);
        bus1.oilAmount(-55);

        taxi taxi1 = new taxi();
        taxi taxi2 = new taxi();

        taxi1.onBoard(2, "서울역", 2);
        taxi1.oilAmount(-80);
        taxi1.pay();
        taxi1.onBoard(5, "??", 3);
        taxi1.onBoard(3, "구로디지털단지역", 12);
        taxi1.oilAmount(-20);
        taxi1.pay();

    }
}
