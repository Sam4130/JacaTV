package br.com.locaweb.jacatv.view;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.model.Episode;

@EViewGroup(R.layout.episode_item)
public class EpisodeItemView extends LinearLayout {
    @ViewById
    TextView episodeName, episodeNumber, season, episodeSummary;

    @ViewById
    ImageView episodePicture;

    public EpisodeItemView(Context context) { super(context); }

    public EpisodeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    public void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Episode episode) {
        episodeName.setText(episode.getName());
        episodeNumber.setText(String.valueOf(episode.getNumber()));
        season.setText(String.valueOf(episode.getSeason()));
        episodeSummary.setText(Html.fromHtml(episode.getSummary()));
        Picasso.with(getContext())
                .load(episode.getImage().getMedium())
                .placeholder(R.mipmap.noimg)
                .into(episodePicture);
    }
}
