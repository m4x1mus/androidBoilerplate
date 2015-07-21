package com.example.skool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.skool.R;
import com.example.skool.common.Utils;
import com.example.skool.models.Preferences;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by IBM_ADMIN on 7/19/2015.
 */
public class PreferenceOpenDatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "skool";
    private static final int DATABASE_VERSION = 1;

    /**
     * The data access object used to interact with the Sqlite database to do C.R.U.D operations.
     */
    private Dao<Preferences, Long> preferencesesDao;
    public PreferenceOpenDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION,
                /**
                 * R.raw.ormlite_config is a reference to the ormlite_config.txt file in the
                 * /res/raw/ directory of this project
                 * */
                R.raw.sample);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Utils.createTable(connectionSource, Preferences.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}