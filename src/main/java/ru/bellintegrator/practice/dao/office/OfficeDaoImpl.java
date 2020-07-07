package ru.bellintegrator.practice.dao.office;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office get(int id) {
        return em.find(Office.class, id);
    }

    /**
     * Save an office into DB
     *
     * @param office if is new (id = null) then create, else - update.
     * @return saved office
     */
    @Override
    public Office save(Office office) {
        if (office.getId() == null) {
            em.persist(office);
            return office;
        } else {
            return em.merge(office);
        }
    }

    @Override
    public List<Office> filter() {
        return null;
    }
}
