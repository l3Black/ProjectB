package ru.bellintegrator.practice.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.User;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @return
     */
    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    /**
     * @param user if is new (id = null) then create, else - update.
     * @return saved user.
     */
    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public List<User> filter() {
        return null;
    }
}
