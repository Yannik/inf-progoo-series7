package programming.set7.statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCollector {
    private final List<Double> items = new ArrayList<>();

    public void addItem(double item) {
        items.add(item);
    }

    public int getCount() {
        return items.size();
    }

    public double getSum() {
        return items
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getMinimum() {
        return items
                .stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElse(Double.POSITIVE_INFINITY);
    }

    public double getMaximum() {
        return items
                .stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(Double.NEGATIVE_INFINITY);
    }

    public double getAverage() {
        return items
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public double getVariance() {
        double average = this.getAverage();

        // avoid items.size() division by zero in the return statement
        if (items.isEmpty()) {
            return 0;
        }

        return items
                .stream()
                .mapToDouble(i -> (i - average) * (i - average))
                .sum() / items.size();
    }

    public double getStandardDeviation() {
        return Math.sqrt(this.getVariance());
    }
}
