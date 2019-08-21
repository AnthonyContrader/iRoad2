package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.QuestionaryService;
import com.mycompany.myapp.domain.Questionary;
import com.mycompany.myapp.repository.QuestionaryRepository;
import com.mycompany.myapp.service.dto.QuestionaryDTO;
import com.mycompany.myapp.service.mapper.QuestionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Questionary.
 */
@Service
@Transactional
public class QuestionaryServiceImpl implements QuestionaryService {

    private final Logger log = LoggerFactory.getLogger(QuestionaryServiceImpl.class);

    private final QuestionaryRepository questionaryRepository;

    private final QuestionaryMapper questionaryMapper;

    public QuestionaryServiceImpl(QuestionaryRepository questionaryRepository, QuestionaryMapper questionaryMapper) {
        this.questionaryRepository = questionaryRepository;
        this.questionaryMapper = questionaryMapper;
    }

    /**
     * Save a questionary.
     *
     * @param questionaryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public QuestionaryDTO save(QuestionaryDTO questionaryDTO) {
        log.debug("Request to save Questionary : {}", questionaryDTO);
        Questionary questionary = questionaryMapper.toEntity(questionaryDTO);
        questionary = questionaryRepository.save(questionary);
        return questionaryMapper.toDto(questionary);
    }

    /**
     * Get all the questionaries.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<QuestionaryDTO> findAll() {
        log.debug("Request to get all Questionaries");
        return questionaryRepository.findAll().stream()
            .map(questionaryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one questionary by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<QuestionaryDTO> findOne(Long id) {
        log.debug("Request to get Questionary : {}", id);
        return questionaryRepository.findById(id)
            .map(questionaryMapper::toDto);
    }

    /**
     * Delete the questionary by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Questionary : {}", id);
        questionaryRepository.deleteById(id);
    }
}
