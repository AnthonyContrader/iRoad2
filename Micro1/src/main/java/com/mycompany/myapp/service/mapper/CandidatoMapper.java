package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CandidatoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Candidato and its DTO CandidatoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CandidatoMapper extends EntityMapper<CandidatoDTO, Candidato> {



    default Candidato fromId(Long id) {
        if (id == null) {
            return null;
        }
        Candidato candidato = new Candidato();
        candidato.setId(id);
        return candidato;
    }
}
