package com.mycompany.myapp.service.dto;

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
 * A DTO for the Questionary entity.
 */
public class QuestionaryDTO implements Serializable {

    private Long id;

    private DomandaUno domandaUno;

    private DomandaDue domandaDue;

    private DomandaSette domandaSette;

    private DomandaTre domandaTre;

    private DomandaQuattro domandaQuattro;

    private DomandaCinque domandaCinque;

    private DomandaSei domandaSei;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomandaUno getDomandaUno() {
        return domandaUno;
    }

    public void setDomandaUno(DomandaUno domandaUno) {
        this.domandaUno = domandaUno;
    }

    public DomandaDue getDomandaDue() {
        return domandaDue;
    }

    public void setDomandaDue(DomandaDue domandaDue) {
        this.domandaDue = domandaDue;
    }

    public DomandaSette getDomandaSette() {
        return domandaSette;
    }

    public void setDomandaSette(DomandaSette domandaSette) {
        this.domandaSette = domandaSette;
    }

    public DomandaTre getDomandaTre() {
        return domandaTre;
    }

    public void setDomandaTre(DomandaTre domandaTre) {
        this.domandaTre = domandaTre;
    }

    public DomandaQuattro getDomandaQuattro() {
        return domandaQuattro;
    }

    public void setDomandaQuattro(DomandaQuattro domandaQuattro) {
        this.domandaQuattro = domandaQuattro;
    }

    public DomandaCinque getDomandaCinque() {
        return domandaCinque;
    }

    public void setDomandaCinque(DomandaCinque domandaCinque) {
        this.domandaCinque = domandaCinque;
    }

    public DomandaSei getDomandaSei() {
        return domandaSei;
    }

    public void setDomandaSei(DomandaSei domandaSei) {
        this.domandaSei = domandaSei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestionaryDTO questionaryDTO = (QuestionaryDTO) o;
        if (questionaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), questionaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "QuestionaryDTO{" +
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
