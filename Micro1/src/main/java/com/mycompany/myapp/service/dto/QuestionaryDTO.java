package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Questionary entity.
 */
public class QuestionaryDTO implements Serializable {

    private Long id;

    private Long candidatoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Long candidatoId) {
        this.candidatoId = candidatoId;
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
            ", candidato=" + getCandidatoId() +
            "}";
    }
}
