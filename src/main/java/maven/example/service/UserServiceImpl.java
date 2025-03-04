package maven.example.service;

import maven.example.DAO.UserDAO;
import maven.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public User getUser(int id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }
}
