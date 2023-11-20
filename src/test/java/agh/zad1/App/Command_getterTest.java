package agh.zad1.App;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class Command_getterTest {

    @Test
    public void get_command_exit() throws WrongCommandException {
        String input = "exit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(Valid_Commands.EXIT, Command_getter.get_command());
    }

    @Test
    public void get_command_list() throws WrongCommandException {
        String input = "LISt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(Valid_Commands.LIST, Command_getter.get_command());
    }
}