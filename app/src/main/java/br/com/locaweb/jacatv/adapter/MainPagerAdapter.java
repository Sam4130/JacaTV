package br.com.locaweb.jacatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.locaweb.jacatv.fragment.CastListFragment_;
import br.com.locaweb.jacatv.fragment.EpisodeListFragment_;
import br.com.locaweb.jacatv.fragment.ShowDetailFragment_;


public class MainPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 3;
    private static final CharSequence[] TITLES = {"Details", "Cast", "Episodes"};
    private int showId;

    public MainPagerAdapter(FragmentManager fm, int showId) {
        super(fm);
        this.showId = showId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ShowDetailFragment_.builder().build();
            case 1:
                return CastListFragment_.builder().showId(this.showId).build();
            case 2:
                return EpisodeListFragment_.builder().build();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
