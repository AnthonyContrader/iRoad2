package it.contrader.iroad.service;

import it.contrader.iroad.service.dto.StreetDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Street.
 */
public interface StreetService {

    /**
     * Save a street.
     *
     * @param streetDTO the entity to save
     * @return the persisted entity
     */
    StreetDTO save(StreetDTO streetDTO);

    /**
     * Get all the streets.
     *
     * @return the list of entities
     */
    List<StreetDTO> findAll();


    /**
     * Get the "id" street.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<StreetDTO> findOne(Long id);

    /**
     * Delete the "id" street.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
