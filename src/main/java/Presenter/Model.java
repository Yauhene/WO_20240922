package Presenter;

import Data.*;

import java.io.*;
import java.util.*;

import static filesOperations.in_out.WO_to_File;

public class Model {
    //public static ArrayList<WOrder> wo_List = new ArrayList<>();
    public static ArrayList<Mashine> mash_List = new ArrayList<>();
    public static ArrayList<Client> cl_List = new ArrayList<>();
    private static HashMap<Integer, Client> map_clientsById = new HashMap<>();
    private static HashMap<String, WOrder> map_WoByName = new HashMap<>();
    private static HashMap<Integer, WOrder> map_WoById = new HashMap<>();
    private static HashMap<Integer, ArrayList<WRecord>> map_RecordsByWo = new HashMap<>(); // ключ - id воркордера
    // значение - ArrayList с записями
    private static HashMap<String, ArrayList<WRecord>> map_RecordsByDate = new HashMap<>();
    private static woLinkList wo_MapList;

    public static woLinkList woList = new woLinkList();


    public static woLinkList getWoList() {
        return woList;
    }

    public Model() throws IOException {
        testList();
    }


    /**
     * ТЕСТОВЫЙ!!!!
     * Создание начального массива данных
     */
    public static void testList() throws IOException {
        System.out.println();
        System.out.println("*********************************************************************************************************************************");
        System.out.println("!!!!!!!!!!!     попытка чтения clients.txt");

        Client.clients_from_File("./src/main/java/Files/clients.txt");

        System.out.println("!!!!!!!!!!!     прочитан src/main/java/Files/clients.bak");

        Client.clients_to_File("./src/main/java/Files/clients.bak");

        Mashine.mashines_from_File("./src/main/java/Files/machines.txt");
        Mashine.mashines_to_File("./src/main/java/Files/machines.bak");

        WO_from_File("./src/main/java/Files/workorders.txt");
        WO_to_File("./src/main/java/Files/workorders.bak");

        System.out.println();
//        woLinkList.woDisplayList();

        WO_to_File("./src/main/java/Files/workorders.txt");
        Mashine.mashines_to_File("./src/main/java/Files/machines.txt");
        Client.clients_to_File("./src/main/java/Files/clients.txt");
    }

    /**
     * Размещение данных о воркордере в мапах
     */
    public static void hashMapWoWork(WOrder wo) {
        map_WoByName.put(wo.getWoName(), wo);
        map_WoById.put(wo.getId(), wo);
    }

    /**
     * Вывод в консоль мапы map_WoByName
     */
    public static void print_hasMapWoByName() {
        WOrder wo;
        for (Map.Entry entry : map_WoByName.entrySet()) {
            wo = (WOrder) entry.getValue();
            System.out.println("Название воркордера: " + entry.getKey() + ", указатель id: " + wo.getId());
        }
    }

    /**
     * Процедура чтения воркордеров из файла
     *
     * @param fileName
     */
    public static void WO_from_File(String fileName) {
        String tempStr = "";
        File file = new File(fileName);
//        WOrder wo;
        try {
            Scanner scanner = new Scanner(file);
            String tStr;
            while (scanner.hasNextLine()) {
                tStr = scanner.nextLine();
               String tempStrArr[] = tStr.split(";");
//
                // ----- Заполнение нового экземпляра WOrder данными работы
                int recCount = Integer.parseInt(tempStrArr[5]); // приводим к int количество записей работ в WO
                WOrder wo = new WOrder(Integer.parseInt(tempStrArr[0]),
                        tempStrArr[1],
                        Integer.parseInt(tempStrArr[2]),
                        Integer.parseInt(tempStrArr[3]),
                        Integer.parseInt(tempStrArr[4]),
                        recCount);
//                WOrder.print_WOrder(wo);
                wo.recordsList = new ArrayList<WRecord>();
                // ----- Внесение записей о работах
                for (int i = 0; i < recCount; i++) {
                    String tRecStr = scanner.nextLine();
                    String tStrArr[] = tRecStr.split(";");
                    tempStr = tStrArr[0].trim();
                    tempStr = tempStr.substring(1);
//                    System.out.println("tempStr = " + tempStr);
                    tempStr += tStrArr[1].trim();
//                    System.out.println("size = " + tStrArr.length);


//                    for (int j = 0; j < tStrArr.length; j++) {
//                        System.out.println("- "  + j + ": " + tStrArr[j]);
//                    }
                    int id = Integer.parseInt(tStrArr[0].trim().substring(1));
                    int idd = Integer.parseInt(tStrArr[1].trim());

                    String wPlace = tStrArr[10].trim();
                    String wType = tStrArr[9].trim();
                    String wDday = tStrArr[2].trim();
                    String wDmonth = tStrArr[3].trim();
                    String wDyear = tStrArr[4].trim();
                    String wBegH = tStrArr[5].trim();
                    String wBegM = tStrArr[6].trim();
                    String wEndH = tStrArr[7].trim();
                    String wEndM = tStrArr[8].trim();
                    String descr = tStrArr[11].trim();
                    int dist = Integer.parseInt(tStrArr[12].trim());

                    wo.recordsList.add(new WRecord(id, idd, wPlace, wType, // id, wPlace, wType
                            wDday, wDmonth, wDyear, // дата
                            wBegH, wBegM, // время начала
                            wEndH, wEndM, // время завершения
                            dist, // расстояние
                            descr)); // описание
//                    wo.printRecList();
//                    WOrder.printTestRecList(wo.recordsList);
                }
//                wo.printRecList();
                WOrder.sortRecordsList(wo.recordsList);
                woList.insertLast(wo);

//                System.out.println("-----------------------------------------------------");
//                pause();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Процедура извлечения дня, месяца и года из строки формата "dd-mm-yyyy"
     * @param str строка формата "dd-mm-yyyy"
     * @return
     */
    public String[] dateSeparFromDate(String str) {
        String tempStrArr[] = str.split("-");
        return tempStrArr;
    }



    public static void pause() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PRESS ANY KEY");
        String s = scanner.nextLine();
    }

    /**
     * Функция поиска клиента по имени
     * @param clName
     * @return
     */
    public static int findClientByName(String clName) {
        return 11111;
    }

}