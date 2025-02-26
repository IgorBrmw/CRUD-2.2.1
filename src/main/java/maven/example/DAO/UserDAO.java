package maven.example.DAO;

import maven.example.model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(int id);
    List<User> findAll();
    void delete(int id);
}
