package maven.example.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import maven.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
