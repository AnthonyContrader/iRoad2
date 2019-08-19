package it.contrader.iroad.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import it.contrader.iroad.domain.enumeration.StreetType;

/**
 * A DTO for the Street entity.
 */
public class StreetDTO implements Serializable {

    private Long id;

    @NotNull
    private String streetName;

    @NotNull
    private StreetType streetType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreetDTO streetDTO = (StreetDTO) o;
        if (streetDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), streetDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StreetDTO{" +
            "id=" + getId() +
            ", streetName='" + getStreetName() + "'" +
            ", streetType='" + getStreetType() + "'" +
            "}";
    }
}
