package br.com.locaweb.jacatv;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Receiver;

import br.com.locaweb.jacatv.fragment.ShowListFragment;
import br.com.locaweb.jacatv.fragment.ShowListFragment_;
import br.com.locaweb.jacatv.service.TvShowIntentService;
import br.com.locaweb.jacatv.service.TvShowIntentService_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    ShowListFragment fragment;

    @AfterViews
    public void init() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment = ShowListFragment_.builder().build();
        transaction.add(R.id.container, fragment);
        transaction.commit();

        TvShowIntentService_.intent(this).fetchShows().start();
    }

    @Receiver(actions = {TvShowIntentService.ACTION_SAVE_DONE})
    public void actionServiceDone() {
        setupView();
    }

    public void setupView() {
        fragment.fetchData();
    }
}
