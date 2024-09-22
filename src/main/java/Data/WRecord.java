package Data;

import Service.Service;
public class WRecord {
    private static int maxId;
    private int id;
    private int idWO;
    private String wPlace;
    private String wType;
    private String wDateDay;
    private String wDateMonth;
    private String wDateYear;
    private String wBeginHours;
    private String wBeginMinutes;
    private String wEndHours;
    private String wEndMinutes;
    private String wDuration = "0";
    private int wDistance = 0;
    private String wDescription = "";

    public WRecord(
            int id, int idWO, String wPlace, String wType,
            String wDateDay, String wDateMonth, String wDateYear,
            String wBeginHours, String wBeginMinutes,
            String wEndHours, String wEndMinutes, int wDistance, String wDescription) {
        this.id = id;
        this.idWO = idWO;
        this.wPlace = wPlace;
//        System.out.println("wPlace = " + wPlace);
        this.wType = wType;
        this.wDateDay = wDateDay;
        this.wDateMonth = wDateMonth;
        this.wDateYear = wDateYear;
        this.wBeginHours = wBeginHours;
        this.wBeginMinutes = wBeginMinutes;
        this.wEndHours = wEndHours;
        this.wEndMinutes = wEndMinutes;
        this.wDistance = wDistance;
        this.wDescription = wDescription;
//        System.out.println("Description = " + wDescription);
        this.wDuration = Service.DateDifferent(wDateDay, wDateMonth, wDateYear, wBeginHours, wBeginMinutes,
                wDateDay, wDateMonth, wDateYear, wEndHours, wEndMinutes);
        if (maxId < this.id) maxId = this.id;

    }

    @Override
    public String toString() {
//        return String.format("WO id: %d, %s, %s, %s, %s, %s, %s", %d, %s ",
//        idWO, wPlace, wType, wDate, wBegin, wEnd, wDuration, wDistance, wDescription);
          return String.format("|   %-5d | %s-%s-%s |  %s:%s | %s:%s  |  %5s   | %-15s   | %-18s | %-3s | %s",
        id, wDateDay, wDateMonth, wDateYear, wBeginHours, wBeginMinutes, wEndHours,
                  wEndMinutes,  wDuration, wPlace,  wType, wDistance, wDescription);

    }

    public int getIdWO() {
        return idWO;
    }

    public String getwPlace() {
        return wPlace;
    }

    public String getwType() {
        return wType;
    }

    public String getwDateDay() {
        return wDateDay;
    }

    public String getwDateMonth() {
        return wDateMonth;
    }

    public String getwDateYear() {
        return wDateYear;
    }

    public String getwBeginHours() {
        return wBeginHours;
    }

    public String getwBeginMinutes() {
        return wBeginMinutes;
    }

    public String getwEndHours() {
        return wEndHours;
    }

    public String getwEndMinutes() {
        return wEndMinutes;
    }

    public String getwDuration() {
        return wDuration;
    }

    public int getwDistance() {
        return wDistance;
    }

    public String getwDescription() {
        return wDescription;
    }

    public static int getMaxId() {
        return maxId;
    }

    public int getId() {
        return id;
    }
}
