package fun.bdd;

public class Checkout {
    private int runningTotal = 0;

    public void add(Integer itemCount, Integer itemPrice) {
        runningTotal += (itemCount * itemPrice);
    }

    public Integer total() {
        return runningTotal;
    }
}
