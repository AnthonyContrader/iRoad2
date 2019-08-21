package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Openjob;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Openjob entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpenjobRepository extends JpaRepository<Openjob, Long> {

}
