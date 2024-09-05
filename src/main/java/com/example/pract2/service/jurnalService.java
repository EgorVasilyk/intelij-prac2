package com.example.pract2.service;

import com.example.pract2.model.jurnalModel;

import java.util.List;

public interface jurnalService {
    public List<jurnalModel> findAlljurnal();
    public List<jurnalModel> findjurnalByMiddleName(String middleName);
    public jurnalModel addjurnal(jurnalModel jurnal);
    public jurnalModel updatejurnal(jurnalModel jurnal);
    public void deletejurnal(int id);

    public List<jurnalModel> filterJurnal1();
    public List<jurnalModel> filterJurnal2();
    public List<jurnalModel> filterJurnal3();
    public void deletejurnalAll();

    public jurnalModel IsDeleteTrue(jurnalModel jurnal);
}
