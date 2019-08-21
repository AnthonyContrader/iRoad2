package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.OpenjobDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Openjob and its DTO OpenjobDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface OpenjobMapper extends EntityMapper<OpenjobDTO, Openjob> {

    @Mapping(source = "company.id", target = "companyId")
    OpenjobDTO toDto(Openjob openjob);

    @Mapping(source = "companyId", target = "company")
    Openjob toEntity(OpenjobDTO openjobDTO);

    default Openjob fromId(Long id) {
        if (id == null) {
            return null;
        }
        Openjob openjob = new Openjob();
        openjob.setId(id);
        return openjob;
    }
}
