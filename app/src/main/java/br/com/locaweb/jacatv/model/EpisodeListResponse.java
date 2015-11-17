package br.com.locaweb.jacatv.model;

import java.util.List;

/**
 * Created by treinamentomobile on 11/17/15.
 */
public class EpisodeListResponse {
    private List<Episode> episodes;

    public List<Episode> getEpisodes() { return episodes; }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
