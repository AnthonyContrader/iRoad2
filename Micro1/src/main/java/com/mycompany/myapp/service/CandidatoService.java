package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.CandidatoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Candidato.
 */
public interface CandidatoService {

    /**
     * Save a candidato.
     *
     * @param candidatoDTO the entity to save
     * @return the persisted entity
     */
    CandidatoDTO save(CandidatoDTO candidatoDTO);

    /**
     * Get all the candidatoes.
     *
     * @return the list of entities
     */
    List<CandidatoDTO> findAll();


    /**
     * Get the "id" candidato.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CandidatoDTO> findOne(Long id);

    /**
     * Delete the "id" candidato.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
