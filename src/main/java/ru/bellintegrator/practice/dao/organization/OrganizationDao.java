package ru.bellintegrator.practice.dao.organization;

import java.util.List;
import ru.bellintegrator.practice.model.Organization;

/**
 * Dao for organization
 */
public interface OrganizationDao {

    /**
     * Get an organization by id
     *
     * @param id organization
     * @return
     */
    Organization get(int id);

    /**
     * Save an organization into DB.
     *
     * @param organization which we wish to save.
     * @return saved organization.
     */
    Organization save(Organization organization);

    List<Organization> getAllFilter();


}
