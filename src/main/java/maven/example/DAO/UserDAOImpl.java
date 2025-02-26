package maven.example.DAO;



import javax.transaction.Transactional;
import maven.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User",
                User.class).getResultList();
        return users;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }


//    @Override
//    public void save(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public User findById(int id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return entityManager.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    public void delete(int id) {
//        User user = entityManager.find(User.class, id);
//        if(user!=null){
//            entityManager.remove(user);
//        }
//    }
}
