package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.QuestionaryDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Questionary.
 */
public interface QuestionaryService {

    /**
     * Save a questionary.
     *
     * @param questionaryDTO the entity to save
     * @return the persisted entity
     */
    QuestionaryDTO save(QuestionaryDTO questionaryDTO);

    /**
     * Get all the questionaries.
     *
     * @return the list of entities
     */
    List<QuestionaryDTO> findAll();


    /**
     * Get the "id" questionary.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<QuestionaryDTO> findOne(Long id);

    /**
     * Delete the "id" questionary.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
