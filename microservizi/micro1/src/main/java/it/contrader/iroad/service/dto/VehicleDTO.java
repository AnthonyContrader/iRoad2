package it.contrader.iroad.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import it.contrader.iroad.domain.enumeration.Vehicletype;

/**
 * A DTO for the Vehicle entity.
 */
public class VehicleDTO implements Serializable {

    private Long id;

    @NotNull
    private Vehicletype vehicleType;

    @NotNull
    private String nameVehicle;

    @NotNull
    private Float speedVehicle;

    @NotNull
    private Float weightVehicle;

    @NotNull
    private Float longVehicle;

    @NotNull
    private Float latVehicle;

    @NotNull
    private Integer idUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicletype getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Vehicletype vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public Float getSpeedVehicle() {
        return speedVehicle;
    }

    public void setSpeedVehicle(Float speedVehicle) {
        this.speedVehicle = speedVehicle;
    }

    public Float getWeightVehicle() {
        return weightVehicle;
    }

    public void setWeightVehicle(Float weightVehicle) {
        this.weightVehicle = weightVehicle;
    }

    public Float getLongVehicle() {
        return longVehicle;
    }

    public void setLongVehicle(Float longVehicle) {
        this.longVehicle = longVehicle;
    }

    public Float getLatVehicle() {
        return latVehicle;
    }

    public void setLatVehicle(Float latVehicle) {
        this.latVehicle = latVehicle;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VehicleDTO vehicleDTO = (VehicleDTO) o;
        if (vehicleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vehicleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
            "id=" + getId() +
            ", vehicleType='" + getVehicleType() + "'" +
            ", nameVehicle='" + getNameVehicle() + "'" +
            ", speedVehicle=" + getSpeedVehicle() +
            ", weightVehicle=" + getWeightVehicle() +
            ", longVehicle=" + getLongVehicle() +
            ", latVehicle=" + getLatVehicle() +
            ", idUser=" + getIdUser() +
            "}";
    }
}
