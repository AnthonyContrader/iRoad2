package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.QuestionaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Questionary and its DTO QuestionaryDTO.
 */
@Mapper(componentModel = "spring", uses = {CandidatoMapper.class})
public interface QuestionaryMapper extends EntityMapper<QuestionaryDTO, Questionary> {

    @Mapping(source = "candidato.id", target = "candidatoId")
    QuestionaryDTO toDto(Questionary questionary);

    @Mapping(source = "candidatoId", target = "candidato")
    Questionary toEntity(QuestionaryDTO questionaryDTO);

    default Questionary fromId(Long id) {
        if (id == null) {
            return null;
        }
        Questionary questionary = new Questionary();
        questionary.setId(id);
        return questionary;
    }
}
