public class Main {
    public static void main(String[] args) {
        Weed test = new Weed();
        Weed test2 = new Weed(100, 0, 5);
        for (int i = 0; i < 20; i++) {
            System.out.println(test.getAmount() + " " + test2.getAmount());
            System.out.println(test.getPrice() + " " + test2.getPrice());
            System.out.println("");
            test.updateWeed();
            test2.updateWeed();
            test.setLean(0);
            test2.setLean(0);
        }
    }
}
