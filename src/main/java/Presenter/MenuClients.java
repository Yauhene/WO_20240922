package Presenter;

import Data.*;

import java.util.*;

import static Data.Client.*;
import static Presenter.Viewer.*;

public class MenuClients {

    public static void menu() {
        String result = "";
        boolean getOut = false; // флаг выхода из главного меню
        String respondString = ""; // строка-ответ
        Scanner scan = new Scanner(System.in);
        int currClient = 0;
        char firstSimbol;
        String secondAndMore;
        int shiftNumber = 0;
        Client currentClient;
//        listShow(Presenter.woListForPresenter, 7);
//        showHeaderForMenu();   !!! Уйдет в clientsListShow


        System.out.println(bottomMenu("Клиенты"));
        while (!getOut) {
//            Viewer.screenClear();
//            System.out.println("position by getCurrClientPosition(): " + getCurrClientPosition());
//            moveDown(1);
//            System.out.println("position by getCurrClientPosition(): " + getCurrClientPosition());
            clientsListShow(Client.getClients_array(), Client.getCurrClientPosition());
            System.out.println(bottomMenu("Опции работы с клиентами:"));
            respondString = "";
            System.out.print("Ваш выбор: ");
//            Временная заглушка чтения ответадля автоматического выхода
            respondString = scan.nextLine();

// Обработка команд вида d(x) и u(x)
            if (respondString.length() > 1 && !respondString.matches("[0-9]+")) {
                firstSimbol = respondString.charAt(0);
                if (firstSimbol == 'd') {
                    secondAndMore = respondString.substring(1);
                    if (respondString.substring(1).matches("[0-9]+")) {
                        shiftNumber = Integer.parseInt(secondAndMore);
                        respondString = "d";
                    } else {
                        System.out.println("Ошибочный ввод команды");
                    }
                }
                if (firstSimbol == 'u') {
                    secondAndMore = respondString.substring(1);
                    if (respondString.substring(1).matches("[0-9]+")) {
                        shiftNumber = Integer.parseInt(secondAndMore);
                        respondString = "u";
                    } else {
                        System.out.println("Ошибочный ввод команды");
                    }
                }
            }


            switch (respondString) {
                case "1": {
                    currentClient = MenuFindClient.findClientForChoice();
                    MenuEditClient.menuEditClient(currentClient);
                    System.out.println("По идее - вернулись в case \"1\": меню Клиент");
                    break;
                }
                case "": {
                    System.out.println("Меню Выбрать в разработке");
                    break;
                }
                case "3": {
                    System.out.println("Меню Редактировать в разработке");
                    break;
                }
                case "4": {
                    addClient();
                    break;
                }
                case "5": {
                    System.out.println("Меню Удалить в разработке");
                    break;
                }
                case "d": {
                    moveDown(Client.getClients_array(), shiftNumber);
                    getOut = false;
                    break;
                }
                case "u": {
                    moveUp(Client.getClients_array(), shiftNumber);
                    getOut = false;
                    break;
                }
                case "0": {
//                    System.out.println("Пока-пока! ---------------------------------------------------");
                    getOut = true;
                    break;
                }
                default: {
                    System.out.println("Ввод неверный, попробуйте еще раз");
                    break;
                }
            }

        }

//        return result;
    }

    /**
     * Процедура добавления клиента (меню "Клиент")
     */
    private static void addClient() {
//       ArrayList<String> fieldsArr = new ArrayList<>();
        String name_0 = "";
        String locPlace_1 = "";
        String locStreet_2 = "";
        String locBuilding_3 = "";
        String locOffice_4 = "";
        String cType_5 = "";
        Client client = null;
        name_0 = takeString("название клиента");
        System.out.println();
        if (!name_0.equals("oops")) {
//            fieldsArr.add(name_0);
            locPlace_1 = takeString("название населенного пункта");
            System.out.println();
        }
        if (!locPlace_1.equals("oops")) {
//            fieldsArr.add(locPlace_1);
            locStreet_2 = takeString("название улицы");
            System.out.println();
        }
        if (!locStreet_2.equals("oops")) {
//            fieldsArr.add(locStreet_2);
            locBuilding_3 = takeString("номер дома/корпуса");
            System.out.println();
        }
        if (!locBuilding_3.equals("oops")) {
//            fieldsArr.add(locBuilding_3);
            locOffice_4 = takeString("номер офиса");
            System.out.println();
        }
        if (!locOffice_4.equals("oops")) {
//            fieldsArr.add(locOffice_4);
            cType_5 = takeString("тип клиента (стройка, агро, отстрел бродячих хомяков и т. п.");
            System.out.println();
        }
        if (!cType_5.equals("oops")) {
//            fieldsArr.add(cType_5);
            client = Client.addNewClient(getMaxId() + 1, name_0, locPlace_1, locStreet_2, locBuilding_3, locOffice_4, cType_5);
            System.out.println(client);
            Client.addClientInMapById(client);
        }
    }
    /**
     * Функция построения строки-значения поля для процедуры addClient()
     * При отказе пользователя от продолжения ввода выдает "oops" как результирующую строку
     *
     * @param prompt - подсказка (имя вводимого поля)
     * @return
     */
    public static String takeString_old(String prompt) {
        String result = "";
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        String choice = "";
        boolean alarm = false;
        boolean onceMore = true;

        System.out.println("Введите " + prompt + ":");
        System.out.println("Для пропуска поля нажмите 'Enter'.");
        answer = scanner.nextLine();
        if (answer.equals("oops") || answer.equals("ой")) {
            alarm = true;
            System.out.println("alarm = " + alarm);
            System.out.println("answer = " + answer);
            result = "oops";
        }
        while (onceMore == true) {

            if (answer.equals("")) {
                System.out.println("Внесено пустое значение, '-'.");
                answer = "-";
                System.out.println("Вносим данное значение? Введите 'N' или 'Н' для отказа или 'Enter' для сохранения.");
                choice = scanner.nextLine();
                if (choice.equals("oops") || choice.equals("ой")) {
                    alarm = true;
                    onceMore = false;
                }
                if (choice.equals("")) {
                    onceMore = false;
                    result = answer;
                }
                if (choice.equals("N") || choice.equals("n") ||
                        choice.equals("Н") || choice.equals("н")) {
                    onceMore = true;
                }
            } else {
                System.out.println("Вносим данное значение? Введите 'N' или 'Н' для отказа или 'Enter' для сохранения.");
                choice = scanner.nextLine();
                if (choice.equals("N") || choice.equals("n") ||
                        choice.equals("Н") || choice.equals("н")) {
                    onceMore = true;
                }
                if (choice.equals("")) {
                    onceMore = false;
                    result = answer;
                }
            }
        }
        if (!alarm) {
            return answer;
        } else {
            return "oops";
        }
    }

