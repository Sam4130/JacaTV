package br.com.locaweb.jacatv.model;

public class Image {
    private String medium, original;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Image(String medium, String original) {
        this.medium = medium;
        this.original = original;
    }
}
