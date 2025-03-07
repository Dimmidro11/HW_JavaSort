package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    AviaSouls avia = new AviaSouls();
    Ticket ticket1 = new Ticket( "Екатеринбург", "Санкт-Петербург", 4805, 7, 10 );
    Ticket ticket2 = new Ticket( "Екатеринбург", "Мурманск", 5879, 7, 20 );
    Ticket ticket3 = new Ticket( "Екатеринбург", "Москва", 5500, 16, 18 );
    Ticket ticket4 = new Ticket( "Екатеринбург", "Сочи", 5750, 19, 23 );
    Ticket ticket5 = new Ticket( "Екатеринбург", "Нижний Новгород", 6755, 14, 16 );
    Ticket ticket6 = new Ticket( "Екатеринбург", "Иркутск", 9612, 1, 15 );
    Ticket ticket7 = new Ticket( "Екатеринбург", "Владивосток", 17541, 0, 19 );
    Ticket ticket8 = new Ticket( "Екатеринбург", "Волгоград", 4569, 17, 20 );
    Ticket ticket9 = new Ticket( "Екатеринбург", "Сочи", 5750, 6, 10 );
    Ticket ticket10 = new Ticket( "Екатеринбург", "Волгоград", 4545, 7, 19 );
    Ticket ticket11 = new Ticket( "Екатеринбург", "Сочи", 6483, 7, 11 );
    Ticket ticket12 = new Ticket( "Екатеринбург", "Сочи", 7089, 6, 10 );
    Ticket ticket13 = new Ticket( "Екатеринбург", "Сочи", 7057, 6, 10 );
    Ticket ticket14 = new Ticket( "Екатеринбург", "Волгоград", 5045, 16, 19 );
    Ticket ticket15 = new Ticket( "Екатеринбург", "Волгоград", 6006, 17, 20 );


    @BeforeEach
    public void setup() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        avia.add(ticket8);
        avia.add(ticket9);
        avia.add(ticket10);
        avia.add(ticket11);
        avia.add(ticket12);
        avia.add(ticket13);
        avia.add(ticket14);
        avia.add(ticket15);
    }

    @Test
    public void shouldCompareToPrice() {
        Arrays.sort(avia.findAll());

        Ticket[] expected = { ticket10, ticket8, ticket1, ticket14, ticket3, ticket4, ticket9, ticket2, ticket15, ticket11, ticket5, ticket13, ticket12, ticket6, ticket7 };
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToPriceSearchSochi() {
        Ticket[] expected = { ticket4, ticket9, ticket11, ticket13, ticket12 };
        Ticket[] actual = avia.search("Екатеринбург", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToPriceSearchVolgograd() {
        Ticket[] expected = { ticket10, ticket8, ticket14, ticket15 };
        Ticket[] actual = avia.search("Екатеринбург", "Волгоград");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToTimeFly() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Arrays.sort(avia.findAll(), timeComparator);

        Ticket[] expected = { ticket3, ticket5, ticket1, ticket8, ticket14, ticket15, ticket4, ticket9, ticket11, ticket12, ticket13, ticket10, ticket2, ticket6, ticket7 };
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToTimeFlySearchVolgograd() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = { ticket8, ticket14, ticket15, ticket10 };
        Ticket[] actual = avia.searchAndSortBy("Екатеринбург", "Волгоград", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
