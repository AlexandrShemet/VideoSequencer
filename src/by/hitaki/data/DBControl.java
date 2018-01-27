package by.hitaki.data;

import by.hitaki.labels.DataLabels;
import by.hitaki.logic.VideoWrapper;
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
                + DataLabels.RELATED_VIDEO_ID   + " ARRAY"
                +")";
        try {
            st.execute(createSeason);
            System.out.println("Video table was created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRow(VideoWrapper vw) {
        String query = "INSERT INTO VIDEO( "+ DataLabels.FIELD_LIST_WITHOUT_ID + " ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(vw.createDate));        // CREATE_DATE
            ps.setString(2, vw.path);                                   // PATH
            ps.setString(3, vw.picturePath);                            // PICTURE_PATH
            ps.setString(4, vw.name);                                   // NAME
            ps.setObject(5, vw.nameList);                               // NAME_LIST
            ps.setString(6, vw.type);                                   // TYPE
            ps.setString(7, vw.country);                                // COUNTRY
            ps.setString(8, vw.studio);                                 // STUDIO
            ps.setString(9, vw.description);                            // DESCRIPTION
            ps.setInt(10, vw.ratingWA);                                 // RATING_WA
            ps.setInt(11, vw.ratingMY);                                 // RATING_MY
            ps.setDate(12, java.sql.Date.valueOf(vw.releaseDate));      // RELEASE_DATE
            ps.setDate(13, java.sql.Date.valueOf(vw.endDate));          // END_DATE
            ps.setDate(14, java.sql.Date.valueOf(vw.lastviewDate));     // LAST_VIEW_DATE
            ps.setString(15, vw.status);                                // STATUS
            ps.setString(16, vw.urlWA);                                 // URL_WA
            ps.setInt(17, vw.seriesCount);                              // SERIES_COUNT
            ps.setInt(18, vw.seriesViewed);                             // SERIES_VIEWED
            ps.setString(19, vw.aniSeason);                             // ANI_SEASON
            ps.setString(20, vw.filmDirector);                          // FILM_DIRECTOR
            ps.setObject(21, vw.genres);                                // GENRES
            ps.setObject(22, vw.relatedVideoList);                      // RELATED_VIDEO_ID

            ps.executeUpdate();
            System.out.println("Row added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeRow(VideoWrapper vw) {
        
    }

}
