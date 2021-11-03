package repository;

import model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> showList ();
    void save (Music music);
    Music findById (int id);
    void update (Music music);
    void delete (int id);
}
