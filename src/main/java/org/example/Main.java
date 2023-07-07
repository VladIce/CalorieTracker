package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);


        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput < 0 || userInput > 4) {
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
                    System.out.println("Укажите месяц с заглавной буквы: ");
                    numberOfDay = scanner.nextInt();
                }

                System.out.println("Укажите количество шагов: ");
                int numberSteps = scanner.nextInt();
                stepTracker.saveSteps(month, numberOfDay, numberSteps);


            }


            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 2) {
                System.out.println("Вы выбрали 2");
                return;
            }
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 3) {
                System.out.println("Вы выбрали 3");
                return;
            }
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 4) {
                System.out.println("Вы выбрали 5");
                return;
            }
        }


    }

    private static void printMenu() {

        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Напечатать статистику за определённый месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выйти из приложения.");

    }
}
