package Data;

import java.util.*;

public class woLinkList {
    public static woLink first;
    public static woLink last;
    public static woLink currEl; // текущая позиция в связанном списке
    static int elCount = 0;
    public static HashMap<String, Integer> woLinkHashMap = new HashMap<>();

    public woLinkList(){
        first = null;
        last = null;
        currEl = last;
    }

    public void insertFirst(int id, WOrder wo) {
        // Создание нового элемента
        woLink newLink = new woLink(id, wo);
        woLinkList.elCount += 1;
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
        System.out.println("Current woLinkList.elCount = " + woLinkList.elCount);
    }

    /**
     * Добавление нового элемента в конец списка воркордеров,
     *                 id нового элемента равен id воркордера
     * @param wo - данные элемента
     */
    public static void insertLast(WOrder wo) {
        int id = wo.getId(); // извлечение id воркордера
        woLinkHashMap.put(wo.getWoName(),wo.getId()); // Добавляем воркордер в мап воркордеров
        //System.out.println("------------<<< " + woLinkHashMap.get(wo.getWoName()));
        // Создание нового элемента
        woLink newLink = new woLink(wo.getId(), wo);
        woLinkList.elCount += 1;
        if (first == null)
        {
            first = newLink;
        }
        if (last == null)
        {
            last = newLink;
        }
        newLink.setPrev(last); // newLink --> старое значение last
        last.next = newLink;
        last = newLink; // last --> newLink
        currEl = last;
    }

    /**
     * Вывод данных списка воркордеров в консоль
     */
    public static void woDisplayList()
    {
//        System.out.println("===== Содержимое woLinkList(first-->last):");
//        System.out.println("List (first-->last): ");
        System.out.println();
        woLink current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
//            System.out.println("id работы: " + current.getId());
            current.displayWoLink(); // Вывод данных
//             System.out.println("current element: " + current + "; prev: " + current.getPrev() + "; next: " + current.next);
//            WOrder.print_WOrder(current);
            System.out.println();
            current = current.next; // Переход к следующему элементу

        }
//        System.out.println("===== конец распечатки woLinkList");
        System.out.println();

    }
    public static void setCurrentElement(int offset) {
        if (offset < woLinkList.elCount) {
            offset = woLinkList.elCount-1;
            for (int i = 0; i < offset; i++) {
                woLinkList.currEl = currEl.getPrev();
//                System.out.println("in lap:");
//                System.out.println("offset = " + offset + ", " + "current id: " + currEl.w_order.getId());
            }
        }
//        System.out.println("as result: offset = " + offset + ", " + "current id: " + currEl.w_order.getId());
    }
    public int getElementsCount()
    {
        return woLinkList.elCount;
    }

    public static woLink getFirst() {
        return first;
    }

    public static woLink getLast() {
        return last;
    }
}
