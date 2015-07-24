package com.example.skool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.skool.R;
import com.example.skool.common.Utils;
import com.example.skool.models.Preferences;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IBM_ADMIN on 7/19/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String PREFERENCES = "Preferences";
    private static final String DATABASE_NAME = "skool";
    private static final int DATABASE_VERSION = 1;
    private RuntimeExceptionDao runtimeDao = null;
    /**
     * The data access object used to interact with the Sqlite database to do C.R.U.D operations.
     */
    private Dao<Preferences, Long> preferencesesDao;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Preferences.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Preferences.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }

    public RuntimeExceptionDao getDataDao(String className) {
        if (runtimeDao == null) {
            switch(className){
                case PREFERENCES: runtimeDao = getRuntimeExceptionDao(Preferences.class);
                                    break;
                default: return null;
            }
        }
        return runtimeDao;
    }

    public int addPreferences(Preferences preferences) {
        RuntimeExceptionDao dao = this.getDataDao(PREFERENCES);
        int i = dao.create(preferences);
        return i;
    }

    public List getPreferences() {
        RuntimeExceptionDao dao = this.getDataDao(PREFERENCES);
        List list = dao.queryForAll();
        return list;
    }

    public void deleteAll() {
        RuntimeExceptionDao dao = this.getDataDao(PREFERENCES);
        List list = dao.queryForAll();
        dao.delete(list);
    }

    @Override
    public void close() {
        runtimeDao = null;
    }
}