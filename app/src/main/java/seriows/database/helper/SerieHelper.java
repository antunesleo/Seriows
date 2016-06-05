package seriows.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import seriows.database.DatabaseHelper;
import seriows.database.table.SerieTable;
import seriows.model.Item;
import seriows.model.Series;

/**
 * Created by thiag on 05/06/2016.
 */
public class SerieHelper {
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;

    public SerieHelper(Context context){
        mContext = context;
        mDatabaseHelper = new DatabaseHelper(mContext);
    }

    //Metodo para inserir os dados no sqlite da lista criada com o json
    public void insertFromSeries(Series series){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();

        //Repeticao para inserir os dados da lista no sqlite
        for(Item item : series.itens){
            ContentValues values = new ContentValues();

            values.put(SerieTable.SERIES_NAME, item.seriesName);
            values.put(SerieTable.SERIES_ACTIVITY, item.seriesActivity);
            values.put(SerieTable.SERIES_RATE, item.seriesName);
            values.put(SerieTable.SERIES_TYPE, item.seriesType);
            values.put(SerieTable.SERIES_RESUME, item.seriesResume);
            values.put(SerieTable.SERIES_PRIMARY_IMAGE, item.imagens.urlPrimaryImage);
            values.put(SerieTable.SERIES_SECONDARY_IMAGE, item.imagens.urlSecondaryImagem);
            db.insert(SerieTable.TABLE_NAME, null, values);

        }
    }

    public Cursor getData(){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        // Query for items from the database and get a cursor back
        //String qry = "SELECT * FROM " + SerieTable.TABLE_NAME;
        Cursor cursor = db.rawQuery("SELECT  * FROM series", null);

        return cursor;
    }
}
