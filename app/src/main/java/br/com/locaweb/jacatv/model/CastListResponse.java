package br.com.locaweb.jacatv.model;

import java.util.List;

public class CastListResponse {
    private List<Cast> cast;

    public List<Cast> getCast() { return cast; }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
