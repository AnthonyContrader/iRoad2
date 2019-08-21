package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.CandidatoService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.service.dto.CandidatoDTO;
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
 * REST controller for managing Candidato.
 */
@RestController
@RequestMapping("/api")
public class CandidatoResource {

    private final Logger log = LoggerFactory.getLogger(CandidatoResource.class);

    private static final String ENTITY_NAME = "candidato";

    private final CandidatoService candidatoService;

    public CandidatoResource(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    /**
     * POST  /candidatoes : Create a new candidato.
     *
     * @param candidatoDTO the candidatoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new candidatoDTO, or with status 400 (Bad Request) if the candidato has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/candidatoes")
    @Timed
    public ResponseEntity<CandidatoDTO> createCandidato(@RequestBody CandidatoDTO candidatoDTO) throws URISyntaxException {
        log.debug("REST request to save Candidato : {}", candidatoDTO);
        if (candidatoDTO.getId() != null) {
            throw new BadRequestAlertException("A new candidato cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CandidatoDTO result = candidatoService.save(candidatoDTO);
        return ResponseEntity.created(new URI("/api/candidatoes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /candidatoes : Updates an existing candidato.
     *
     * @param candidatoDTO the candidatoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated candidatoDTO,
     * or with status 400 (Bad Request) if the candidatoDTO is not valid,
     * or with status 500 (Internal Server Error) if the candidatoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/candidatoes")
    @Timed
    public ResponseEntity<CandidatoDTO> updateCandidato(@RequestBody CandidatoDTO candidatoDTO) throws URISyntaxException {
        log.debug("REST request to update Candidato : {}", candidatoDTO);
        if (candidatoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CandidatoDTO result = candidatoService.save(candidatoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, candidatoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /candidatoes : get all the candidatoes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of candidatoes in body
     */
    @GetMapping("/candidatoes")
    @Timed
    public List<CandidatoDTO> getAllCandidatoes() {
        log.debug("REST request to get all Candidatoes");
        return candidatoService.findAll();
    }

    /**
     * GET  /candidatoes/:id : get the "id" candidato.
     *
     * @param id the id of the candidatoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the candidatoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/candidatoes/{id}")
    @Timed
    public ResponseEntity<CandidatoDTO> getCandidato(@PathVariable Long id) {
        log.debug("REST request to get Candidato : {}", id);
        Optional<CandidatoDTO> candidatoDTO = candidatoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(candidatoDTO);
    }

    /**
     * DELETE  /candidatoes/:id : delete the "id" candidato.
     *
     * @param id the id of the candidatoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/candidatoes/{id}")
    @Timed
    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
        log.debug("REST request to delete Candidato : {}", id);
        candidatoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
