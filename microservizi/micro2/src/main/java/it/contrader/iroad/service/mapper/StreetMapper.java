package it.contrader.iroad.service.mapper;

import it.contrader.iroad.domain.*;
import it.contrader.iroad.service.dto.StreetDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Street and its DTO StreetDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StreetMapper extends EntityMapper<StreetDTO, Street> {


    @Mapping(target = "sensors", ignore = true)
    @Mapping(target = "signales", ignore = true)
    Street toEntity(StreetDTO streetDTO);

    default Street fromId(Long id) {
        if (id == null) {
            return null;
        }
        Street street = new Street();
        street.setId(id);
        return street;
    }
}
