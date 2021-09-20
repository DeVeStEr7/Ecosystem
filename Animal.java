public class Animal {
    public int move() {
        int choice = (int)(1 + Math.random()*3);
        if(choice == 1) {
            return 0;
        }
        else if(choice == 2) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
