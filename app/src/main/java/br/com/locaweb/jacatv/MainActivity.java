package br.com.locaweb.jacatv;

import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.database.DatabaseHelper;
import br.com.locaweb.jacatv.model.Show;
import br.com.locaweb.jacatv.service.TvShowIntentService_;

/**
 * TODO:
 * Fazer lazy-loading da lista de shows (scroll infinito)
 * Busca - se não encontrar no banco, buscar no site
 * Usar SharedPreferences annotation para armazenar lastUpdate
 */

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    SearchView searchShow;

    @OrmLiteDao(helper = DatabaseHelper.class)
    Dao<Show, Long> daoTvShow;

    @AfterViews
    public void init() {
        TvShowIntentService_.intent(this).fetchShows().start();
    }
}
