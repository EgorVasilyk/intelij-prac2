package com.example.pract2.controller;

import com.example.pract2.model.workerModel;
import com.example.pract2.service.workerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


//Основная бизнес-логика нашего проекта
@Controller
public class workerController {

    @Autowired
    private workerService workerService;

    @GetMapping("/workers")
    public String getAllworkers(Model model) {
        model.addAttribute("workers", workerService.findAllworker()); // просто выгрузка студентов на экран
        return "workerList";
    }

    @PostMapping("/workers/add")
    public String addworker(@RequestParam String name,
                            @RequestParam String lastName,
                            @RequestParam String firstName,
                            @RequestParam String Job) {
        workerModel newworker = new workerModel(0, name, lastName, firstName, Job); // тут мы получаем данные с главных полей, id задается автоматически из нашего репозитория
        workerService.addworker(newworker); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/workers/update")
    public String updateworker(@RequestParam int id,
                               @RequestParam String name,
                               @RequestParam String lastName,
                               @RequestParam String firstName,
                               @RequestParam String Job) {
        workerModel updatedworker = new workerModel(id, name, lastName, firstName, Job); // Получаем новые данные из полей для обновления
        workerService.updateworker(updatedworker); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/workers/delete")
    public String deleteworker(@RequestParam int id) {
        workerService.deleteworker(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }
}
