package by.hitaki.labels;

import java.util.Arrays;
import java.util.List;

public class PickListLabels {

    //Video Types
    public static String TYPE_ANI_TV        = "Ani Tv";
    public static String TYPE_ANI_OVA       = "Ani Ova";
    public static String TYPE_ANI_SPECIAL   = "Ani Special";
    public static String TYPE_ANI_MOVIE     = "Ani Movie";
    public static String TYPE_MOVIE         = "Movie";
    public static String TYPE_DORAMA        = "Dorama";
    public static String TYPE_SERIAL        = "Serial";
    public static String TYPE_SHORT_SERIAL  = "Short Serial";

    public static List<String> TYPE_LIST = Arrays.asList(
            TYPE_ANI_TV,
            TYPE_ANI_OVA,
            TYPE_ANI_SPECIAL,
            TYPE_ANI_MOVIE,
            TYPE_MOVIE,
            TYPE_DORAMA,
            TYPE_SERIAL,
            TYPE_SHORT_SERIAL
    );


    //Video Status
    public static String STATUS_QUEUE   = "Queue";
    public static String STATUS_NOW     = "Now";
    public static String STATUS_WATCHED = "Watched";

    public static List<String> STATUS_LIST = Arrays.asList(
            STATUS_QUEUE,
            STATUS_NOW,
            STATUS_WATCHED
    );

    //Rating
    public static List<Integer> RATING_MY = Arrays.asList(0, 1, 2, 3, 4);
}
