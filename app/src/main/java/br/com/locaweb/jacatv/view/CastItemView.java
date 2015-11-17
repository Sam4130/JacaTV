package br.com.locaweb.jacatv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.model.Cast;

@EViewGroup(R.layout.cast_item)
public class CastItemView extends LinearLayout {
    @ViewById
    TextView personName, characterName;

    @ViewById
    ImageView personPicture;

    public CastItemView(Context context) { super(context); }

    public CastItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    public void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Cast cast) {
        personName.setText(cast.getPerson().getName());
        characterName.setText(cast.getCharacter().getName());
        Picasso.with(getContext())
                .load(cast.getPerson().getImage().getMedium())
                .placeholder(R.mipmap.noimg)
                .into(personPicture);
    }
}
