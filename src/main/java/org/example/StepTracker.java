package org.example;



import java.util.HashMap;
import java.util.Map;


public class StepTracker {

    private int numberOfSteps = 10000;
    HashMap<String, MonthData> monthData = new HashMap<>();
    String[] months = {"Январь", "Февраль", "Март", "Апрель",
            "Май", "Июнь", "Июль", "Август", "Сентябрь",
            "Октябрь", "Ноябрь", "Декабрь"};

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

    public void gettingStatisticsTheMonth(String month) {
        System.out.println("Количество пройденных шагов по дням: ");





    }





    public void setNumberOfSteps(int numberOfSteps) {
        if (numberOfSteps < 0) {
            System.out.println("Количество шагов не может быть отрицательным.");
            return;
        }
        this.numberOfSteps = numberOfSteps;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
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
