package it.contrader.iroad.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import it.contrader.iroad.domain.enumeration.SignaleType;

/**
 * A DTO for the Signale entity.
 */
public class SignaleDTO implements Serializable {

    private Long id;

    @NotNull
    private SignaleType signaleType;

    @NotNull
    private String signaleName;

    @NotNull
    private Float longSignale;

    @NotNull
    private Float latSignale;

    private Long streetId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SignaleType getSignaleType() {
        return signaleType;
    }

    public void setSignaleType(SignaleType signaleType) {
        this.signaleType = signaleType;
    }

    public String getSignaleName() {
        return signaleName;
    }

    public void setSignaleName(String signaleName) {
        this.signaleName = signaleName;
    }

    public Float getLongSignale() {
        return longSignale;
    }

    public void setLongSignale(Float longSignale) {
        this.longSignale = longSignale;
    }

    public Float getLatSignale() {
        return latSignale;
    }

    public void setLatSignale(Float latSignale) {
        this.latSignale = latSignale;
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

        SignaleDTO signaleDTO = (SignaleDTO) o;
        if (signaleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), signaleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SignaleDTO{" +
            "id=" + getId() +
            ", signaleType='" + getSignaleType() + "'" +
            ", signaleName='" + getSignaleName() + "'" +
            ", longSignale=" + getLongSignale() +
            ", latSignale=" + getLatSignale() +
            ", street=" + getStreetId() +
            "}";
    }
}
