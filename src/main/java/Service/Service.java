package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    public static String DateDifferent(String strDateDay_1, String strDateMonth_1, String strDateYear_1,
                                       String strHours_1, String strMinutes_1,
                                       String strDateDay_2, String strDateMonth_2, String strDateYear_2,
                                       String strHours_2, String strMinutes_2) {
        String resultStr = "";
        double resultDouble = 0;

        String sDay_1 =  strDateDay_1;
        String sMonth_1 = strDateMonth_1;
        String sYear_1 = strDateYear_1;

        String sHours_1 = strHours_1;
        String sMinutes_1 = strMinutes_1;

        String sDay_2 =  strDateDay_2;
        String sMonth_2 = strDateMonth_2;
        String sYear_2 = strDateYear_2;

        String sHours_2 = strHours_2;
        String sMinutes_2 = strMinutes_2;

        String dateStart = sDay_1 + "/" + sMonth_1 + "/" + sYear_1 + " " +
                sHours_1 + ":" + sMinutes_1 + ":00";

        String dateStop = sDay_2 + "/" + sMonth_2 + "/" + sYear_2 + " " +
                sHours_2 + ":" + sMinutes_2 + ":00";

//        System.out.println(dateStart);
//        System.out.println(dateStop);

        // ЧЧ преобразует часы в 24-часовой формат (0-23), расчет дня
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

// в миллисекундах
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);



//            if (diffDays > 0) {
//                System.out.print(diffDays + " days, ");
//            }
            if (diffHours > 0) {
//                System.out.print(diffHours + " hours, ");
                resultDouble += (double) diffHours;
//                System.out.println(resultStr);
            }
            if (diffMinutes > 0) {
//                System.out.print(diffMinutes + " minutes, ");
                double minutes = (double) diffMinutes / 60;
                resultDouble +=  minutes;
            }
//            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        resultStr = Double.toString(resultDouble);
        return resultStr;
    }

}
