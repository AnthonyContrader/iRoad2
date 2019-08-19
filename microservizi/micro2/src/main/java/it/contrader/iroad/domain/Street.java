package it.contrader.iroad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import it.contrader.iroad.domain.enumeration.StreetType;

/**
 * A Street.
 */
@Entity
@Table(name = "street")
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "street_name", nullable = false)
    private String streetName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "street_type", nullable = false)
    private StreetType streetType;

    @OneToMany(mappedBy = "street")
    private Set<Sensor> sensors = new HashSet<>();

    @OneToMany(mappedBy = "street")
    private Set<Signale> signales = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public Street streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public Street streetType(StreetType streetType) {
        this.streetType = streetType;
        return this;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public Street sensors(Set<Sensor> sensors) {
        this.sensors = sensors;
        return this;
    }

    public Street addSensor(Sensor sensor) {
        this.sensors.add(sensor);
        sensor.setStreet(this);
        return this;
    }

    public Street removeSensor(Sensor sensor) {
        this.sensors.remove(sensor);
        sensor.setStreet(null);
        return this;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Set<Signale> getSignales() {
        return signales;
    }

    public Street signales(Set<Signale> signales) {
        this.signales = signales;
        return this;
    }

    public Street addSignale(Signale signale) {
        this.signales.add(signale);
        signale.setStreet(this);
        return this;
    }

    public Street removeSignale(Signale signale) {
        this.signales.remove(signale);
        signale.setStreet(null);
        return this;
    }

    public void setSignales(Set<Signale> signales) {
        this.signales = signales;
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
        Street street = (Street) o;
        if (street.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), street.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Street{" +
            "id=" + getId() +
            ", streetName='" + getStreetName() + "'" +
            ", streetType='" + getStreetType() + "'" +
            "}";
    }
}
