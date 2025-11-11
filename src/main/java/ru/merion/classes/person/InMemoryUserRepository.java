package main.java.ru.merion.classes.person;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    // предполагается, что список хранится в БД
    // для теста список создается здесь с некоторыми email
    private List<User> users = new ArrayList<>();

//    emails.add("hello@world.com");
//    emails.add("python@world.com");

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void save(User user) {
        users.add(user);
        System.out.println("User " + user.getName() + " with user id " + user.getId() + " saved");
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("User with id " + id + " deleted");
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null || email.isBlank() || email.isEmpty()) {
            return false;
        }

        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();

        User user1 = new User();
        User user2 = new User("John", "Smith", "New Str 754", "john@smith.com", 35);

        repository.save(user1);
        repository.save(user2);

        System.out.println(repository.findAll());
        System.out.println(repository.existsByEmail("john@example.com"));
        System.out.println(repository.findById(2));
    }
}
