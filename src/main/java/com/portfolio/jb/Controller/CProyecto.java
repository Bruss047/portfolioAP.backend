
package com.portfolio.jb.Controller;
import com.portfolio.jb.Dto.dtoProyecto;
import com.portfolio.jb.Entity.Proyecto;
import com.portfolio.jb.Entity.Skills;
import com.portfolio.jb.Security.Controller.Mensaje;
import com.portfolio.jb.Service.ServProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "*")
public class CProyecto {
    
    @Autowired
    ServProyecto sproyecto;
    
    @GetMapping("/get_proyectos")
    public ResponseEntity<List<Skills>> list() {
        List<Proyecto> list = sproyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/get_detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("Skill no encontrado."), HttpStatus.NOT_FOUND);
        }
        Proyecto proy = sproyecto.getOne(id).get();
        return new ResponseEntity(proy, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy){      
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if(sproyecto.existsByNombre(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("Proyecto Inexistente."), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoproy.getNombre(),dtoproy.getDescripcion(),dtoproy.getImg(),dtoproy.getUrlP(), dtoproy.getFecha());
        sproyecto.saveProyecto(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto Agregado."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproy){
      
        if(!sproyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
   
        if(sproyecto.existsByNombre(dtoproy.getNombre()) && sproyecto.getByNombre(dtoproy.getNombre()).get().getProyId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
  
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sproyecto.getOne(id).get();
        proyecto.setNombre(dtoproy.getNombre());
        proyecto.setDescripcion(dtoproy.getDescripcion());
        proyecto.setImg(dtoproy.getImg());
        proyecto.setFecha((dtoproy.getFecha()));
       
        
        sproyecto.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
     
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
