package com.timeline.model;

import java.time.LocalDate;
import java.util.Date;

public class Event {

    private EventType eventType;
    private LocalDate date;
    private String description;

    public Event() { }

  public Event(EventType eventType, LocalDate date, String description) {
    this.eventType = eventType;
    this.date = date;
    this.description = description;
  }

  public Event(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
