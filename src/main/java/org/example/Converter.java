package org.example;

public class Converter {
    private double oneSteps = 0.75 / 1000.0;
    private double caloriesStep = 50.0 / 1000;

    public void distanceСovered(int quantitySteps) {
        System.out.println("Пройденная дистанция в километрах: " + quantitySteps * oneSteps);
    }

    public void numberOfCalories(int quantitySteps) {
        System.out.println("Количество сожженых килокалорий: " + quantitySteps * caloriesStep);
    }
}
