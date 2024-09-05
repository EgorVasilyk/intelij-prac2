package com.example.pract2.service;

import com.example.pract2.entity.jurnalEntity;
import com.example.pract2.model.jurnalModel;
import com.example.pract2.repository.InMemoryJurnalRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//Сервисный слой отвечает за бизнес-логику приложения. Он использует репозиторий для выполнения операций с данными и может включать дополнительные проверки или преобразования данных
//так же мы тут можем настроить инкапсуляцию
//А если простыми словами тут происходит разделенние запросов от контроллера к сервису
@Service
public class InMemoryJurnalServiceImpl implements jurnalService {

    private final InMemoryJurnalRepository jurnalRepository;

    public InMemoryJurnalServiceImpl(InMemoryJurnalRepository jurnalRepository) {
        this.jurnalRepository = jurnalRepository;
    }

    @Override
    public List<jurnalModel> findAlljurnal() {
        return jurnalRepository.findAlljurnals();
    }

    @Override
    public List<jurnalModel> findjurnalByMiddleName(String middleName) {
        return jurnalRepository.findjurnalByMiddleName(middleName);
    }

    @Override
    public jurnalModel addjurnal(jurnalModel jurnal) {
        return jurnalRepository.addjurnal(jurnal);
    }

    @Override
    public jurnalModel updatejurnal(jurnalModel jurnal) {
        return jurnalRepository.updatejurnal(jurnal);
    }

    @Override
    public void deletejurnal(int id) {
        jurnalRepository.deletejurnal(id);
    }

    @Override
    public List<jurnalModel> filterJurnal1() {
        return jurnalRepository.filterJurnal1();
    }

    @Override
    public List<jurnalModel> filterJurnal2() {
        return jurnalRepository.filterJurnal2();
    }

    @Override
    public List<jurnalModel> filterJurnal3() {
        return jurnalRepository.filterJurnal3();
    }

    @Override
    public void deletejurnalAll() {
        jurnalRepository.deletejurnalAll();
    }

    @Override
    public jurnalModel IsDeleteTrue(jurnalModel jurnal) {
        return jurnalRepository.IsDeleteTrue(jurnal);
    }
}

