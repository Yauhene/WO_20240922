package Presenter;

import Data.*;

public class MenuEditClient {
    public static void menuEditClient(Client client) {
//        showHeaderClientEdit(client); // *******
//        showClientEdit(client); // ******
        System.out.println("Редактирование данных клиента.");
        System.out.println(client);
    }
    public static void showClientEdit(Client client) {
        String offset = "      ";
        String resultString = offset + "Редактирование записи о клиенте:\n";
        resultString += offset;
        resultString += "=================================================================================================================================\n";
        resultString += offset;
        resultString += "|  id   "; // Добавляем id клиента
        resultString += String.format("| %-20s ", "Название"); // Добавляем иия клиента
        resultString += "|  Нас.пункт       "; // Добавляем расположение клиента
        resultString += String.format("| %-21s ", "Улица");// Добавляем улицу
        resultString += "| Дом/корп. "; // Добавляем номер дома
        resultString += String.format("|%-4s", "Офис"); // Добавляем офис клиента
        resultString += String.format("| %-15s", "Тип") + "\n"; // Добавляем тип клиента
        resultString += offset;
        resultString += "=================================================================================================================================";

        resultString = "";

        resultString += " |      " + client.getId(); // id
        resultString += String.format("| %-21s", client.getName()); // name
        resultString += String.format("| %-17s", client.getLocPlace()); // place
        resultString += String.format("| %-21s ", client.getLocStreet()); // street
        resultString += String.format("| %-8s ", client.getLocBuilding()); // building
        resultString += " |  " + client.getLocOffice(); // office
        resultString += " |  " + client.getcType() + "\n"; // type
    System.out.println(resultString);
    }
}
