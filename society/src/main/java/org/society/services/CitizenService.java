package org.society.services;

import org.society.models.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CitizenService {
    //find all Citizens in the data bases
    Optional<List<Citizen>> getCitizens();

    //find Citizen by id
    Optional<Citizen> getCitizenById(Long id);

    //find Citizen by CNI
    Optional<Citizen> getCitizenByCni(String cni);

    // update Citizen
    Optional<Citizen> update(Citizen citizen);

    // create Citizen
    Optional<Citizen> saveCitizen(Citizen citizen);

    //delete Citizen
    void delete(Long id);

    //delete Citizens
    void deleteAll();
}
