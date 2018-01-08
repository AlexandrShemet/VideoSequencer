package by.hitaki;

import by.hitaki.data.DBControl;
import by.hitaki.labels.DataLabels;
import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    public static String modeBD = "jdbc:h2:file:";
    public static String folderRoot = System.getProperty("user.dir");
    public static String nameBD = "/db/videoSequencerDB";
    public static String userBD = "sa";
    public static String passBD = "";

    public static void main(String[] args) {

        DBControl dbControl = new DBControl(modeBD, folderRoot, nameBD, userBD, passBD);
        dbControl.createConnection();
//        dbControl.createTableInBase();
        dbControl.addRowInTable();
        dbControl.closeConnection();

//        for (Field field : DataLabels.class.getFields()) {
//            System.out.println(field);
//            try {
//                System.out.println((String)field.get(field.get(field.getName())));
//            } catch (Exception e) {
//            }
//        }

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
