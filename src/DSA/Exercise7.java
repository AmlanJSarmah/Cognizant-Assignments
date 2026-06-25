package DSA;

public class Exercise7 {
    public static double futureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) return presentValue;
        return futureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double pv = 1000;
        double rate = 0.05;
        int years = 10;
        double fv = futureValue(pv, rate, years);
        System.out.println("Future value of $" + pv + " at " + (rate * 100) + "% growth over " + years + " years: $" + fv);
    }
}
