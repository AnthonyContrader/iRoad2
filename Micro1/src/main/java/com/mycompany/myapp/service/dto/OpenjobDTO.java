package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Openjob entity.
 */
public class OpenjobDTO implements Serializable {

    private Long id;

    private String titolo;

    private String descrizione;

    private String requisiti;

    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getRequisiti() {
        return requisiti;
    }

    public void setRequisiti(String requisiti) {
        this.requisiti = requisiti;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OpenjobDTO openjobDTO = (OpenjobDTO) o;
        if (openjobDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), openjobDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OpenjobDTO{" +
            "id=" + getId() +
            ", titolo='" + getTitolo() + "'" +
            ", descrizione='" + getDescrizione() + "'" +
            ", requisiti='" + getRequisiti() + "'" +
            ", company=" + getCompanyId() +
            "}";
    }
}
