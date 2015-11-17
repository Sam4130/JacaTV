package br.com.locaweb.jacatv.adapter;

import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.jacatv.model.Episode;
import br.com.locaweb.jacatv.view.EpisodeItemView;
import br.com.locaweb.jacatv.view.EpisodeItemView_;

@EBean
public class EpisodeAdapter extends AABaseAdapter<Episode> {
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = EpisodeItemView_.build(context);
        }

        ((EpisodeItemView) convertView).bind(getItem(position));

        return convertView;
    }
}
