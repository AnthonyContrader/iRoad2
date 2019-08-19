package it.contrader.iroad.service;

import it.contrader.iroad.service.dto.SignaleDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Signale.
 */
public interface SignaleService {

    /**
     * Save a signale.
     *
     * @param signaleDTO the entity to save
     * @return the persisted entity
     */
    SignaleDTO save(SignaleDTO signaleDTO);

    /**
     * Get all the signales.
     *
     * @return the list of entities
     */
    List<SignaleDTO> findAll();


    /**
     * Get the "id" signale.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SignaleDTO> findOne(Long id);

    /**
     * Delete the "id" signale.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
