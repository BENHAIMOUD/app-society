package org.society.services;


import org.society.models.Citizen;
import org.society.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ayoub benHaimoud ;ayoubbenhaimoud@gmail.com
 * @since 10/03/2020
 */
@Service
public class CitizenServiceImpl implements CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Optional<List<Citizen>> getCitizens() {
        return Optional.of(citizenRepository.findAll());
    }

    @Override
    public Optional<Citizen> getCitizenById(Long id) {
        return citizenRepository.findById(id);
    }

    @Override
    public Optional<Citizen> getCitizenByCNI(String CNI) {
        return Optional.of(citizenRepository.findByCNI(CNI));
    }

    @Override
    public Optional<Citizen> update(Citizen citizen) {
        return Optional.of(citizenRepository.save(citizen));
    }

    @Override
    public Optional<Citizen>  saveCitizen(Citizen citizen) {
        return Optional.of(citizenRepository.save(citizen));
    }

    @Override
    public void delete(Long id) {
        citizenRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        citizenRepository.deleteAll();

    }
}