package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.interfaces.IOperateur;
import tn.esprit.spring.repositories.IOperateurRepository;

import java.util.List;
@Service
public class OperateurService implements IOperateur {
    @Autowired
    IOperateurRepository operateurRepository;
    @Override
    public List<Operateur> retrieveAllOperateurs() {
        return operateurRepository.findAll();
    }

    @Override
    public Operateur addOperateur(Operateur o) {
        return operateurRepository.save(o);
    }

    @Override
    public Operateur updateOperateur(Operateur o) {
        return operateurRepository.save(o);
    }

    @Override
    public Operateur retrieveOperateur(Long id) {
        return operateurRepository.findById(id).orElse(null);
    }

    @Override
    public void removeOperateur(Long id) {
        operateurRepository.deleteById(id);
    }


}
