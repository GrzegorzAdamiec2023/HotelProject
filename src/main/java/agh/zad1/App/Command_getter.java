package agh.zad1.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Command_getter {
    private static ArrayList<String> valid_commands = new ArrayList<String>(Arrays.asList("exit", "list", "checkin", "checkout",
            "view"));

    private Command_getter(){
        super();
    }
    public static Valid_Commands get_command() throws WrongCommandException {
        String userCommand;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\nPodaj komende:\n");
            userCommand = scanner.nextLine().toLowerCase();

            if (valid_commands.contains(userCommand.trim())){
                break;
            }else {
                System.out.println("Podano złą komendę, sprobój ponownie.");
            }
        }

        Valid_Commands out = Valid_Commands.EXIT;
        switch (userCommand){
            case "exit":
                break;
            case "checkout":
                out = Valid_Commands.CHECKOUT;
                break;
            case "checkin":
                out = Valid_Commands.CHECKIN;
                break;
            case "view":
                out = Valid_Commands.VIEW;
                break;
            case "list":
                out = Valid_Commands.LIST;
                break;
            default:
                throw new WrongCommandException("Podano złą komendę: " + userCommand);

        }
        return out;
    }
}

