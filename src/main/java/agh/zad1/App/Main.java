package agh.zad1.App;

import agh.zad1.hotel.Hotel;
import agh.zad1.hotel.ZaDuzoPokoiException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ZaDuzoPokoiException {
        Hotel hotel = new Hotel(10, 64);
        Scanner scanner = new Scanner(System.in);
        Valid_Commands command;
        String nr_pokoju;
        while(true){
            command = Command_getter.get_command();

            switch (command){
                case exit:
                    System.exit(0);
                    break;

                case checkout:
                    System.out.println("Podaj numer pokoju");
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.checkout(nr_pokoju));
                    break;

                case checkin:
                    System.out.println("Podaj numer pokoju");
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.checkin(nr_pokoju));
                    break;

                case view:
                    System.out.println("Podaj numer pokoju");
                    nr_pokoju = scanner.nextLine();
                    System.out.print(hotel.view(nr_pokoju));
                    break;

                case list:
                    System.out.print(hotel.list());
                    break;
            }
        }
    }
}