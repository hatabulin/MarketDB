package com.example.test.model.repositorys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test.model.events.BooleanEvent;
import com.example.test.model.events.MarketListEvent;
import com.example.test.model.models.MarketModel;
import com.example.test.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import static com.example.test.MyApp.getContext;

public class DatabaseRepositoryImpl extends SQLiteOpenHelper implements DatabaseRepository {

    //  данные по умолчанию в таблице 'shop'
    final int[] market_stock_id = {2, 1, 5, 6};
    final String[] market_name = {"TamTam", "Silpo", "ATB", "Salut"};
    // данные по умолчанию в таблице 'stock'
    final int[] stock_id = {1, 2, 3, 4, 5, 6};
    final String[] stock_name = {"STOCK #1", "STOCK #2", "STOCK #3", "STOCK #4", "STOCK #5", "STOCK #6"};
    final int[] stock_product_id = {2, 3, 2, 2, 3, 1};
    // данные по умолчанию в таблице 'product_name'
    final int[] product_id = {1, 2, 3, 4, 5, 6};
    final String[] product_name = {"Apple", "Orange", "Lemon", "Tea", "Beer", "Vodka"};

    final private String TABLE_MARKETS_NAME = "markets";
    final private String DATABASE_NAME = "base_db";

    final private String NAME_FIELD = "name";
    final private String STOCK_ID_FIELD = "stock_id";

    public SQLiteDatabase sqLiteDatabase;

    public DatabaseRepositoryImpl() {

        super(getContext(), "base_db", null, 1);
        sqLiteDatabase = getWritableDatabase();
        LogUtils.log("--== DATABASE '" + DATABASE_NAME + "' CREATED SUCCESS !==--");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        this.sqLiteDatabase = sqLiteDatabase;
        ContentValues contentValues = new ContentValues();

        LogUtils.log(" --== CREATE TABLE '" + TABLE_MARKETS_NAME + "' ==--");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MARKETS_NAME + " ("
                + "id integer primary key, "
                + NAME_FIELD + " text, "
                + STOCK_ID_FIELD + " integer "
                + ");");

        // заполняем первую
        for (int i = 0; i < market_name.length; i++) {
            contentValues.clear();
            contentValues.put(NAME_FIELD, market_name[i]);
            contentValues.put(STOCK_ID_FIELD, market_stock_id[i]);
            sqLiteDatabase.insert(TABLE_MARKETS_NAME, null, contentValues);
        }
    }

    @Override
    public void addRecordToTable(MarketModel model, BooleanEvent event) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_FIELD, model.getName());
        contentValues.put(STOCK_ID_FIELD, model.getStockID());

        sqLiteDatabase.insert(TABLE_MARKETS_NAME, null, contentValues);
        LogUtils.log("--== LOG MODEL ADDED TO TABLE '" + TABLE_MARKETS_NAME + "' SUCCESS. ==--");

        event.result(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKETS_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void checkTable(BooleanEvent event) {

        Cursor cursor;

        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.query(TABLE_MARKETS_NAME, null, null, null, null, null, null);
            if (cursor.getCount() > 0) {
                sqLiteDatabase.close();
                event.result(true);
            } else {
                sqLiteDatabase.close();
                event.result(false);
            }
        } else {
            LogUtils.log(" --== TABLE '" + TABLE_MARKETS_NAME + "' IS EMPTY !!! ==--");
            event.result(false);
        }
    }

    @Override
    public void getAllRecordsFtomTable(MarketModel model, MarketListEvent event) {
        Cursor cursor;

        List<MarketModel> listArray = new ArrayList<>();
        cursor = sqLiteDatabase.query(TABLE_MARKETS_NAME, null, null, null, null, null, null);

        LogUtils.log(" --== GET RECORDS FROM TABLE '" + TABLE_MARKETS_NAME + "' ==--");
        if (cursor != null) {
            if (cursor.moveToFirst()) {

                int name = cursor.getColumnIndex(NAME_FIELD);
                int stock = cursor.getColumnIndex(STOCK_ID_FIELD);

                do {
                    MarketModel marketModel = new MarketModel();

                    marketModel.setName(cursor.getString(name));
                    marketModel.setStockID(cursor.getInt(stock));
                    listArray.add(marketModel);

                } while (cursor.moveToNext());
                LogUtils.log("--== TABLE '" + TABLE_MARKETS_NAME + "' HAVE " + listArray.size() + " records.. .==--");
                event.result(listArray);
            }
        }
        cursor.close();
    }

    @Override
    public void getAllRecordsFtomTableStock(MarketModel model, MarketListEvent event) {

    }


    @Override
    public void clearDB(BooleanEvent event) {

        LogUtils.log(" --== DELETE ALL DATA FROM TABLE '" + TABLE_MARKETS_NAME + "' ==--");
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_MARKETS_NAME);

        event.result(true);
    }

    @Override
    public void fillTable() {

    }

    @Override
    public void getAllRecordsFtomTable(MarketModel model) {

    }

    @Override
    public void closeBase() {
        sqLiteDatabase.close();
    }
}
