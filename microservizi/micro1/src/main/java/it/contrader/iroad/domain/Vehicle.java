package it.contrader.iroad.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import it.contrader.iroad.domain.enumeration.Vehicletype;

/**
 * A Vehicle.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private Vehicletype vehicleType;

    @NotNull
    @Column(name = "name_vehicle", nullable = false)
    private String nameVehicle;

    @NotNull
    @Column(name = "speed_vehicle", nullable = false)
    private Float speedVehicle;

    @NotNull
    @Column(name = "weight_vehicle", nullable = false)
    private Float weightVehicle;

    @NotNull
    @Column(name = "long_vehicle", nullable = false)
    private Float longVehicle;

    @NotNull
    @Column(name = "lat_vehicle", nullable = false)
    private Float latVehicle;

    @NotNull
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicletype getVehicleType() {
        return vehicleType;
    }

    public Vehicle vehicleType(Vehicletype vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public void setVehicleType(Vehicletype vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public Vehicle nameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
        return this;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public Float getSpeedVehicle() {
        return speedVehicle;
    }

    public Vehicle speedVehicle(Float speedVehicle) {
        this.speedVehicle = speedVehicle;
        return this;
    }

    public void setSpeedVehicle(Float speedVehicle) {
        this.speedVehicle = speedVehicle;
    }

    public Float getWeightVehicle() {
        return weightVehicle;
    }

    public Vehicle weightVehicle(Float weightVehicle) {
        this.weightVehicle = weightVehicle;
        return this;
    }

    public void setWeightVehicle(Float weightVehicle) {
        this.weightVehicle = weightVehicle;
    }

    public Float getLongVehicle() {
        return longVehicle;
    }

    public Vehicle longVehicle(Float longVehicle) {
        this.longVehicle = longVehicle;
        return this;
    }

    public void setLongVehicle(Float longVehicle) {
        this.longVehicle = longVehicle;
    }

    public Float getLatVehicle() {
        return latVehicle;
    }

    public Vehicle latVehicle(Float latVehicle) {
        this.latVehicle = latVehicle;
        return this;
    }

    public void setLatVehicle(Float latVehicle) {
        this.latVehicle = latVehicle;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Vehicle idUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        if (vehicle.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vehicle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
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
