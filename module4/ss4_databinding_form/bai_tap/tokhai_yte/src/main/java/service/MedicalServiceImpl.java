package service;

import model.Medical;
import org.springframework.stereotype.Service;
import repository.MedicalRepositoryImpl;

import java.util.List;


@Service
public class MedicalServiceImpl implements IMedicalService{

    private final MedicalRepositoryImpl medicalRepository = new MedicalRepositoryImpl();

    @Override
    public void createMedical(Medical medical) {
        medicalRepository.createMedical(medical);
    }

    @Override
    public List<Medical> showListMedical() {
        return medicalRepository.showListMedical();
    }
}
