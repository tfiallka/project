package org.example.models;

import java.time.LocalDate;
import java.util.Random;

public class Event  {
    private int id;
    private LocalDate eventDate;

    public Event(LocalDate eventDate) {
        this.id = new Random().nextInt();
        this.eventDate = eventDate;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventDate=" + eventDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

}
