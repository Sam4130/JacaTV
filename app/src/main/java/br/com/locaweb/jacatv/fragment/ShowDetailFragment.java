package br.com.locaweb.jacatv.fragment;

import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.adapter.ShowAdapter;
import br.com.locaweb.jacatv.database.DatabaseHelper;
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
    Long showId;

    @OrmLiteDao(helper = DatabaseHelper.class)
    Dao<Show, Long> daoTvShow;

    private Show show;

    @AfterViews
    public void init() {
        try {
            show = daoTvShow.queryForId(showId);
            setDetails(show);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    public void setDetails(Show show) {
        showName.setText(show.getName());
        showLanguage.setText(show.getLanguage());
        showGenre.setText(TextUtils.join(", ", show.getGenres()));
        showStatus.setText(show.getStatus());
        showRating.setText(String.valueOf(show.getRating()));
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
