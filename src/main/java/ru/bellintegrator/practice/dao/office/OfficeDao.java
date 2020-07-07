package ru.bellintegrator.practice.dao.office;

import java.util.List;
import ru.bellintegrator.practice.model.Office;

/**
 * Dao for office
 */
public interface OfficeDao {

    /**
     * Get office by id
     *
     * @param id
     * @return
     */
    Office get(int id);

    /**
     * Save an office into DB
     *
     * @param office which we want to save
     * @return saved office
     */
    Office save(Office office);

    /**
     * Get offices by define filter
     *
     * @return
     */
    List<Office> filter();
}
