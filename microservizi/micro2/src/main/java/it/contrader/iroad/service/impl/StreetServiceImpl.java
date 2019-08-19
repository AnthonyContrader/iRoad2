package it.contrader.iroad.service.impl;

import it.contrader.iroad.service.StreetService;
import it.contrader.iroad.domain.Street;
import it.contrader.iroad.repository.StreetRepository;
import it.contrader.iroad.service.dto.StreetDTO;
import it.contrader.iroad.service.mapper.StreetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Street.
 */
@Service
@Transactional
public class StreetServiceImpl implements StreetService {

    private final Logger log = LoggerFactory.getLogger(StreetServiceImpl.class);

    private final StreetRepository streetRepository;

    private final StreetMapper streetMapper;

    public StreetServiceImpl(StreetRepository streetRepository, StreetMapper streetMapper) {
        this.streetRepository = streetRepository;
        this.streetMapper = streetMapper;
    }

    /**
     * Save a street.
     *
     * @param streetDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public StreetDTO save(StreetDTO streetDTO) {
        log.debug("Request to save Street : {}", streetDTO);
        Street street = streetMapper.toEntity(streetDTO);
        street = streetRepository.save(street);
        return streetMapper.toDto(street);
    }

    /**
     * Get all the streets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<StreetDTO> findAll() {
        log.debug("Request to get all Streets");
        return streetRepository.findAll().stream()
            .map(streetMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one street by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StreetDTO> findOne(Long id) {
        log.debug("Request to get Street : {}", id);
        return streetRepository.findById(id)
            .map(streetMapper::toDto);
    }

    /**
     * Delete the street by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Street : {}", id);
        streetRepository.deleteById(id);
    }
}
