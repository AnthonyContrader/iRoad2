package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.QuestionaryService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.service.dto.QuestionaryDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Questionary.
 */
@RestController
@RequestMapping("/api")
public class QuestionaryResource {

    private final Logger log = LoggerFactory.getLogger(QuestionaryResource.class);

    private static final String ENTITY_NAME = "questionary";

    private final QuestionaryService questionaryService;

    public QuestionaryResource(QuestionaryService questionaryService) {
        this.questionaryService = questionaryService;
    }

    /**
     * POST  /questionaries : Create a new questionary.
     *
     * @param questionaryDTO the questionaryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new questionaryDTO, or with status 400 (Bad Request) if the questionary has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/questionaries")
    @Timed
    public ResponseEntity<QuestionaryDTO> createQuestionary(@RequestBody QuestionaryDTO questionaryDTO) throws URISyntaxException {
        log.debug("REST request to save Questionary : {}", questionaryDTO);
        if (questionaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new questionary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuestionaryDTO result = questionaryService.save(questionaryDTO);
        return ResponseEntity.created(new URI("/api/questionaries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /questionaries : Updates an existing questionary.
     *
     * @param questionaryDTO the questionaryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated questionaryDTO,
     * or with status 400 (Bad Request) if the questionaryDTO is not valid,
     * or with status 500 (Internal Server Error) if the questionaryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/questionaries")
    @Timed
    public ResponseEntity<QuestionaryDTO> updateQuestionary(@RequestBody QuestionaryDTO questionaryDTO) throws URISyntaxException {
        log.debug("REST request to update Questionary : {}", questionaryDTO);
        if (questionaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuestionaryDTO result = questionaryService.save(questionaryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, questionaryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /questionaries : get all the questionaries.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of questionaries in body
     */
    @GetMapping("/questionaries")
    @Timed
    public List<QuestionaryDTO> getAllQuestionaries() {
        log.debug("REST request to get all Questionaries");
        return questionaryService.findAll();
    }

    /**
     * GET  /questionaries/:id : get the "id" questionary.
     *
     * @param id the id of the questionaryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the questionaryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/questionaries/{id}")
    @Timed
    public ResponseEntity<QuestionaryDTO> getQuestionary(@PathVariable Long id) {
        log.debug("REST request to get Questionary : {}", id);
        Optional<QuestionaryDTO> questionaryDTO = questionaryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(questionaryDTO);
    }

    /**
     * DELETE  /questionaries/:id : delete the "id" questionary.
     *
     * @param id the id of the questionaryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/questionaries/{id}")
    @Timed
    public ResponseEntity<Void> deleteQuestionary(@PathVariable Long id) {
        log.debug("REST request to delete Questionary : {}", id);
        questionaryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
