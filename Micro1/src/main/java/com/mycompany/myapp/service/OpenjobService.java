package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.OpenjobDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Openjob.
 */
public interface OpenjobService {

    /**
     * Save a openjob.
     *
     * @param openjobDTO the entity to save
     * @return the persisted entity
     */
    OpenjobDTO save(OpenjobDTO openjobDTO);

    /**
     * Get all the openjobs.
     *
     * @return the list of entities
     */
    List<OpenjobDTO> findAll();


    /**
     * Get the "id" openjob.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<OpenjobDTO> findOne(Long id);

    /**
     * Delete the "id" openjob.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
