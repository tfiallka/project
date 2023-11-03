package org.example.ui.impl;

import org.example.ui.MainMenu;

import java.util.Scanner;


public class MainMenuImpl implements MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private int choice;

    @Override
    public void show() {
        System.out.println("Добро пожаловать в RemindMe");
        System.out.println("Выберите действие: \n 1. Посмотреть все события \n 2. Добавить новое событие\n 3. Удалить событие \n 4. Закрыть программу");
    }

    @Override
    public int getUserInput() {
        try {
            choice = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("Неправильный ввод!!!");
        }
        return choice;
    }
}

