package it.contrader.iroad.service.mapper;

import it.contrader.iroad.domain.*;
import it.contrader.iroad.service.dto.SignaleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Signale and its DTO SignaleDTO.
 */
@Mapper(componentModel = "spring", uses = {StreetMapper.class})
public interface SignaleMapper extends EntityMapper<SignaleDTO, Signale> {

    @Mapping(source = "street.id", target = "streetId")
    SignaleDTO toDto(Signale signale);

    @Mapping(source = "streetId", target = "street")
    Signale toEntity(SignaleDTO signaleDTO);

    default Signale fromId(Long id) {
        if (id == null) {
            return null;
        }
        Signale signale = new Signale();
        signale.setId(id);
        return signale;
    }
}
