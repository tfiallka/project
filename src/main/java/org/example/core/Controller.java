package org.example.core;

import org.example.db.DB;
import org.example.db.DBImpl;
import org.example.ui.AddNewEventMenu;
import org.example.ui.DeleteEventMenu;
import org.example.ui.MainMenu;
import org.example.ui.ShowAllEventsMenu;
import org.example.ui.impl.*;


public class Controller {
    private final MainMenu mainMenu = new MainMenuImpl();
    private final DB db = new DBImpl();

    public void start() {
        int choice;
        do {
            mainMenu.show();
            choice = mainMenu.getUserInput();
            switch (choice) {
                case 1 -> showAllEvents();
                case 2 -> addNewEvent();
                case 3 -> deleteEvent();
                case 4 -> exit();
                default -> System.out.println("\nНеправильный ввод!!!\n");
            }
        }
        while (choice != 4);
    }

    private void showAllEvents() {
        ShowAllEventsMenu showAllEventsMenu = new ShowAllEventsMenuImpl();
        showAllEventsMenu.show();
        if (db.getAll() != null) {
            db.getAll().stream().forEach(System.out::println);
        } else {
            System.out.println("Нет информации о мероприятиях");
        }
    }

    private void addNewEvent() {
        AddNewEventMenu addNewEventMenu = new AddNewEventMenuImpl();
        int eventType = addNewEventMenu.show();
        if (eventType == 1) {
            AddBirthDayMenuImpl addBirthDayMenuImpl = new AddBirthDayMenuImpl();
            db.add(addBirthDayMenuImpl.show());
        } else if (eventType == 2) {
            AddMeetingMenuImpl addMeetingMenuImpl = new AddMeetingMenuImpl();
            db.add(addMeetingMenuImpl.show());
        }
    }

    private void deleteEvent() {
        DeleteEventMenu deleteEventMenu = new DeleteEventMenuImpl();
        deleteEventMenu.show();
        db.delete(deleteEventMenu.getUserInput());
    }

    private void exit() {
        System.out.println("\nСпасибо за использование программы! Пока!\n");
        System.exit(0);
    }

}



