package ru.netology.javaqa;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {

    private String from;
    private String to;
    private int price;
    private int timeFrom;
    private int timeTo;

    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getFrom() {
        return from;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public int getPrice() {
        return price;
    }

    public String getTo() {
        return to;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && timeFrom == ticket.timeFrom && timeTo == ticket.timeTo && from.equals(ticket.from) && to.equals(ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, timeFrom, timeTo);
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
