package br.com.locaweb.jacatv.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.locaweb.jacatv.model.Episode;
import br.com.locaweb.jacatv.model.Show;

/**
 * Created by treinamentomobile on 11/18/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Show.class);
            //TableUtils.createTable(connectionSource, Episode.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Show.class, true);
            //TableUtils.dropTable(connectionSource, Episode.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }
}
