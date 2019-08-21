package com.mycompany.myapp.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import com.mycompany.myapp.domain.enumeration.DomandaUno;

import com.mycompany.myapp.domain.enumeration.DomandaDue;

import com.mycompany.myapp.domain.enumeration.DomandaSette;

import com.mycompany.myapp.domain.enumeration.DomandaTre;

import com.mycompany.myapp.domain.enumeration.DomandaQuattro;

import com.mycompany.myapp.domain.enumeration.DomandaCinque;

import com.mycompany.myapp.domain.enumeration.DomandaSei;

/**
 * A Questionary.
 */
@Entity
@Table(name = "questionary")
public class Questionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_uno")
    private DomandaUno domandaUno;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_due")
    private DomandaDue domandaDue;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_sette")
    private DomandaSette domandaSette;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_tre")
    private DomandaTre domandaTre;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_quattro")
    private DomandaQuattro domandaQuattro;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_cinque")
    private DomandaCinque domandaCinque;

    @Enumerated(EnumType.STRING)
    @Column(name = "domanda_sei")
    private DomandaSei domandaSei;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomandaUno getDomandaUno() {
        return domandaUno;
    }

    public Questionary domandaUno(DomandaUno domandaUno) {
        this.domandaUno = domandaUno;
        return this;
    }

    public void setDomandaUno(DomandaUno domandaUno) {
        this.domandaUno = domandaUno;
    }

    public DomandaDue getDomandaDue() {
        return domandaDue;
    }

    public Questionary domandaDue(DomandaDue domandaDue) {
        this.domandaDue = domandaDue;
        return this;
    }

    public void setDomandaDue(DomandaDue domandaDue) {
        this.domandaDue = domandaDue;
    }

    public DomandaSette getDomandaSette() {
        return domandaSette;
    }

    public Questionary domandaSette(DomandaSette domandaSette) {
        this.domandaSette = domandaSette;
        return this;
    }

    public void setDomandaSette(DomandaSette domandaSette) {
        this.domandaSette = domandaSette;
    }

    public DomandaTre getDomandaTre() {
        return domandaTre;
    }

    public Questionary domandaTre(DomandaTre domandaTre) {
        this.domandaTre = domandaTre;
        return this;
    }

    public void setDomandaTre(DomandaTre domandaTre) {
        this.domandaTre = domandaTre;
    }

    public DomandaQuattro getDomandaQuattro() {
        return domandaQuattro;
    }

    public Questionary domandaQuattro(DomandaQuattro domandaQuattro) {
        this.domandaQuattro = domandaQuattro;
        return this;
    }

    public void setDomandaQuattro(DomandaQuattro domandaQuattro) {
        this.domandaQuattro = domandaQuattro;
    }

    public DomandaCinque getDomandaCinque() {
        return domandaCinque;
    }

    public Questionary domandaCinque(DomandaCinque domandaCinque) {
        this.domandaCinque = domandaCinque;
        return this;
    }

    public void setDomandaCinque(DomandaCinque domandaCinque) {
        this.domandaCinque = domandaCinque;
    }

    public DomandaSei getDomandaSei() {
        return domandaSei;
    }

    public Questionary domandaSei(DomandaSei domandaSei) {
        this.domandaSei = domandaSei;
        return this;
    }

    public void setDomandaSei(DomandaSei domandaSei) {
        this.domandaSei = domandaSei;
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
        Questionary questionary = (Questionary) o;
        if (questionary.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), questionary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Questionary{" +
            "id=" + getId() +
            ", domandaUno='" + getDomandaUno() + "'" +
            ", domandaDue='" + getDomandaDue() + "'" +
            ", domandaSette='" + getDomandaSette() + "'" +
            ", domandaTre='" + getDomandaTre() + "'" +
            ", domandaQuattro='" + getDomandaQuattro() + "'" +
            ", domandaCinque='" + getDomandaCinque() + "'" +
            ", domandaSei='" + getDomandaSei() + "'" +
            "}";
    }
}
