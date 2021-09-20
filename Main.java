public class Main {
    public static void main(String[] args) {
        River river = new River(40);
        Animal a = new Fish();
        Animal b = new Fish();
        Animal f = new Fish();
        Animal l = new Bear();
        Animal d = new Bear();
        Animal g = new Bear();
        Animal h = new Bear();
        Animal i = new Fish();
        Animal j = new Fish();
        Animal k = new Fish();
        river.add(d, 20);
        river.add(a, 17);
        river.add(b, 4);
        river.add(f,38);
        river.add(g, 35);
        river.add(h, 1);
        river.add(i,15);
        river.add(j, 30);
        river.add(k,7);
        river.add(l, 11);
        river.print();

        while (river.fishAlive()) {
            river.simulate();
            river.print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
