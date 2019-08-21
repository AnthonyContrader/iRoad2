package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.OpenjobService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.service.dto.OpenjobDTO;
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
 * REST controller for managing Openjob.
 */
@RestController
@RequestMapping("/api")
public class OpenjobResource {

    private final Logger log = LoggerFactory.getLogger(OpenjobResource.class);

    private static final String ENTITY_NAME = "openjob";

    private final OpenjobService openjobService;

    public OpenjobResource(OpenjobService openjobService) {
        this.openjobService = openjobService;
    }

    /**
     * POST  /openjobs : Create a new openjob.
     *
     * @param openjobDTO the openjobDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new openjobDTO, or with status 400 (Bad Request) if the openjob has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/openjobs")
    @Timed
    public ResponseEntity<OpenjobDTO> createOpenjob(@RequestBody OpenjobDTO openjobDTO) throws URISyntaxException {
        log.debug("REST request to save Openjob : {}", openjobDTO);
        if (openjobDTO.getId() != null) {
            throw new BadRequestAlertException("A new openjob cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpenjobDTO result = openjobService.save(openjobDTO);
        return ResponseEntity.created(new URI("/api/openjobs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /openjobs : Updates an existing openjob.
     *
     * @param openjobDTO the openjobDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated openjobDTO,
     * or with status 400 (Bad Request) if the openjobDTO is not valid,
     * or with status 500 (Internal Server Error) if the openjobDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/openjobs")
    @Timed
    public ResponseEntity<OpenjobDTO> updateOpenjob(@RequestBody OpenjobDTO openjobDTO) throws URISyntaxException {
        log.debug("REST request to update Openjob : {}", openjobDTO);
        if (openjobDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OpenjobDTO result = openjobService.save(openjobDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, openjobDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /openjobs : get all the openjobs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of openjobs in body
     */
    @GetMapping("/openjobs")
    @Timed
    public List<OpenjobDTO> getAllOpenjobs() {
        log.debug("REST request to get all Openjobs");
        return openjobService.findAll();
    }

    /**
     * GET  /openjobs/:id : get the "id" openjob.
     *
     * @param id the id of the openjobDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the openjobDTO, or with status 404 (Not Found)
     */
    @GetMapping("/openjobs/{id}")
    @Timed
    public ResponseEntity<OpenjobDTO> getOpenjob(@PathVariable Long id) {
        log.debug("REST request to get Openjob : {}", id);
        Optional<OpenjobDTO> openjobDTO = openjobService.findOne(id);
        return ResponseUtil.wrapOrNotFound(openjobDTO);
    }

    /**
     * DELETE  /openjobs/:id : delete the "id" openjob.
     *
     * @param id the id of the openjobDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/openjobs/{id}")
    @Timed
    public ResponseEntity<Void> deleteOpenjob(@PathVariable Long id) {
        log.debug("REST request to delete Openjob : {}", id);
        openjobService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
