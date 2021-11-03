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

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Music> showList() {
        String query = "SELECT m from music AS m";
        TypedQuery<Music> typedQuery = entityManager.createQuery(query, Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(music);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Music findById(int id) {
        String query = "SELECT m FROM music AS m WHERE m.id = :id";
        TypedQuery<Music> typedQuery = entityManager.createQuery(query, Music.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(Music music) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Music improvedMusic = findById(music.getId());
            improvedMusic.setName(music.getName());
            improvedMusic.setArtist(music.getArtist());
            improvedMusic.setTypeOfMusic(music.getTypeOfMusic());
            improvedMusic.setFilePath(music.getFilePath());
            session.saveOrUpdate(improvedMusic);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Music music = findById(id);
            if (music != null) {
                session.delete(music);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}



