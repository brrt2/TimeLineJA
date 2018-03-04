package model;

import java.time.LocalDate;

public class Event {

    private EventType eventType;
    private LocalDate date;
    private String description;

    public Event(String description) {
        this.description = description;
    }
}
