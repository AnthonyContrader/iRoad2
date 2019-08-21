package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Openjob.
 */
@Entity
@Table(name = "openjob")
public class Openjob implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "requisiti")
    private String requisiti;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Company company;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public Openjob titolo(String titolo) {
        this.titolo = titolo;
        return this;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Openjob descrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getRequisiti() {
        return requisiti;
    }

    public Openjob requisiti(String requisiti) {
        this.requisiti = requisiti;
        return this;
    }

    public void setRequisiti(String requisiti) {
        this.requisiti = requisiti;
    }

    public Company getCompany() {
        return company;
    }

    public Openjob company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        Openjob openjob = (Openjob) o;
        if (openjob.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), openjob.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Openjob{" +
            "id=" + getId() +
            ", titolo='" + getTitolo() + "'" +
            ", descrizione='" + getDescrizione() + "'" +
            ", requisiti='" + getRequisiti() + "'" +
            "}";
    }
}
