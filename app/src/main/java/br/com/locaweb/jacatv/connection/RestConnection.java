package br.com.locaweb.jacatv.connection;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;

import java.util.List;

import br.com.locaweb.jacatv.MyGsonHttpMessageConverter;
import br.com.locaweb.jacatv.model.Cast;
import br.com.locaweb.jacatv.model.Episode;
import br.com.locaweb.jacatv.model.ShowResponse;

@Rest(rootUrl = "http://api.tvmaze.com", converters = MyGsonHttpMessageConverter.class)
public interface RestConnection {
    @Get("/shows")
    List<ShowResponse> getShows();

    @Get("/shows/{show_id}/cast")
    List<Cast> getCast(long show_id);

    @Get("/shows/{show_id}/episodes")
    List<Episode> getEpisodes(long show_id);

    @Get("/shows/{show_id}")
    ShowResponse getShow(long show_id);
}
