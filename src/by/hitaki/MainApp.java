package by.hitaki;

import by.hitaki.data.DBControl;
import by.hitaki.labels.DataLabels;
import by.hitaki.labels.PickListLabels;
import by.hitaki.logic.VideoWrapper;
import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp extends Application {

    public static String modeBD = "jdbc:h2:file:";
    public static String folderRoot = System.getProperty("user.dir");
    public static String nameBD = "/db/videoSequencerDB";
    public static String userBD = "sa";
    public static String passBD = "";

    public static void main(String[] args) {

        VideoWrapper vw = new VideoWrapper();
        vw.createDate           = LocalDate.now();
        vw.path                 = "Path";
        vw.picturePath          = "PicturePath";
        vw.name                 = "Name";
        vw.nameList             = Arrays.asList("one", "two");
        vw.type                 = PickListLabels.TYPE_MOVIE;
        vw.country              = "Nippon";
        vw.studio               = "Bones";
        vw.description          = "some description";
        vw.ratingWA             = 10;
        vw.ratingMY             = 5;
        vw.releaseDate          = LocalDate.of(2018, 1,1);
        vw.endDate              = LocalDate.of(2018, 2,1);
        vw.lastviewDate         = LocalDate.now();
        vw.status               = PickListLabels.STATUS_NOW;
        vw.urlWA                = "http://world-art.ru";
        vw.seriesCount          = 13;
        vw.seriesViewed         = 0;
        vw.aniSeason            = null;
        vw.filmDirector         = "Hitaki";
        vw.genres               = Arrays.asList("Trash");
        vw.relatedVideoList     = null;

        DBControl dbControl = new DBControl(modeBD, folderRoot, nameBD, userBD, passBD);
        dbControl.createConnection();
        dbControl.addRow(vw);
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
