package br.com.locaweb.jacatv.fragment;

import android.support.v4.app.ListFragment;
import android.widget.ListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import java.util.List;

import br.com.locaweb.jacatv.adapter.CastAdapter;
import br.com.locaweb.jacatv.connection.RestConnection;
import br.com.locaweb.jacatv.model.Cast;
import br.com.locaweb.jacatv.model.CastListResponse;

@EFragment
public class CastListFragment extends ListFragment {
    @Bean
    CastAdapter adapter;

    @FragmentArg
    int showId;

    @RestService
    RestConnection connection;

    @AfterViews
    public void init() {
        fetchData();
    }

    @UiThread
    @Override
    public void setListAdapter(ListAdapter adapter) {
        super.setListAdapter(adapter);
    }

    @Background
    void fetchData() {
        adapter.setList(getCast());
        setListAdapter(adapter);
    }

    private List<Cast> getCast() {
        CastListResponse matches = connection.getCast(showId);
        //List<Match> matches = new Select().all().from(Match.class).execute();
        return matches.getCast();
    }
}
