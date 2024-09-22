package Data;

public class woLink {
    private int id;
    public final WOrder w_order;
    public woLink next;
    private woLink prev;
    public int elCount = 0;

    public woLink (int id, WOrder w_order) {
        this.id = id;
        this.w_order = w_order;
        this.elCount += 1;

    }
    //------------------------------------------------


    public woLink getPrev() {
        return prev;
    }

    public int getId() {
        return w_order.getId();
    }


    public void setPrev(woLink prev) {
        this.prev = prev;
    }

    /**
     * Вывод на экран элемента woLink
     *
     */
    public void displayWoLink() {

//        System.out.println("[ " + id + ", " + w_order.getWoName() + ", " +
//                w_order.getIdMash() + ", " +  w_order.getHoursMash() + ", " +
//                w_order.getIdClient() + ", " + next + ", " + getPrev() + " ]");

        System.out.println(w_order.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| id      | Дата       | Начало | Конец  | Всего, ч |       Место       | Тип                |  км |     Описание  ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i <= w_order.recordsList.size() - 1; i ++) {
            System.out.println(w_order.recordsList.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

} //------ конец класса woLink ---------------------------------------
