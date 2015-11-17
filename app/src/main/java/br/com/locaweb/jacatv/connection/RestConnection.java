package br.com.locaweb.jacatv.connection;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import br.com.locaweb.jacatv.model.CastListResponse;
import br.com.locaweb.jacatv.model.EpisodeListResponse;
import br.com.locaweb.jacatv.model.ShowResponse;

@Rest(rootUrl = "http://api.tvmaze.com", converters = GsonHttpMessageConverter.class)
public interface RestConnection {
    @Get("/shows/{show_id}/cast")
    CastListResponse getCast(int show_id);

    @Get("/shows/{show_id}/episodes")
    EpisodeListResponse getEpisodes(int show_id);

    @Get("shows/{show_id}")
    ShowResponse getShow(int show_id);
}
