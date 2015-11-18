package br.com.locaweb.jacatv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Wrapper for Show model
 * Some values returned from TVMaze API doesnt match the database field types, this class converts
 * these values to something that can be stored on table fields
 */
public class ShowResponse {
    private String name, type, language, status, summary;

    private Long id;

    private Image image;

    private Date premiered;

    private HashMap<String, Float> rating;

    private ArrayList<String> genres;

    public Show getShow() {
        Show show = new Show();
        show.setId(id);
        show.setName(name);
        show.setType(type);
        show.setLanguage(language);
        show.setStatus(status);
        show.setSummary(summary);
        show.setImage(image);
        show.setPremiered(premiered);
        show.setRating(rating.get("average"));
        show.setGenres(genres);
        return show;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Date getPremiered() {
        return premiered;
    }

    public void setPremiered(Date premiered) {
        this.premiered = premiered;
    }

    public HashMap<String, Float> getRating() {
        return rating;
    }

    public void setRating(HashMap<String, Float> rating) {
        this.rating = rating;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
}
