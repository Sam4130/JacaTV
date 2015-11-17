package br.com.locaweb.jacatv.adapter;

import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.jacatv.model.Cast;
import br.com.locaweb.jacatv.view.CastItemView;
import br.com.locaweb.jacatv.view.CastItemView_;

@EBean
public class CastAdapter extends AABaseAdapter<Cast> {
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = CastItemView_.build(context);
        }

        ((CastItemView) convertView).bind(getItem(position));

        return convertView;
    }
}
