package ru.bellintegrator.practice.dao.organization;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization get(int id) {
        return em.find(Organization.class, id);
    }

    /**
     * @param organization if is new (id = null) then create. Else - update.
     */
    @Override
    public Organization save(Organization organization) {
        if (organization.getId() == null) {
            em.persist(organization);
            return organization;
        } else {
            return em.merge(organization);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getAllFilter() {
        return null;
    }
}
