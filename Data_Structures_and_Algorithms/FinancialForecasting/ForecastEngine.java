// Exercise 7: Financial Forecasting
public class ForecastEngine {
    // Recursive method for future value calculation
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double pv = 1000.0; // Starting amount
        double rate = 0.05; // 5% growth
        int years = 10;
        
        double fv = calculateFutureValue(pv, rate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, fv);
    }
}