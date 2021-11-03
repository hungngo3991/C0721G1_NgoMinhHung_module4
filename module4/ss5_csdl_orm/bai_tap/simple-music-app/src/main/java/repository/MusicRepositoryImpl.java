package repository;

import model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class MusicRepositoryImpl implements IMusicRepository {


    @Override
    public List<Music> showList() {
        return null;
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public Music findById(int id) {
        return null;
    }

    @Override
    public Music update(Music music) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}


