package it.contrader.iroad.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import it.contrader.iroad.domain.enumeration.Sensortype;

/**
 * A Sensor.
 */
@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_type", nullable = false)
    private Sensortype sensorType;

    @NotNull
    @Column(name = "long_sensor", nullable = false)
    private Float longSensor;

    @NotNull
    @Column(name = "lat_sensor", nullable = false)
    private Float latSensor;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("sensors")
    private Street street;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensortype getSensorType() {
        return sensorType;
    }

    public Sensor sensorType(Sensortype sensorType) {
        this.sensorType = sensorType;
        return this;
    }

    public void setSensorType(Sensortype sensorType) {
        this.sensorType = sensorType;
    }

    public Float getLongSensor() {
        return longSensor;
    }

    public Sensor longSensor(Float longSensor) {
        this.longSensor = longSensor;
        return this;
    }

    public void setLongSensor(Float longSensor) {
        this.longSensor = longSensor;
    }

    public Float getLatSensor() {
        return latSensor;
    }

    public Sensor latSensor(Float latSensor) {
        this.latSensor = latSensor;
        return this;
    }

    public void setLatSensor(Float latSensor) {
        this.latSensor = latSensor;
    }

    public Street getStreet() {
        return street;
    }

    public Sensor street(Street street) {
        this.street = street;
        return this;
    }

    public void setStreet(Street street) {
        this.street = street;
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
        Sensor sensor = (Sensor) o;
        if (sensor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sensor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sensor{" +
            "id=" + getId() +
            ", sensorType='" + getSensorType() + "'" +
            ", longSensor=" + getLongSensor() +
            ", latSensor=" + getLatSensor() +
            "}";
    }
}
