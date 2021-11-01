package repository;

import model.Medical;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepositoryImpl implements IMedicalRepository{

    private final List<Medical> medicalList = new ArrayList<>();
    @Override
    public void createMedical(Medical medical) {
        medicalList.add(medical);
    }

    @Override
    public List<Medical> showListMedical() {
        return medicalList;
    }
}
