package org.example.ui.impl;


import org.example.ui.DeleteEventMenu;

import java.util.Scanner;

public class DeleteEventMenuImpl implements DeleteEventMenu {
    private int choice;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        System.out.println("Введите id события, которое хотите удалить");
    }

    @Override
    public int getUserInput() {
        try {
            choice = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("Неверный ввод!!!");
        }
        return choice;
    }

}
