package agh.zad1.hotel;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    @Test
    public void list() throws ZaDuzoPokoiException {
        Hotel hotel = new Hotel(10, 64);
        hotel.checkin("101");
        String out = hotel.list();

        String goal = "Piętro: 0\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 1\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 63\n" +
                "\n" +
                "Piętro: 2\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 3\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 4\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 5\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 6\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 7\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 8\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n" +
                "\n" +
                "Piętro: 9\n" +
                "Liczba pokoi = 64\n" +
                "Liczba wolnych = 64\n\n";
        assertEquals(goal, out);
    }


    @Test
    public void view() throws ZaDuzoPokoiException {
        Hotel hotel = new Hotel(10, 64);
        assertEquals("Pokój na piętrze: 1 o numerze: 01\n" +
                " status: WOLNY\n", hotel.view("101"));
    }

    @Test
    public void checkin() throws ZaDuzoPokoiException {
        Hotel hotel = new Hotel(10, 64);
        hotel.checkin("101");
        assertEquals("Pokój na piętrze: 1 o numerze: 01\n" +
                " status: ZAJĘTY\n", hotel.view("101"));

    }

    @Test
    public void checkout() throws ZaDuzoPokoiException {
        Hotel hotel = new Hotel(10, 64);
        hotel.checkin("101");
        hotel.checkout("101");
        assertEquals("Pokój na piętrze: 1 o numerze: 01\n" +
                " status: WOLNY\n", hotel.view("101"));
    }
}