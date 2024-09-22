package Data;

import java.io.*;
import java.util.*;

public class Mashine {
    private static int index = 0;
    private static FileWriter writer;
    private int id;

    private static int maxId = 0;
    private String brand;
    private String model;
    private String sNumber;
    private int idClient;
    private static HashMap<Integer, Mashine> mapMashineById = new HashMap<>();

    public Mashine(int id, String brand, String model, String sNumber, int idClient) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.sNumber = sNumber;
        this.idClient = idClient;
        if (id > maxId) maxId = id;
    }

    /**
     * == Процедура чтения машин из файла
     * @param fileName - имя файла
     */
    public static void mashines_from_File(String fileName) {
        String tempStr = "";
        File file = new File(fileName);
//        WOrder wo;
        try {
            Scanner scanner = new Scanner(file);
            String tStr;
            while (scanner.hasNextLine()) {
                tStr = scanner.nextLine();
                String tempStrArr[] = tStr.split(";");

                Mashine mashine = new Mashine(Integer.parseInt(tempStrArr[0].trim()), // id
                        tempStrArr[1].trim(), // бренд
                        tempStrArr[2].trim(), // модель
                        tempStrArr[3].trim(), // серийный номер
                        Integer.parseInt(tempStrArr[4].trim())); // id клиента
                if (mashine.getId() > maxId) {
                    maxId = mashine.id;
                }
//                System.out.println();
//                System.out.println("Распечатка из Mashine.mashines_from_File после создания экземпляра машины");
//                System.out.println(mashine);
                Mashine.addMashineInMapById(mashine);

//                System.out.println(mapMashineById);
            }
//            System.out.println();
//            System.out.println("Распечатка из Mashine.mashines_from_File после внесения машин в мапу");
//            System.out.println(mapMashineById);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(mapMashineById);
    }

    public static <e> void mashines_to_File(String fileName) throws IOException { //throws Exception {
        String tempStr = "";
//        System.out.println(mapMashineById);
        Set<Integer> keysMas = mapMashineById.keySet();

        try (FileWriter writer = new FileWriter(fileName)) {
            for(Integer key: keysMas) {
                tempStr = "";
//                System.out.println(mapMashineById.get(key));
                tempStr += mapMashineById.get(key).getId() + "; ";
                tempStr += mapMashineById.get(key).getBrand() + "; ";
                tempStr += mapMashineById.get(key).getModel() + "; ";
                tempStr += mapMashineById.get(key).getsNumber() + "; ";
                tempStr += mapMashineById.get(key).getIdClient() + "; ";
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


    public static void addMashineInMapById(Mashine mashine) {
//        if (mashine.getId() = null) {
//            mashine.setId(Mashine.getMaxId + 1);
//        }
//        System.out.println();
//        System.out.println("Распечатка из Mashine.addMashineInMapById на входе");
//        System.out.println("Mashine: \n" + mashine);
        if (!mapMashineById.containsKey(mashine.getId())) {

//            System.out.println();
//            System.out.println("Перед самым внесением машины в мапу в addMashineInMapById:");
//            System.out.println("id " + mashine.getId() + ", mashine: "+ mashine.model + " " + mashine.getIdClient());

            mapMashineById.put(mashine.getId(), mashine);

//            System.out.println();
//            System.out.println("Запись в мапе после внесения машины по ключу '1': ");
//            System.out.println("id " + mapMashineById.get(1).getId()
//                    + ", mashine: "+mapMashineById.get(1).getModel()
//                    + " " + mapMashineById.get(1).getIdClient());
//            System.out.println();

//            System.out.println();
//            System.out.println("После внесения машины в мапу в addMashineInMapById:");
//            System.out.println("id " + mashine.getId() + ", mashine: "+ mashine.model + " " + mashine.getIdClient());

        } else {
            System.out.println("Ошибка!!! Мапа cmapMashineByIdd уже содержит такой ключ.");
        }
    }

    public static HashMap<Integer, Mashine> get_mapMashineById() {
        return mapMashineById;
    }




        @Override
        public String toString () {
            return String.format("машина %d, бренд %s, модель: %s, s/n %s, клиент %d",
                    id, brand, model, sNumber, idClient);
        }


        public int getIndex () {
            return index;
        }

        public int getId () {
            return id;
        }

        public static int getMaxId () {
            return maxId;
        }

        public String getBrand () {
            return brand;
        }

        public String getModel () {
            return model;
        }

        public String getsNumber () {
            return sNumber;
        }

        public int getIdClient() {
            return idClient;
        }

        public HashMap<Integer, Mashine> getMapMashineById () {
            return mapMashineById;
        }


    public void setId(int id) {
        this.id = id;
    }
}