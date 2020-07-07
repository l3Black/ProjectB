package ru.bellintegrator.practice.dao.catalog;

import java.util.List;
import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.model.DocumentType;

/**
 * DAO for work with Catalogs
 */
public interface CatalogDao {
    /**
     * Get all types of documents
     *
     * @return
     */
    List<DocumentType> getAllDocumentTypes();

    /**
     * Get all country
     *
     * @return
     */
    List<Country> getAllCountry();
}
