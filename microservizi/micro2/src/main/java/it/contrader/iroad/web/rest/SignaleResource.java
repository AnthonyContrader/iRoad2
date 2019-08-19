package it.contrader.iroad.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.iroad.service.SignaleService;
import it.contrader.iroad.web.rest.errors.BadRequestAlertException;
import it.contrader.iroad.web.rest.util.HeaderUtil;
import it.contrader.iroad.service.dto.SignaleDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Signale.
 */
@RestController
@RequestMapping("/api")
public class SignaleResource {

    private final Logger log = LoggerFactory.getLogger(SignaleResource.class);

    private static final String ENTITY_NAME = "signale";

    private final SignaleService signaleService;

    public SignaleResource(SignaleService signaleService) {
        this.signaleService = signaleService;
    }

    /**
     * POST  /signales : Create a new signale.
     *
     * @param signaleDTO the signaleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new signaleDTO, or with status 400 (Bad Request) if the signale has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/signales")
    @Timed
    public ResponseEntity<SignaleDTO> createSignale(@Valid @RequestBody SignaleDTO signaleDTO) throws URISyntaxException {
        log.debug("REST request to save Signale : {}", signaleDTO);
        if (signaleDTO.getId() != null) {
            throw new BadRequestAlertException("A new signale cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SignaleDTO result = signaleService.save(signaleDTO);
        return ResponseEntity.created(new URI("/api/signales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /signales : Updates an existing signale.
     *
     * @param signaleDTO the signaleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated signaleDTO,
     * or with status 400 (Bad Request) if the signaleDTO is not valid,
     * or with status 500 (Internal Server Error) if the signaleDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/signales")
    @Timed
    public ResponseEntity<SignaleDTO> updateSignale(@Valid @RequestBody SignaleDTO signaleDTO) throws URISyntaxException {
        log.debug("REST request to update Signale : {}", signaleDTO);
        if (signaleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SignaleDTO result = signaleService.save(signaleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, signaleDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /signales : get all the signales.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of signales in body
     */
    @GetMapping("/signales")
    @Timed
    public List<SignaleDTO> getAllSignales() {
        log.debug("REST request to get all Signales");
        return signaleService.findAll();
    }

    /**
     * GET  /signales/:id : get the "id" signale.
     *
     * @param id the id of the signaleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the signaleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/signales/{id}")
    @Timed
    public ResponseEntity<SignaleDTO> getSignale(@PathVariable Long id) {
        log.debug("REST request to get Signale : {}", id);
        Optional<SignaleDTO> signaleDTO = signaleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(signaleDTO);
    }

    /**
     * DELETE  /signales/:id : delete the "id" signale.
     *
     * @param id the id of the signaleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/signales/{id}")
    @Timed
    public ResponseEntity<Void> deleteSignale(@PathVariable Long id) {
        log.debug("REST request to delete Signale : {}", id);
        signaleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
