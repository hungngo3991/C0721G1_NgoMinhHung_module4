package service;

import model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showList ();
    void save (Music music);
    Music findById (int id);
    Music update (Music music);
    void delete (int id);
}
