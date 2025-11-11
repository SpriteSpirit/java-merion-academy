package main.java.ru.merion.classes.person;

import java.util.List;

public interface UserRepository {
    User findById(int id);
    List<User> findAll();
    void save(User user);
    void delete(int id);
    boolean existsByEmail(String email);
}
