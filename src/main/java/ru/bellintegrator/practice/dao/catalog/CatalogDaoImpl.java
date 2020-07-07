package ru.bellintegrator.practice.dao.catalog;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.model.DocumentType;

/**
 * {@inheritDoc}
 */
@Repository
public class CatalogDaoImpl implements CatalogDao {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public CatalogDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return em.createNamedQuery(DocumentType.ALL, DocumentType.class).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getAllCountry() {
        return em.createNamedQuery(Country.ALL, Country.class).getResultList();
    }
}
