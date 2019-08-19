package it.contrader.iroad.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import it.contrader.iroad.domain.enumeration.Sensortype;

/**
 * A DTO for the Sensor entity.
 */
public class SensorDTO implements Serializable {

    private Long id;

    @NotNull
    private Sensortype sensorType;

    @NotNull
    private Float longSensor;

    @NotNull
    private Float latSensor;

    private Long streetId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensortype getSensorType() {
        return sensorType;
    }

    public void setSensorType(Sensortype sensorType) {
        this.sensorType = sensorType;
    }

    public Float getLongSensor() {
        return longSensor;
    }

    public void setLongSensor(Float longSensor) {
        this.longSensor = longSensor;
    }

    public Float getLatSensor() {
        return latSensor;
    }

    public void setLatSensor(Float latSensor) {
        this.latSensor = latSensor;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SensorDTO sensorDTO = (SensorDTO) o;
        if (sensorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sensorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SensorDTO{" +
            "id=" + getId() +
            ", sensorType='" + getSensorType() + "'" +
            ", longSensor=" + getLongSensor() +
            ", latSensor=" + getLatSensor() +
            ", street=" + getStreetId() +
            "}";
    }
}
