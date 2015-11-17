package br.com.locaweb.jacatv.adapter;

import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.jacatv.model.Show;
import br.com.locaweb.jacatv.view.ShowDetailView;
import br.com.locaweb.jacatv.view.ShowDetailView_;

@EBean
public class ShowAdapter extends AABaseAdapter<Show> {
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = ShowDetailView_.build(context);
        }

        ((ShowDetailView) convertView).bind(getItem(position));

        return convertView;
    }
}
