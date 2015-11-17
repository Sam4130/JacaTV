package br.com.locaweb.jacatv.adapter;

import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.jacatv.fragment.ShowDetailFragment_;
import br.com.locaweb.jacatv.model.Show;

@EBean
public class ShowAdapter extends AABaseAdapter<Show> {
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = View.inflate(context, android.R.layout.simple_list_item_1, null);
        }

        return convertView;
    }
}
