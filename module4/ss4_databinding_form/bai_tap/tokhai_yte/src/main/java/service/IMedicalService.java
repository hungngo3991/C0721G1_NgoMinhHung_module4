package service;

import model.Medical;

import java.util.List;

public interface IMedicalService {
    void createMedical(Medical medical);
    List<Medical> showListMedical();
}
