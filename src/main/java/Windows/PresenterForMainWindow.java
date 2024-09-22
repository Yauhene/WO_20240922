package Windows;

//import.Service.Model;

import Data.*;
import Presenter.*;

import java.io.*;

public class PresenterForMainWindow {
    public static woLinkList woListForPresenter;

    public PresenterForMainWindow() throws IOException {
        String command = "";
        Model ModelList = new Model();
        woListForPresenter = ModelList.getWoList();

//        Viewer viewer = new Viewer();


//        while (!command.equals("exit")) {
//            command = getMenuAnswer(woListForPresenter);
////            command = "exit";
//        }

    }
//    public static String getMenuAnswer(woLinkList woList) throws IOException {
//        String result = Viewer.mainMenu(woList);
//        return result;
//    }


}
