package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting extends Event {
    private LocalTime timeOfEvent;
    public Meeting(LocalDate eventDate, LocalTime timeOfEvent) {
        super(eventDate);
        this.timeOfEvent = timeOfEvent;
    }

    public Meeting(LocalTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }
    public Meeting() {
    }

    public LocalTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }
}
