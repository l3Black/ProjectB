package ru.bellintegrator.practice.dao.user;

import java.util.List;
import ru.bellintegrator.practice.model.User;

/**
 * Dao for user
 */
public interface UserDao {

    /**
     * Get user by id
     *
     * @param id
     * @return
     */
    User get(int id);

    /**
     * Save user into DB
     *
     * @param user which we want to save
     * @return saved user
     */
    User save(User user);

    List<User> filter();
}
