package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput < 0 || userInput > 3) {
                System.out.println("Вы ввели неверный номер!");
                printMenu();
                userInput = scanner.nextInt();
            }

            if (userInput == 1) {
                System.out.println("Введите название месяца с заглавной буквы: ");
                String month = scanner.next();
                while (!stepTracker.monthData.containsKey(month)) {
                    System.out.println("Месяц введён некорректно! Пожалуйста, повторите ввод.");
                    System.out.println("Введите название месяца с заглавной буквы: ");
                    month = scanner.next();
                }

                System.out.println("Введите номер дня: ");
                int numberOfDay = scanner.nextInt();
                while (numberOfDay < 1 || numberOfDay > 30) {
                    System.out.println("Вы ввели некорретное число! Доступный диапазон от 1 до 30.");
                    System.out.println("Пожалуйста, повторите ввод: ");
                    numberOfDay = scanner.nextInt();
                }

                System.out.println("Введите количество шагов: ");
                int numberSteps = scanner.nextInt();
                while (numberSteps <= 0) {
                    System.out.println("Количество шагов не может быть отрицательным! Пожалуйста, повторите ввод.");
                    System.out.println("Введите количество шагов: ");
                    numberSteps = scanner.nextInt();
                }
                stepTracker.saveSteps(month, numberOfDay, numberSteps);
                System.out.println();
            }

            if (userInput == 2) {
                System.out.println("Введите месяц по которому ходите получить статистику: ");
                String month = scanner.next();
                while (!stepTracker.monthData.containsKey(month)) {
                    System.out.println("Месяц введён некорректно! Пожалуйста, повторите ввод.");
                    System.out.println("Введите название месяца с заглавной буквы: ");
                    month = scanner.next();
                }
                stepTracker.printStatistic(month);
            }

            if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов в день:  ");
                int numberSteps = scanner.nextInt();
                while (numberSteps <= 0) {
                    System.out.println("Количество шагов не может быть отрицательным! Пожалуйста, повторите ввод.");
                    System.out.println("Введите количество шагов: ");
                    numberSteps = scanner.nextInt();
                }
                stepTracker.setNumberOfSteps(numberSteps);
                System.out.println("Новая цель в " + stepTracker.getNumberOfSteps() + " шагов установлена.");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите один из пунктов: ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");

    }
}
