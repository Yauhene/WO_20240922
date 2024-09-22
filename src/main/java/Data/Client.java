package Data;

import java.io.*;
import java.util.*;

public class Client {
    private static int index = 0;
    private int id;
    private static int maxId;
    private String name;
    private String locPlace;
    private String locStreet;
    private String locBuilding;
    private String locOffice;
    private String cType;
    private static int currClientPosition = 0;

    private static HashMap<Integer, Client> clients_mapById = new HashMap<>() ;
    private static HashMap<String, Client> clients_mapByName = new HashMap<>();

    public static int getCurrClientPosition() {
        return currClientPosition;
    }

    public static HashMap<String, Client> getClients_mapByName() {
        return clients_mapByName;
    }

    public static ArrayList<Client> getClients_array() {
        return clients_array;
    }

    private static ArrayList<Client> clients_array = new ArrayList();

     private Client (int id, String name, String locPlace, String locStreet, String locBuilding, String locOffice, String cType) {
         this.id = id;
         this.name = name;
         this.locPlace = locPlace;
         this.locStreet = locStreet;
         this.locBuilding = locBuilding;
         this.locOffice = locOffice;
         this.cType = cType;
         if (maxId < this.id) maxId = this.id;

         addClientInMapById(this);
         addClientInMapByName(this);
         addClientInArray(this);

     }

    public static int getIndex() {
        return index;
    }

    public int getId() {
        return id;
    }

    public static int getMaxId() {
        return maxId;
    }

    public String getName() {
        return name;
    }

    public String getLocPlace() {
        return locPlace;
    }

    public String getLocStreet() {
        return locStreet;
    }

    public String getLocBuilding() {
        return locBuilding;
    }

    public String getLocOffice() {
        return locOffice;
    }

    public String getcType() {
        return cType;
    }

    public static HashMap<Integer, Client> getClients_mapById() {
         return clients_mapById;
    }

    public static void setCurrClientPosition(int currClientPosition) {
        Client.currClientPosition = currClientPosition;
    }

    public static void addClientInMapById(Client client) {
         if (!clients_mapById.containsKey(client.getId())) {
             clients_mapById.put(client.getId(),client);
         }
         else {
             System.out.println("Ошибка!!! Мапа clients_mapById уже содержит такой ключ.");
         }
    }

    public static void addClientInMapByName(Client client) {
        if (!clients_mapByName.containsKey(client.getName())) {
            clients_mapByName.put(client.getName(),client);
        }
        else {
            System.out.println("Ошибка!!! Мапа clients_mapById уже содержит такой ключ.");
        }
    }

    public static void addClientInArray(Client client) {
        clients_array.add(client);
    }

    /**
     * Чтение общего списка клиентов из файла
     *
     * @param fileName - файл-источник
     */
    public static void clients_from_File(String fileName) {
        String tempStr = "";
        File file = new File(fileName);
//        WOrder wo;
        try {
            Scanner scanner = new Scanner(file);
            String tStr;
            while (scanner.hasNextLine()) {
                tStr = scanner.nextLine();
                String tempStrArr[] = tStr.split(";");
//                System.out.println(" размер массива tempStrArr[]: " + tempStrArr.length);
//
                // ----- Заполнение нового экземпляра Client данными работы
//                Client client_1 = new Client(1, "Трест 15", "Минск", "Минина", "1", "", "стройка");

                Client client = new Client(Integer.parseInt(tempStrArr[0]), // id
                        tempStrArr[1].trim(), // имя клиента
                        tempStrArr[2].trim(), // локация клиента
                        tempStrArr[3].trim(), // улица
                        tempStrArr[4].trim(), // здание
                        tempStrArr[5].trim(), // номер офиса
                        tempStrArr[6].trim());// тип клиента

//                Client.addClientInMapById(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <e> void clients_to_File(String fileName) throws IOException { //throws Exception {
        String tempStr = "";
//        System.out.println(mapMashineById);
        Set<Integer> keysClients = clients_mapById.keySet();

        try (FileWriter writer = new FileWriter(fileName)) {
            for(Integer key: keysClients) {
                tempStr = "";
//                System.out.println(mapMashineById.get(key));
                tempStr += clients_mapById.get(key).getId() + "; ";
                tempStr += clients_mapById.get(key).getName() + "; ";
                tempStr += clients_mapById.get(key).getLocPlace() + "; ";
                tempStr += clients_mapById.get(key).getLocStreet() + "; ";
                tempStr += clients_mapById.get(key).getLocBuilding() + "; ";
                tempStr += clients_mapById.get(key).getLocOffice() + "; ";
                tempStr += clients_mapById.get(key).getcType() + "; ";
//                System.out.println(mapMashineById.get(key));
                writer.write(tempStr);
                writer.append('\n');
//                System.out.println(tempStr);
                writer.flush();
//                writer.close();
            }
//            System.out.println(tempStr);
            writer.flush();
//             writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Client> findClient(String template) {
        ArrayList<Client> result = new ArrayList<>();
        boolean like = false;
        template = template.toLowerCase(Locale.ROOT);
        for (int i = 0; i < clients_array.size(); i++) {
//            if (Integer.toString(clients_array.get(i).getId()).contains(template)) ||
            if ((Integer.toString(clients_array.get(i).getId()).contains(template)) ||
                    (clients_array.get(i).getName().toLowerCase().contains(template)) ||
                    (clients_array.get(i).getName().contains(template)) ||
                    (clients_array.get(i).getLocPlace().contains(template)) ||
                    (clients_array.get(i).getLocStreet().contains(template)) ||
                    (clients_array.get(i).getLocBuilding().contains(template)) ||
                    (clients_array.get(i).getLocOffice().contains(template)) ||
                    (clients_array.get(i).getcType().contains(template)))

            {
                like = true;
                result.add(clients_array.get(i));

            }

        }

        if (result != null) {
            return result;
        } else {
            System.out.println("По данному запросу соответствий не найдено");
            return result;
        }

    }

    /**
     * Функция создания нового экземпляра класса извне
     * @param id
     * @param name
     * @param locPlace
     * @param locStreet
     * @param locBuilding
     * @param locOffice
     * @param cType
     * @return
     */
    public static Client addNewClient(int id, String name, String locPlace, String locStreet, String locBuilding, String locOffice, String cType) {
        Client client = new Client(maxId + 1, name, locPlace, locStreet, locBuilding, locOffice, cType);
        maxId ++;
        return client;
    }
    public static void setMaxId(int maxId) {
        Client.maxId = maxId;
    }

    @Override
    public String toString() {
         return String.format("клиент: id %d, назв. %s, нас.пункт %s, улица %s, дом %s, офис %s, тип: %s", id, name, locPlace, locStreet, locBuilding, locOffice, cType);
     }
}
