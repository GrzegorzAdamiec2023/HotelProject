package agh.zad1.App;

import agh.zad1.hotel.Hotel;
import agh.zad1.hotel.ZaDuzoPokoiException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ZaDuzoPokoiException, WrongCommandException {
        Hotel hotel = new Hotel(10, 64);
        Scanner scanner = new Scanner(System.in);
        Valid_Commands command;
        String nr_pokoju;
        String zapytanieOPokoj = "Podaj numer pokoju";
        boolean end = false;

        while (!end) {
            command = Command_getter.get_command();

            switch (command) {
                case EXIT:
                    end = true;
                    break;

                case CHECKOUT:
                    System.out.println(zapytanieOPokoj);
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.checkout(nr_pokoju));
                    break;

                case CHECKIN:
                    System.out.println(zapytanieOPokoj);
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.checkin(nr_pokoju));
                    break;

                case VIEW:
                    System.out.println(zapytanieOPokoj);
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.view(nr_pokoju));
                    break;

                case LIST:
                    System.out.print(hotel.list());
                    break;
            }
        }
    }
}