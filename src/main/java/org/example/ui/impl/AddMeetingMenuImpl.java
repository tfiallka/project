package org.example.ui.impl;

import org.example.models.Meeting;
import org.example.ui.AddMeetingMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddMeetingMenuImpl implements AddMeetingMenu {
    private final Scanner scanner = new Scanner(System.in);
    private LocalDate date;
    private LocalTime time;

    @Override
    public Meeting show() {
        try {
            System.out.println("Введите информацию о мероприятии \n Дата мероприятия(в формате YYYY-MM-DD:");
            date = LocalDate.parse(scanner.next());
            System.out.println("Введите время мероприятия");
            time = LocalTime.parse(scanner.next());
        } catch (RuntimeException e) {
            System.out.println("Неверный ввод!!!");
        }
            return new Meeting(date, time);
        }
}
