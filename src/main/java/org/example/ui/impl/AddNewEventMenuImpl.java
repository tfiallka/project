package org.example.ui.impl;


import org.example.ui.AddNewEventMenu;
import java.util.Scanner;

public class AddNewEventMenuImpl implements AddNewEventMenu {
    private final Scanner scanner = new Scanner(System.in);
    private int choice;

    @Override
    public int show() {
        try {
            System.out.println("Добавление события \n Следуйте инструкции на экране \n");
            System.out.println("Выберите тип события: \n 1. День Рождения \n 2. Мероприятие");
            choice = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("Неверный ввод");
        }
        return  choice;
    }
}
