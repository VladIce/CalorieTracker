package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput < 0 || userInput > 3) {
                System.out.println("Выбранной команды нет! Выберите одну из доступных команд: ");
                printMenu();
                userInput = scanner.nextInt();
            }

            if (userInput == 1) {
                System.out.println("Укажите месяц с заглавной буквы: ");
                String month = scanner.next();
                while (!stepTracker.monthData.containsKey(month)) {
                    System.out.println("Вы ввели некорретный месяц! Пожалуйста, повторите ввод.");
                    System.out.println("Укажите месяц с заглавной буквы: ");
                    month = scanner.next();
                }

                System.out.println("Укажите номер дня: ");
                int numberOfDay = scanner.nextInt();
                while (numberOfDay < 1 || numberOfDay > 30) {
                    System.out.println("Вы ввели некорретное число! Пожалуйста, повторите ввод.");
                    System.out.println("Введите номер дня в диапозоне от 1 до 30: ");
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
                System.out.println("");
            }

            if (userInput == 2) {
                System.out.println("Введите месяц по которому ходите получить статистику: ");
                String month = scanner.next();
                stepTracker.printStatistic(month);

            }

            if (userInput == 3) {
                System.out.println("Изменить цель по количеству шагов в день. ");
                return;
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
