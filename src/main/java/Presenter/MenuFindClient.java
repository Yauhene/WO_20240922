package Presenter;

import Data.*;

import java.util.*;

public class MenuFindClient {
    public static Client findClientForChoice() {
        boolean getOut = false;
        Scanner scanner = new Scanner(System.in);
        char firstSimbol;
        String secondAndMore = "";
        int shiftNumber = 0;
        int arrPosition = 0;
        Client currentClient = null;
        Client result;

        while (!getOut) {

            System.out.println("------- вошли в цикл");

            System.out.println("Введите образец поиска:");
            String temp = scanner.nextLine();
            ArrayList<Client> arr = Client.findClient(temp);
            System.out.println("arrPosition: " + arrPosition);
            if (arr.size() > 0) {
                currentClient = arr.get(0);

                System.out.println("Результаты поиска:");
                clientsFoundListShow(arr, 0);
            } else {
//                currentClient = null;
                System.out.println("Не найдено подходящих записей");
            }

            temp = scanner.nextLine();
            // Обработка команд вида d(x) и u(x)
            if ((temp.equals("d") || (temp.equals("в")))) {
//                System.out.println("------выбрали обработку d");
                temp = "d";
                shiftNumber = 1;
            }
            if ((temp.equals("u") || (temp.equals("г")))) {
                temp = "u";
                shiftNumber = -1;
            }
            if (temp.length() > 1 && !temp.matches("[0-9]+")) {
                firstSimbol = temp.charAt(0);
                if ((firstSimbol == 'd') || (firstSimbol == 'в')) {
                    firstSimbol = 'd';
                    secondAndMore = temp.substring(1);
                    if (temp.substring(1).matches("[0-9]+")) {
                        shiftNumber = Integer.parseInt(secondAndMore);
                        temp = "d";
                    } else {
                        System.out.println("Ошибочный ввод команды");
                    }
                    System.out.println("--------" + "firstSimbol = " + firstSimbol + ";  " + "shiftNumber = " + shiftNumber);
                }
                if ((firstSimbol == 'u') || firstSimbol == 'г') {
                    firstSimbol = 'u';
                    secondAndMore = temp.substring(1);
                    if (temp.substring(1).matches("[0-9]+")) {
                        shiftNumber = Integer.parseInt(secondAndMore) * -1;
                        temp = "u";

                    } else {
                        System.out.println("Ошибочный ввод команды");
                    }
                }
            }
            arrPosition += shiftNumber;
            if (temp.equals("")) {
                System.out.println("Нажат Enter//////" );
            }

            switch (temp) {

                case "0": {
                    System.out.println("------ зашли в '0'");
//                    System.out.println("Меню Найти в разработке");
                    currentClient = arr.get(arrPosition);
                    MenuEditClient.menuEditClient(currentClient);
                    getOut = true;
                    break;
                }
                case "": {

                    System.out.println("------ зашли в Редактирование " );
                    result = currentClient;
//                    System.out.println("Меню Выбрать в разработке");
                    MenuEditClient.menuEditClient(currentClient);
                    getOut = false;
                    break;
                }
                case "d": {
                    System.out.println("------ зашли в 'd'");
//                    moveDown(arr, shiftNumber);
//                    arrPosition += shiftNumber;
//                    clientsListShow(arr, arrPosition + shiftNumber);
//                    arrPosition += shiftNumber;
//                    clientsListShow(arr, arrPosition);
                    clientsFoundListShow(arr, arrPosition);
                    currentClient = arr.get(arrPosition);
                    getOut = false;
                    break;
                }
                case "u": {
                    System.out.println("------ зашли в 'u'");
//                    moveUp(arr, shiftNumber);
//                    clientsListShow(arr, arrPosition - shiftNumber);
//                    arrPosition -= shiftNumber;
                    clientsFoundListShow(arr, arrPosition);
                    getOut = false;
                    break;
                }
                default: {
                    System.out.println("Ввод неверный, попробуйте еще раз");
                    break;
                }

            }

            System.out.println("----- вышли из цикла");
        }
        return currentClient;
    }

    /**
     * Метод вывода "подвала" для массива клиентов после поиска
     */
    public static void printFoundArrBottom() {
//            clientsFoundListShow(arr, currPos);
        String bottomLine = " \n";
        bottomLine += "0 - Назад; Enter - Выбрать\n";
        bottomLine += "=================================================================================================================================\n";
        bottomLine += "Перемещения: \n";
        bottomLine += "d ('Down') - вниз на позицию, d3 - вниз на 3 позиции и так далее. \n";
        bottomLine += "u ('Up') - вверх на позицию, u3 - вверх на 3 позиции и так далее. \n";
        System.out.println(bottomLine);
    }

    /**
     * Метод вывода страницы результатов поиска
     * @param clArray - массив-результат поиска
     * @param position - текущая строка-клиент
     */
    public static void clientsFoundListShow(ArrayList<Client> clArray, int position) {
        System.out.println();
        System.out.println();
        System.out.println("Поиск клиентов по шаблону.");
        System.out.println("Найдено записей: " + clArray.size());
        System.out.println();
        String resultString = "";
        Client client;
        int showSize = 10; // количество выводимых клиентов
        if (showSize > clArray.size()) {
            showSize = clArray.size();
        } // переопределение на случай если элементов массива меньше десяти
        if ((clArray.size() - position) > showSize) {
            showSize = clArray.size() - position;
        }
        for (int i = position; i < showSize; i++) {
//            System.out.println("position = " + position);
            if (i != position) {
                resultString += "     ";
            } else {
                resultString += ">>>>>";
            }
            resultString += " |      " + clArray.get(i).getId(); // id
            resultString += String.format("| %-21s", clArray.get(i).getName()); // name
            resultString += String.format("| %-17s", clArray.get(i).getLocPlace()); // place
            resultString += String.format("| %-21s ", clArray.get(i).getLocStreet()); // street
            resultString += String.format("| %-8s ", clArray.get(i).getLocBuilding()); // building
            resultString += " |  " + clArray.get(i).getLocOffice(); // office
            resultString += " |  " + clArray.get(i).getcType() + "\n"; // type
//
        }
        System.out.println(MenuClients.showHeaderForClientMenu());
        System.out.println(resultString);
        printFoundArrBottom();
    }
}
