package com.example.pract2.controller;

import com.example.pract2.model.jurnalModel;
import com.example.pract2.service.jurnalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


//Основная бизнес-логика нашего проекта
@Controller
public class jurnalController {

    @Autowired
    private jurnalService jurnalService;

    @GetMapping("/jurnals")
    public String getAlljurnals(Model model) {
        model.addAttribute("jurnals", jurnalService.findAlljurnal()); // просто выгрузка студентов на экран
        return "jurnalList";
    }

    @PostMapping("/jurnals/add")
    public String addjurnal(@RequestParam String name,
                             @RequestParam String lastName,
                             @RequestParam String firstName,
                             @RequestParam String middleName) {
        jurnalModel newjurnal = new jurnalModel(0, name, lastName, firstName, middleName, false); // тут мы получаем данные с главных полей, id задается автоматически из нашего репозитория
        jurnalService.addjurnal(newjurnal); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/update")
    public String updatejurnal(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String lastName,
                                @RequestParam String firstName,
                                @RequestParam String middleName) {
        jurnalModel updatedjurnal = new jurnalModel(id, name, lastName, firstName, middleName, false); // Получаем новые данные из полей для обновления
        jurnalService.updatejurnal(updatedjurnal); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/delete")
    public String deletejurnal(@RequestParam int id) {
        jurnalService.deletejurnal(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/id")
    public String findbyMiddleName(Model model, @RequestParam String middleName){
        model.addAttribute("jurnals", jurnalService.findjurnalByMiddleName(middleName));//выгрузка студентов на экран по id
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter1")
    public String filterJurnal1(Model model){
        model.addAttribute("jurnals", jurnalService.filterJurnal1());
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter2")
    public String filterJurnal2(Model model){
        model.addAttribute("jurnals", jurnalService.filterJurnal2());
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter3")
    public String filterJurnal3(Model model){
        model.addAttribute("jurnals", jurnalService.filterJurnal3());
        return "jurnalList";
    }

    @PostMapping("/jurnals/clear")
    public String ClearJurnal(Model model){
        jurnalService.deletejurnalAll();
        model.addAttribute("jurnals", jurnalService.findAlljurnal());
        return "jurnalList";
    }

    @PostMapping("/jurnals/bool")
    public String IsDeleted(@RequestParam int id,
                            @RequestParam String name,
                            @RequestParam String lastName,
                            @RequestParam String firstName,
                            @RequestParam String middleName){
        jurnalModel IsDeleted = new jurnalModel(id, name, lastName, firstName, middleName, true); // Получаем новые данные из полей для обновления
        jurnalService.IsDeleteTrue(IsDeleted); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/jurnals";
    }
}
