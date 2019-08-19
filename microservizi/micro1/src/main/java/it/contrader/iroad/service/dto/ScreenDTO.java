package it.contrader.iroad.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Screen entity.
 */
public class ScreenDTO implements Serializable {

    private Long id;

    private String output;

    private Long vehicleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ScreenDTO screenDTO = (ScreenDTO) o;
        if (screenDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), screenDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ScreenDTO{" +
            "id=" + getId() +
            ", output='" + getOutput() + "'" +
            ", vehicle=" + getVehicleId() +
            "}";
    }
}
