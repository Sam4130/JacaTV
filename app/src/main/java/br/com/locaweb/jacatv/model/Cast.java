package br.com.locaweb.jacatv.model;

import com.google.gson.annotations.SerializedName;

public class Cast {
    private Person person;

    private Character character;

    public Person getPerson() {
        return person;
    }

    public void setPersonName(Person person) {
        this.person = person;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacterName(Character character) {
        this.character = character;
    }
}
