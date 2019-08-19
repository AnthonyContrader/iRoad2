package it.contrader.iroad.service.impl;

import it.contrader.iroad.service.SignaleService;
import it.contrader.iroad.domain.Signale;
import it.contrader.iroad.repository.SignaleRepository;
import it.contrader.iroad.service.dto.SignaleDTO;
import it.contrader.iroad.service.mapper.SignaleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Signale.
 */
@Service
@Transactional
public class SignaleServiceImpl implements SignaleService {

    private final Logger log = LoggerFactory.getLogger(SignaleServiceImpl.class);

    private final SignaleRepository signaleRepository;

    private final SignaleMapper signaleMapper;

    public SignaleServiceImpl(SignaleRepository signaleRepository, SignaleMapper signaleMapper) {
        this.signaleRepository = signaleRepository;
        this.signaleMapper = signaleMapper;
    }

    /**
     * Save a signale.
     *
     * @param signaleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SignaleDTO save(SignaleDTO signaleDTO) {
        log.debug("Request to save Signale : {}", signaleDTO);
        Signale signale = signaleMapper.toEntity(signaleDTO);
        signale = signaleRepository.save(signale);
        return signaleMapper.toDto(signale);
    }

    /**
     * Get all the signales.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SignaleDTO> findAll() {
        log.debug("Request to get all Signales");
        return signaleRepository.findAll().stream()
            .map(signaleMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one signale by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SignaleDTO> findOne(Long id) {
        log.debug("Request to get Signale : {}", id);
        return signaleRepository.findById(id)
            .map(signaleMapper::toDto);
    }

    /**
     * Delete the signale by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Signale : {}", id);
        signaleRepository.deleteById(id);
    }
}
