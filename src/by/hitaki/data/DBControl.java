package by.hitaki.data;

import by.hitaki.labels.DataLabels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBControl {

    private Statement st;
    private Connection conn;

    private String modeDB;
    private String rootDB;
    private String nameDB;
    private String userDB;
    private String passDB;


//    private static ObservableList<Season> seasonTable = FXCollections.observableArrayList();

    public DBControl(String modeDB, String rootDB, String nameDB, String userDB, String passDB) {
        this.modeDB = modeDB;
        this.rootDB = rootDB;
        this.nameDB = nameDB;
        this.userDB = userDB;
        this.passDB = passDB;
    }

    public void createConnection() {

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(modeDB + rootDB + nameDB, userDB, passDB);
            st = conn.createStatement();
            System.out.println("Base is opened");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            conn.close();
            st.close();
            System.out.println("Base is closed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableInBase() {
        String createSeason = "CREATE TABLE VIDEO("
                + DataLabels.ID                 + " TINYINT auto_increment, "
                + DataLabels.CREATE_DATE        + " DATE, "
                + DataLabels.PATH               + " CLOB, "
                + DataLabels.PICTURE_PATH       + " CLOB, "
                + DataLabels.NAME               + " VARCHAR, "
                + DataLabels.NAME_LIST          + " ARRAY, "
                + DataLabels.TYPE               + " VARCHAR, "
                + DataLabels.COUNTRY            + " VARCHAR, "
                + DataLabels.STUDIO             + " VARCHAR, "
                + DataLabels.DESCRIPTION        + " CLOB, "
                + DataLabels.RATING_WA          + " TINYINT, "
                + DataLabels.RATING_MY          + " TINYINT, "
                + DataLabels.RELEASE_DATE       + " DATE, "
                + DataLabels.END_DATE           + " DATE, "
                + DataLabels.LAST_VIEW_DATE     + " DATE, "
                + DataLabels.STATUS             + " VARCHAR, "
                + DataLabels.URL_WA             + " CLOB, "
                + DataLabels.SERIES_COUNT       + " TINYINT, "
                + DataLabels.SERIES_VIEWED      + " ARRAY, "
                + DataLabels.ANI_SEASON         + " VARCHAR, "
                + DataLabels.FILM_DIRECTOR      + " VARCHAR, "
                + DataLabels.GENRES             + " ARRAY, "
                + DataLabels.RELATED_VIDEO_ID   + " VARCHAR"
                +")";
        try {
            st.execute(createSeason);
            System.out.println("Video table was created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRowInTable() {
        String query = "INSERT INTO VIDEO(NAME, STUDIO ) VALUES(?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, null);
            ps.setString(2, "AHAHAHAAHAHAHAHAAHA");
            ps.executeUpdate();
            System.out.println("Row added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
