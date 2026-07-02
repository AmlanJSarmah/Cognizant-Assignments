package TDD;

public class Exercise3 {
    public int add(int a, int b) {
        return a + b;
    }

    public boolean isGreater(int a, int b) {
        return a > b;
    }

    public boolean isLess(int a, int b) {
        return a < b;
    }

    public Object maybeNull(boolean returnNull) {
        return returnNull ? null : new Object();
    }
}
