package Presenter;

import Data.*;

import java.util.*;

import static Presenter.MenuClients.*;
import static Presenter.Viewer.*;

public class MenuMashines {

        public static void menu() {
            String result = "";
            boolean getOut = false; // флаг выхода из главного меню
            String respondString = ""; // строка-ответ
            Scanner scan = new Scanner(System.in);
//        listShow(Presenter.woListForPresenter, 7);
//        showHeaderForMenu();   !!! Уйдет в clientsListShow


            System.out.println(bottomMenu("Машины"));
            while (!getOut) {
//            Viewer.screenClear();
                clientsListShow(Client.getClients_array(), Client.getCurrClientPosition());
                System.out.println(bottomMenu("Опции работы с машинами:"));
                respondString = "";
                System.out.print("Ваш выбор: ");
//            Временная заглушка чтения ответадля автоматического выхода
                respondString = scan.nextLine();
                switch (respondString) {
                    case "1" : {
                        System.out.println("Меню Найти в разработке");
                        break;
                    }
                    case "2" : {
                        System.out.println("Меню Выбрать в разработке");
                        break;
                    }
                    case "3" : {
                        System.out.println("Меню Редактировать в разработке");
                        break;
                    }
                    case "4" : {
//                    System.out.println(ifElseTest());
                        addMashine();
                        break;
                    }
                    case "5" : {
                        System.out.println("Меню Удалить в разработке");
                        break;
                    }
                    case "0", "" : {
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

        /** Процедура добавления клиента (меню "Клиент")
         *
         */
        private static void addMashine() {
//       ArrayList<String> fieldsArr = new ArrayList<>();
            String brand_0 = "";
            String model_1 = "";
            String sNumber_2 = "";
            int idClient_3 = -1;
            Mashine mashine = null;
            brand_0 = takeString("название бренда");
            System.out.println();
            if (!brand_0.equals("oops")) {
//            fieldsArr.add(name_0);
                model_1 = takeString("название модели");
                System.out.println();
            }
            if (!model_1.equals("oops")) {
//            fieldsArr.add(locPlace_1);
                sNumber_2 = takeString("серийный номер");
                System.out.println();
            }
            if (!sNumber_2.equals("oops")) {
//            fieldsArr.add(locStreet_2);


//                !!!!!!!!!  функция  findClientByName() пока не существует, нужно написать  !!!!!!!!!!

                idClient_3 = menuFindClientByName();
                System.out.println();
            }
//            if (!locBuilding_3.equals("oops")) {
////            fieldsArr.add(locBuilding_3);
//                locOffice_4 = takeString("номер офиса");
//                System.out.println();
//            }
//            if (!locOffice_4.equals("oops")) {
////            fieldsArr.add(locOffice_4);
//                cType_5 = takeString("тип клиента (стройка, агро, отстрел бродячих хомяков и т. п.");
//                System.out.println();
//            }
            if (idClient_3 > 0) {
//            fieldsArr.add(cType_5);
//                int intIdClient = Integer.parseInt(idClient_3);
                mashine = new Mashine(Mashine.getMaxId() + 1, brand_0, model_1, sNumber_2, idClient_3);
                Mashine.addMashineInMapById(mashine);
                System.out.println(mashine);
                Mashine.addMashineInMapById(mashine);
            }
        }

        /**
         * Функция построения строки-значения поля для процедуры addMashine()
         * При отказе пользователя от продолжения ввода выдает "oops" как результирующую строку
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
                } else
                {
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
            } else  {
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
        public static void mashinesListShow(HashMap<Integer, Mashine> map ){
            String resultString = "";
            Mashine mashine;
            int currMashine = 0;
            ArrayList<Mashine> mashArray = new ArrayList<>();
            for ( Map.Entry entry: map.entrySet()) {
                mashine = (Mashine) entry.getValue();
                mashArray.add(mashine);
            }
            int showSize = 10; // количество выводимых клиентов
            if (showSize > mashArray.size()) { showSize = mashArray.size();} // переопределение на случай если элементов массива меньше десяти
            for (int i = 0; i < showSize; i++) {
                if (i != currMashine) { resultString += "     ";}
                else { resultString += ">>>>>"; }
                resultString += " |      " + mashArray.get(i).getId(); // id
                resultString += String.format("| %-21s", mashArray.get(i).getBrand()); // brand
                resultString += String.format("| %-17s", mashArray.get(i).getModel()); // model
                resultString += String.format("| %-21s ", mashArray.get(i).getsNumber()); // serial number
                resultString += String.format("| %-8s ", mashArray.get(i).getIdClient()); // id of client
//
            }
            System.out.println(showHeaderForMashineMenu());
            System.out.println(resultString);
        }

        public static String showHeaderForMashineMenu() {
            String offset = "      ";
            String resultString = offset + "Список машин:\n";
            resultString += offset;
            resultString += "=================================================================================================================================\n";
            resultString += offset;
            resultString += "|  id   "; // Добавляем id машины
            resultString += String.format("| %-20s ", "Бренд"); // Добавляем бренд
            resultString += "|  Модель       "; // Добавляем модель
            resultString += String.format("| %-15s ", "S/N");// Добавляем серийный номер
            resultString += "| id клиента " + "\n"; // Добавляем id клиента
            resultString += "=================================================================================================================================";

            return resultString;
        }

    public static int menuFindClientByName() {
        int result = -1;
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя клиента:");
        answer = scanner.nextLine();


        return result;
    }

}
