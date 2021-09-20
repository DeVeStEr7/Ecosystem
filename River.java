public class River {
    private int waterLength;
    private Animal river[];

    public River(int waterLength) {
        this.waterLength = waterLength;
        river = new Animal[waterLength];
    }


    public int getWaterLength() {
        return waterLength;
    }

    public void add(Animal a, int pos) {
        river[pos] = a;
    }

    public void print() {
        for (int i = 0; i < river.length; i++) {
            if (river[i] == null) {
                System.out.print("-");
            } else if (river[i] instanceof Fish) {
                System.out.print("F");
            } else if (river[i] instanceof Bear) {
                System.out.print("B");
            }
        }
        System.out.println();
    }

    public void simulate() {
        for (int i = 0; i < waterLength; i++) {
            Animal a = river[i];
            if (a != null) {
                int move = a.move();
                if (move == -1 && i != 0) {
                    if (river[i] instanceof Fish && river[i - 1] instanceof Fish) {
                        Animal baby = new Fish();
                        int num = (int) (Math.random() * waterLength);
                        while (river[num] instanceof Fish || river[num] instanceof Bear) {
                            num = (int) (Math.random() * waterLength);
                        }
                        river[num] = baby;
                    } else if (river[i] instanceof Bear && river[i - 1] instanceof Bear) {
                        Animal baby = new Bear();
                        int num = (int) (Math.random() * waterLength);
                        while (river[num] instanceof Fish || river[num] instanceof Bear) {
                            num = (int) (Math.random() * waterLength);
                        }
                        river[num] = baby;
                    } else if (river[i - 1] instanceof Bear) {
                        river[i] = null;
                    } else {
                        river[i] = null;
                        river[i - 1] = a;
                    }
                } else if (move == 1 && i != waterLength - 1) {
                    if (river[i] instanceof Fish && river[i + 1] instanceof Fish) {
                        Animal baby = new Fish();
                        int num = (int) (Math.random() * waterLength);
                        while (river[num] instanceof Fish || river[num] instanceof Bear) {
                            num = (int) (Math.random() * waterLength);
                        }
                        river[num] = baby;
                        i++;

                    } else if (river[i] instanceof Bear && river[i + 1] instanceof Bear) {
                        Animal baby = new Bear();
                        int num = (int) (Math.random() * waterLength);
                        while (river[num] instanceof Fish || river[num] instanceof Bear) {
                            num = (int) (Math.random() * waterLength);
                            i++;
                        }
                        river[num] = baby;
                    } else if (river[i + 1] instanceof Bear) {
                        river[i] = null;
                    } else {
                        river[i] = null;
                        river[i + 1] = a;
                        i++;
                    }
                }
            }
        }
    }

    public boolean fishAlive() {
        for(int i = 0; i < waterLength; i++) {
            if(river[i] instanceof Fish) {
                return true;
            }
        }
        return false;
    }
}