    public static String takeString(String prompt) {
        String result = "";
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        String choice = "";
//        boolean alarm = false;
        boolean onceMore = true;

        System.out.println("Введите " + prompt + ":");
        System.out.println("Для пропуска поля нажмите 'Enter'.");
        answer = scanner.nextLine();
        if (answer.equals("oops") || answer.equals("ой")) {
            result = "oops";
        } else if (answer.equals("")) {
            while (onceMore) {
                System.out.println("Внесено пустое значение, '-'. Вы подтверждаете его ввод?");
                choice = scanner.nextLine();
                if (choice.equals("oops") || choice.equals("ой")) {
                    result = "oops";
                    onceMore = false;
                } else if (choice.equals("")) {
                    result = answer;
                    onceMore = false;
                } else if (choice.equals("n") || choice.equals("N") ||
                        choice.equals("н") || choice.equals("Н")) {
                    onceMore = true;
                }
            }
            result = "-";
        } else {
            while (onceMore) {
                System.out.println("Вы подтверждаете ввод?");
                choice = scanner.nextLine();
                if (choice.equals("oops") || choice.equals("ой")) {
                    result = answer;
                    onceMore = false;
                } else if (choice.equals("")) {
                    result = answer;
                    onceMore = false;
                } else if (choice.equals("n") || choice.equals("N") ||
                        choice.equals("н") || choice.equals("Н")) {
                    onceMore = true;
                    System.out.println("Введите верное значение:");
                    answer = scanner.nextLine();
                }
            }
            result = answer;
        }
        return result;
    }

    public static String ifElseTest() {
        String result = "";
        String answer = "";
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите!");
        answer = scanner.nextLine();
        boolean onceMore = true;

        if (answer.equals("oops")) {
            result = "oops";
        } else if (answer.equals("")) {
            while (onceMore) {
                System.out.println("Введено пустое значение. Вы подтверждаете ввод? ");
                choice = scanner.nextLine();
                if (choice.equals("oops")) {
                    result = "oops";
                    onceMore = false;
                } else if (choice.equals("")) {
                    result = answer;
                    onceMore = false;
                } else if (choice.equals("n")) {
                    onceMore = true;
                }
            }
            result = "-";
        } else {
            while (onceMore) {
                System.out.println("Вы подтверждаете ввод? ");
                choice = scanner.nextLine();
                if (choice.equals("oops")) {
                    result = "oops";
                    onceMore = false;
                } else if (choice.equals("")) {
                    result = answer;
                    onceMore = false;
                } else if (choice.equals("n")) {
                    onceMore = true;
                    System.out.println("Введите верное значение:");
                    answer = scanner.nextLine();
                }
            }
//            result = answer;
        }

        return result;
    }

    public static void clientsListShow(ArrayList<Client> clArray, int position) {
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
        }
        System.out.println(showHeaderForClientMenu());
        System.out.println(resultString);
    }

    public static String showHeaderForClientMenu() {
        String offset = "      ";
        String resultString = offset + "Список клиентов:\n";
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
        return resultString;
    }

    public static void moveDown_old(int posDown) {
        Client.setCurrClientPosition(getCurrClientPosition() + posDown);
    }

    public static void moveUp_old(int posUp) {
        if (getCurrClientPosition() - posUp >= 0) {
            Client.setCurrClientPosition(getCurrClientPosition() - posUp);
        } else {
            Client.setCurrClientPosition(0);
        }
    }
    public static void moveDown(ArrayList<Client> arr, int posDown) {
        Client.setCurrClientPosition(getCurrClientPosition() + posDown);
    }

    public static void moveUp(ArrayList<Client> arr, int posUp) {
        if (getCurrClientPosition() - posUp >= 0) {
            Client.setCurrClientPosition(getCurrClientPosition() - posUp);
        } else {
            Client.setCurrClientPosition(0);
        }
    }





}
