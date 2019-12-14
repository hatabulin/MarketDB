package com.example.marketDB.model.repositorys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.marketDB.model.events.BooleanEvent;
import com.example.marketDB.model.events.MarketListEvent;
import com.example.marketDB.model.events.MarketWithStockListEvent;
import com.example.marketDB.model.models.MarketModel;
import com.example.marketDB.model.models.MarketWithStockModel;
import com.example.marketDB.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import static com.example.marketDB.MyApp.getContext;

public class DatabaseRepositoryImpl extends SQLiteOpenHelper implements DatabaseRepository {

    //  данные по умолчанию в таблице 'shop'
    final int[] market_stock_id = {2, 1, 5, 6};
    final String[] market_name = {"ТАМ-ТАМ", "Сільпо", "АТБ", "Салют"};
    // данные по умолчанию в таблице 'stock'
    final String[] stock_name = {"Львів", "Луцьк", "Рівне", "Київ", "Харків", "Крим"};
    // данные по умолчанию в таблице 'product_name'
    final int[] product_id = {1, 2, 3, 4, 5, 6};
    final String[] product_name = {"Яблоки", "Груши", "Мандарині", "Виноград", "Хлеб", "Бухло"};

    final private String TABLE_MARKETS_NAME = "markets";
    final private String TABLE_STOCKS_NAME = "stocks";

    final private String DATABASE_NAME = "base_db";

    final private String NAME_FIELD = "name";
    final private String STOCK_ID_FIELD = "stock_id";
    final private String PRODUCT_ID_FIELD = "product_id";

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

        LogUtils.log(" --== CREATE TABLE '" + TABLE_STOCKS_NAME + "' ==--");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_STOCKS_NAME + " ("
                + "id integer primary key, "
                + NAME_FIELD + " text, "
                + PRODUCT_ID_FIELD + " integer "
                + ");");

        // заполняем первую
        for (int i = 0; i < market_name.length; i++) {
            contentValues.clear();
            contentValues.put(NAME_FIELD, market_name[i]);
            contentValues.put(STOCK_ID_FIELD, market_stock_id[i]);
            sqLiteDatabase.insert(TABLE_MARKETS_NAME, null, contentValues);
        }

        for (int i = 0; i < stock_name.length; i++) {
            contentValues.clear();
            contentValues.put(NAME_FIELD, stock_name[i]);
            contentValues.put(PRODUCT_ID_FIELD, product_id[i]);
            sqLiteDatabase.insert(TABLE_STOCKS_NAME, null, contentValues);
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
    public void getAllRecordsFtomTableMarket(MarketModel model, MarketListEvent event) {

        Cursor cursor;

        List<MarketModel> listMarket = new ArrayList<>();

        cursor = sqLiteDatabase.query(TABLE_MARKETS_NAME, null, null, null, null, null, null);

        LogUtils.log(" --== GET RECORDS FROM TABLE '" + TABLE_MARKETS_NAME + "' ==--");
        if (cursor != null) {
            if (cursor.moveToFirst()) {

                int marketNameFieldIndex = cursor.getColumnIndex(NAME_FIELD);
                int marketStockIdFieldIndex = cursor.getColumnIndex(STOCK_ID_FIELD);

                do {
                    MarketModel marketModel = new MarketModel();

                    marketModel.setName(cursor.getString(marketNameFieldIndex));
                    marketModel.setStockID(cursor.getInt(marketStockIdFieldIndex));
                    listMarket.add(marketModel);

                } while (cursor.moveToNext());
                LogUtils.log("--== TABLE '" + TABLE_MARKETS_NAME + "' HAVE " + listMarket.size() + " records.. .==--");
                event.result(listMarket);
            }
        }
        cursor.close();
    }

    @Override
    public void getAllRecordsFtomTableMarketWithStock(MarketWithStockModel model, MarketWithStockListEvent event) {

        Cursor cursorMarket;
        Cursor cursorStock;

        List<MarketWithStockModel> marketWithStockModelList = new ArrayList<>();

        cursorMarket = sqLiteDatabase.query(TABLE_MARKETS_NAME, null, null, null, null, null, null);
        cursorStock = sqLiteDatabase.query(TABLE_STOCKS_NAME, null, null, null, null, null, null);

        LogUtils.log(" --== GET RECORDS FROM TABLE '" + TABLE_MARKETS_NAME + "' ==--");
        if (cursorMarket != null) {
            if (cursorMarket.moveToFirst()) {

                int marketNameFieldIndex = cursorMarket.getColumnIndex(NAME_FIELD);
                int marketStockIdFieldIndex = cursorMarket.getColumnIndex(STOCK_ID_FIELD);

                do {
                    MarketWithStockModel marketWithStockModel = new MarketWithStockModel();

                    marketWithStockModel.setName(cursorMarket.getString(marketNameFieldIndex));

                    int stockId = cursorMarket.getInt(marketStockIdFieldIndex);

                    if (cursorStock.moveToFirst()) cursorStock.moveToPosition(stockId - 1);

                    int stockNameFieldIndex = cursorMarket.getColumnIndex(NAME_FIELD);
                    marketWithStockModel.setStockName(cursorStock.getString(stockNameFieldIndex));

                    marketWithStockModelList.add(marketWithStockModel);

                } while (cursorMarket.moveToNext());
                LogUtils.log("--== TABLE '" + TABLE_MARKETS_NAME + "' HAVE " + marketWithStockModelList.size() + " records.. .==--");
                event.result(marketWithStockModelList);
            }
        }
        cursorMarket.close();
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
    public void getAllRecordsFtomTableMarket(MarketModel model) {

    }

    @Override
    public void closeBase() {
        sqLiteDatabase.close();
    }
}
