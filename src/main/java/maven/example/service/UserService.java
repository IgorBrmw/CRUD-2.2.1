package maven.example.service;

import maven.example.DAO.UserDAO;
import maven.example.DAO.UserDAOImpl;
import maven.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public User getUser(int id) {
        return userDAO.findById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public void deleteUser(int id) {
        userDAO.delete(id);
    }
}
