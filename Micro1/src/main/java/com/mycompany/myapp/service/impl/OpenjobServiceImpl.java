package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.OpenjobService;
import com.mycompany.myapp.domain.Openjob;
import com.mycompany.myapp.repository.OpenjobRepository;
import com.mycompany.myapp.service.dto.OpenjobDTO;
import com.mycompany.myapp.service.mapper.OpenjobMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Openjob.
 */
@Service
@Transactional
public class OpenjobServiceImpl implements OpenjobService {

    private final Logger log = LoggerFactory.getLogger(OpenjobServiceImpl.class);

    private final OpenjobRepository openjobRepository;

    private final OpenjobMapper openjobMapper;

    public OpenjobServiceImpl(OpenjobRepository openjobRepository, OpenjobMapper openjobMapper) {
        this.openjobRepository = openjobRepository;
        this.openjobMapper = openjobMapper;
    }

    /**
     * Save a openjob.
     *
     * @param openjobDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public OpenjobDTO save(OpenjobDTO openjobDTO) {
        log.debug("Request to save Openjob : {}", openjobDTO);
        Openjob openjob = openjobMapper.toEntity(openjobDTO);
        openjob = openjobRepository.save(openjob);
        return openjobMapper.toDto(openjob);
    }

    /**
     * Get all the openjobs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<OpenjobDTO> findAll() {
        log.debug("Request to get all Openjobs");
        return openjobRepository.findAll().stream()
            .map(openjobMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one openjob by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OpenjobDTO> findOne(Long id) {
        log.debug("Request to get Openjob : {}", id);
        return openjobRepository.findById(id)
            .map(openjobMapper::toDto);
    }

    /**
     * Delete the openjob by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Openjob : {}", id);
        openjobRepository.deleteById(id);
    }
}
