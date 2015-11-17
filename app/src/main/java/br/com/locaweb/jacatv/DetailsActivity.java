package br.com.locaweb.jacatv;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.adapter.MainPagerAdapter;

@EActivity(R.layout.activity_details)
public class DetailsActivity extends AppCompatActivity {
    @ViewById
    ViewPager pager;

    @ViewById
    TabLayout tabs;

    MainPagerAdapter adapter;

    private static int showId = 76;

    @AfterViews
    public void init() {
        setupViewPager();
    }

    @UiThread
    void setupViewPager() {
        adapter = new MainPagerAdapter(getSupportFragmentManager(), showId);
        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);
    }
}
