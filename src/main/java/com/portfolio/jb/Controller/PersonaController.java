
package com.portfolio.jb.Controller;

import com.portfolio.jb.Dto.dtoPersona;
import com.portfolio.jb.Entity.Persona;
import com.portfolio.jb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/get_list")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestBody dtoPersona pers){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setDireccion(pers.getDireccion());
        persona.setEmail(pers.getEmail());
        persona.setImg(pers.getImg());
        persona.setSobreMi(pers.getSobreMi());
        persona.setTelefono(pers.getTelefono());
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
   
}
