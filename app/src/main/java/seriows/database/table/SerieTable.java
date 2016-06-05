package seriows.database.table;

/**
 * Created by thiag on 05/06/2016.
 */
public interface SerieTable {

    String TABLE_NAME = "series";

    String ID = "_id";
    String SERIES_NAME = "series_name";
    String SERIES_ACTIVITY = "series_activity";
    String SERIES_RATE = "series_rate";
    String SERIES_TYPE = "series_type";
    String SERIES_RESUME = "series_resume";
    String SERIES_PRIMARY_IMAGE = "primary_image";
    String SERIES_SECONDARY_IMAGE = "secondary_image";

    String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SERIES_NAME + " TEXT, "
            + SERIES_ACTIVITY + " TEXT, "
            + SERIES_RATE + " float, "
            + SERIES_TYPE + " TEXT, "
            + SERIES_RESUME + " TEXT, "
            + SERIES_PRIMARY_IMAGE + " TEXT, "
            + SERIES_SECONDARY_IMAGE + " TEXT )";


    String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
