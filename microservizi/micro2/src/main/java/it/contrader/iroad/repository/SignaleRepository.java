package it.contrader.iroad.repository;

import it.contrader.iroad.domain.Signale;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Signale entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SignaleRepository extends JpaRepository<Signale, Long> {

}
