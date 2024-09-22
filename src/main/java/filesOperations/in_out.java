package filesOperations;

import Data.*;

import java.io.*;
import java.util.*;

//import static Data.Client.clients_mapById;
import static Data.Client.getClients_mapById;

//import static Data.woLinkList.getFirstfirst;

public class in_out {
    /**
     * Сохранение воркордеров в файл
     * @param fileName
     * @throws Exception
     */
    public static void WO_to_File(String fileName) throws IOException { //throws Exception {
        //ArrayList<Toy> arr = Toy.toysList;
        woLinkList wo_ll = Presenter.Model.woList;
        String tempStr = "";
        FileWriter writer = null;
        writer = new FileWriter(fileName);

        woLink current = wo_ll.getFirst(); // От начала списка
        try {
            while (current != null) {
                //public WOrder (int id, String woName, int idMash, int hoursMash, int idClient, int countOfRecords)
                tempStr = current.w_order.getId() + ";" +
                        current.w_order.getWoName() + ";" +
                        current.w_order.getIdMash() + ";" +
                        current.w_order.getHoursMash() + ";" +
                        current.w_order.getIdClient() + ";" +
                        current.w_order.recordsList.size();
//                System.out.println("tempStr = " + tempStr);
                writer.write(tempStr);
                writer.append('\n');
                if (current.w_order.recordsList.size() != 0) {
//                    System.out.println("current.w_order.recordsList.size() = " + current.w_order.recordsList.size());
                    for (int j = 0; j <= current.w_order.recordsList.size() - 1; j++) {
                        //id, idWO, wDateDay, wDateMonth, wDateYear, wBeginHours, wBeginMinutes, wEndHours, wEndMinutes,  wDuration, wType,  wPlace, wDescription
                        tempStr = "~" + current.w_order.recordsList.get(j).getId() + "; " +
                                current.w_order.recordsList.get(j).getIdWO() + "; " +
                                current.w_order.recordsList.get(j).getwDateDay() + "; " +
                                current.w_order.recordsList.get(j).getwDateMonth() + "; " +
                                current.w_order.recordsList.get(j).getwDateYear() + "; " +
                                current.w_order.recordsList.get(j).getwBeginHours() + "; " +
                                current.w_order.recordsList.get(j).getwBeginMinutes() + "; " +
                                current.w_order.recordsList.get(j).getwEndHours() + "; " +
                                current.w_order.recordsList.get(j).getwEndMinutes() + "; " +
                               // current.w_order.recordsList.get(j).getwDuration() + "; " +
                                current.w_order.recordsList.get(j).getwType() + "; " +
                                current.w_order.recordsList.get(j).getwPlace() + "; " +
                                current.w_order.recordsList.get(j).getwDescription() + "; " +
                                current.w_order.recordsList.get(j).getwDistance() + "; ";
//                        System.out.println("tempStr = " + tempStr);
                        writer.write(tempStr);
                        writer.append('\n');
                    }
                }
                current = current.next;
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



//    public static void clientsFromFile(String fileName) {
//        String tempStr = "";
////        String tempStrArr[];
//        File file = new File(fileName);
//        try {
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                String tStr = scanner.nextLine();
//                String tempStrArr[] = tStr.split(";");
//                System.out.println(tempStrArr[0] + ", " + tempStrArr[1] + ", " +tempStrArr[2] + ", " + tempStrArr[3]);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//
//        clientsFromFile("src/Files/clients.txt");
//    }

    public static void helloFromFiles() {
        System.out.println();
        System.out.println();
        System.out.println("Hi from in_out.java !!!");

    }


}