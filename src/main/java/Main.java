public class Main {
    public static void main(String[] args) {
        TrenchCoat inventory = new TrenchCoat(0,2000);
        Weed weed = new Weed(100,0,0);
        Events event = new Events();
        for (int i = 0; i < 20; i++) {
            System.out.println(inventory.getMoney() + "  " + weed.getPrice());
            event.eventRoll(weed);
        }
    }
}
