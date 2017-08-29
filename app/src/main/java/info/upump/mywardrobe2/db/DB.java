package info.upump.mywardrobe2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import info.upump.mywardrobe2.model.ItemMainMenu;

/**
 * Created by Сергей on 17.08.2017.
 */

public class DB {
    public static final int DATA_BASE_VERSION = 1;
    public static final String DATA_BASE_NAME = "wardrobe";
    public static final String TABLE_MAIN_MENU = "menu";
    public static final String TABLE_SUB_MENU = "submenu";
    public static final String TABLE_DESCRIPTION = "description";

    public static final String TABLE_KEY_ID = "_id";
    public static final String TABLE_KEY_NAME = "name";
    public static final String TABLE_KEY_PARENTID = "parentId";
    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;
    private final Context mCtx;
    private static final String CREATE_MAIN_MENU_TABLE =
            "create table " + TABLE_MAIN_MENU +
                    "(" + TABLE_KEY_ID + " integer primary key autoincrement, " +
                    TABLE_KEY_NAME + " text)";
    private static final String CREATE_SUB_MENU_TABLE =
            "create table " + TABLE_SUB_MENU +
                    "(" + TABLE_KEY_ID + " integer primary key autoincrement, " +
                    TABLE_KEY_NAME + " text," + TABLE_KEY_PARENTID + " integer)";
    private static final String CREATE_TABLE_DESCRIPTION =
            "create table " + TABLE_DESCRIPTION +
                    "(" + TABLE_KEY_ID + " integer primary key autoincrement, " +
                    TABLE_KEY_NAME + " text)";


    public DB(Context mCtx) {
        this.mCtx = mCtx;
    }

    // открыть подключение
    public void open() {
        mDBHelper = new DBHelper(mCtx, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    // закрыть подключение
    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }

    // получить все данные из таблицы DB_TABLE
    public Cursor getAllData() {
        Log.d("DB", "getAll");
        return mDB.query(TABLE_MAIN_MENU, null, null, null, null, null, null);
    }

    public Cursor getAllData(String table) {
        Log.d("DB", "getAll");
        return mDB.query(table, null, null, null, null, null, null);
    }

    // добавить запись в DB_TABLE
    public void addMain(ItemMainMenu itemMainMenu) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_KEY_NAME, itemMainMenu.getName());
        //   cv.put(COLUMN_IMG, img);
        mDB.insert(TABLE_MAIN_MENU, null, cv);
    }
    public void addSubMain(String txt) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_KEY_NAME, txt);
        //   cv.put(COLUMN_IMG, img);
        mDB.insert(TABLE_MAIN_MENU, null, cv);
    }

    // удалить запись из DB_TABLE
    public void delRec(long id) {
        mDB.delete(TABLE_MAIN_MENU, TABLE_KEY_ID + " = " + id, null);
    }

/*   public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MAIN_MENU_TABLE);
     //   db.execSQL("create table " + TABLE_SUB_MENU + "(" + TABLE_KEY_ID
            //    + " integer primary key," + TABLE_KEY_NAME + " text," + TABLE_KEY_PARENTID + " integer" + ")");
       // db.execSQL("create table " + TABLE_DESCRIPTION + "(" + TABLE_KEY_ID
//                + " integer primary key," + TABLE_KEY_NAME + " text," + TABLE_KEY_PARENTID + " integer" + ")");

    }*/


    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        // создаем и заполняем БД
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_MAIN_MENU_TABLE);
            db.execSQL(CREATE_SUB_MENU_TABLE);
            ContentValues cv = new ContentValues();
            cv.put(TABLE_KEY_NAME, "футболки");
            db.insert(TABLE_MAIN_MENU, null, cv);
            cv.put(TABLE_KEY_NAME, "штаны ");
            db.insert(TABLE_MAIN_MENU, null, cv);
            cv.put(TABLE_KEY_NAME, "юбки ");
            db.insert(TABLE_MAIN_MENU, null, cv);
            Log.d("ddd", "dddd");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
