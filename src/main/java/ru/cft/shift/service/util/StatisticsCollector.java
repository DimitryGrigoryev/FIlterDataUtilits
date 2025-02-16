package ru.cft.shift.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class StatisticsCollector {
    public void collectStatisticsInt(List<Long> longIntegers, boolean isFull) {
        long count = longIntegers.size();
        System.out.println("Статистика по типу элементов \"целые числа\"");
        System.out.println("Количество элементов: " + count);

        if (isFull) {
            Long maximum = Collections.max(longIntegers);
            Long minimum = Collections.min(longIntegers);
            long total = longIntegers.stream().mapToLong(Long::longValue).sum();
            double average = (double) total / count;

            System.out.println("Максимальное значение: " + maximum);
            System.out.println("Минимальное значение: " + minimum);
            System.out.println("Сумма элементов: " + total);
            System.out.println("Среднее значение элементов: " + average);
            System.out.println("\n");
        }
    }

    public void collectStatisticsFloat(List<BigDecimal> bigDecimals, boolean isFull) {
        System.out.println("Статистика по типу элементов \"вещественные числа\"");
        System.out.println("Количество элементов: " + bigDecimals.size());

        if (isFull) {
            BigDecimal total = BigDecimal.ZERO;
            BigDecimal maximum = bigDecimals.get(0);
            BigDecimal minimum = bigDecimals.get(0);
            for (BigDecimal bigDecimal : bigDecimals) {
                total = total.add(bigDecimal);
                maximum = maximum.max(bigDecimal);
                minimum = minimum.min(bigDecimal);
            }
            BigDecimal average = total.divide(BigDecimal.valueOf(bigDecimals.size()), RoundingMode.HALF_UP);

            System.out.println("Максимальное значение: " + maximum);
            System.out.println("Минимальное значение: " + minimum);
            System.out.println("Сумма элементов: " + total.setScale(6, RoundingMode.HALF_UP));
            System.out.println("Среднее значение элементов: " + average.setScale(6, RoundingMode.HALF_UP));
            System.out.println("\n");
        }
    }

    public void collectStatisticsString(List<String> strings, boolean isFull) {
        System.out.println("Статистика по типу элементов \"строки\"");
        System.out.println("Количество элементов: " + strings.size());

        if (isFull) {
            int minString = strings.get(0).length();
            int maxString = strings.get(0).length();
            for (String string : strings) {
                if (string.length() > maxString) {
                    maxString = string.length();
                }
                if (string.length() < minString) {
                    minString = string.length();
                }
            }

            System.out.println("Размер самой короткой строки: " + minString);
            System.out.println("Размер самой длинной строки: " + maxString);
        }
    }
}
