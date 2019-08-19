package it.contrader.iroad.service.mapper;

import it.contrader.iroad.domain.*;
import it.contrader.iroad.service.dto.ScreenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Screen and its DTO ScreenDTO.
 */
@Mapper(componentModel = "spring", uses = {VehicleMapper.class})
public interface ScreenMapper extends EntityMapper<ScreenDTO, Screen> {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    ScreenDTO toDto(Screen screen);

    @Mapping(source = "vehicleId", target = "vehicle")
    Screen toEntity(ScreenDTO screenDTO);

    default Screen fromId(Long id) {
        if (id == null) {
            return null;
        }
        Screen screen = new Screen();
        screen.setId(id);
        return screen;
    }
}
