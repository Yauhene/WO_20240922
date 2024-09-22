package Service;

import Presenter.*;

import java.io.*;
import Windows.*;

public class StartProgram {
    public static void main(String[] args) throws IOException {
//        filesOperations.in_out.clientsFromFile("src/Files/clients.txt");
//        testList();

// ==== Отключено для запуска версии в окне
//        Presenter pres = new Presenter();
// ====

// ** запуск версии в окне
        PresenterForMainWindow presenter = new PresenterForMainWindow();
    new MainWindow();
    }
}