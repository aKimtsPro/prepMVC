package com.example.demo.controllers;

import com.example.demo.business.PersonService;
import com.example.demo.models.dtos.PersonDTO;
import com.example.demo.models.forms.PersonForm;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable long id){
        PersonDTO dto = service.getOne(id);
        model.addAttribute("person", dto);
        return "pages/displayOne";
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("persons", service.getAll());
        return "pages/displayAll";
    }

    @GetMapping("/add")
    @Secured("ROLE_ADMIN")
    public String getInsertForm(@ModelAttribute("person") PersonForm form){
        return "/form/insertForm";
    }

    @GetMapping("/{id}/update")
    @Secured("ROLE_ADMIN")
    public String getUpdateForm(@PathVariable Long id, Model model){
        PersonDTO baseInfo = service.getOne(id);
        model.addAttribute("id", baseInfo.getId());
        model.addAttribute("person", new PersonForm(baseInfo.getPrenom(), baseInfo.getNom()));
        return "/form/updateForm";
    }

    @PostMapping("/insert")
    @Secured("ROLE_ADMIN")
    public String processInsert(@Valid @ModelAttribute("person") PersonForm form, BindingResult br, Model model){
        if(br.hasErrors()){
            return "form/insertForm";
        }

        service.insert(form);
        return "redirect:/person";
    }

    @PostMapping("/{id}/update")
    @Secured("ROLE_ADMIN")
    public String processUpdate(@PathVariable Long id, @Valid PersonForm form, BindingResult br ){
        PersonDTO dto = service.update(id, form);
        return "redirect:/person/"+id;
    }


}
