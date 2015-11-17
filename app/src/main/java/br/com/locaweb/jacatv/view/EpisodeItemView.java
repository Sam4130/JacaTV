package br.com.locaweb.jacatv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.model.Episode;

@EViewGroup(R.layout.episode_item)
public class EpisodeItemView extends LinearLayout {
    @ViewById
    TextView episodeName, episodeNumber ,season;

    public EpisodeItemView(Context context) { super(context); }

    public EpisodeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    public void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Episode episode) {
        episodeName.setText(episode.getEpisodeName());
        episodeNumber.setText(episode.getEpisodeNumber());
        season.setText(episode.getSeason());
    }
}
