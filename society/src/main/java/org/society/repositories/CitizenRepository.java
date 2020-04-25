package org.society.repositories;

import org.society.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Citizen findByCni(String cni);
}
