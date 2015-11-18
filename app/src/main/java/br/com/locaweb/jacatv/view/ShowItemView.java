package br.com.locaweb.jacatv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.jacatv.R;
import br.com.locaweb.jacatv.model.Show;

@EViewGroup(R.layout.show_item)
public class ShowItemView extends LinearLayout {
    @ViewById
    TextView showName;

    public ShowItemView(Context context) { super(context); }

    public ShowItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    public void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Show show) {
        showName.setText(show.getName());
    }
}
