package Windows;

import Data.*;
import Presenter.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static Data.Client.getClients_mapById;
import static Data.Mashine.get_mapMashineById;
import static Data.WOrder.getBriefWOInfo;

public class MainWindow extends JFrame {


    public MainWindow() throws HeadlessException {
        final int WINDOW_HEIGHT = 600;
        final int WINDOW_WIDTH = 1000;
        final int WINDOW_POSX = 200;
        final int WINDOW_POSY = 200;

        final int worksArraySize = 8; // Количество полей в правой панели

        woLinkList woList = Model.getWoList();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Главное окно");
        setResizable(false);
// *** Правая панель
        JPanel panRight = new JPanel(new GridLayout(worksArraySize, 1));
        panRight.setSize(200, 3);
//        ***  Содержимое правой панели
    // Объявляем массив из полей
        ArrayList<JTextField> rightTextArray = new ArrayList<JTextField>(worksArraySize);

    // Заполняем массив полями, добавляя их в правую панель
        for (int i = 0; i <= worksArraySize-1; i++) {
            JTextField fieldR = new JTextField(75);
            fieldR.setText("Это номер " + i);
            rightTextArray.add(fieldR);
            panRight.add(fieldR);
        }

        add(panRight, BorderLayout.EAST);
// *** Правая панель завершение


        setVisible(true);
    }



    /**
     * == Процедура вывода последних элементов списка в текстовую панель
     * @param list - список woLinkList
     * @param num - количество выводимых элементов
     */
    public static String listShowForTextArea(JTextField[] arr, woLinkList list, int num) {
        String result = "";
//        area.setText(WOrder.showHeaderForMenu());
        result += WOrder.showHeaderForMenu() + "\n";
//        int n = 0;
        int n = list.getElementsCount();
//        woLink element = list.last;
        woLink curr = list.last;
//        woLinkList.setCurrentElement(0);
        // Проверка на существование выводимого числа элементов в списке list
        if (num > n) {
            num = n;
        }
        // --- конец проверки
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for ( int i = 1; i <= n; i++) {
            result += getBriefWOInfoForTextArea(curr.w_order) + "\n";
//            area.setText(area.getText() + getBriefWOInfo(curr.w_order) + "\n");
            System.out.println(getBriefWOInfo(curr.w_order));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            curr = curr.getPrev();
        }
        return result;

    }

    public static String getBriefWOInfoForTextArea(WOrder wo) {
        String resultString = "";
        String offset = "     ";
        // Добавляем отступ
//        System.out.println("Проверка:---------------------------------");
//        System.out.println("woLinkList.currEl.w_order.getId() = " + woLinkList.currEl.w_order.getId());
//        System.out.println("wo.getId() = " + wo.getId());
//        if (woLinkList.currEl.w_order.getId() == wo.getId()) {
//            offset = ">>>>>";
//        } else {
//            offset = "     ";
//        }
        resultString += offset;
        // Добавляем id воркордера
        resultString += String.format("| %5d ", wo.getId());
        // Добавляем иия воркордера
        resultString += String.format("| %10s ", wo.getWoName());
        // Добавляем первую дату начала работ
        resultString += String.format("| %2s-%2s-%4s ",
                wo.recordsList.get(0).getwDateDay(),
                wo.recordsList.get(0).getwDateMonth(),
                wo.recordsList.get(0).getwDateYear());
        // Добавляем места работ
        for (int i = 0; i < wo.getCountOfRecords(); i++) {
            resultString += wo.recordsList.get(i).getwPlace() + ", ";
        }
        // Добавляем последнюю дату начала работ
        resultString += String.format("| %2s-%2s-%4s ",
                wo.recordsList.get(wo.getCountOfRecords()).getwDateDay(),
                wo.recordsList.get(wo.getCountOfRecords()).getwDateMonth(),
                wo.recordsList.get(wo.getCountOfRecords()).getwDateYear());
        // Добавляем примечание о работах воркордера
        for (int i = 0; i < wo.getCountOfRecords(); i++) {
            resultString += wo.recordsList.get(i).getwDescription() + ", ";
        }
        // Добавляем место проведения работ
        for (int i = 0; i < wo.recordsList.size(); i++) {
            if (!wo.recordsList.get(i).getwDescription().contains("дорога")) {
                resultString += String.format("| %-10s ", wo.recordsList.get(i).getwPlace());
                break;
            }
        }
        // Добавляем клиента
        resultString += String.format("| %-14s", getClients_mapById().get(wo.getIdClient()).getName());
        resultString += String.format(" ( id %-5d)", getClients_mapById().get(wo.getIdClient()).getId());
        resultString += String.format(" | %-10s", get_mapMashineById().get(wo.getIdMash()).getBrand());
        resultString += String.format(" | %-10s", get_mapMashineById().get(wo.getIdMash()).getModel());
        resultString += String.format(" | %-10s |", get_mapMashineById().get(wo.getIdMash()).getsNumber());
        resultString += "\n     |        |             работы: ";
        for (int j = 0; j < wo.recordsList.size(); j++) {
            if (!wo.recordsList.get(j).getwDescription().contains("дорога")) {
                resultString += wo.recordsList.get(j).getwDescription() + "; ";
            }
        }

//        String datesString = "";
//        System.out.println();
        return resultString;
    }
}
