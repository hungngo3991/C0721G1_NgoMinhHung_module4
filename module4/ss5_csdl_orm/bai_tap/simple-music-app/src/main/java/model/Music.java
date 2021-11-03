package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String artist;
    private String typeOfMusic;
    private String filePath;


    public Music() {
    }

    public Music(int id, String name, String artist, String typeOfMusic, String filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.filePath = filePath;
    }

    public Music(String name, String artist, String typeOfMusic, String filePath) {
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
