package br.com.locaweb.jacatv.fragment;

import android.support.v4.app.Fragment;
import android.text.Html;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.adapter.EpisodeAdapter;
import br.com.locaweb.jacatv.adapter.ShowAdapter;
import br.com.locaweb.jacatv.connection.RestConnection;
import br.com.locaweb.jacatv.model.Episode;
import br.com.locaweb.jacatv.model.Show;

@EFragment(R.layout.show_detail)
public class ShowDetailFragment extends Fragment {
    @Bean
    ShowAdapter adapter;

    @ViewById
    TextView showName, showLanguage, showGenre, showStatus, showRating, showPremiered, showSummary;

    @ViewById
    ImageView showPicture;

    @FragmentArg
    int showId;

    @RestService
    RestConnection connection;

    @AfterViews
    public void init() {
        fetchData();

    }

    @Background
    public void fetchData() {
        Show show = connection.getShow(showId);
        setDetails(show);
    }

    @UiThread
    public void setDetails(Show show) {
        showName.setText(show.getName());
        showLanguage.setText(show.getLanguage());
        showGenre.setText(show.getGenres().toString());
        showStatus.setText(show.getStatus());
        showRating.setText(String.valueOf(show.getRating().get("average")));
        showSummary.setText(Html.fromHtml(show.getSummary()));

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String premiered = df.format(show.getPremiered()).toString();
        showPremiered.setText(premiered);

        Picasso.with(getContext())
                .load(show.getImage().getMedium())
                .placeholder(R.mipmap.noimg)
                .into(showPicture);
    }

}
