package br.com.locaweb.jacatv.service;

import android.content.Intent;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.ServiceAction;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.support.app.AbstractIntentService;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import br.com.locaweb.jacatv.connection.RestConnection;
import br.com.locaweb.jacatv.database.DatabaseHelper;
import br.com.locaweb.jacatv.model.Show;

@EIntentService
public class TvShowIntentService extends AbstractIntentService {


    public static final String ACTION_SAVE_DONE = "ACTION_SAVE_DONE";

    @RestService
    RestConnection connection;

    @OrmLiteDao(helper = DatabaseHelper.class)
    Dao<Show, Long> daoShow;

    public TvShowIntentService() {
        super("TvShowIntentService");
    }

    @ServiceAction
    void fetchAndSaveData(long showId) {
        final Show showInfo = connection.getShow(showId).getShow();

        try {
            TransactionManager.callInTransaction(daoShow.getConnectionSource(), new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    daoShow.createOrUpdate(showInfo);
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(ACTION_SAVE_DONE);
        sendBroadcast(intent);
    }
}
