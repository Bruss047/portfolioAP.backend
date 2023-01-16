package com.portfolio.jb.Controller;

import com.portfolio.jb.Dto.dtoSkill;
import com.portfolio.jb.Entity.Skills;
import com.portfolio.jb.Security.Controller.Mensaje;
import com.portfolio.jb.Service.ServSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping("/skill")
public class CSkills {

    @Autowired
    ServSkill skill;

    @GetMapping("/get_skills")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/get_detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skill.existsById(id)) {
            return new ResponseEntity(new Mensaje("Skill no encontrado."), HttpStatus.NOT_FOUND);
        }
        Skills hYs = skill.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skill.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        skill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (skill.existsByNombre(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoSkills.getNombre(), dtoSkills.getPorcentaje());
        skill.save(skills);
            
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoSkills) {

        if (!skill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (skill.existsByNombre(dtoSkills.getNombre()) && skill.getByNombre(dtoSkills.getNombre()).get().getSkillId() != id) {
            return new ResponseEntity(new Mensaje("Skill existente"), HttpStatus.BAD_REQUEST);
        }
       
        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills hYs = skill.getOne(id).get();
        hYs.setNombre(dtoSkills.getNombre());
        hYs.setPorcentaje(dtoSkills.getPorcentaje());

        skill.save(hYs);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);

    }
}
