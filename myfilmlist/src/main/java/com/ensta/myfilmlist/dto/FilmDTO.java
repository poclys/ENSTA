package com.ensta.myfilmlist.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FilmDTO {
    private long id;
    private String titre;
    private int duration;

    public String getTitre() {
        return titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FilmDTO(String titre, int duration) {
        this.titre = titre;
        this.duration = duration;
    }

    public FilmDTO(long id, String titre, int duration) {
        this.id = id;
        this.titre = titre;
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

}