package br.com.locaweb.jacatv.fragment;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.UiThread;

import java.sql.SQLException;
import java.util.List;

import br.com.locaweb.jacatv.DetailsActivity_;
import br.com.locaweb.jacatv.adapter.ShowAdapter;
import br.com.locaweb.jacatv.database.DatabaseHelper;
import br.com.locaweb.jacatv.model.Show;
import br.com.locaweb.jacatv.service.TvShowIntentService;

@EFragment
public class ShowListFragment extends ListFragment {
    @Bean
    ShowAdapter adapter;

    @OrmLiteDao(helper = DatabaseHelper.class)
    Dao<Show, Long> daoTvShow;

    private List<Show> show;

    @UiThread
    @Override
    public void setListAdapter(ListAdapter adapter) {
        super.setListAdapter(adapter);
    }

    @AfterViews
    public void init() {
        fetchData();
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Long showId = adapter.getItem(position).getId();
        DetailsActivity_.intent(this).showId(showId).start();
    }

    @Receiver(actions = {TvShowIntentService.ACTION_SAVE_DONE})
    public void fetchData() {
        try {
            show = daoTvShow.queryBuilder().orderBy("name", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        adapter.setList(show);
        adapter.notifyDataSetChanged();
    }
}
