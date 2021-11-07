package com.codegym.validate_info_song.model;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String artist;

    private String typeMusic;


    public Song() {
    }

    public Song(Long id, String name, String artist, String typeMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeMusic = typeMusic;
    }

    public Song(String name, String artist, String typeMusic) {
        this.name = name;
        this.artist = artist;
        this.typeMusic = typeMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String[] specialCharacter = {"@", ";", ",", ".", "=", "-", "+"};
        String name = song.getName();
        String artist = song.getArtist();
        String typeMusic = song.getTypeMusic();

        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        if (name.length() > 800) {
            errors.rejectValue("name", "name.length");
        }
        for (String s : specialCharacter) {
            if (name.contains(s)) {
                errors.rejectValue("name", "name.contains");
            }
        }
        ValidationUtils.rejectIfEmpty(errors, "artist", "artist.empty");
        if (artist.length() > 300) {
            errors.rejectValue("artist", "artist.length");
        }
        for (String s : specialCharacter) {
            if (artist.contains(s)) {
                errors.rejectValue("artist", "artist.contains");
            }
        }
        ValidationUtils.rejectIfEmpty(errors, "typeMusic", "typeMusic.empty");
        if (typeMusic.length() > 1000) {
            errors.rejectValue("typeMusic", "typeMusic.length");
        }
        for (int i = 0; i < specialCharacter.length; i++) {
            if (i != 2) {
                if (typeMusic.contains(specialCharacter[i])) {
                    errors.rejectValue("typeMusic", "typeMusic.contains");
                }
            }
        }
    }
}
