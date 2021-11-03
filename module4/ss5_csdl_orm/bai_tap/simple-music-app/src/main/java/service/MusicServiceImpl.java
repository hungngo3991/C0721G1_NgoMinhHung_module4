package service;

import model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IMusicRepository;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;


    @Override
    public List<Music> showList() {
        return musicRepository.showList();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public Music update(Music music) {
        return musicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }
}
