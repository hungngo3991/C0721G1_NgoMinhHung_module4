package repository;

import model.Medical;

import java.util.List;

public interface IMedicalRepository {
    void createMedical(Medical medical);
    List<Medical> showListMedical();
}
