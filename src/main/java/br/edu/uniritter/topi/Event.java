package br.edu.uniritter.topi;

import java.util.Date;

public class Event {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void save() {

    }

    public Event setDate(Date date) {
        this.date = date;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
}