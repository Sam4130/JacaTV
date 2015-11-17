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
import br.com.locaweb.jacatv.adapter.EpisodeAdapter;
import br.com.locaweb.jacatv.connection.RestConnection;
import br.com.locaweb.jacatv.model.Episode;

@EFragment
public class EpisodeListFragment extends ListFragment {
    @Bean
    EpisodeAdapter adapter;

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
        adapter.setList(getEpisode());
        setListAdapter(adapter);
    }

    private List<Episode> getEpisode() {
        return connection.getEpisodes(showId);
    }
}
