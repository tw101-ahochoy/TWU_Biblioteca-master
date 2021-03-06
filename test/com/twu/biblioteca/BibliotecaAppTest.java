package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


// Dismantle!
public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private BufferedReader inStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inStream = mock(BufferedReader.class);

        Collection<String> bookList = new ArrayList<String>();
        bookList.add("Book 1");
        Catalog catalog = new Catalog(bookList, printStream);
        biblioteca = new BibliotecaApp(catalog, printStream, inStream);
    }

    @Test
    public void shouldDisplayWelcomeMessage(){
        biblioteca.displayUserPrompt();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayBookListWhenGivenProperInput() throws IOException {
        when(inStream.readLine())
                .thenReturn("1");

        biblioteca.readUserInput();
        verify(printStream).println("Book List:");
        verify(printStream).println("Book 1");

    }
}
