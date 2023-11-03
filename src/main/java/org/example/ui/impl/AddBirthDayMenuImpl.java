package org.example.ui.impl;

import org.example.models.BirthDay;
import org.example.ui.AddBirthDayMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class AddBirthDayMenuImpl implements AddBirthDayMenu {
    private final Scanner scanner = new Scanner(System.in);
    private LocalDate dateOfBirth;
    private String firstName;
    private String gender;
    private String lastName;
    private boolean isRelative;

    @Override
    public BirthDay show() {
        try {
            System.out.println("Введите информацию о дне рождения");
            System.out.println("Введите дату рождения в формате YYYY-MM-DD:");
            dateOfBirth = LocalDate.parse(scanner.next());
            System.out.println("Введите имя: ");
            firstName = scanner.next();
            System.out.println("Введите фамилию: ");
            lastName = scanner.next();
            System.out.println("Введите пол: 1. М 2. Ж");
            if (scanner.nextInt() == 1) {
                gender = "M";
            } else if (scanner.nextInt() == 2) {
                gender = "Ж";
            } else {
                System.out.println("Вы ввели неправильную цифру. Повторите сначала");
            }
            System.out.println("Это ваш родственник?: 1. Да 2. Нет");
            if (scanner.nextInt() == 1) {
                isRelative = true;
            } else if (scanner.nextInt() == 2) {
                isRelative = false;
            } else {
                System.out.println("Вы ввели неправильную цифру. Повторите сначала");
            }
        } catch (RuntimeException e) {
            System.out.println("неверный ввод!!!");
        }

        return new BirthDay(dateOfBirth, gender, isRelative, firstName, lastName);
    }
}
