package it.contrader.iroad.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import it.contrader.iroad.domain.enumeration.SignaleType;

/**
 * A Signale.
 */
@Entity
@Table(name = "signale")
public class Signale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "signale_type", nullable = false)
    private SignaleType signaleType;

    @NotNull
    @Column(name = "signale_name", nullable = false)
    private String signaleName;

    @NotNull
    @Column(name = "long_signale", nullable = false)
    private Float longSignale;

    @NotNull
    @Column(name = "lat_signale", nullable = false)
    private Float latSignale;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Street street;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SignaleType getSignaleType() {
        return signaleType;
    }

    public Signale signaleType(SignaleType signaleType) {
        this.signaleType = signaleType;
        return this;
    }

    public void setSignaleType(SignaleType signaleType) {
        this.signaleType = signaleType;
    }

    public String getSignaleName() {
        return signaleName;
    }

    public Signale signaleName(String signaleName) {
        this.signaleName = signaleName;
        return this;
    }

    public void setSignaleName(String signaleName) {
        this.signaleName = signaleName;
    }

    public Float getLongSignale() {
        return longSignale;
    }

    public Signale longSignale(Float longSignale) {
        this.longSignale = longSignale;
        return this;
    }

    public void setLongSignale(Float longSignale) {
        this.longSignale = longSignale;
    }

    public Float getLatSignale() {
        return latSignale;
    }

    public Signale latSignale(Float latSignale) {
        this.latSignale = latSignale;
        return this;
    }

    public void setLatSignale(Float latSignale) {
        this.latSignale = latSignale;
    }

    public Street getStreet() {
        return street;
    }

    public Signale street(Street street) {
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
        Signale signale = (Signale) o;
        if (signale.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), signale.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Signale{" +
            "id=" + getId() +
            ", signaleType='" + getSignaleType() + "'" +
            ", signaleName='" + getSignaleName() + "'" +
            ", longSignale=" + getLongSignale() +
            ", latSignale=" + getLatSignale() +
            "}";
    }
}
