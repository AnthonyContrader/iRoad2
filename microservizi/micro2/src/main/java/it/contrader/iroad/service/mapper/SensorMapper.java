package it.contrader.iroad.service.mapper;

import it.contrader.iroad.domain.*;
import it.contrader.iroad.service.dto.SensorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Sensor and its DTO SensorDTO.
 */
@Mapper(componentModel = "spring", uses = {StreetMapper.class})
public interface SensorMapper extends EntityMapper<SensorDTO, Sensor> {

    @Mapping(source = "street.id", target = "streetId")
    SensorDTO toDto(Sensor sensor);

    @Mapping(source = "streetId", target = "street")
    Sensor toEntity(SensorDTO sensorDTO);

    default Sensor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sensor sensor = new Sensor();
        sensor.setId(id);
        return sensor;
    }
}
