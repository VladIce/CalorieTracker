package org.example;


import java.util.HashMap;
import java.util.Map;


public class StepTracker {
    Converter converter = new Converter();

    private int numberOfSteps = 10000;
    HashMap<String, MonthData> monthData = new HashMap<>();
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    protected int dayOfMonth = 30;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthData.put(months[i], new MonthData());
        }
    }

    public void saveSteps(String month, int dayNumber, int numberSteps) {
        monthData.get(month).dayOfMonths.put(dayNumber, numberSteps);
        System.out.println("Данные успешно сохранены!");
    }

    public void printStatistic(String month) {
        quantityStepsPerMonth(month);
        totalStepsPerMonth(month);
        maximumQuantityStepsCompletedInMonth(month);
        averageQuantitySteps(month);
        converter.distanceСovered(totalSteps(month));
        converter.numberOfCalories(totalSteps(month));
    }

    private void quantityStepsPerMonth(String month) {
        System.out.println("Количество пройденных шагов по дням: ");
        for (Integer day : monthData.get(month).dayOfMonths.keySet()) {
            System.out.print(day + " день: " + monthData.get(month).dayOfMonths.get(day) + " шагов, ");
        }
        System.out.println();
    }

    private void totalStepsPerMonth(String month) {
        int totalSteps = totalSteps(month);
        System.out.println("За месяц " + month + " Вы прошли " + totalSteps + " шагов.");
        if (totalSteps > 100000) {
            System.out.println("Молодец, так держать!");
        }
    }

    private int totalSteps(String month) {
        int totalSteps = 0;
        for (Integer day : monthData.get(month).dayOfMonths.keySet()) {
            totalSteps += monthData.get(month).dayOfMonths.get(day);
        }
        return totalSteps;
    }

    private void maximumQuantityStepsCompletedInMonth(String month) {
        int maxSteps = 0;
        for (Integer day : monthData.get(month).dayOfMonths.keySet()) {
            if (maxSteps < monthData.get(month).dayOfMonths.get(day)) {
                maxSteps = monthData.get(month).dayOfMonths.get(day);
            }
        }
        System.out.println("Максимальное пройденное количество шагов за месяц: " + maxSteps);
    }

    private void averageQuantitySteps(String month) {
        int totalSteps = 0;
        for (Integer day : monthData.get(month).dayOfMonths.keySet()) {
            totalSteps += monthData.get(month).dayOfMonths.get(day);
        }
        System.out.println("Среднее количество шагов: " + totalSteps / dayOfMonth);
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    class MonthData {
        Map<Integer, Integer> dayOfMonths = new HashMap<>();

        public MonthData() {
            for (int i = 0; i <= 30; i++) {
                dayOfMonths.put(i, 0);
            }
        }
    }
}
