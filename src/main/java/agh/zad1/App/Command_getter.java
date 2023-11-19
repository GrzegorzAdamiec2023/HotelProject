package agh.zad1.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Command_getter {
    private static ArrayList<String> valid_commands = new ArrayList<String>(Arrays.asList("exit", "list", "checkin", "checkout",
            "view"));

    public static Valid_Commands get_command(){
        String userCommand;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\nPodaj komende:\n");
            userCommand = scanner.nextLine();

            if (valid_commands.contains(userCommand.trim())){
                break;
            }else {
                System.out.println("Podano złą komendę, sprobój ponownie.");
            }
        }

        Valid_Commands out = Valid_Commands.exit;
        switch (userCommand){
            case "exit":
                out = Valid_Commands.exit;
                break;
            case "checkout":
                out = Valid_Commands.checkout;
                break;
            case "checkin":
                out = Valid_Commands.checkin;
                break;
            case "view":
                out = Valid_Commands.view;
                break;
            case "list":
                out = Valid_Commands.list;
                break;
        }
        return out;
    }
}

